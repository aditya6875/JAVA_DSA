package GraphRepresentation;

public class Graph_Representation {
    public static void main(String[] args) {
        int n=3,m=3;
        int adj[][] = new int[n+1][n+1];

        //edge 1-2
        adj[1][2]=1;
        adj[2][1]=1;

        //edge 2-3
        adj[2][3]=1;
        adj[3][2]=1;

        //edge 1-3
        adj[1][3]=1;
        adj[3][1]=1;

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                System.out.print(adj[i][j]);
            }
            System.out.println();
        }

    }

}
