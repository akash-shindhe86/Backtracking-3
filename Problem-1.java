// Time Complexity : O(mxn)
// Space Complexity : O(m) stack + O(mxn) for boolean array ~ O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Backtracking-3;

public class Problem-1 {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        boolean [][] grid = new boolean[n][n];
        backtrack(grid,0);
        return res;
    }

    private void backtrack(boolean [][] grid, int r){
        //base
        if(r == grid.length){
            //valid solution
            List<String> li = new ArrayList<>();
            for(int i = 0; i < grid.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < grid.length; j++){
                    if(grid[i][j]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                li.add(sb.toString());
            }
            res.add(li);
            return;
        }
        //logic
        for(int c = 0; c < grid.length; c++){
            if(isSafe(grid, r, c)){
                //action
                System.out.println(r+","+c +"are safe to put");
                grid[r][c] = true;
                //recurse
                backtrack(grid, r+1);
                System.out.println(r+","+c +"are not safe to put backtracking");
                //backtrack
                grid[r][c] = false;
            }
        }
    }

    private boolean isSafe(boolean [][] grid, int r, int c){
        //column up
        for(int i = 0; i < r; i++){
            if(grid[i][c]){
                return false;
            }
        }

        //diagonal up left check
        int i = r, j =c;
        while(i >= 0 && j>= 0){
            if(grid[i][j]){
                return false;
            }
            i--;
            j--;
        }

        //diagonal up right check
        i = r; j =c;
        while(i >= 0 && j < grid.length){
            if(grid[i][j]){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}
