package com.wjh.clutter.sortdemo;

/**
 * @author JHW
 * @date created at 2018/04/13
 */
public class MaxHeapTest {

    public static void main(String[] args) {
        int[] arr = new int[]{12,3,9,5,7,4,3,2};
        MaxHeap heap = new MaxHeap(arr);
        heap.buildMaxHeap();

//        for (Integer integer : arr){
//            System.out.println(integer);
//        }

        heap.heapSort();

        for (Integer integer : heap.heap){
            System.out.println(integer);
        }

    }
}
