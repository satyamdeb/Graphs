package com.satyamdeb.traversal;

import java.util.*;
public class Solution {

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 2),
                Arrays.asList(0, 3),
                Arrays.asList(0, 1),
                Arrays.asList(2, 4)
        );

        System.out.println(bfsOfGraph(V, edges));
        System.out.println(dfsOfGraph(V, edges));
    }

    public static List<Integer> dfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();

        // Convert edges to Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i ++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge: edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] vis = new boolean[V];

        dfs(0, adj, vis, ans);

        return ans;
    }

    private static void dfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> ans) {
        vis[node ] = true;
        ans.add(node);

        for(int adjacentElement: adj.get(node)) {
            if(!vis[adjacentElement]) {
                dfs(adjacentElement, adj, vis, ans);
            }
        }

    }

    public static List<Integer> bfsOfGraph(int V, List<List<Integer>> edges) {
        List<Integer> bfs = new ArrayList<>();

        List<List<Integer>> adj = new ArrayList<>();
        // Convert edges to adj;
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge: edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] vis = new boolean[V];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            List<Integer> adjacentElements = adj.get(node);
            for(int e: adjacentElements) {
                if(!vis[e]) {
                    vis[e] = true;
                    q.add(e);
                }
            }
        }

        return bfs;
    }
}
