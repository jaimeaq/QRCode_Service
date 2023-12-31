import java.util.HashMap;
import java.util.Scanner;

class Main {
    private static void printMostFrequentWord(String[] words) {
        // write your code here
        HashMap<String, Integer> wordFreq = new HashMap<>();
        String mostFreqWord = null;
        int highestFreq = 0;

        for (String word : words) {
            if (wordFreq.containsKey(word)) {
                int currWordFreq = wordFreq.get(word);
                wordFreq.put(word, currWordFreq + 1);
                if (currWordFreq + 1 > highestFreq) {
                    mostFreqWord = word;
                    highestFreq = currWordFreq + 1;
                }
            } else {
                wordFreq.put(word, 1);
            }
        }
        System.out.println(mostFreqWord + " " + highestFreq);
    }

    // don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        printMostFrequentWord(words);
    }
}