/*
 * Test program exercising DictBinTree.java. Move to the directory
 * containing the project java files, compile and run.
 */

class TestProjectPartII {

    public static void main(String[] args) {

	System.out.println();
	System.out.println("Creating a DictBinTree");
        Dict d = new DictBinTree();

	System.out.println();
        System.out.println("Inserting 10,20,11,19,12,18,13,17,14,16,10,20,20");
        int[] insertValues = {10,20,11,19,12,18,13,17,14,16,10,20,20};
	for (int i=0; i<insertValues.length; i++) {
	    d.insert(insertValues[i]);
	}

	System.out.println();
	System.out.println("Testing search()");
	String answer;
	int[] searchValues = {2, 12, 0, 15, 20, 21};
	for (int i=0; i<searchValues.length; i++) {
	    System.out.print("Searching for " + searchValues[i]);
	    if (d.search(searchValues[i])) {answer = "PRESENT";} else {answer = "ABSENT";}
	    System.out.println(" - searching for value " + searchValues[i] + " reported " + answer);
	}

	System.out.println();
	System.out.println("Calling orderedTraversal");
	int[] list = d.orderedTraversal();
	System.out.println("Output is:");	
	for (int i=0; i<list.length; i++) {
	    System.out.print(" " + list[i]);
	}
	System.out.println();

	System.out.println();
	System.out.println("Calling orderedTraversal again");
	list = d.orderedTraversal();
	System.out.println("Output is:");	
	for (int i=0; i<list.length; i++) {
	    System.out.print(" " + list[i]);
	}
	System.out.println();

	System.out.println();
	System.out.println("Now testing empty tree");

	System.out.println();
	System.out.println("Creating a DictBinTree");
        d = new DictBinTree();

	System.out.println();
	System.out.println("Testing search()");
	for (int i=0; i<searchValues.length; i++) {
	    System.out.print("Searching for " + searchValues[i]);
	    if (d.search(searchValues[i])) {answer = "PRESENT";} else {answer = "ABSENT";}
	    System.out.println(" - searching for value " + searchValues[i] + " reported " + answer);
	}

	System.out.println();
	System.out.println("Calling orderedTraversal");
	list = d.orderedTraversal();
	System.out.println("Output is:");	
	for (int i=0; i<list.length; i++) {
	    System.out.print(" " + list[i]);
	}

	System.out.println();
	System.out.println("Now testing tree of size one, containing 15");
	d.insert(15);

	System.out.println();
	System.out.println("Testing search()");
	for (int i=0; i<searchValues.length; i++) {
	    System.out.print("Searching for " + searchValues[i]);
	    if (d.search(searchValues[i])) {answer = "PRESENT";} else {answer = "ABSENT";}
	    System.out.println(" - searching for value " + searchValues[i] + " reported " + answer);
	}

	System.out.println();
	System.out.println("Calling orderedTraversal");
	list = d.orderedTraversal();
	System.out.println("Output is:");	
	for (int i=0; i<list.length; i++) {
	    System.out.print(" " + list[i]);
	}

	System.out.println();

    }
}
