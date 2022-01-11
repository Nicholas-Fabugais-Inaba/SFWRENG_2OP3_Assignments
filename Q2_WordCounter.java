/* Assignment 11 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (50 marks in total)
    Use the Q1_TreeMapByBST to implement a WordCounter to count words in documents.
    You cannot use JCF provided map.
 */

import javax.lang.model.element.Element;
import java.io.*;
import java.util.*;

public class Q2_WordCounter {
    // use the m_treemap as the data structure for word counting
    Q1_TreeMapByBST m_treemap = new Q1_TreeMapByBST();

    // Question 2.1 (15 marks) implement buildTreeMap() to build a treemap that stores
    // the words and word frequencies of a document into m_treemap.
    // "filename" is the path to the file. Please use the "JingleBell.txt" under folder "data".
    // You can ONLY modify the body of this method including the return statement.
    public void buildTreeMap(String filename){
        try {
            Scanner fileScanner = new Scanner(new FileReader(filename));
            while (fileScanner.hasNext()) {
                String fileKey = fileScanner.next().toLowerCase();
                fileKey = fileKey.replaceAll("[\\[\\]12,]","");
                int freq;
                if (m_treemap.get(fileKey) == -1) {
                    freq = 1;
                    m_treemap.put(fileKey, freq);
                } else {
                    freq = m_treemap.get(fileKey);
                    m_treemap.put(fileKey, freq+1);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Question 2.2 (15 marks) print all the counted words in the document in alphabetical order.
    // You can ONLY modify the body of this method including the return statement.
    public void printWordsAlphabetical(){
        ArrayList words = m_treemap.getKeysInAlphabeticalOrder();
        ArrayList newList = new ArrayList();
        for (int j = 0; j < words.size(); j++) {
            if (!newList.contains(words.get(j))) {
                newList.add(words.get(j));
            }
        }
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i) + " ");
        }
    }

    // Question 2.3 (15 marks) write an output file named "Output.txt" under folder "data"
    // The output of will consist of two lists.
    // Each list contains all the words from the file, along with the number of times
    // that the word occurred.
    // One list is sorted alphabetically.
    // The other list is sorted according to the number of occurrences, with the most
    // common words (i.e., a word with a larger frequency or count is said to be more common)
    // at the top and the least common at the bottom.
    // IMPORTANT: the output format is given in the file "Output_Example.txt" under folder "data".
    // Input parameter "filename" is the path to the output file.
    public void outputResult(String filename) {
        try {
            PrintWriter fileWriter = new PrintWriter(new FileWriter(filename));
            ArrayList words = m_treemap.getKeysInAlphabeticalOrder();
            ArrayList newList = new ArrayList();
            ArrayList newList_freq = new ArrayList();
            for (int j = 0; j < words.size(); j++) {
                if (!newList.contains(words.get(j))) {
                    newList.add(words.get(j));
                    newList_freq.add(Collections.frequency(words,words.get(j)));
                }
            }
            fileWriter.println(newList.size()-1 + " words found in file:");
            fileWriter.println("");
            fileWriter.println("List of words in alphabetical order (with counts in parentheses):");
            fileWriter.println("");
            for (int i = 1; i < newList.size(); i++) {
                fileWriter.println("   " + newList.get(i) + " " + "(" + newList_freq.get(i) + ")");
            }
            fileWriter.println("");
            fileWriter.println("");
            fileWriter.println("List of words by frequency of occurence:");
            fileWriter.println("");
            Collections.sort(newList_freq, Collections.reverseOrder());
            for (int i = 1; i < newList.size(); i++) {
                fileWriter.println("   " + newList.get(i) + " " + "(" + newList_freq.get(i-1) + ")");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Question 2.4 (5 marks) call each of the above methods in the main() method to
    // successfully count the words and produce expected outputs.
    public static void main(String[] args){
        Q2_WordCounter wordCounter = new Q2_WordCounter();
        wordCounter.buildTreeMap("C:\\Users\\nfabu\\OneDrive\\Documents\\fabugain_2OP3\\Assignment11\\src\\data\\JingleBell.txt");
        wordCounter.printWordsAlphabetical();
        File output = new File("C:\\Users\\nfabu\\OneDrive\\Documents\\fabugain_2OP3\\Assignment11\\src\\data\\Output.txt");
        wordCounter.outputResult(output.getName());
    }

}
