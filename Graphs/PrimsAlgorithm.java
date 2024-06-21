import java.util.Scanner;

public class PrimsAlgorithm {

    public static int findMinVertex(int[] weight, boolean[] visited){
        int minVertex=-1;
        for(int i=0;i<weight.length;i++){
            if(!visited[i] && (minVertex==-1 || weight[i]<weight[minVertex])){
                minVertex=i;
            }
        }
        return minVertex;
    }

    public static void Prims(int[][] garph){
        int n=garph.length;
        int[] parent=new int[n];
        int[] weight=new int[n];
        boolean[] visited=new boolean[n];
        parent[0]=-1;
        weight[0]=0;
        for(int i=1;i<n;i++){
            weight[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int minVertex=findMinVertex(weight,visited);
            visited[minVertex]=true;
            for(int j=0;j<n;j++){
                if(garph[minVertex][j]!=0 && !visited[j]){
                    if(garph[minVertex][j]<weight[j]){
                        weight[j]=garph[minVertex][j];
                        parent[j]=minVertex;
                    }
                }
            }
        }
        System.out.println("Edges of MST are: ");
        for(int i=1;i<n;i++){
            if(parent[i]<i){
                System.out.println(parent[i]+" "+i+" "+weight[i]);
            }else{
                System.out.println(i+" "+parent[i]+" "+weight[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int e=input.nextInt();
        int[][] graph=new int[n][n];
        for(int i=0;i<e;i++){
            int a=input.nextInt();
            int b=input.nextInt();
            int w=input.nextInt();
            graph[a][b]=w;
            graph[b][a]=w;
        }
        Prims(graph);
    }
}
