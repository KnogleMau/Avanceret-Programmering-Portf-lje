package app.algoritms.maze;

public class MazeExercise {
    static final int N = 6;

    static int[][] maze = {
            {1, 0, 1, 1, 1, 0},
            {1, 1, 1, 0, 1, 0},
            {0, 0, 1, 0, 1, 1},
            {0, 1, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1}
    };

    static int[][] path = new int[N][N];

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            printPath();
        } else {
            System.out.println("Ingen løsning fundet.");
        }
    }

    // TODO: Implementer denne metode
    static boolean solveMaze(int row, int col) {
        if(row < 0 || col < 0 || row >= N || col >= N){
            return false;
        }
        if(maze[row][col] == 0){return false;}

        if(path[row][col] == 1){ return false;}

        path[row][col] = 1;

        if(row == N - 1 && col == N - 1){ return true;}

        if(solveMaze(row + 1, col)) return true; // ned
        if (solveMaze(row, col + 1)) return true; // Højre
        if (solveMaze(row - 1, col)) return true; // op
        if(solveMaze(row, col - 1)) return true; // Venstre

        path[row][col] = 0;

        return false;
    }

    static void printPath() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
