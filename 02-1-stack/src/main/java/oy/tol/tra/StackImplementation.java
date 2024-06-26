package oy.tol.tra;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * 
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.
 * - StackImplementation(int size), which allocates an array of Object's with size.
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   private Object [] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;

   
   public StackImplementation() throws StackAllocationException {
      // TODO: call the constructor with size parameter with default size of 10.
      capacity = DEFAULT_STACK_SIZE; 
      itemArray = new Object[DEFAULT_STACK_SIZE];
      
   }


   public StackImplementation(int capacity) throws StackAllocationException {

      if(capacity < 2)
      {
      throw new StackAllocationException("the size of capactiy is too small");
      }

      this.capacity=capacity;
      itemArray=new Object[capacity];
   }
      
      
   

   @Override
   public int capacity() {
      // TODO: Implement this
      return this.capacity;

   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      // TODO: Implement this
      if(element==null){
         throw new NullPointerException("the element is null");
      }
      else{
      if(size() >= capacity  ){
         Object [] Newarray = new Object [this.capacity*10];
         for(int i = 0 ;i < itemArray.length ;i++){
            Newarray [i] = itemArray[i];
         }
         // Newarray = itemArray; 
         itemArray = Newarray;
         Newarray = null;
         capacity = capacity*10;
      }
   }

      // if(element==null){
      //    throw new NullPointerException("the element is null");
      // }
      itemArray[++currentIndex]=element;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("the stack is empty");

      }

      E element = (E) itemArray[currentIndex];
      itemArray [currentIndex] = null;
      currentIndex--;
      return element;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if(isEmpty()){
         throw new StackIsEmptyException("the stack is empty");

      }
      return (E)itemArray[currentIndex];
   }

   @Override
   public int size() {
      // TODO: Implement this
      return currentIndex+1;
      
   }

   @Override
   public void clear() {
      // TODO: Implement this
      currentIndex = -1 ;
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
      return currentIndex == -1;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
