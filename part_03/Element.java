public class Element {

    private int key;
    private BinTree tree;

    public Element(int i, BinTree tree){
	this.key = i;
	this.tree = tree;
    }
    public int getKey(){
	return this.key;
    }
    public Object getTree(){
	return this.tree;
    }
}
