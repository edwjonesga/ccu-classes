package compiler.cli;

import compiler.infra.CompilerContext;
import compiler.infra.CompilerOrchestrator;
import compiler.infra.CompilerPass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Main <source-file>");
            return;
        }

        String sourceFile = args[0];

        try (InputStream inputStream = new FileInputStream(sourceFile)) {
            // Create the compiler context and set the input stream
            CompilerContext context = new CompilerContext();
            context.setInputStream(inputStream);

            // Create the compiler pass orchestrator and add passes
            CompilerOrchestrator orchestrator = new CompilerOrchestrator();

            // Example passes (to be implemented by students) Note: you may choose to separate
            // your passes differently. E.g. you may make a LexerParserPass class because that makes more
            // sense to you.
            // orchestrator.addPass(new LexicalAnalysisPass());
            // orchestrator.addPass(new SyntaxAnalysisPass());
            // orchestrator.addPass(new TypeCheckingPass());
            // orchestrator.addPass(new CodeGenerationPass());

            // Run the compiler passes
            orchestrator.runPasses(context);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}