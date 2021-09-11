package Graph;
import java.util.List;
import java.util.ArrayList;

public class Graph547 {       //547-省份数量-dfs/bfs/并查集
    //dfs

    public static int [] isVisited;                          //节点访问状态 0/1
    public static int [][] connected;
    public static int city;

    public static int findCircleNum(int[][] isConnected) {

        int province = 0;
        city = isConnected.length;
        isVisited = new int [city];
        connected = isConnected;

        for(int i = 0; i < city;i++) {
            isVisited[i] = 0;
        }

        for(int i = 0; i < city;i++) {

            if(isVisited[i] == 0) {
                dfs(i);
                province++;
            }
        }

        return province;
    }

    public static void dfs(int node) {


        for(int  Node : connected[node]) {

            if(isVisited[Node] == 0 && connected[node][Node] ==1) {
                isVisited[node] = 1;
                dfs(Node);
            }
        }
    }


    public static void main(String args[]) {

        int [][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        System.out.println(findCircleNum(isConnected));

    }

}
