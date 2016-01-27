package com.hr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            
            // adjacency list
            Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
            
            int n = sc.nextInt(); // number of vertices
            int m = sc.nextInt(); // number of edges
            
            for (int i = 0; i < m; ++i) {
                // read the end vertices for each edge
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                
                // add the edges to the adjacency lists
                List<Integer> neighborList = adjList.get(v1);
                if (neighborList == null) {
                    neighborList = new ArrayList<Integer>();
                    adjList.put(v1, neighborList);
                }
                neighborList.add(v2);
                
                neighborList = adjList.get(v2);
                if (neighborList == null) {
                    neighborList = new ArrayList<Integer>();
                    adjList.put(v2, neighborList);
                }
                neighborList.add(v1);
            }
            
            int s = sc.nextInt(); // source vertex
            List<Integer> distances = bfs(adjList, n, s);
            int len = distances.size();
            for (int i = 0; i < distances.size(); ++i) {
                System.out.print(distances.get(i));
                if (i != len - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
    
    public static List<Integer> bfs(Map<Integer, List<Integer>> adjList, int n, int sourceVertex) {
        boolean[] visited = new boolean[n + 1];
        
        int[] distances = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            distances[i] = -1;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        distances[sourceVertex] = 0;
        
        while (!queue.isEmpty()) {
            int u = queue.remove();
            List<Integer> neighbors = adjList.get(u);
            if (neighbors != null) {
                for (Integer v : neighbors) {
                    if (!visited[v]) {
                        visited[v] = true;
                        distances[v] = distances[u] + 6;
                        queue.add(v);
                    }
                }
            }
        }
        
        List<Integer> d = new ArrayList<Integer>(n);
        for (int i = 1; i <= n; ++i) {
            if (i != sourceVertex) {
                d.add(distances[i]);
            }
        }
        return d;
        
    }
    
}
