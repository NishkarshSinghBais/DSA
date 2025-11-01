package SQ_Implementation;

public class CircularQueue {
     protected int[] data;
     private static final int DEFAULT_SIZE = 10;

     protected int end = 0;
     protected int start = 0;
     private int size = 0;

     public CircularQueue(){
         this(DEFAULT_SIZE);
     }

     public CircularQueue(int size){
         this.data = new int[size];
     }

     boolean isFull(){
         return size == data.length;
     }

     boolean isEmpty(){
         return size == 0;
     }

     boolean insert(int item){
         if ( isFull() ){
             return false;
         }
         data[end] = item;
         end++;
         end = end % data.length;
         size++;
         return true;
     }

     public int remove() throws Exception {
         if ( isEmpty() ){
             throw new Exception("Queue is Empty");
         }
         int remove = data[start];
         start++;
         start = start % data.length;
         size--;
         return remove;
     }

     public void display(){
         if ( isEmpty() ){
             System.out.print("Empty");
             return;
         }
         int i = start;
         do {
             System.out.print(data[i] + " <- ");
             i++;
             i = i % data.length;
         } while ( i != end );
     }
}
