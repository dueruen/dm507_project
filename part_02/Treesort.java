
/**
 * DM507, Software Engineering
 * 
 * @author Mads Due Kristensen, madkr17@student.sdu.dk
 * @auther Victor Gram Thomsen, vitho17@student.sdu.dk
 * @auther Jeppe Hannibal Niemann, niema17@student.sdu.dk
 */

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