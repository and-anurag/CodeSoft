import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Project2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter '1' to Enter the Text Manually or '2' to Provide a File : ");
        int choice = sc.nextInt();
        sc.nextLine();
        String text = "";

        if (choice == 1) {
            System.out.println("Enter the Text : ");
            text = sc.nextLine();
        }

        else if (choice == 2) {

            System.out.println("Enter the File Path : ");
            String filePath = sc.nextLine();

            try {
                File file = new File(filePath);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + " ";
                }
                fileScanner.close();
            }

            catch (FileNotFoundException e) {
                System.out.println("File Not Found..");
                System.exit(1);
            }

        }

        else {
            System.out.println("Invalid Choice. Exiting the Program.");
            System.exit(1);
        }

        int wordCount = countWords(text);
        System.out.println("Total Count of Words : " + wordCount);
        getUniqueWords(text);
        getWordFrequency(text);
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static void getUniqueWords(String text) {

        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("No.of Unique Words : " + wordCountMap.size());
        System.out.println("Frequency of Each Word : ");

    }

    public static void getWordFrequency(String text) {

        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        int wordCount = countWords(text);
        System.out.println("Word Count is "+ wordCount);
    }
}
