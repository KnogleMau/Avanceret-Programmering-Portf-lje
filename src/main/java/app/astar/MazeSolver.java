package app.astar;

import java.util.*;

public class MazeSolver {

    // 0 = åben, 1 = mur
    static int[][] grid = {
            {0,0,0,1,0,0,0,1,0,0,0,0},
            {1,1,0,1,0,1,0,1,0,1,1,0},
            {0,0,0,0,0,1,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,0},
            {0,0,0,0,0,0,0,0,1,0,0,0},
            {1,1,1,0,1,1,1,0,1,1,0,1},
            {0,0,0,0,0,0,1,0,0,0,0,0},
            {0,1,1,1,1,0,1,1,1,1,1,0},
            {0,0,0,0,1,0,0,0,0,0,1,0},
            {1,1,0,1,1,0,1,1,0,1,1,0},
            {0,0,0,0,0,0,1,0,0,0,1,0},
            {0,1,1,1,0,1,1,0,1,1,0,0},
    };

    static final int ROWS = 12, COLS = 12;

    public static void main(String[] args) {
        // Byg alle noder
        MazeNode[][] nodes = new MazeNode[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    nodes[r][c] = new MazeNode(r, c);
                }
            }
        }

        // Forbind naboer — urettede kanter i alle 4 retninger
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (nodes[r][c] == null) continue;
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && nodes[nr][nc] != null) {
                        nodes[r][c].addNeighbor(nodes[nr][nc]);
                    }
                }
            }
        }

        // Placér byer i nogle af de åbne celler. Cellen er stadig bare en node —
        // vi knytter et navn til dens position så vi kan finde vej "fra Nordby
        // til Sydby" i stedet for "fra (0,0) til (11,11)".
        Map<String, MazeNode> byer = new LinkedHashMap<>();
        byer.put("Nordby",   nodes[0][0]);
        byer.put("Skovby",   nodes[0][8]);
        byer.put("Vestby",   nodes[4][0]);
        byer.put("Centerby", nodes[4][4]);
        byer.put("Østby",    nodes[4][11]);
        byer.put("Søby",     nodes[6][0]);
        byer.put("Stenby",   nodes[7][5]);
        byer.put("Markby",   nodes[10][0]);
        byer.put("Sydby",    nodes[11][11]);

        MazeNode source = byer.get("Nordby");
        MazeNode destination = byer.get("Sydby");

        System.out.println("Finder korteste vej fra Nordby til Sydby...");
        findShortestPath(source, destination, byer);
    }

    // Manhattan-afstand som heuristik
    private static int heuristic(MazeNode node, MazeNode destination) {
        return Math.abs(destination.getRow() - node.getRow())
                + Math.abs(destination.getCol() - node.getCol());
    }

    public static void findShortestPath(MazeNode source, MazeNode destination, Map<String, MazeNode> byer) {
        Map<MazeNode, MazeNode> prev = new HashMap<>();
        Map<MazeNode, Integer> dist = new HashMap<>();
        Set<MazeNode> visited = new HashSet<>();

        PriorityQueue<NodeWithDist> queue = new PriorityQueue<>();
        queue.add(new NodeWithDist(source, 0, heuristic(source, destination)));
        dist.put(source, 0);

        while (!queue.isEmpty()) {
            NodeWithDist current = queue.poll();

            if (current.node.equals(destination)) break;
            if (visited.contains(current.node)) continue;
            visited.add(current.node);

            for (MazeNode next : current.node.getNeighbors()) {
                if (visited.contains(next)) continue;

                // Alle skridt koster 1 i en labyrint
                int newDist = current.gCost + 1;

                if (newDist < dist.getOrDefault(next, Integer.MAX_VALUE)) {
                    dist.put(next, newDist);
                    prev.put(next, current.node);
                    queue.add(new NodeWithDist(next, newDist, heuristic(next, destination)));
                }
            }
        }

        // Vendt opslag: node → bynavn, så vi kan vise bynavn i ruten
        Map<MazeNode, String> nodeTilNavn = new HashMap<>();
        for (Map.Entry<String, MazeNode> e : byer.entrySet()) {
            nodeTilNavn.put(e.getValue(), e.getKey());
        }

        // Rekonstruer stien via prev
        List<String> path = new ArrayList<>();
        MazeNode step = destination;
        while (step != null) {
            String label = nodeTilNavn.getOrDefault(step, "(" + step.getRow() + "," + step.getCol() + ")");
            path.add(0, label);
            step = prev.get(step);
        }

        System.out.println("Korteste vej: " + path);
        System.out.println("Antal skridt: " + (path.size() - 1));
    }

    private static class NodeWithDist implements Comparable<NodeWithDist> {
        MazeNode node;
        int gCost;
        int fCost;

        public NodeWithDist(MazeNode node, int gCost, int hCost) {
            this.node = node;
            this.gCost = gCost;
            this.fCost = gCost + hCost;
        }

        @Override
        public int compareTo(NodeWithDist other) {
            return Integer.compare(this.fCost, other.fCost);
        }
    }
}
