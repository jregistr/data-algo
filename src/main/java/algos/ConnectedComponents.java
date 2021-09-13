package algos;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
From leetcode: https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

You have graph of n nodes. You are given an integer n and an array of edges
where edges[i] = [ai, bi] indicates that there is an edge between ai and bi
in the graph.

Input: n = 5, edges = [[0, 1], [1,2], [3, 4]]

0 ---- 1        3
       |        |
       |        |
       2        4

Solution is to use Union Find data structure.
 */
public class ConnectedComponents {

    public static int countComponent(int n, int[][] edges) {
        int[] parents = IntStream.rangeClosed(0, n - 1).toArray();
        int[] ranks = new int[n];
        Arrays.fill(ranks, 1);

        int connected = n;
        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            if(union(node1, node2, parents, ranks)) {
                connected --;
            }
        }
        return connected;
    }

    private static int findParent(int someNode, int[] parents) {
        int result = someNode;
        while (result != parents[result]) {
            parents[result] = parents[parents[result]];
            result = parents[result];
        }
        return result;
    }

    private static boolean union(int node1, int node2, int[] parents, int[] ranks) {
        int parentNode1 = findParent(node1, parents);
        int parentNode2 = findParent(node2, parents);

        if (parentNode1 == parentNode2) return false;

        if (ranks[parentNode2] > ranks[parentNode1]) {
            parents[parentNode1] = parentNode2;
            ranks[parentNode2] += ranks[parentNode1];
        } else {
            parents[parentNode2] = parentNode1;
            ranks[parentNode1] += ranks[parentNode2];
        }
        return  true;
    }
}
