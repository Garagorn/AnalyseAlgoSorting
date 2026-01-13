package modele.sorting;

public class InsertionSort extends AbstractSort{

    public InsertionSort(){
        super();
    }

    @Override
    protected void sortImpl(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int a = read(array, i);
            int b = i - 1;
            while (b >= 0 && isLess(a, read(array, b))) {
                write(array, b + 1, read(array, b));
                b--;
            }
            write(array, b + 1, a);
        }
    }


    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
