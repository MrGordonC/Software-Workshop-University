package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * Gordon Chan
 * @author gxc378
 * @version 10-06-16
 * MapDictionary class provides a constructor for instantiating MapDictionary objects and instance methods.
 */
public class MapDictionary implements Dictionary{

	private HashMap<String, TreeSet<String>> hM;
	
	/**
	 * Constructor for MapDictionary. MapDictionary stores the dictionary using a generic multi-valued map, i.e. a data structure that
	 * maps signatures to a set of words. Using a map, data can be recovered quickly by signature. 
	 * This implementation of MapDictionary uses HashMap from the Java collections API, mapping keys to values, given that all keys are unique, 
	 * thus retrievable by said key, and that all keys and values are not-null. The order of insertion into a HashMap is no guarantee of the 
	 * order of values in the HashMap.
	 * This constructor reads in the dictionary line by line. For each line, the while loop checks if the word is valid, and if a corresponding
	 * key(i.e. matching signature) exists in the HashMap. If the signature is already a key in the HashMap, the word is added to the
	 * value of this mapped object, a TreeSet<String>, and the amended TreeSet<String> is put into the HashMap, else a new TreeSet<String> 
	 * containing the word is mapped to the signature and put() into the HashMap.
	 * HashMap is roughly equivalent to HashTable, which was another implementation that I considered. The key differences are that HashMap
	 * permits one null key, and null values, whereas HashTable does not, and that HashMap is not synchronized like HashTable is. These differences
	 * should not be problematic for this implementation of MapDictionary because all words are non-null by definition before they can be inserted
	 * into the map, and each will have a corresponding signature, and because there will not be multiple threads performing operations on
	 * MapDictionary instances.
	 * I decided to store words as TreeSet<String>, because it matches the return type of signatureToWords.
	 */
	public MapDictionary(String filename){
		this.hM = new HashMap<String,TreeSet<String>>();
		String entry;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((entry=in.readLine())!=null){
				if(isValidWord(entry)){
					String signature = wordToSignature(entry.toLowerCase());
					if(!hM.containsKey(signature)){
						TreeSet<String> results = new TreeSet<String>();
						results.add(entry.toLowerCase());
						hM.put(signature, results);
					} else {
						TreeSet<String> s = hM.get(signature);
						s.add(entry.toLowerCase());
						hM.put(signature, s);
					}
					
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Accessor method for HashMap in MapDictionary objects.
	 * @return the map of this MapDictionary as HashMap<String,TreeSet<String>.
	 */
	public HashMap<String,TreeSet<String>> getHashMap(){
		return this.hM;
	}
	/**
	 * insertWord instance method will insert the argument into this HashMap, creating a new signature key if necessary.
	 * @param word for the word to be inserted into this HashMap as a String.
	 * @return true if the insertion was successful, false if the word was already a value contained in the HashMap.
	 */
	public boolean insertWord(String word){
		HashMap<String, TreeSet<String>> target = this.getHashMap();
		String key = wordToSignature(word);
		if(target.containsKey(key)){
			if(target.get(key).contains(word)){
				return false;
			} else {
				TreeSet<String> insertExisting = target.get(key);
				insertExisting.add(word.toLowerCase());
				this.hM.put(key, insertExisting);
				return true;
			}
		} else {
			TreeSet<String> insertNew = new TreeSet<String>();
			insertNew.add(word.toLowerCase());
			this.hM.put(key, insertNew);
			return true;
		}
	}
	/**
	 * signatureToWords instance method for MapDictionary objects. This method gets the HashMap of this object and stores it as a local variable.
	 * The TreeSet<String> mapped to the signature index is stored and then returned
	 * @return matching words to the signature as TreeSet<String>.
	 */
	@Override
	public TreeSet<String> signatureToWords(String signature){
		HashMap<String,TreeSet<String>> hM = this.getHashMap();
		TreeSet<String> matches = hM.get(signature);
		return matches;
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
	 * Boolean method that checks whether all characters in the argument constitute a valid word that can be added to the dictionary. This method uses the same code as the prototype method.
	 * @param word for the String to be checked as a String. Identical to isValidWord method in prototype implementation and ListDictionary implementation.
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
