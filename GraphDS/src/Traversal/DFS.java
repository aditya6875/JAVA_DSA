package Traversal;

import java.util.ArrayList;

public class DFS {

    public void dfs(int node,boolean visited[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res_dfs){
        visited[node] = true;
        res_dfs.add(node);

        // going to iterate on neighbors
        for(Integer i : adj.get(node)){
            if(visited[i]==false){
                dfs(i,visited,adj,res_dfs);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean [] visited = new boolean[V+1];
        visited[0] = true;
        ArrayList<Integer> res_dfs = new ArrayList<Integer>();
        dfs(0,visited,adj,res_dfs);
        return res_dfs;

    }

    public static void main(String args[]) {

        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        DFS sl = new DFS();
        ArrayList < Integer > ans = sl.dfsOfGraph(5, adj);
        int n = ans.size();
        for(int i = 0;i<n;i++) {
            System.out.print(ans.get(i)+" ");
        }
    }
}
