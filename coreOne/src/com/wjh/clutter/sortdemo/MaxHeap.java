package com.wjh.clutter.sortdemo;

/**
 * @author JHW
 * @date created at 2018/04/13
 */
public class MaxHeap {

    int[] heap;
    int heapsize;

    public MaxHeap(int[] heap) {
        this.heap = heap;
        this.heapsize = heap.length;
    }

    public void buildMaxHeap(){
        for (int i=(heapsize/2-1);i>=0;i--){
            maxify(i);
        }
    }

    private void maxify(int i) {
        int l = 2*(i+1)-1;
        int r = 2*(i+1);
        int largest = i;

        if (l < heapsize && heap[l]>heap[largest]){
            largest = l;
        }
        if (r < heapsize && heap[r]>heap[largest]){
            largest = r;
        }
        if (largest == i || largest >= heapsize){
            return;
        }

        int temp = heap[i];
        heap[i] = heap[largest];
        heap[largest] = temp;

        maxify(largest);

    }

    public void heapSort(){
        for (int i=0; i<heap.length; i++){
            int temp = heap[0];
            heap[0] = heap[heapsize-1];
            heap[heapsize-1] = temp;
            heapsize--;
            maxify(0);
        }
    }
}
