package Graph;
import java.util.*;

public class Graph547bfs {          //547-省份数量-dfs/bfs/uf
    //bfs

    public static int [] isVisited;
    public static int city;


    public static int findCircleNum(int[][] isConnected){

        int province = 0;
        city = isConnected.length;
        isVisited = new int [city];
        for(int i = 0;i < city;i++) {
            isVisited[i] = 0;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < city;i++) {
            if(isVisited[i] == 0) {

                queue.offer(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    isVisited[node] = 1;
                    for(int j = 0;j < city;j++) {
                        if(isVisited[j] == 0 && isConnected[node][j] == 1) {
                            queue.offer(j);
                        }
                    }
                }
                province++;
            }
        }


        return province;
    }

    public static void main(String args[]) {

        int [][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        System.out.println(findCircleNum(isConnected));

    }
}
