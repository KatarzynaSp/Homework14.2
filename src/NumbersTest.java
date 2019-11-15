import java.io.*;
import java.util.*;

public class NumbersTest {
    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Numbers.txt")));) {

            List<Integer> numbersList = listCreator(bfr);
            TreeSet<Integer> numbersTree = treeCreator(numbersList);
            System.out.println(numbersList);
            System.out.println(numbersTree);
            int[] counter = count(numbersList, numbersTree);
            print(numbersTree, counter);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static TreeSet<Integer> treeCreator(List<Integer> numbersList) {
        TreeSet<Integer> numbersTree = new TreeSet<>();
        numbersTree.addAll(numbersList);
        return numbersTree;
    }

    private static List<Integer> listCreator(BufferedReader bfr) throws IOException {
        List<Integer> numbersList = new ArrayList<>();
        String line;
        while ((line = bfr.readLine()) != null) {
            numbersList.add(Integer.valueOf(line));
        }
        return numbersList;
    }

    private static void print(TreeSet<Integer> numbersTree, int[] counter) {
        int j = 0;
        for (Integer el : numbersTree) {
            System.out.println(el + " - liczba wystąpień: " + counter[j]);
            j++;
        }
    }

    private static int[] count(List<Integer> numbersList, TreeSet<Integer> numbersTree) {
        int[] counter = new int[numbersTree.size()];
        int j = 0;
        for (Integer el : numbersTree) {
            for (int i = 0; i < numbersList.size(); i++) {
                if (el == numbersList.get(i)) {
                    ++counter[j];
                }
            }
            j++;
        }
        return counter;
    }
}