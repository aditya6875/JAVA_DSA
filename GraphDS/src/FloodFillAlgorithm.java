package QuestionOnGraph;

public class FloodFillAlgorithm {

    private void dfs(int row, int col,int[][] ans,
                     int[][] image,
                     int newColor, int dr[], int dc[],
                     int iniColor) {
        // color with new color
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        // there are exactly 4 neighbours
        for(int i = 0;i<4;i++) {
            int nrow = row + dr[i];
            int ncol = col + dc[i];
            // check for valid coordinate
            // then check for same initial color and unvisited pixel
            if(nrow>=0 && nrow<n && ncol>=0 && ncol < m &&
                    image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, newColor, dr, dc, iniColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // get initial color
        int iniColor = image[sr][sc];
        int[][] ans = image;
        // for neighbors
        int dr[] = {-1, 0, +1, 0};
        int dc[] = {0, +1, 0, -1};
        dfs(sr, sc, ans, image, newColor, dr, dc, iniColor);
        return ans;
    }


    public static void main(String[] args) {
        int[][] image =  {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        // sr = 1, sc = 1, newColor = 2
        FloodFillAlgorithm obj = new FloodFillAlgorithm();
        int[][] ans = obj.floodFill(image, 1, 1, 2);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++)
                System.out.print(ans[i][j] + " ");
            System.out.println();

        }
    }
}

