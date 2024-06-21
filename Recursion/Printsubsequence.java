public class Printsubsequence {
    public static void printsubsequence(String input, String outputsoFar) {
        if (input.length() == 0) {
            System.out.println(outputsoFar);
            return;
        }
        /*
         * We choose not to include first character
         */
        printsubsequence(input.substring(1), outputsoFar);
        /*
         * We choose to include first character
         */
        printsubsequence(input.substring(1), outputsoFar + input.charAt(0));
    }

    public static void printsubsequence(String input) {
        printsubsequence(input, "");
    }

    public static void main(String[] args) {
        printsubsequence("xyz");
    }
}
