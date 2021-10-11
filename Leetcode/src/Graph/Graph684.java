package Graph;
import java.util.List;
import java.util.ArrayList;


public class Graph684 {     //684-冗余连接-uf
    //uf

    public static int number;
    public static int preNode [];                                 //并查集中每个节点的元节点

    public static int[] findRedundantConnection(int[][] edges) {

        number = edges.length;
        preNode = new int[number+1];
        for(int i = 1;i <= number; i++) {
            preNode[i]=i;                                            //初始化元节点为自身
        }

        for(int [] edge : edges) {

            if(find(preNode,edge[0]) != find(preNode,edge[1])) {
                join(preNode,edge[0],edge[1]);
            }
            else {
                return edge;
            }
        }
        return new int [0];

    }

    public static int find(int [] preNode,int node) {                //并查集find函数，查找元节点

        if (preNode[node] != node) {
            node = find(preNode,preNode[node]);
        }

        return node;
    }

    public static void join(int [] preNode, int node1, int node2) {   //并查集join函数，合并两个分支

        preNode[find(preNode,node1)] = find(preNode,node2);

    }


    public static void main(String [] args) {                          //测试用例

        int [][] edges = {{1,2},{1,3},{2,3}};

         int [] res = findRedundantConnection(edges);

        for(int i = 0; i< edges[0].length; i++) {
            System.out.println(res[i]);
        }
    }

}
