class stack_using_array{
    private  int data[];
    private int topIndex=-1;
    public stack_using_array(){
        data=new int[10];
    }
     public void push(int elem){
        data[topIndex+1]=elem;
        topIndex++;
     }
     public void pop(){
        topIndex--;
     }
     public int size(){
        return topIndex+1;
     }
     public boolean isEmpty(){
        if(topIndex==-1){
            return true;
        }
        return false;
     }
     public int top(){
        if(topIndex==-1){
            return -1;
        }
        return data[topIndex];
     }
}
public class stack_array {
    public static void main(String[] args) {
        stack_using_array stack=new stack_using_array();
      //  stack.push(10);
      //  stack.push(20);
      //  stack.push(30);
      //  stack.push(40);
      //  stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.isEmpty());
    }
}
