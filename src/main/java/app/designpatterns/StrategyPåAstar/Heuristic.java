package app.designpatterns.StrategyPåAstar;

public interface Heuristic {
    int estimate(MazeNode node, MazeNode destination);
}