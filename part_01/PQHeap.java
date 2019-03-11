/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk 
 */
public class PQHeap implements PQ {

    // Array with Element's
    private Element[] elements;
    // The current heap size
    private int heapSize;

   /**
    * This is the main constructor.
    * @param maxElms the max size of the array.
   */
    public PQHeap(int maxElms) {
        elements = new Element[maxElms - 1];
    }
    /**
     * This method extracts smallest Element from the array/heap and cut the size of the array/heap   
     * @param return smallest Element after array has been minheapified  
     */
    @Override
    public Element extractMin() {
        // set min to index 0 
        Element min = elements[0];
        // Index 0 is sat to the higest element 
        elements[0] = elements[heapSize - 1];
        // reduce heapSize by one, to remove element
        heapSize--;
        // calls MinHeapify to put array in to min-heap order after removal of element    
        MinHeapify(elements, 0);
        return min;
    }

    /**
     * Inserts an element into the heap
     * @param e element to be inserted into the heap 
     */
    @Override
    public void insert(Element e) {
        int i = heapSize;
         //Element is inserted into last index of array / heap
        elements[i] = e;
        //While i is larger than zero (while there are still parent nodes), and the parent of the new element is larger than it's child
        while (i > 0 && elements[Parrent(i)].getKey() > elements[i].getKey()) { 
            //placeholder element is initialized as element at index i 
            Element tmp = elements[i]; 
            //Element at index i is set equal to it's own parents index, positioning it higher in the heap
            elements[i] = elements[Parrent(i)];  
            //Parent node is set equal to inserted element via placeholder - the inserted element has now been moved upwards once
            elements[Parrent(i)] = tmp; 
            //i is set to the index of the next parentnode
            i = Parrent(i); 
        }
        //when the loop is completed, heapsize is incremented by 1
        heapSize++; 
    }

   /**
    * This method returns a array of Elements in min-heap order, therefore with the smallest Element in the top.
    * @param A array with elements.
    * @param i index for the current element.
    * @return array of Elements that has been minheapified.
   */       
    private Element[] MinHeapify(Element[] A, int i) {
        int l = Left(i);
        int r = Right(i);
        int smallest;

        if (l <= heapSize && A[l].getKey() < A[i].getKey()) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r <= heapSize && A[r].getKey() < A[smallest].getKey()) {
            smallest = r;
        }
        if (smallest != i) {
            Element tmp = A[smallest];
            A[smallest] = A[i];
            A[i] = tmp;
            return MinHeapify(A, smallest);
        }
        return A;
    }

   /**
    * This method returns the index of the parent for the param.
    * @param i element index.
    * @return the parent index
   */    
    private int Parrent(int i) {
        return i / 2;
    }

   /**
    * This method returns the index of the element to the left.
    * @param i element index.
    * @return index of element to the left
   */      
    private int Left(int i) {
        return 2 * i;
    }

   /**
    * This method returns the index of the element to the right.
    * @param i element index.
    * @return index of element to the right
   */       
    private int Right(int i) {
        return 2 * i + 1;
    }
}
