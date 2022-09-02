package Graph;

// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
// Time Complexity: O(N^3)
// Space Complexity: O(V^2)

public class FloydWarshallAlgorithm {
    public static void main(String[] args) {

    }

    private void FloydWarshallAlgorithm(int n, int[][] graph) {
        Integer[][] dist = new Integer[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}
