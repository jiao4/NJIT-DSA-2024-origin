package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
   private Object [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_Queue_SIZE = 10;

   private int head = 0;
   private int tail = -1;
//    private int size();
   private int currentSize = 0;

   public QueueImplementation() throws QueueAllocationException {

    capacity = DEFAULT_Queue_SIZE; 
    itemArray = new Object[DEFAULT_Queue_SIZE];
    
 }


 public QueueImplementation(int capacity) throws QueueAllocationException {

    if(capacity < 2)
    {
    throw new QueueAllocationException("the size of capactiy is too small");
    }

    this.capacity=capacity;
    itemArray=new Object[capacity];
 }
    
    
 

 @Override
 public int capacity() {
    
    return this.capacity;

 }

 @Override
 public void enqueue(E element) throws QueueAllocationException, NullPointerException {
    
    if(size() >= capacity  ){
       Object [] Newarray = new Object [this.capacity*10];

       for (int i = 0; i < currentSize; i++) {
        Newarray[i] = itemArray[(head + i) % capacity];
      //   head = (head + i) % capacity;
      }
      head = 0;
      tail = currentSize - 1;
      itemArray = Newarray;
      capacity = capacity * 10;
       
       
    }
    // else if (element != E){
    //     throw new QueueAllocationException("the reallocation is wrong");
    // }


    if(element==null){
       throw new NullPointerException("the element is null");
    }
    tail=(tail+1)%capacity;
    itemArray[tail]=element;
    currentSize++; 


 }


 @Override
 public E dequeue() throws QueueIsEmptyException {
    E OUT = element(); 
    head = (head + 1) % capacity; 
    currentSize--; 
    return OUT; 

 }

 @SuppressWarnings("unchecked")
 @Override
 public E element() throws QueueIsEmptyException {
    if(isEmpty()){
       throw new QueueIsEmptyException("the Queue is empty");

    }
    return (E)itemArray[head];
 }



 @Override
 public int size() {

    return currentSize;
    
 }



 @Override
 public void clear() {

    head=0;
    tail=-1;
    currentSize=0;
 }



 @Override
 public boolean isEmpty() {

    return currentSize == 0;
 }



 @Override
//  public String toString() {
//     StringBuilder builder = new StringBuilder("[");
//     for (var index = 0; index <= currentIndex; index++) {
//        builder.append(itemArray[index].toString());
//        if (index < currentIndex) {
//           builder.append(", ");
//        }
//     }
//     builder.append("]");
//     return builder.toString();
//  }

public String toString() {
    StringBuilder builder = new StringBuilder("[");
    int index = head; 
    int count = 0;
    while (count < currentSize) { 
        builder.append(itemArray[index].toString());
        if (count < currentSize - 1) { 
            builder.append(", ");
        }
        index = (index + 1) % capacity; 
        count++;
    }
    builder.append("]");
    return builder.toString();
}

}

