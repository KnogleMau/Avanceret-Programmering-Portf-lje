package app.designpatterns.CommandPåSort;

public class QuickSortCommand implements SortCommand {
    private Sorter sorter;
    private int[] arr;

    public QuickSortCommand(Sorter sorter, int[] arr) {
        this.sorter = sorter;
        this.arr = arr;
    }

    public void execute() {
        sorter.quickSort(arr);
    }
}
