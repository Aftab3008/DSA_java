import java.util.Scanner;

public class bit_prob {
  public static boolean isOneBitCharacter(int[] bits) {
    int n = bits.length;
    if (bits[n - 1] == 0 && bits[n - 2] == 0) {
      return true;
    } else {
      return false;
    }

  }

  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      int l = input.nextInt();
      int[] bits = new int[l];
      for (int i = 0; i < l; i++) {
        bits[i] = input.nextInt();
      }
      boolean is_true = isOneBitCharacter(bits);
      System.out.println(is_true);
    }

  }
}
