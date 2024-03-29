package sorting;

public class MergeSort {

    public static void conquer(int[] arr, int start, int mid, int end){
        int merged[] = new int[end-start+1];
        int idx1=start;
        int idx2=mid+1;
        int x=0;
        //Copying elements in merged array and in a sorted manner
        while(idx1<=mid && idx2<=end){
            if(arr[idx1]<arr[idx2]){
                merged[x++]=arr[idx1++];
            }else{
                merged[x++]=arr[idx2++];
            }
        }
        //Checking for remaining elements and copying them in merged array
        while(idx1<=mid){
            merged[x++]=arr[idx1++];
        }
        while(idx2<=end){
            merged[x++]=arr[idx2++];
        }
        // Copying back sorted elements in original array
        for(int i=0, j=start; i<merged.length; i++, j++){
            arr[j]=merged[i];
        }
    }

    public static void sort(int[] arr, int start, int end){
        if(start>=end) return;
        //divide
        int mid = start+(end-start)/2;
        sort(arr, start, mid);
        sort(arr, mid+1, end);
        //conquer
        conquer(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,9};
        int[] b = new int[]{2,4,6,8};
        int[] unsorted = new int[]{2,1,4,3,6,5,8,7,9};
        sort(unsorted, 0, unsorted.length-1);
        printArray(unsorted);
    }

    public static void printArray(int[] A){
        for(int a : A){
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }
}
