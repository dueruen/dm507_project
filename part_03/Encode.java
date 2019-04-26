import java.lang.Math;

public class Encode {


    public Element huffMan(int[] input) { 
        int n = Math.abs(input.length);
        PQ q = populateQueue(input);
        for(int i = 0; i < n; i++) {
            Element left = q.extractMin();
            Element x = left; 
            Element right = q.extractMin();
            Element y = right;
            int key = x.getKey() + y.getKey();
            q.insert(new Element(key, new BinTree()));

        }
        return q.extractMin();
        
    }

    private PQ populateQueue(int[] input) { 
        PQ q = new PQHeap(input.length);
        for (int i: input) { 
            q.insert(new Element(i, new BinTree()));
        }
        return q;
    }
    
}