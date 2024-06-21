import java.util.Scanner;

public class new_bit {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String s = input.next();
            // BigInteger S= new BigInteger(s);
            int S = Integer.parseInt(s, 2);
            // System.out.println(S);
            if (S % 3 == 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
