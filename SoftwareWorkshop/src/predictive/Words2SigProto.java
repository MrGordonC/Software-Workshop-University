package predictive;

/**
 * Gordon Chan
 * @author gxc378
 * @version 04-02-2016
 * This is a command line program that calls the wordToSignature method. An array of Strings is created and a for loop converts
 * this list of words to their numerical signatures.
 */

public class Words2SigProto{
	
	public static void main(String[]args){
		
		long start = System.currentTimeMillis();
		
		String[] list = {"discrete","zero","hero","gravitational","infinity","strike", "Einstein"};
		
		for(int i = 0; i < list.length; i++){
			System.out.println(PredictivePrototype.wordToSignature(list[i]));
		}
		for(String s: args){
			System.out.println(PredictivePrototype.wordToSignature(s));
		}
		long end = System.currentTimeMillis();
		
		System.out.println((end - start)+ " ms time to compute signatures corresponding to argument words");
	}

}
