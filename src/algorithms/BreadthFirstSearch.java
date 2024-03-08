package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch {

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

    // Perform BFS starting from vertex 0
    System.out.println("Breadth-First Search starting from vertex 0:");
    bfs(graph, 0);
  }

  static class Graph {

    private final int vertices;
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

  // method to perform BFS traversal
  private static void bfs(Graph graph, int vertex) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[graph.vertices];

    queue.offer(vertex);
    visited[vertex] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll();
      System.out.println(current + " ");

      for (int n : graph.getNeighbors(current)) {
        if (!visited[n]) {
          queue.offer(n);
          visited[n] = true;
        }
      }
    }
  }
}
