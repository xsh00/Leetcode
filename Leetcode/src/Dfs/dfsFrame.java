package Dfs;


/**
 * <p>
 * Title: dfsFrame
 * </p>
 *
 * <p>
 * Description: 将不同数据结构（树、图等）的dfs遍历方式抽象为框架
 * </p>
 *
 *
 * @author xsh00
 */


public class dfsFrame {

    /*二叉树*/
    public void dfs (TreeNode node) {

        /*1. 判断base case  即返回条件*/
        if(node == null){
            return;
        }

        /*2. 递归调用  遍历后续结点 */
        dfs(node.left);
        dfs(node.right);

    }


    /*网格结构图*/
    public  void dfs (int [][] grid, int a, int b ) {

        /*1.判断base case  即返回条件*/
        /*对于网格结构来说，返回条件即为遍历超出网格边界*/
        if(a < 0 || a > grid[0].length || b < 0 || b > grid.length) {
            return;
        }


        /*2.判断结点是否重复遍历并标记当前结点*/
        if(grid[a][b] == 1) {
            return;
        }

        grid[a][b] = 1;


        /*3. 递归调用  遍历后续结点 */
        /*对于网格结构来说，其后续结点为上下左右4个结点*/
        dfs(grid,a-1,b);
        dfs(grid,a,b-1);
        dfs(grid,a+1,b);
        dfs(grid,a,b+1);

    }


    /*邻接表标识的图*/





}
