public class Element {

    private int key;
    private DictBinTree tree;

    public Element(int i, DictBinTree tree){
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
