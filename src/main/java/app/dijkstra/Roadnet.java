package app.dijkstra;

import java.util.*;
import java.util.stream.Collectors;

public class Roadnet {

    public static void main(String[] args) {
        // Vejnet med 10 byer i Jylland og på Fyn. Vægtene er ca. afstande i km.
        WeightedNode aarhus = new WeightedNode("Aarhus");
        WeightedNode silkeborg = new WeightedNode("Silkeborg");
        WeightedNode skanderborg = new WeightedNode("Skanderborg");
        WeightedNode horsens = new WeightedNode("Horsens");
        WeightedNode vejle = new WeightedNode("Vejle");
        WeightedNode fredericia = new WeightedNode("Fredericia");
        WeightedNode kolding = new WeightedNode("Kolding");
        WeightedNode esbjerg = new WeightedNode("Esbjerg");
        WeightedNode middelfart = new WeightedNode("Middelfart");
        WeightedNode odense = new WeightedNode("Odense");

        aarhus.addNeighbor(skanderborg, 25);
        aarhus.addNeighbor(silkeborg, 45);
        silkeborg.addNeighbor(vejle, 60);
        skanderborg.addNeighbor(silkeborg, 30);
        skanderborg.addNeighbor(horsens, 25);
        horsens.addNeighbor(vejle, 30);
        horsens.addNeighbor(fredericia, 50);
        vejle.addNeighbor(fredericia, 25);
        vejle.addNeighbor(kolding, 25);
        fredericia.addNeighbor(middelfart, 20);
        kolding.addNeighbor(middelfart, 40);
        kolding.addNeighbor(esbjerg, 70);
        middelfart.addNeighbor(odense, 25);
        esbjerg.addNeighbor(odense, 140);

        findShortestPath(aarhus, odense);
    }


    public static void findShortestPath(WeightedNode source, WeightedNode destination) {
        Map<WeightedNode, WeightedNode> prev = new HashMap<>();

        Map<WeightedNode, Integer> dist = new HashMap<>();

        Set<WeightedNode> visited = new LinkedHashSet<>();

        // Køen sorterer efter dist fordi NodeWithDist implementerer Comparable
        PriorityQueue<NodeWithDist> queue = new PriorityQueue<>();

        queue.add(new NodeWithDist(source, 0));
        dist.put(source, 0);

        System.out.println("=== Dijkstra: korteste vej fra " + source.getName()
                + " til " + destination.getName() + " ===\n");

        int trin = 1;
        while (!queue.isEmpty()) {
            NodeWithDist current = queue.poll();

            if (visited.contains(current.node)) continue;

            System.out.println("Trin " + trin++ + ": Besøger " + current.node.getName()
                    + " (afstand fra " + source.getName() + " = " + current.dist + " km)");

            visited.add(current.node);

            if (current.node.equals(destination)) {
                System.out.println("  → Vi er nået frem til " + destination.getName() + "!\n");
                break;
            }

            // Slap kanterne ud til alle naboer
            for (Map.Entry<WeightedNode, Integer> entry : current.node.getNeighbors().entrySet()) {
                WeightedNode next = entry.getKey();
                int weight = entry.getValue();

                if (visited.contains(next)) continue;

                int newDist = current.dist + weight;
                Integer oldDist = dist.get(next);

                if (newDist < (oldDist == null ? Integer.MAX_VALUE : oldDist)) {
                    dist.put(next, newDist);
                    prev.put(next, current.node);
                    queue.add(new NodeWithDist(next, newDist));

                    String før = oldDist == null ? "∞" : oldDist + " km";
                    System.out.println("    Afstanden til " + next.getName() + " er nu " + newDist
                            + " km (før " + før + ", via " + current.node.getName() + ")");
                }
            }

            printStatus(visited, queue);
            System.out.println();
        }

        // Rekonstruer stien fra destination tilbage til source
        List<String> path = new ArrayList<>();
        WeightedNode step = destination;
        while (step != null) {
            path.add(0, step.getName());
            step = prev.get(step);
        }

        System.out.println("=== Resultat ===");
        System.out.println("Korteste vej: " + String.join(" → ", path));
        System.out.println("Samlet afstand: " + dist.get(destination) + " km");
    }

    // Lille hjælper der viser hvilke byer vi er færdige med, og hvad der står i kø lige nu.
    // Køen kan indeholde forældede entries — vi viser kun den bedste kendte for hver by.
    private static void printStatus(Set<WeightedNode> visited, PriorityQueue<NodeWithDist> queue) {
        String visitedStr = visited.stream()
                .map(WeightedNode::getName)
                .collect(Collectors.joining(", "));

        Map<String, Integer> bedsteIKø = new LinkedHashMap<>();
        for (NodeWithDist n : queue) {
            if (visited.contains(n.node)) continue;
            bedsteIKø.merge(n.node.getName(), n.dist, Math::min);
        }
        String køStr = bedsteIKø.entrySet().stream()
                .map(e -> e.getKey() + "(" + e.getValue() + ")")
                .collect(Collectors.joining(", "));

        System.out.println("    Visited: [" + visitedStr + "]");
        System.out.println("    I kø:    [" + køStr + "]");
    }

    // Hjælpeklasse der pakker en node og dens afstand sammen, så PriorityQueue
    // selv kan sortere uden at kigge i et separat dist-map.
    private static class NodeWithDist implements Comparable<NodeWithDist> {
        WeightedNode node;
        int dist;

        public NodeWithDist(WeightedNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(NodeWithDist other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
