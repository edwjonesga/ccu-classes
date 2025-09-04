import java.util.HashMap;
import java.util.Map;







public class Main {
    public static void main(String[] args) {
        UnaryAdder adder = new UnaryAdder("111+11");
        System.out.println("Unary Addition Output: " + adder.compute());

        BinaryIncrementer incrementer = new BinaryIncrementer("111");
        System.out.println("Binary Increment Output: " + incrementer.compute());

        BinaryDecrementer decrementer = new BinaryDecrementer("1011");
        System.out.println("Binary Decrement Output: " + decrementer.compute());

        PalindromeChecker checker = new PalindromeChecker("11011");
        System.out.println("Palindrome Check Output: " + checker.check());

        BinaryAdder binaryAdder = new BinaryAdder("_1010+1011");
        System.out.println("Binary Addition Output: " + binaryAdder.compute());
    }
}

