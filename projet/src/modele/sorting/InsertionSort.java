package modele.sorting;
import modele.SortingModel;

public class InsertionSort extends AbstractSort{

    public InsertionSort(SortingModel model){
        super(model);
    }

    @Override
    protected void sortImpl(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int a = read(array, i);
            int b = i - 1;

            while (b >= 0) {
                setCompareIndices(b + 1, b);
                if (!isLess(a, read(array, b))) {
                    break;
                }

                write(array, b + 1, read(array, b));
                b--;
            }

            write(array, b + 1, a);
        }
    }


    @Override
    public String getName() {
        return "InsertionSort";
    }
}
