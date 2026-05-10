package com.satyamdeb.connected.components;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int V = 7;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5)
        );


        System.out.println(findNumberOfComponent(V, edges));
    }

    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int n = 0;
        // Convert edges to Adj List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge: edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }


        boolean[] vis = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, adj, vis);
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
