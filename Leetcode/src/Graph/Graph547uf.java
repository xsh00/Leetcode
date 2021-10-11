package Graph;

public class Graph547uf {               //547-省份数量-dfs/bfs/uf
    //uf

    public static int [] preNode;
    public static int number;

    public static int findCircleNum(int[][] isConnected) {
        int province = 0;
        number = isConnected.length;
        preNode = new int [number];
        for(int i = 0;i < number;i++) {
            preNode[i] = i;
        }

        for(int i = 0;i < number;i++) {
            for(int j = 0;j < number;j++) {
                if(isConnected[i][j] == 1 ) {
                    union(preNode,i,j);
                }
            }
        }

        for(int i = 0;i < number;i++) {
            if(find(preNode,i) == i) {
                province++;
            }
        }

        return province;

    }


    public static void union(int [] preNode,int node1,int node2) {

        preNode[find(preNode,node1)] = find(preNode,node2);

    }

    public static int find(int [] preNode ,int node) {

        while(preNode[node] != node) {
            node = find(preNode, preNode[node]);
        }
        return node;
    }

    public static void main(String args[]) {

        int [][] isConnected = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};

        System.out.println(findCircleNum(isConnected));

    }

}
