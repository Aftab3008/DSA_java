import java.util.Scanner;

class Node{
         int data;
         Node next;
         Node(int data){
            this.data=data;
         }
}
public class firstll {
 public static Node fun(){
    try (Scanner input = new Scanner(System.in)) {
        int data=input.nextInt();
        Node head=new Node(data);
        Node h1=head;
        data=input.nextInt();
        while(data!=-1){
            Node currentNode=new Node(data);
            head.next=currentNode;
            head=currentNode;
            data=input.nextInt();
        }
        head=h1;
        return head;
    }
 }
public static Node rem(Node head,int pos){
    if(pos==0){
        head=head.next;
    }
    
    return head;

}
public static void main(String[] args) {
    Node head=fun();
    Node h1=head;
    System.out.println("Enter the position you want to remove");
    Scanner inputs= new Scanner(System.in);
    int pos=20;//inputs.nextInt();
  //  head=rem(head,pos);
 // Node inser=new Node(pos);
  //inser.next=head;
 // head=inser;
 boolean swapped;
        Node current;
        Node tail = null;
 do {
    swapped = false;
    current = head;

    while (current.next != tail) {
        if (current.data > current.next.data) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            swapped = true;
        }
        current = current.next;
    }
    tail = current;
} while (swapped);
/*   while(head!=null){
    int temp;
    if(head.next!=null && head.data>head.next.data){
        temp=head.next.data;
        head.next.data=head.data;
        head.data=temp;
    }
    head=head.next;
  }*/
  head=h1;
    while(head!=null){
        System.out.println(head.data);
        head=head.next;
    }
    //System.out.println(head);
    //head=h1;
   //System.out.println(head);
}
    
}