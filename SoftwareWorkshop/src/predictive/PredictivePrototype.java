package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;
/**
 * Gordon Chan
 * @author gxc378
 * @version 04-02-2016
 * This class contains the methods wordToSignature and signatureToWords.
 */

public class PredictivePrototype {
	/**
	 * wordToSignature method takes a word and returns a numerical signature. If the word has any non-alphabetic characters
	 * they are replaced by a space in the resulting signature. The result is accumulated character by character.
	 * String builder is used to construct the return String signature because String objects are read only, whereas StringBuffer objects 
	 * can be changed via instance methods that make concatenation easier. One StringBuffer is used, rather than multiple String objects, to
	 * accumulate the result character by character.
	 * @param word for the word that will be converted into a numeric signature as a String.
	 * @return numeric signature of String word as a String
	 */
	public static String wordToSignature(String word){
		StringBuffer signature = new StringBuffer();
		for(int i = 0; i < word.length(); i++){
			char index = word.charAt(i);
			if(index == 'a' || index == 'b' || index == 'c'||index == 'A' || index == 'B' || index == 'C'){
				signature.append(2);
			} else if(index == 'd'||index=='e'||index =='f'||index == 'D' || index == 'E' || index == 'F'){
				signature.append(3);
			} else if (index == 'g'|| index == 'h'|| index =='i'||index == 'G' || index == 'H' || index == 'I'){
				signature.append(4);
			} else if(index =='j'|| index == 'k'|| index == 'l'||index == 'J' || index == 'K' || index == 'L'){
				signature.append(5);
			} else if(index=='m'|| index =='n'|| index =='o'||index == 'M' || index == 'N' || index == 'O'){
				signature.append(6);
			} else if(index == 'p'|| index == 'q' || index =='r'|| index =='s'||index == 'P' || index == 'Q' || index == 'R'||index =='S'){
				signature.append(7);
			} else if(index == 't'|| index == 'u' || index == 'v'||index == 'T' || index == 'U' || index == 'V'){
				signature.append(8);
			} else if(index =='w' || index == 'x' || index == 'y' || index == 'z'||index == 'W' || index == 'X' || index == 'Y'|| index =='Z'){
				signature.append(9);
			}
		}return signature.toString();
	}
	/**
	 * the method signatureToWords takes the given numeric signature and returns a set of possible matching words from
	 * the dictionary. The returned list does not have duplicates and each word returned is in the lower case
	 * in this part of the exercise, the dictionary is not stored. This means that each time the signatureToWords method is called,
	 * a new Dictionary is created, searched through for words that match the signature, before all other words except the results are
	 * discarded. With each method call the file will be read line by line, meaning the time complexity is linear time.
	 * @param signature for the signature to be converted into possible matching words as a String
	 * @return results consisting of Strings that match the signature as Set<String>
	 */
	public static Set<String> signatureToWords(String signature){
		TreeSet<String> results = new TreeSet<String>();
		String word;
		try {
			BufferedReader in = new BufferedReader(new FileReader("/usr/share/dict/words"));
			while((word=in.readLine())!=null){
				if(isValidWord(word) && wordToSignature(word).equals(signature)){
					results.add(word.toLowerCase());
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return results;
	 }
	 /**
	  * Helper method. When reading the dictionary, lines with non-alphabetic characters are ignored.
	  * @param word for the word to be checked as a String.
	  * @return false if the line contains non-alphabetic characters, true if otherwise.
	  */
	 public static boolean isValidWord(String word) {
		StringBuffer w = new StringBuffer(word);
		for(int counter = 0; counter < w.length(); counter++){
			char o = w.charAt(counter);
			if(!Character.isLetter(o)){
				return false;
			}
		} return true;
	 }
	 
	
}
