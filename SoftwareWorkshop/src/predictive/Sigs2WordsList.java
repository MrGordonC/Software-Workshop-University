package predictive;
/**
 * Gordon Chan
 * @author gxc378
 * @version 12-02-2016
 */
public class Sigs2WordsList{

	/**
	 * Command line program for Sigs2WordsList
	 * @param args
	 */
	public static void main(String[]args) {
		
		long instantiate = System.currentTimeMillis();
		

		ListDictionary lD = new ListDictionary("/usr/share/dict/words");
		
		long start = System.currentTimeMillis();

		
		String[] signatures = {"9376","7733428483","8398","2273965837","467366","4728482846625"};
		
		for(int i = 0; i < signatures.length; i++){
			System.out.println(lD.signatureToWords(signatures[i]));
		}
		for(String s: args){
			System.out.println(lD.signatureToWords(s));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((start - instantiate) + "ms time to instantiate ListDictionary");
		System.out.println((end - instantiate) + " ms time to call signatureToWords on ListDictionary object");
	}

}
