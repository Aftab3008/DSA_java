//import java.util.*;
public class bit_1 {

public static void main(String[] args) {
    int a=5;
    int b=a<<1;
    boolean iseven=(b & 1)== 0;
    if(iseven){
        System.out.println("Even");
    }
    else{
        System.out.println("Odd");
    }
    System.out.println(b);
    
}
    
}
