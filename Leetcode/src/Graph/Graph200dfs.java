package Graph;

public class Graph200dfs {

    public static  void main(String []args) {

        int [][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,1,0,0},{0,0,0,1,1}};

        numIslands(grid);
    }


    public static int numIslands(int [][] grid) {

        int b = grid[0].length;
        int a = grid.length;
        int num = 0;

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(grid[i][j] == 1){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }

        System.out.println(num);
        return num;
    }

    public static void dfs(int [][] grid ,int a,int b) {

        /*1*/
        if(a < 0 || b < 0 || a >= grid.length || b >= grid[0].length) {
            return ;
        }

        /*2*/
        if(grid[a][b] == 2 || grid[a][b] == 0) {
            return ;
        }

        grid[a][b] = 2 ;


        /*3*/
        dfs(grid,a,b-1);
        dfs(grid,a,b+1);
        dfs(grid,a-1,b);
        dfs(grid,a+1,b);


    }

}
