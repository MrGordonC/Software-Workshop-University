package predictive;

/**
 * Gordon Chan
 * @author gxc378
 * @version 16-02-2016
 * Command line program.
 */
public class Sigs2WordsTree {

	/**
	 * Command line program for TreeDictionary. A new instance of TreeDictionary is instantiated, and a String[] of signatures is assigned,
	 * before a for loop iterates through the array and calls the instance method signatureToWords on each element, printing the returned Tree<Set>
	 * as a String.
	 * @param args
	 */
	public static void main(String[] args) {
		
		long instantiate = System.currentTimeMillis();

		TreeDictionary tD = new TreeDictionary("/usr/share/dict/words");
		
		long start = System.currentTimeMillis();

				
		String[] signatures = {"9376","7733428483","8398","2273965837","467366","4728482846625"};
		
		for(int i = 0; i < signatures.length; i++){
			System.out.println(tD.signatureToWords(signatures[i]));
			}
		long arguments = System.currentTimeMillis();
		
		for(String s: args){
			System.out.println(tD.signatureToWords(s));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println(end-arguments + "ms time to compute arguments");
		System.out.println((start - instantiate) + "ms time to instantiate TreeDictionary");
		System.out.println((end - start)+ " ms time to find Strings in TreeDictionary object");
		

	}

}
