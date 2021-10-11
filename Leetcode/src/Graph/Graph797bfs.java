package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph797bfs {       ////797-所有可能的路径-dfs/bfs
    //bfs

    public static int [][] edge;
    public static int number;
    public static boolean [] isVisited;
    public static List<List<Integer>> path = new ArrayList<>();
    public static int times;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        times = 10;
        number = graph.length;
        edge = graph;
        isVisited = new boolean[number];
        for(int i = 0;i < number; i++) {
            isVisited[i] = false;
        }
        for(int i = 0;i < times;i++) {
            path.add(new ArrayList<>());
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < number;i++) {
            queue.offer(i);

            while(!queue.isEmpty()) {
                int node = queue.poll();
                isVisited[node] = true;
                path.get(0).add(node);

                for(int Node : edge[node]) {
                    if(isVisited[Node] = false) {
                        queue.offer(Node);
                    }
                }
            }
            //times++;
        }
        return path;
    }

    public static void main(String []args) {

        int [][] graph = {{1,2},{3},{3},{}};
        System.out.println(allPathsSourceTarget(graph));
    }

}
