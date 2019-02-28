/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 */
public class PQHeap implements PQ {

    private Element[] elements;
    private int heapSize;

    public PQHeap(int maxElms) {
        elements = new Element[maxElms - 1];
    }

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

    private int Parrent(int i) {
        return i / 2;
    }

    private int Left(int i) {
        return 2 * i;
    }

    private int Right(int i) {
        return 2 * i + 1;
    }
}