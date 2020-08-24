package predictiveGUI;

import java.util.ArrayList;
import java.util.Observable;
import java.util.TreeSet;

import predictive.TreeDictionary;
/**
 * Gordon Chan
 * @author gxc378
 * @version 22-02-16
 * PredictiveModel class contains a constructor for creating PredictiveModel objects and for manipulating the components
 * of this object.
 */
public class PredictiveModel extends Observable{
	
	private ArrayList<String> text;
	private StringBuffer current;
	private String prefix;
	private TreeDictionary tD;
	private ArrayList<String> pool;
	private int counter;
	private int poolCounter; 
	/**
	 * Constructor for PredictiveModel has one argument for the file to be read in be read in to create a TreeDictionary
	 * instance variable. This PredictiveModel object will be passed as an argument to PredictiveView.
	 * @param filename for the file to be converted into a dictionary.
	 */
	public PredictiveModel(String filename){
		super();
		this.tD = new TreeDictionary(filename);
		this.text = new ArrayList<String>();
		this.counter = 0;
		this.current = new StringBuffer();
	}
	/**
	 * getter for text
	 * @return text as an ArrayList<String>
	 */
	public ArrayList<String> getText() {
		return this.text;
	}
	/**
	 * getter for the TreeDictionary of this object.
	 * @return tD as a TreeDictionary.
	 */
	public TreeDictionary getTD(){
		return tD;
	}
	/**
	 * addWord adds a word to the ArrayList<String> text. Calling this method will notify the Observer that something
	 * has changed.
	 * @param word for the word to be added to the ArrayList.
	 */
	public void addWord(String word){
		this.text.add(word);
		setChanged();
		notifyObservers();
	}
	/**
	 * setText is a mutator method for setting the text of this object to a new ArrayList<String>. Calling this method
	 * will notify the observer.
	 * @param t for the ArrayList<String> to be stored in this PredictiveModel.
	 */
	public void setText(ArrayList<String> t){
		this.text = t;
		setChanged();
		notifyObservers();

	}
	/**
	 * Getter method for the prefix
	 * @return the prefix currently stored in this object as a String.
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * Setter method for the prefix stored in this object.
	 * @param prefix for the for the argument to be stored in this argument as a String.
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * get the current count of the number of confirmed words in the ArrayList<String> text.
	 * @return
	 */
	public int getCounter() {
		return counter;
	}
	/**
	 * setter method for the counter instance of this object
	 * @param counter for the new value of the counter as an int.
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	/**
	 * instance method that removes the last entry in the ArrayList<Text>
	 * Does nothing if the list is empty or the size of the ArrayList is equal to the counter i.e. All words in the 
	 * ArrayList form the sentence that should be displayed and therefore should not be removed.
	 */
	public void remove(){
		if(text.isEmpty()){	
		} else if(getText().size() == getCounter()){
		} else {
			this.text.remove(getCounter());
		}
	}
	/**
	 * increment the counter by one.
	 */
	public void incrementCounter(){
		this.counter = counter+1;
	}
	/**
	 * decrement the counter by one. Could be used to delete the last word in the ArrayList<String> text.
	 */
	public void decrementCounter(){
		this.counter = counter-1;
	}
	/**
	 * gets the current pool of possible words that the currently evaluated signature could correspond to.
	 * @return
	 */
	public ArrayList<String> getPool() {
		return pool;
	}
	/**
	 * setter method for the pool of the corresponding signatures.
	 * @param pool
	 */
	public void setPool(ArrayList<String> pool) {
		this.pool = pool;
	}
	/**
	 * Converts ArrayList<String> text into a readable format.
	 * @param words for the list to be converted into a sentence as ArrayList<String>
	 * @return all the words in the list as a String.
	 */
	public String display(ArrayList<String> words){
		String r = "";
		for(int i = 0; i < words.size(); i++){
			r += words.get(i) + " ";
		}
		return r;
	}
	/**
	 * getter method for the poolCounter, which keeps track of which element in the ArrayList<String> text is
	 * currently being considered by the user.
	 * @return the poolCounter value as a
	 */
	public int getPoolCounter() {
		return poolCounter;
	}
	/**
	 * mutator method for the pool counter.
	 * @param poolCounter for the value to be stored in poolCounter as an int.
	 */
	public void setPoolCounter(int poolCounter) {
		this.poolCounter = poolCounter;
	}

	/**
	 * Helper method that calls the signatureToWords on a String, converts the output TreeSet to an ArrayList,
	 * before setting the instance variable pool in the model to this ArrayList.
	 * @param signature for the signature to be converted into a set of words as an String.
	 */
	public void sig2Words(String signature){
		ArrayList<String> s = new ArrayList<String>();
		TreeSet<String> match = getTD().signatureToWords(signature);
		s.addAll(match);
		setPool(s);
	}
	/*
	 * Some unused methods
	 */
	public StringBuffer getCurrent() {
		return current;
	}
	public void setCurrent(StringBuffer current) {
		this.current = current;
	}
}
