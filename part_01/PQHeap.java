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
     * This method extracts element 0 from the array.    
     */
    @Override
    public Element extractMin() {
        Element min = elements[0];
        elements[0] = elements[heapSize - 1];
        heapSize--;
        MinHeapify(elements, 0);
        return min;
    }

    @Override
    public void insert(Element e) {
        int i = heapSize;
        elements[i] = e;
        while (i > 0 && elements[Parrent(i)].getKey() > elements[i].getKey()) {
            Element tmp = elements[i];
            elements[i] = elements[Parrent(i)];
            elements[Parrent(i)] = tmp;
            i = Parrent(i);
        }
        heapSize++;
    }

   /**
    * This method returns a array of Elements in heap order with the smallest Element in the top.
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
