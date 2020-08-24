package predictive;
/**
 * Gordon Chan
 * @author gxc378
 * @version 16-02-2016
 * Command line program.
 */
public class Sigs2WordsMap {

	/**
	 * Sigs2WordsMap is a command line program that uses the MapDictionary class. This program is almost identical to other main
	 * methods for implementations of Dictionary, with a different type being initially instantiated and difference variable names being used.
	 */
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		MapDictionary mD = new MapDictionary("/usr/share/dict/words");
		
		long instantiate = System.currentTimeMillis();
		
		String[] signatures = {"9376","7733428483","8398","2273965837","467366","4728482846625"};
		
		for(int i = 0; i < signatures.length; i++){
			System.out.println(mD.signatureToWords(signatures[i]));
		}
		for(String s: args){
			System.out.println(mD.signatureToWords(s));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((instantiate - start) + "ms time to instantiate MapDictionary");
		System.out.println((end - instantiate)+ " ms time to find String gravitational in TreeDictionary object");
	}
}
