/**
 * 
 */
package predictive;

/**
 * Gordon Chan
 * @author gxc378
 * @version
 * Command line program that calls the signatureToWords method on a given list of strings, converting numerical signatures
 * into words.
 */
public class Sigs2WordsProto {

	public static void main(String[]args) {

		long start = System.currentTimeMillis();
		
		String[] list = {"8574","9376","7733428483","8398","2273965837","467366"};
		
		for(int i = 0; i < list.length; i++){
			System.out.println(PredictivePrototype.signatureToWords(list[i]));
		}
		
		for(String s: args){
			System.out.println(PredictivePrototype.signatureToWords(s));
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end - start)+ "ms time to find matching words to argument signatures");

	}

}
