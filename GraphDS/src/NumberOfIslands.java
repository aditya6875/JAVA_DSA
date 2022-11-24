package QuestionOnGraph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    private void bfs(int r,int c, int[][] visited,char [][] grid)
    {
        visited[r][c] =1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.add(new Pair(r,c));
        int n=grid.length;
        int m= grid[0].length;

        // start queue traversal
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();

            // now traverse in the neighbours
            // and mark them visited

            for(int dr=-1;dr<=1;dr++){
                for(int dc=-1;dc<=1;dc++){
                    int nr=r+dr;
                    int nc=c+dc;

                    if(nr>=0 && nr<n && nc>=0 && nc<m &&
                    grid[nr][nc]=='1' && visited[nr][nc]==0){
                        visited[nr][nc]=1;
                        q.add(new Pair(nr,nc));
                    }
                }
            }
        }
    }
    public int numberOfIslands(char [][] grid){
        int n=grid.length;
        int m=grid[0].length;

        int [][] visited=new int[n][m];

        int count=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(visited[r][c]==0 && grid[r][c]=='1'){
                    count++;
                    bfs(r,c,visited,grid);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid={
                {'0', '1', '1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0', '1', '0'}
        };
        NumberOfIslands obj = new NumberOfIslands();
        System.out.println(obj.numberOfIslands(grid));
    }
}

class  Pair{
    int first, second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}