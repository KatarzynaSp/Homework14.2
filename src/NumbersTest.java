import java.io.*;
import java.util.*;

public class NumbersTest {
    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Numbers.txt")));) {
            List<Integer> numbersList = new ArrayList<>();
            TreeSet<Integer> numbersTree = new TreeSet<>();

            read(bfr, numbersList, numbersTree);
            int[] counter = count(numbersList, numbersTree);
            print(numbersTree, counter);

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    private static void print(TreeSet<Integer> numbersTree, int[] counterList) {
        int j = 0;
        for (Integer el : numbersTree) {
            for (int i = 0; i < counterList.length; i++) {
            }
            System.out.println(el + " - liczba wystąpień: " + counterList[j]);
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

    private static void read(BufferedReader bfr, List<Integer> numbersList, TreeSet<Integer> numbersTree) throws IOException {
        String line;
        while ((line = bfr.readLine()) != null) {
            numbersList.add(Integer.valueOf(line));
            numbersTree.add(Integer.valueOf(line));
        }
    }
}