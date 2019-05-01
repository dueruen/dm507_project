public class Element {

    private int index;
    private int key;
    private DictBinTree tree;

    public Element(int i, DictBinTree tree, int index){
	this.key = i;
	this.tree = tree;
    this.index = index;
    }
    public int getKey(){
	return this.key;
    }
    public int getIndex(){
	return this.index;
    }
    public Dict getTree(){
	return this.tree;
    }
}
