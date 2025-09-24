import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple tree structure used to validate Abstract Syntax Trees (ASTs).
 * Students will implement a toASTTestTree() method on their AST nodes
 * that returns an instance of this class.
 */
public class ASTTestTree {

    private final String label;
    private final List<ASTTestTree> children;

    public ASTTestTree(String label) {
        this.label = label;
        this.children = new ArrayList<>();
    }

    public void addChild(ASTTestTree child) {
        this.children.add(child);
    }

    public String getLabel() {
        return label;
    }

    public List<ASTTestTree> getChildren() {
        return children;
    }

    /**
     * Pretty-prints the tree in a readable format.
     */
    public String prettyPrint() {
        StringBuilder sb = new StringBuilder();
        prettyPrintHelper(sb, 0);
        return sb.toString();
    }

    private void prettyPrintHelper(StringBuilder sb, int indent) {
        sb.append("  ".repeat(indent)).append(label).append("\n");
        for (ASTTestTree child : children) {
            child.prettyPrintHelper(sb, indent + 1);
        }
    }

    /**
     * Compact string (useful for automated testing).
     * Example: (+ x (* y z))
     */
    @Override
    public String toString() {
        if (children.isEmpty()) {
            return label;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(label);
        for (ASTTestTree child : children) {
            sb.append(" ").append(child.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Equality check based on label and children.
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ASTTestTree)) return false;
        ASTTestTree other = (ASTTestTree) obj;
        return Objects.equals(label, other.label) &&
               Objects.equals(children, other.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, children);
    }
}
