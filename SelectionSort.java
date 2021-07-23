import java.util.Random;

class SelectionSort {
    private long[] selectionArray;
    private int nItems;

    public SelectionSort(int max) {
        selectionArray = new long[max];
        nItems = 0;
    }

    public void insert(long value) {
        selectionArray[nItems] = value;
        nItems++;
    }

    public void display() {
        for (int j = 0; j < nItems; j++) {
            System.out.print(selectionArray[j] + " ");
        }
        System.out.println("");
    }

    public void sort() {
        int out;
        int in;
        int min;
        for (out = 0; out < nItems - 1; out++) {
            min = out;
            for (in = out + 1; in < nItems; in++) {

                if (selectionArray[in] < selectionArray[min]) {
                    min = in;
                }
            }
            exchange(out, min);
        }
    }

    private void exchange(int one, int two) {
        long temp = selectionArray[one];
        selectionArray[one] = selectionArray[two];
        selectionArray[two] = temp;
    }
}
class SelectSortDeneme {
    public static void main(String[] args)
    {
        int maxSize = 100;
        SelectionSort arr = new SelectionSort(maxSize);
        Random random = new Random();

        for (int i=0; i<15; i++) {
            int r = random.nextInt(100);
            arr.insert(r);
        }

        System.out.println("Unsorted: ");
        arr.display();
        arr.sort();
        System.out.println("Sorted: ");
        arr.display();
    }
}