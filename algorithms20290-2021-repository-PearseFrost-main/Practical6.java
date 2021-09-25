import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Practical6 {
    final static int CUTOFF=12;
    public static void quickSort(int array[],int start,int end){
        if(start<end){//If last element greater than the first
            int piv=partition(array,start,end);//Calls partition method
            quickSort(array,start,piv-1);//Recursively calls itself
            quickSort(array,piv+1,end);//Recursively calls itself again
        }
    }
    public static void swap(int array[],int i,int j){//Swap function for swapping positions in array
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static int partition(int array[],int start,int end){
        int pi=start;//Lets pi equal first element
        int pivot=array[end];//Pivot initialised

        for(int i=start;i<=end-1;i++){//If pivot is greater than the value
            //swap method is called and pi is incremented
            if(array[i]<=pivot){
                swap(array,pi,i);
                pi++;
            }
        }
        //Swap function called again
        swap(array,pi,end);
        //Returns pi
        return pi;
    }
    public static void insertionSort(int array[]) {//Takes integer array as parameter
        int size = array.length;//Integer size is equal to length of array
        for (int i = 1; i < size; i++) {
            int key = array[i];
            int j = i - 1;
            while ((j > -1) && (array[j] > key)) {//Moves integers in array one index up
                //If they are greater than key
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }//Prints sorted array
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            System.out.println();
        }
    }

    public static void quickSortEnhanced(int array[],int start,int end) {
        if(end<=start+CUTOFF){//CUTOFF for quicksort enhanced
            insertionSort(array);//Calls insertionSort
        }
        else if (start < end) {//If last element greater than the first
            int piv = partitionEnhanced(array, start, end);//Calls partition method
            quickSort(array, start, piv - 1);//Recursively calls itself
            quickSort(array, piv + 1, end);//Recursively calls itself again
        }
            for(int i = 0; i < array.length; i++) {//Prints sorted array
                System.out.print(array[i] + " ");
                System.out.println();
            }
        }

    public static void shuffleArray(int array[]){
        Random rnd = ThreadLocalRandom.current();
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            int a = array[index];
            array[index] = array[i];
            array[i] = a;
        }
    }

    public static int partitionEnhanced(int array[],int start,int end){
        shuffleArray(array);//Shuffles array before starting
        int pi=start;//Lets pi equal first element
        int pivot=array[end];//Pivot initialised

        for(int i=start;i<=end-1;i++){//If pivot is greater than the value
            //swap method is called and pi is incremented
            if(array[i]<=pivot){
                swap(array,pi,i);
                pi++;
            }
        }
        //Swap function called again
        swap(array,pi,end);
        //Returns pi
        return pi;
    }



    public static void main(String[] args) {
        int array[]={12,23,21,4,3};
        Practical6 ob=new Practical6();
        long startTime = System.nanoTime();
        ob.quickSortEnhanced(array,0, array.length-1);
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Elapsed time: "+elapsedTime+" nano seconds");
    }

}
