import java.util.ArrayList;

class tree{
    int data;
    ArrayList<tree> children;
    tree(int data){
        this.data=data;
        children =new ArrayList<>();
    }
}

public class trees_one {
    public static void main(String[] args) {
        tree a = new tree(1);
        tree b = new tree(2);
        tree c = new tree(3);
        a.children.add(b);
        a.children.add(c);
        System.out.println("a: "+a.data+"\n");
        for(int i=0;i<a.children.size();i++){
            System.out.print("  " + a.children.get(i)+": "+a.children.get(i).data);
        }
    }
}