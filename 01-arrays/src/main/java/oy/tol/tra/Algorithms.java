package oy.tol.tra;

public class Algorithms {

    // private Integer [] array = null;

    // public Algorithms(Integer [] array) {
    //     this.array = new Integer [array.length];
    // }
    

    public static <T extends Comparable<T>> void sort(T [] array) {
        // implementation here...
        int n = array.length;
        boolean exchange;

        do {
         exchange = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1].compareTo(array[i]) > 0) {
                    T temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    exchange = true;
                }
            }
            n--;
        } while (exchange);
     
      }
    

     // ...
     public static <T> void reverse(T [] array) {
        // implementation here... 
        int i = 0;
        int x = array.length -1;
        while (i <= x/2) {
           T temp = array[i];
           array[i] = array[x-i];
           array[x-i] = temp;
           i++ ;
        }
     }
}
