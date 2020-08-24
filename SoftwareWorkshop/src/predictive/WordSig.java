package predictive;

/**
 * Gordon Chan
 * @author gxc378
 * @version 04-02-2016
 * WordSig class instantiates WordSig objects and includes instance methods for manipulating WordSig objects.
 */

public class WordSig implements Comparable<WordSig>{

	private String words;
	private String signature;
	/**
	 * A constructor for WordSig objects that has for arguments two Strings, words and signature. This object is only instantiated
	 * as a dummy object in the signatureToWord method, all other instances of WordSig use the other constructor. In theory this constuctor
	 * can be used to assign words to non-matching signatures.
	 * @param words for the word to be stored in this instance as an int.
	 * @param signature for the paired signature to this word. Together they comprise an instance of WordSig.
	 */
	public WordSig(String words, String signature){
		this.words = words;
		this.signature = signature;
	}
	/**
	 * This implementation of the constructor for WordSig objects has one required argument, a String words that will be stored in
	 * in this object. This constructor automatically generates the WordSig element Signature using the wordtoSignature method in
	 * the ListDictionary class.
	 * @param word for the word that this object represents in the dictionary as a String.
	 */
	public WordSig(String word){
		this.words = word;
		this.signature = ListDictionary.wordToSignature(this.getWords());
	}
	/**
	 * Get method for instance element words
	 * @return this objects element words as a String.
	 */
	public String getWords() {
		return this.words;
	}
	/**
	 * Accessor method for the signature of WordSig objects.
	 * @return the signature of this WordSig as a String.
	 */
	public String getSignature() {
		return this.signature;
	}
	/**
	 * Mutuator method for WordSig objects. Will set the word to the argument and change this signature to the new signature useing
	 * the wordsToSignature method.
	 * @param word for the word to be assigned to this WordSig object as a String.
	 */
	public void setWords(String word){
		this.words = word;
		this.signature = ListDictionary.wordToSignature(this.getWords());
	}
	/**
	 * toString method defines how WordSig objects should be printed.
	 * @return WordSig instance in a readable format.
	 */
	@Override
	public String toString(){
		String s= "";
		return s + getWords() +": "+ getSignature();
	}
	/**
	 * compareToMethod for WordSig objects. The signature of the WordSig instance this method is called upon and the signature
	 * of the argument are compared and a value is return based upon their natural ordering.
	 * This compareTo method defines in what order the WordSig objects in ListDictionary are stored by Collection.sort.
	 * @return -1 if the instance precedes the argument, 1 if the argument precedes the instance, and 0 if the signatures are equal.
	 */
	@Override
	public int compareTo(WordSig ws){
		if(this.getSignature().compareTo(ws.getSignature()) >= 1){
			return 1;
		} else if(this.getSignature().compareTo(ws.getSignature()) <= -1){
			return -1;
		} else return 0;
	}
}
