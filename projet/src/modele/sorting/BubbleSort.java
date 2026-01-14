package modele.sorting;


public class BubbleSort extends AbstractSort{
    
    public BubbleSort(){
        super();
    }

    @Override
    public void sortImpl(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (isLess(read(array, j + 1), read(array, j))) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
