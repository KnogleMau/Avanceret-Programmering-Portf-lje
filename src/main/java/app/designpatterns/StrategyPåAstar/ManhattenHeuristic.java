package app.designpatterns.StrategyPåAstar;

public class ManhattenHeuristic implements Heuristic{
    @Override
    public int estimate(MazeNode node, MazeNode destination) {
        return Math.abs(destination.getRow() - node.getRow())
                + Math.abs(destination.getCol() - node.getCol());
    }
}
