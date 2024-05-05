import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class englishWords {
    static Map<Integer, Set<String>> english_words = new HashMap<>();

    static {
        load_sowpods();
    }

    public static void load_sowpods() {
        String filename = "sowpods.txt";
        String filedir = "english_words";
        try  {
            BufferedReader english_file = new BufferedReader(new FileReader("./" + filedir + "/" + filename));
            String word;
            while ((word = english_file.readLine()) != null) {
                // System.out.println(word);
                english_words.computeIfAbsent(word.length(), k -> new HashSet<String>()).add(word);
            }
            english_file.close();
        } catch(FileNotFoundException FNFe){
            FNFe.printStackTrace();
        } catch(IOException IOe) {
            IOe.printStackTrace();
        }
    }

    public static Set<String> getDictionary(int word_length) {
        return english_words.get(word_length);
    }

    public static void printDictionary() {
        english_words.forEach((key, values) -> {
            values.forEach(value -> {System.out.println("Key: " + key); System.out.println("Value: " + value);});
        });
    }

    // Calculate the difference between 2 word (For heuristic function)
    public static int charDiff(String word_1, String word_2) {
        if (word_1.length() != word_2.length()) {
            System.out.println("\n The strings are not of the same length");
            return -1;
        }
        int diff_counter = 0;
        for (int i = 0; i < word_1.length(); i++) {
            if (word_1.charAt(i) != word_2.charAt(i)) {
                diff_counter++;
            }
        }
        return diff_counter;
    }

    public static boolean validWords(String start, String end) {
        if (start.length() != end.length() || start.length() > 15 || start.length() < 1 || end.length() > 15) {
            return false;
        }
        return (englishWords.getDictionary(start.length()).contains(start) && englishWords.getDictionary(end.length()).contains(end));
    }
}
