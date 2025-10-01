public interface SymbolTable {

/**
 * Declare a new symbol in the current scope.
 * @param symbol the symbol to declare
 * @return true if successfully declared, false if duplicate in this scope
 */
boolean declare(Symbol symbol);

/**
 * Lookup a symbol in the current scope only.
 */
Optional<Symbol> lookupLocal(String name);

/**
 * Lookup a symbol in the current and enclosing scopes.
 */
Optional<Symbol> lookup(String name);

/**
 * Enter a new scope (e.g., function, block).
 */
void enterScope();

/**
 * Exit the current scope, discarding its symbols.
 */
void exitScope();

/**
 * Return a structured view of current scopes (for testing).
 */
List<ScopeInfo> getScopeInfo();
}
