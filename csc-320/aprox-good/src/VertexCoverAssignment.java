
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VertexCoverAssignment {

    public static class Graph {
        private final Map<String, Set<String>> adj;

        public Graph() {
            adj = new HashMap<>();
        }

        public void addEdge(String u, String v) {
            adj.computeIfAbsent(u, k -> new HashSet<>()).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<>()).add(u);
        }

        public Set<String> getVertices() {
            return adj.keySet();
        }

        public List<String[]> getEdges() {
            List<String[]> edges = new ArrayList<>();
            Set<String> seen = new HashSet<>();
            for (String u : adj.keySet()) {
                for (String v : adj.get(u)) {
                    String edgeKey = u.compareTo(v) < 0 ? u + "," + v : v + "," + u;
                    if (!seen.contains(edgeKey)) {
                        edges.add(new String[] { u, v });
                        seen.add(edgeKey);
                    }
                }
            }
            return edges;
        }

        public int degree(String node) {
            return adj.getOrDefault(node, Collections.emptySet()).size();
        }

        public void removeNode(String node) {
            if (adj.containsKey(node)) {
                for (String neighbor : adj.get(node)) {
                    adj.get(neighbor).remove(node);
                }
                adj.remove(node);
            }
        }

        public Graph copy() {
            Graph g = new Graph();
            for (String u : adj.keySet()) {
                for (String v : adj.get(u)) {
                    g.addEdge(u, v);
                }
            }
            return g;
        }

        public boolean hasEdges() {
            return !getEdges().isEmpty();
        }
    }

    // 1. Greedy Max-Degree Heuristic
    public static Set<String> vertexCoverMaxDegree(Graph graph) {
        Set<String> cover = new HashSet<>();
        Graph g = graph.copy();

        while (g.hasEdges()) {
            String maxNode = g.getVertices().stream().max(
                    Comparator.comparingInt(s -> g.degree(s))).orElseThrow(() -> new IllegalStateException());
            cover.add(maxNode);
            g.removeNode(maxNode);
        }
        return cover;
    }

    // 2. 2-Approximation Using Maximal Matching
    public static Set<String> vertexCoverTwoApprox(Graph graph) {
        Set<String> cover = null;

        return cover;
    }

    // 3. Generate a Pathological Graph
    public static Graph generatePathologicalGraph() {
        Graph g = new Graph();
        g.addEdge("1", "2");
        g.addEdge("1", "3");
        g.addEdge("3", "4");
        g.addEdge("4", "2");
        g.addEdge("2", "5");
        g.addEdge("3", "6");
        return g;
    }

    public static void main(String[] args) {
        Graph g = generatePathologicalGraph();

        Set<String> coverMaxDeg = vertexCoverMaxDegree(g);
        Set<String> coverTwoApprox = vertexCoverTwoApprox(g);

        System.out.println("Max-Degree Greedy Cover: " + coverMaxDeg + " (Size: " + coverMaxDeg.size() + ")");
        System.out.println("2-Approximation Cover: " + coverTwoApprox + " (Size: " + coverTwoApprox.size() + ")");
    }
}
