package compiler.infra;

import java.io.InputStream;

/**
 * Shared compiler state that passes can read or modify.
 * This context object acts as the central hub for all compiler data.
 */
public class CompilerContext {
    private InputStream inputStream;

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    // Add fields like tokens, ASTNode, IR, symbol tables, etc. Whatever you need to make your compiler work
}