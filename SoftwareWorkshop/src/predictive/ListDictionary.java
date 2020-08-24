package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * Gordon Chan
 * @author gxc378
 * @version 04-02-16
 */
public class ListDictionary implements Dictionary{
	
	private ArrayList<WordSig> ListDictionary = new ArrayList<WordSig>();
	/**
	 * ListDictionary constructor instantiates ListDictionary object, reading in words from the words.txt file, and 
	 * passing each valid word as an argument for WordSig objects, before storing the WordSig instance in an ArrayList.
	 * After all entries have been made the collection is sorted using the compareTo method implemented in WordSig.
	 * @param ws for the ArrayList in which WordSig objects are stored.
	 */
	public ListDictionary(String filename){
		String word;
		this.ListDictionary = new ArrayList<WordSig>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((word=in.readLine())!=null){
				if(isValidWord(word)){
					WordSig w = new WordSig(word.toLowerCase());
					this.ListDictionary.add(w);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  Collections.sort(this.ListDictionary);
	}
	/**
	 * Accessor method for ListDictionary ArrayList of WordSig objects
	 * @return ListDictionary as ArrayList<WordSig>
	 */
	public ArrayList<WordSig> getListDictionary(){
		return this.ListDictionary;
	}
	
	/**
	 * The wordToSignature method is identical to the method found in PredictivePrototype.
	 * @param word for the word to be converted into a signature as a String.
	 * @return signature of word as a String.
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
	 * signatureToWords is an instance method that uses the stored dictionary. The ArrayList<WordSig> must be stored in sorted order and the
	 * signature to words method uses binary search to find a match WordSig for the signature. Below and above the matching index are scanned
	 * for all other words that match the signature.
	 * @param signature that will be checked against matching Strings.
	 * @return results that match the signature as TreeSet<String> 
	 */
	public TreeSet<String> signatureToWords(String signature){
		TreeSet<String> results = new TreeSet<String>();
		ArrayList<WordSig> list = this.ListDictionary;	
		int match = Collections.binarySearch(list, new WordSig("",signature));
		results.add(list.get(match).getWords());
		for(int i = match + 1 ; i < list.size() ; i++){
			if(list.get(i).getSignature().equals(signature)){
				results.add(list.get(i).getWords());
			} else {
				i = list.size();
			}
		}
		for(int j = match - 1; j >= 0; j--){
			if(list.get(j).getSignature().equals(signature)){
				results.add(list.get(j).getWords());
			} else {
				j = 0;
			}
		}
		return results;
	}
	/**
	 * Boolean method that checks whether all characters in the argument constitute a valid word that can be added to the dictionary. 
	 * This method uses the same code as the prototype method isValidWord.
	 * @param word for the String to be checked as a String.
	 * @return true if the word is valid according to the specification,i.e. contains only alphabetical characters, false if otherwise.
	 */
	public static boolean isValidWord(String word) {
		StringBuffer w = new StringBuffer(word);
		for(int counter = 0; counter < w.length(); counter++){
			char t = w.charAt(counter);
			if(!Character.isLetter(t)){
				return false;
			}
		} return true;
	 }

}
