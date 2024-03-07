package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DepthFirstSearch {

  public static void main(String[] args) {
    // Create a sample graph
    int vertices = 7;
    Graph graph = new Graph(vertices);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 5);
    graph.addEdge(2, 6);

    // Perform DFS starting from vertex 0
    System.out.println("Depth-First Search starting from vertex 0:");
    dfs(graph);
  }

  static class Graph {

    private static int vertices;
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph(int vertices) {
      this.vertices = vertices;
      this.adjacencyList = new HashMap<>();
      for (int i = 0; i < vertices; i++) {
        adjacencyList.put(i, new LinkedList<>());
      }
    }

    public void addEdge(int source, int destination) {
      adjacencyList.get(source).add(destination);
    }

    public List<Integer> getNeighbors(int vertex) {
      return adjacencyList.get(vertex);
    }
  }

  static void dfs(Graph graph) {
    boolean[] visited = new boolean[graph.vertices];
    dfsRecursion(graph, 0, visited);
  }

  static void dfsRecursion(Graph graph, int vertex, boolean[] visited) {
    visited[vertex] = true;
    System.out.println(vertex + " ");

    List<Integer> neighbors = graph.getNeighbors(vertex);
    for (var n : neighbors) {
      if (!visited[n]) {
        dfsRecursion(graph, n, visited);
      }
    }
  }
}
