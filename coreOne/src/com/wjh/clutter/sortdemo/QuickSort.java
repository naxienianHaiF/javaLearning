package com.wjh.clutter.sortdemo;

/**
 * @author JHW
 * @date created at 2018/04/14
 */
public class QuickSort {

    private static void quickSort(int[] arr,int left,int right){
        if (left>right){
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[left];

        while (l<r) {
            while (l<r && arr[r] >= temp){
                r--;
            }
            if (l<r){
                arr[l++] = arr[r];
            }
            while (l<r && arr[l] < temp){
                l++;
            }
            if (l<r){
                arr[r--] = arr[l];
            }
        }
        arr[l] = temp;
        quickSort(arr,left,l-1);
        quickSort(arr,l+1,right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,7,4,6,5,6,12,10,11};
        quickSort(arr,0,arr.length-1);

        for (int i =0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
