package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.TreeSet;

/** The following class implements a recursive tree data structure in order to store the Dictionary for the predictive text program.
 * Contains constructor for instantiating TreeDictionary objects and instance methods for manipulating instances.
 * Gordon Chan
 * @author gxc378
 * @version 16-02-2016
 *
 */
public class TreeDictionary implements Dictionary {

	TreeSet<String> words = new TreeSet<String>();
	public String signature;
	TreeDictionary[] tD = new TreeDictionary[8];
	int level = 0;
	
	/**
	 * TreeDictionary constructor for root node of Tree Dictionary instances. Takes a String pathname argument and reads in the file line by line. If the word is valid
	 * i.e. the isValidWord method returns true, the word is converted into lower case, a corresponding signature variable is instantiated, the insert method is called.
	 * @param filename for the dictionary file to be read in as a String.
	 */
	public TreeDictionary(String filename) {
		String entry;
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((entry=in.readLine())!=null){
				if(MapDictionary.isValidWord(entry)){
					String signature = wordToSignature(entry.toLowerCase());
					insert(entry, signature);
				}
				
		}
			in.close();
		}
		catch (Exception e) {
			System.out.println("File not found");
		}
	}
	/**
	 * Empty constructor for TreeDictionary.
	 */
	public TreeDictionary() {
		
	}
	/** Method for facilitating recursive insertion into the Tree data structure.  In the base case, if the s
	 * @param word for the word to be inserted into TreeDictionary instance as a String
	 * @param signature for the signature to be prefix matched against the current position of the Tree as a String.
	 * 
	 */
	public void insert(String word, String signature) {
		StringBuffer sB = new StringBuffer(signature);
		if (sB.length() == 0) { // Base case for recursive call. If the length of the signature equals zero, the word is inserted into words, but no new subtrees are instantiated. 
			words.add(word.toLowerCase());
		}
		else {
			int index = Character.getNumericValue(sB.charAt(0)) - 2; // Converts the value of each character into an int index
			if (rangeCheck(index)) {
				/**
				 * If true a new TreeDictionary is stored at tD[index], the level of the new Tree is set to 1 more down than the current level, the word is inserted into this objects
				 * Tree<Set> words, before the insert is called recursively on the newly instantiated Tree.
				 * If false, which means that a TreeDictionary is already stored at this index, the word is inserted into the Tree at this index and the insert is called recursively
				 * on the existing TreeDictionary at that index.
				 */
				if (tD[index] == null) { 
					tD[index] = new TreeDictionary();
					tD[index].level = level + 1;
					tD[index].words.add(word.toLowerCase());
					tD[index].insert(word, sB.substring(1)); 
				}
				else { 
					tD[index].words.add(word.toLowerCase()); 
					tD[index].insert(word, sB.substring(1));
				}
			}
		}
	}


	/**
	 * This implementation of signatureToWords is a recursive implementation of the signatureToWords method. The argument String signature is assigned to a StringBuffer local variable.
	 * In the base case, in which the length of the argument is equal to zero, a new TreeSet and a new Iterator for Strings are instantiated.
	 * While there are still words in the TreeSet<String> tS, a loop runs which pops the next word in the set, generates a substring prefix from the start of the String to the current
	 * level of the Tree, and this subString is added to the results. Once this loop has finished, the results tS are returned.
	 * Else, recursion is used to traverse deeper into the tree. This requires the index of the target TreeDictionary, and a substring of this signatureToWords call's signature, beginning
	 * at index 1 of the String. The return statement calls signatureToWords on the target instance, with the new substring as an argument.
	 * @param signature for the signature to be prefix matched with words in TreeDictionary as a String.
	 * @return the complete list of prefix matched words with the signature argument as a String.
	 */
	@Override
	public TreeSet<String> signatureToWords(String signature) {
		
		StringBuffer sB = new StringBuffer(signature);
		
		if (sB.length() == 0) {
			TreeSet<String> tS = new TreeSet<>();
			Iterator<String> iterator = words.iterator();  
			while (iterator.hasNext()) {
				String word = iterator.next().toString();
				String subString = word.substring(0, level);
				tS.add(subString);
			}
			return tS;	
		}
		else {
			int index = Character.getNumericValue(sB.charAt(0)) -2;
			String subString = sB.substring(1);
			return tD[index].signatureToWords(subString);
		}
	}
	/** 
	 * Method for checking if the index is within range. A TreeDictionary node can have at most 8 nodes, and a minimum of one, so it must
	 * hold true that 0 <= index <=7
	 * @param index for the argument index of the TreeDictionary. As a TreeDictionary instance can have 8 nodes at most, this value should
	 * never be less than zero or greater than 7.
	 * @return true if the index is valid, false if otherwise.
	 */
	public boolean rangeCheck(int index) {
		if (index >= 0 && index <= 7) {
			return true;
		} else {
			return false;
		}
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
			} else if (index =='g'|| index == 'h'|| index =='i'||index == 'G' || index == 'H' || index == 'I'){
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

}
	

