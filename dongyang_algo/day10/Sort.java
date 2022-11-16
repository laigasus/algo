package day10;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {10, 58, 65, 73, 8, 9};
        bubble(arr);
        selection(arr);
        insertion(arr);
    }

    public static void bubble(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=0; j<arr.length-i; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, i, j);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr){
        int min;
        for(int i=0; i<arr.length; i++){
            min=i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            if(min==i){
                continue;
            }else{
                swap(arr, min, i);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void insertion(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            final int key = arr[i];
            int pos = i;
            while (pos > 0 && key < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = key;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j){
        int tmp;
        tmp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=tmp;
    }
}
