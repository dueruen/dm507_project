/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */
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
    public DictBinTree getTree(){
	return this.tree;
    }
}
