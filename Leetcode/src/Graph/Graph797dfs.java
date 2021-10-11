package Graph;
import java.util.ArrayList;
import java.util.List;

public class Graph797dfs {      //797-所有可能的路径-dfs/bfs
    //dfs

    public static int [][] edge;
    public static int number;
    public static boolean [] visited;
    public static List<List<Integer>> path = new ArrayList<>();
    public static int times;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        times = 0;
        number = graph.length;
        edge = graph;
        visited = new boolean[number];

        for(int i =0;i < 4; i++) {
            path.add(new ArrayList<>());
        }

        for(int i = 0;i < number; i++) {
            visited[i] = false;
        }

        for(int i = 0;i < number; i++) {
            if(visited[i] == false) {
                dfs(i);
                times++;
            }
        }


        return path;

    }


    public static void dfs(int node) {

        visited[node] = true;
        path.get(times).add(node);

        for(int Node : edge[node]) {
            if(visited[Node] = false) {
                dfs(Node);
            }
        }
    }

    public static void main(String [] args) {

        int [][] graph = {{1,2},{3},{3},{}};

        System.out.println(allPathsSourceTarget(graph));
    }
}


//   1.如何动态的计算出path总数并对存储path的数组进行初始化
//   2.如何将路径初始结点重复加入路径中