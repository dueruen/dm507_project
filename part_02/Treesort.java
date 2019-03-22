import java.util.Scanner;

public class Treesort {
    public static void main(String[] args) {

        Dict dict = new DictBinTree();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            dict.insert(sc.nextInt());
        }

        for (int i : dict.orderedTraversal()) {
            System.out.println(i);
        }
    }
}