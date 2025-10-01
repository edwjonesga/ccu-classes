// File: MainTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sem.*; // adjust package if needed

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for SymbolTableImpl.
 * Validates scope mechanics:
 * - declare / lookupLocal / lookup
 * - shadowing
 * - duplicate detection
 * - scope entry/exit
 * - getScopeInfo structure
 */
public class MainTest {

    private SymbolTable table;

    @BeforeEach
    void setup() {
        table = new SymbolTableImpl();
        table.enterScope(); // establish "global" scope
    }

    @Test
    void declareAndLookupLocal_shouldSucceed() {
        assertTrue(table.declare(new Symbol("x", Kind.VARIABLE, null)));
        assertTrue(table.lookupLocal("x").isPresent(), "x should be found in current scope");
        assertTrue(table.lookup("x").isPresent(), "x should be found via outward lookup too");
    }

    @Test
    void lookupLocal_shouldNotSeeOuterScope() {
        assertTrue(table.declare(new Symbol("g", Kind.VARIABLE, null)));
        table.enterScope();
        assertTrue(table.lookupLocal("g").isEmpty(), "lookupLocal must NOT see outer decls");
        assertTrue(table.lookup("g").isPresent(), "lookup must see outer decls");
        table.exitScope();
    }

    @Test
    void shadowing_sameNameInnerScope_shouldBeAllowed_andResolveToInner() {
        assertTrue(table.declare(new Symbol("a", Kind.VARIABLE, null)), "declare a in global");
        table.enterScope();
        assertTrue(table.declare(new Symbol("a", Kind.VARIABLE, null)), "shadow a in inner scope");

        var local = table.lookupLocal("a");
        assertTrue(local.isPresent(), "inner a should be visible via lookupLocal");

        var outward = table.lookup("a");
        assertTrue(outward.isPresent(), "lookup should prefer nearest declaration");
        assertEquals(local.get(), outward.get(), "lookup should resolve to inner a first");

        table.exitScope();
        assertTrue(table.lookup("a").isPresent(), "outer a should remain after exiting inner scope");
    }

    @Test
    void duplicateDeclaration_sameScope_shouldFail() {
        assertTrue(table.declare(new Symbol("x", Kind.VARIABLE, null)));
        assertFalse(table.declare(new Symbol("x", Kind.VARIABLE, null)),
                "duplicate name in SAME scope must be rejected");
    }

    @Test
    void exitScope_shouldRemoveSymbolsDeclaredInThatScope() {
        table.enterScope();
        assertTrue(table.declare(new Symbol("temp", Kind.VARIABLE, null)));
        assertTrue(table.lookup("temp").isPresent(), "temp should be visible before exit");
        table.exitScope();
        assertTrue(table.lookup("temp").isEmpty(), "temp should not be visible after exit");
    }

    @Test
    void getScopeInfo_shouldReflectCurrentScopesAndSymbols() {
        assertTrue(table.declare(new Symbol("g", Kind.VARIABLE, null)));

        table.enterScope();
        assertTrue(table.declare(new Symbol("x", Kind.VARIABLE, null)));
        assertTrue(table.declare(new Symbol("add", Kind.FUNCTION, null)));

        table.enterScope();
        assertTrue(table.declare(new Symbol("x", Kind.VARIABLE, null))); // shadow
        assertTrue(table.declare(new Symbol("p", Kind.PARAMETER, null)));

        List<ScopeInfo> info = table.getScopeInfo();
        assertNotNull(info, "getScopeInfo should not return null");
        assertTrue(info.size() >= 3, "Expect at least 3 scopes (global + 2 inner)");

        boolean hasGlobal = info.stream()
                .anyMatch(si -> si.level() == 0 && contains(si.symbols(), "g"));
        assertTrue(hasGlobal, "global scope should contain g");

        boolean innerHasShadow = info.stream()
                .filter(si -> si.level() > 0)
                .anyMatch(si -> contains(si.symbols(), "x"));
        assertTrue(innerHasShadow, "inner scope should contain shadow x");

        boolean hasParam = info.stream()
                .anyMatch(si -> contains(si.symbols(), "p"));
        assertTrue(hasParam, "some scope should contain parameter p");
    }

    // Helper
    private boolean contains(List<Symbol> symbols, String name) {
        return symbols != null && symbols.stream().anyMatch(s -> Objects.equals(s.name(), name));
    }
}
