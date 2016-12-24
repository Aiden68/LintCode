/**
 *LintCode(176) Route Between Two Nodes in Graph
 *
 *题解BFS LinkList实现队列,HashSet标记是否访问。
 *
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * }
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {

        if (graph == null || s == null || t == null) return false;

        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        Set<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        q.offer(s);
        while (!q.isEmpty()) {
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                DirectedGraphNode node = q.poll();
                visited.add(node);
                if (node == t) return true;
                // push neighbors into queue
                if (node.neighbors.size() > 0) {
                    for (DirectedGraphNode n : node.neighbors) {
                        // avoid cylic
                        if (visited.contains(n)) continue;
                        q.offer(n);
                    }
                }
            }
        }

        return false;
    }
}