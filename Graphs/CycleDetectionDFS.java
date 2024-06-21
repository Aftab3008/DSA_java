import java.util.Scanner;

public class CycleDetectionDFS {
    public static boolean hasCycle(int[][] graph,int sv,int parent,boolean[] visited){
        visited[sv]=true;
        for(int i=0;i<graph.length;i++){
            if(graph[sv][i]==1){
                if(!visited[i]){
                    if(hasCycle(graph,i,sv,visited)){
                        return true;
                    }
                }else if(i!=parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int e = input.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < e; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        boolean[] visited=new boolean[n];
        boolean isCycle=hasCycle(graph, 0, -1, visited);
        System.out.println(isCycle);
    }
}
