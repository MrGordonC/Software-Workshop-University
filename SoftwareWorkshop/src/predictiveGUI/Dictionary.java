package predictiveGUI;


import java.util.Set;

/**
 * Gordon Chan
 * @author gxc378
 * @version 04-02-2016
 * Interface Dictionary requires implementation of signatureToWords.
 */
public interface Dictionary {
	/**
	 * The required method signatureToWords finds the possible words that could correspond to a given signature and
	 * returns them as a set.
	 * @param signature for the numerical signature that matches the string that we are searching for as a String.
	 * @return all words corresponding to the numerical signature as a set.
	 */
	public Set<String> signatureToWords(String signature);
		

}
