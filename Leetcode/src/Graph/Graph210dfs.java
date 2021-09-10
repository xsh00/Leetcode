package Graph;

import java.util.ArrayList;
import java.util.List;


public class Graph210dfs {        //210-课程表-拓扑排序

    public static boolean isCircle = false;
    public static List<List<Integer>> edge = new ArrayList<>();
    public static ArrayList<String> isVisited = new ArrayList<>();          //isVisited有3种状态  waiting、visiting、visited
    public static int [] result ;
    public static int index;


    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        index = numCourses-1;
        result = new int [numCourses];

        for(int i = 0;i<numCourses;i++) {                                   //初始化edge、isVisited
            edge.add(new ArrayList<>());
            isVisited.add("waiting");
        }

        for(int [] info : prerequisites) {                                  //邻接表存入edge信息
            edge.get(info[1]).add(info[0]);
        }

        System.out.println(edge);
        System.out.println(isVisited.get(0));

        for(int i = 0;i < numCourses ;i++) {
            if(isVisited.get(i).equals("waiting")){
                dfs(i);
            }

            if(isCircle == true){
                return new int [0];
            }

        }

        for(int j = 0;j < numCourses;j++) {
            System.out.println(result[j]);
        }
    return result;
    }


    public static void dfs(int node) {

        isVisited.set(node,"visiting");

        for(int nextNode : edge.get(node)) {

            if(isVisited.get(nextNode).equals("waiting")) {
                dfs(nextNode);
                if(isCircle == true) {
                    return;
                }
            }

            else if(isVisited.get(nextNode).equals("visiting")) {
                isCircle = true;
                return;
            }
        }

        isVisited.set(node,"visited");
        result[index--] = node;

        return ;
    }


    public static void main (String [] arg) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};


        findOrder(numCourses,prerequisites);

    }


}
