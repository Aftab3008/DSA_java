import java.util.Scanner;
    class node{
    int data;
    node left, right;
    node(int data){
        this.data = data;
    }
}
public class tree_recu{
public static  tree takeinput(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root value ");
        int data = s.nextInt();
        tree root=new tree(data);
        System.out.println("No.of Children of "+data+" ");
        int count=s.nextInt();
        for(int i=0;i<count;i++){
            tree child=takeinput();
            root.children.add(child);
        }
        return root;
    }
public static void printf(tree root){
    String s=root.data +" :";
    for(int i=0;i<root.children.size();i++){
        s=s+root.children.get(i).data+",";
    }
    System.out.println(s);
    for(int i=0;i<root.children.size();i++){
        printf(root.children.get(i));
    }
}

    public static void main(String[] args) {
      tree root =takeinput();  
      printf(root);
    }
}
