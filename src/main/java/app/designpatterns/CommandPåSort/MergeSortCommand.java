package app.designpatterns.CommandPåSort;

public class MergeSortCommand implements SortCommand {
    private Sorter sorter;
    private int[] arr;

    public MergeSortCommand(Sorter sorter, int[] arr) {
        this.sorter = sorter;
        this.arr = arr;
    }

    public void execute() {
        sorter.mergeSort(arr);
    }
}
