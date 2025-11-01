package Heap_;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Integer> heap;

    public MinHeap(){
        heap = new ArrayList<>();
    }

    public void insert(int val){
        heap.add(val);
        upHeap();
    }
    private void upHeap(){
        int index = heap.size() - 1;
        while ( index > 0 && heap.get(index) < heap.get(parent(index))){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int remove(){
        if ( heap.isEmpty() ){
            throw new IllegalStateException("Heap is Empty");
        }
        int max = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        downHeap(0);
        return max;
    }
    private void downHeap(int index){
        int smallest = index;
        int leftChild = leftChild(index);
        int rightChild = rightChild(index);

        if ( leftChild < heap.size() && heap.get(smallest) > heap.get(leftChild)){
            smallest = leftChild;
        }
        if ( rightChild < heap.size() && heap.get(smallest) > heap.get(rightChild)){
            smallest = rightChild;
        }
        if ( smallest != index ){
            swap(index, smallest);
            downHeap(smallest);
        }
    }

    private int parent(int index){
        return (index - 1) / 2;
    }
    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
    public void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    public int peek(){
        if ( heap.isEmpty() ){
            throw new IllegalStateException("Heap is Empty");
        }
        return heap.get(0);
    }
    public void display(){
        System.out.println(heap);
    }

    public static void main(String[] args) {
        MinHeap min = new MinHeap();

        min.insert(10);
        min.insert(20);
        min.insert(30);
        min.insert(40);
        min.insert(50);
        min.insert(60);

        min.display();
        min.remove();
        min.display();


    }
}
