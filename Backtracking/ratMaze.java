public class ratMaze {
    public static boolean ratInMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze, 0, 0, path);
    }

    private static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
        int n = maze.length;
        /*
         * Check if i,j cell is valid or not
         */
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        /*
         * Include the cell inn the current path
         */
        path[i][j] = 1;

        /*
         * Destination cell
         */
        if (i == n - 1 && j == n - 1) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }

        // Explore further paths
        // top
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }
        // right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }
        // Down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }
        // Left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        boolean pathPossible = ratInMaze(maze);
        System.out.println(pathPossible);
    }
}