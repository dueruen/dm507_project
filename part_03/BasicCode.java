/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
public abstract class BasicCode{

    /**
     * The Huffman algortihm
     * @param input input array of ints, in
     * this case the frequency table
     * @return Element returns the last element in the queue, 
     * the root of the tree
     */
    public Element huffman(int[] input) { 
        //Counting variable, set to length of input
        int n = input.length;
        //Input is passed to private populating-method,
        //with the result being set as a new PQ instance
        PQ q = populateQueue(input);
        for(int i = 0; i < n - 1; i++) {
            //the element with lowest priority is fetched from the queue
            //and set equal to a new Element
            Element x = q.extractMin();
            //Same as above
            Element y = q.extractMin();
            //A new Element key is calculated, by adding 
            //the key values of the two recently fetched elements
            int key = x.getKey() + y.getKey();

            //A new Tree instance is made, passing the new 
            //key value as root key, -1 to indicate the creation of a root or a 
            //knot, and x and y as children to the key
            DictBinTree tree = new DictBinTree(key, -1, x, y);
            //Finally, a new element is  created, with the 
            //new key as key value, the new tree as it's data, 
            //and -1 as it's index
            q.insert(new Element(key, tree, -1));
        }
        //once the loop is completed, the only remaining Elemnt in
        //the queueu is returned, which will now have all of the previous 
        //Elements as parts of it's Tree
        return q.extractMin();   
    }

    /**
     * Populates the instance of PQ 
     * that is used in the Huffman algortihm with 
     * objects of the Element type, instead of the 
     * primitiv int types
     * @param input
     * @return PQ, a  priority queue implementing 
     * the PQ interface
     */
    private PQ populateQueue(int[] input) { 
        /* New instance of PQHeap, instantiated 
        polymorphically as an instance of PQ */
        PQ q = new PQHeap(input.length);
        for (int i = 0; i < input.length; i++) {
            /*For each index in the input array 
            create a new Element with they key being 
            the frequency, the tree being null for now,
            and the index value being the current index*/
            q.insert(new Element(input[i], null, i));
        }
        //Returns the now populated queue
        return q;
    }
}