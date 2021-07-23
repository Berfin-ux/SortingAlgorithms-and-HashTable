
import java.util.Random;

class QuickSort {
    private long[] quickArray;
    private int nItems;

    public QuickSort(int max) {
        quickArray = new long[max];
        nItems = 0;
    }

    public void insert(long value) {
        quickArray[nItems] = value;
        nItems++;
    }

    public void display() {
        System.out.print("");
        for(int j=0; j<nItems; j++) {
            System.out.print(quickArray[j] + " ");
        }
        System.out.println("");
    }

    public void sort(){
        qSort(0, nItems-1);
    }

    public void qSort(int left, int right) {

        int size = right-left+1;

        if(size < 10) {
            insertionSort(left, right);
        }
        else {
            long median = median(left, right);
            int partition = partition(left, right, median);
            qSort(left, partition-1);
            qSort(partition+1, right);
        }
    }

    public long median(int left, int right) {

        int center = (left+right)/2;

        if( quickArray[left] > quickArray[center] ) {
            exchange(left, center);
        }
        if( quickArray[left] > quickArray[right] ) {
            exchange(left, right);
        }
        if( quickArray[center] > quickArray[right] ) {
            exchange(center, right);
        }
        exchange(center, right-1);
        return quickArray[right-1];
    }

    public void exchange(int one, int two) {
        long temp = quickArray[one];
        quickArray[one] = quickArray[two];
        quickArray[two] = temp;
    }

    public int partition(int left, int right, long median) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while(true) {
            while( quickArray[++leftPtr] < median ){}

            while( quickArray[--rightPtr] > median ){}

            if(leftPtr >= rightPtr) {
                break;
            }
            else {
                exchange(leftPtr, rightPtr);
            }
        }
        exchange(leftPtr, right-1);
        return leftPtr;
    }

    public void insertionSort(int left, int right)
    {
        int in, out;

        for(out=left+1; out<=right; out++) {

            long temp = quickArray[out];
            in = out;

            while(in>left && quickArray[in-1] >= temp) {
                quickArray[in] = quickArray[in-1];
                --in;
            }
            quickArray[in] = temp;
        }
    }
}
class QuickSortDeneme {
    public static void main(String[] args) {

        int maxSize = 16;

        QuickSort quickSort = new QuickSort(maxSize);

        Random random = new Random();
        for (int j = 0; j < maxSize; j++) {
            int r = random.nextInt(100);
            quickSort.insert(r);
        }
        System.out.println("Unsorted: ");
        quickSort.display();
        quickSort.sort();
        System.out.println("Sorted: ");
        quickSort.display();
    }
}

