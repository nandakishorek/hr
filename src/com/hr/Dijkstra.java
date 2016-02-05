/**
 * 
 */
package com.hr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author kishore
 *
 */
public class Dijkstra {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Graph g = new Graph();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < m; ++i) {
                g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            
            int s = sc.nextInt();
            List<Integer> distances = g.shortestPaths(s);
            for (int d : distances) {
                System.out.print(d + " ");
            }
            System.out.println("");
        }
        
        sc.close();

    }
    
}

/**
 * Represents a graph with undirected edges
 * 
 * @author kishore
 *
 */
class Graph {
    private Map<Integer, List<Edge>> adjList;
    int numOfEdges;
    
    public Graph() {
        this.adjList = new HashMap<Integer, List<Edge>>();
        this.numOfEdges = 0;
    }
    
    public void addEdge(int u, int v, int weight) {
        List<Edge> uList = adjList.get(u);
        if (uList == null) {
            uList = new LinkedList<Edge>();
            adjList.put(u, uList);
        }
        
        List<Edge> vList = adjList.get(v);
        if (vList == null) {
            vList = new LinkedList<Edge>();
            adjList.put(v, vList);
        }
        
        Edge edge = new Edge(u, v, weight);
        uList.add(edge);
        vList.add(edge);
        
        ++numOfEdges;
    }
    
    /**
     * shortest path lengths from source vertex to every other vertex using Dijkstra's algo
     * -1 if there is no path.
     * 
     * @param source
     * @return
     */
    public List<Integer> shortestPaths(int source) {
        
        // init
        PriorityQueue<Distance> priorityQueue = new PriorityQueue<Distance>();
        Map<Integer, Distance> distances = new HashMap<Integer, Distance>();

        for (int vertex : adjList.keySet()) {
            distances.put(vertex, new Distance(vertex, -1));
        }

        // for source distance value should be zero
        distances.put(source, new Distance(source, 0));
        
        // enqueue start vertex
        priorityQueue.add(distances.get(source));
        
        while(!priorityQueue.isEmpty()) {
            // dequeue vertex with highest priority
            Distance currDistance = priorityQueue.remove();

            int currVertex = currDistance.getToVertex();
            
            List<Edge> neighborList = adjList.get(currVertex);
            if (neighborList != null) {
                
                // perform relax operation on all the outgoing edges
                for (Edge edge : neighborList) {
                    int neighbor = edge.getOtherEnd(currVertex);
                    
                    Distance neighborDistance = distances.get(neighbor);
                    int possibleNewDistance = edge.getWeight() + currDistance.getDistance();
                    
                    if (neighborDistance.getDistance() == -1 || possibleNewDistance <  neighborDistance.getDistance()) {
                        // there is a another shorter path
                        neighborDistance.setDistance(possibleNewDistance);
                        
                        // enqueue the neighbor
                        priorityQueue.add(neighborDistance);
                    }
                }
            }
        }
        
        List<Integer> pathLengths = new ArrayList<Integer>(adjList.size() - 1);
        for (int i = 1; i <= adjList.size(); ++i) {
            if (i != source) {
                pathLengths.add(distances.get(i).getDistance());
            }
        }
        
        return pathLengths;
    }
    
    private class Edge {
        int v1;
        int v2;
        int weight;
        
        public Edge(int u, int v, int weight) {
            this.v1 = u;
            this.v2 = v;
            this.weight = weight;
        }
        
        public int getWeight(){
            return weight;
        }
        
        public int getOtherEnd(int u) {
            if (v1 == u) {
                return v2;
            } else {
                return v1;
            }
        }
        
        @Override
        public String toString() {
            return "Edge [v1=" + v1 + ", v2="+ v2 + ", weight=" + weight + "]";
        }
    }
    
    private class Distance implements Comparable<Distance> {
        
        // any vertex other than source
        private int toVertex;
        
        // the shortest distance from the source vertex, same as the shortest path length
        private int distance;

        public Distance(int toVertex, int distance) {
            super();
            this.toVertex = toVertex;
            this.distance = distance;
        }

        /**
         * Method to compare priority of one vertex to another in Dijkstra's algo
         * Vertex closer to the source get higher priority i.e., lower distance will get higher priority.
         * 
         * @param other The other vertex to be compared with
         */
        @Override
        public int compareTo(Distance other) {
            
            if (this.distance < other.distance) {
                return -1;
            } else if (this.distance  > other.distance) {
                return 1;
            }
            
            return 0;
        }

        public int getToVertex() {
            return toVertex;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
        
        @Override
        public String toString() {
            return "Distance [toVertex=" + toVertex + ", distance=" + distance + "]";
        }
    }
}
