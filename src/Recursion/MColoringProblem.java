package Recursion;

// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

public class MColoringProblem {
    class solve {
        // Function to determine if graph can be coloured with at most M colours
        // such
        // that no two adjacent vertices of graph are coloured with same colour.
        public boolean graphColoring(boolean graph[][], int m, int n) {
            // Your code here
            int[] colors = new int[n];
            return colorTheGraph(graph, m, 0, n, colors);
        }

        private boolean colorTheGraph(boolean graph[][], int m, int node, int n, int[] colors) {
            if(node == n) {
                return true;
            }

            for(int color=1; color<=m; color++) {
                if(isSafe(graph, color, colors, node)) {
                    colors[node] = color;
                    if(colorTheGraph(graph, m, node+1, n, colors)) {
                        return true;
                    }
                    colors[node] = 0;
                }
            }

            return false;
        }

        private boolean isSafe(boolean[][] graph, int color, int[] colors, int node) {
            for(int i=0; i<graph[0].length; i++) {
                if(graph[node][i] == true && colors[i]==color) {
                    return false;
                }
            }

            return true;
        }
    }
}
