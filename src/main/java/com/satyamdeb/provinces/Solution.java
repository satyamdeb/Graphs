package com.satyamdeb.provinces;


import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] adj = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        System.out.println(numProvinces(adj));

    }


    public static int numProvinces(int[][] adj) {
        int n = 0;
        int V = adj.length;

        // Create Adj List
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                if(adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        // Iterate over all nodes
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, adjList, vis);
                n++;
            }
        }

        return n;
    }
    private static void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for(int neighbour: adj.get(node)) {
            if(!vis[neighbour]) {
                vis[neighbour] = true;
                dfs(neighbour, adj, vis);
            }
        }
    }
}
