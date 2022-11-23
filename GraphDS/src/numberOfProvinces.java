package QuestionOnGraph;

import java.util.ArrayList;

// 1-2-3     4-5-6    7-8
// numberOfProvinces here is = 3
// DFS Solution
public class numberOfProvinces {

    public void dfs(int i, int[] visited,ArrayList<ArrayList<Integer>> adjLs){
        visited[i]=1;
        for(Integer it: adjLs.get(i)){
            if(visited[it]==0){
                dfs(it,visited,adjLs);
            }

        }

    }
    public int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V){
        ArrayList<ArrayList<Integer>> adjLs= new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<V;i++)
        {
            adjLs.add(new ArrayList<Integer>());
        }

        // to change adjacency matrix to list
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adjMatrix.get(i).get(j)==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int [] visited = new int[V];
        int count=0;

        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,adjLs);
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args)
    {

        // adjacency matrix
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer> >();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        numberOfProvinces ob = new numberOfProvinces();
        System.out.println(ob.numProvinces(adj,3));
    }

}

// Time Complexity -- O(N)+O(V+2E)
// where N is for the outer loop and inner loops in total run as partial DFS over entire graph

// Space Complexity -- O(N)+O(N)
