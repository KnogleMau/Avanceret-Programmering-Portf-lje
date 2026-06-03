package app.designpatterns.StrategyPåAstar;

public class EuclidiskHeuristic implements Heuristic {
    @Override
    public int estimate(MazeNode node, MazeNode destination) {
        int dx = destination.getRow() - node.getRow();
        int dy = destination.getCol() - node.getCol();
        return (int) Math.sqrt(dx * dx + dy * dy);
    }
}
