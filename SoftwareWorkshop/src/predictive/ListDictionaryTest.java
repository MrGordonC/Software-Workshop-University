package predictive;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Gordon Chan
 * @author gxc378
 * @version 11-02-16
 */
public class ListDictionaryTest {
	
	ListDictionary lD = new ListDictionary("/usr/share/dict/words");

	/*
	 * Testing the signatureToWords method implemented in ListDictionary.
	 */	
	@Test
	public void signatureToWordsTest(){
		//ListDictionary lD = new ListDictionary("/usr/share/dict/words");
		//using a List that has already been instantiated, the List takes 0.001 s to complete this test.
		//The List takes just over half a second to instantiate.
		String[] expected = {"[project]", "[gravitational]","[analysis]", "[possession]", "[predictive]", "[prototype]", "[yern, yeso, zero]", "[block, cloak, clock]"};
		String[] test = {"7765328","4728482846625","26259747","7677377466","7733428483","776868973","9376","25625"};

		for(int i = 0; i < test.length; i++){
			String actual = lD.signatureToWords(test[i]).toString();

			assertEquals(expected[i],actual);
		}
	}
	/*
	 * test case for compareTo method in WordSig class. Essential for Collections.sort and Collections.binarySearch
	 */
	@Test
	public void compareToTest(){
		
		String[] words = {"clock","clock","zero","hero","abba","abca","mist","miss","predictive","prototype"};
		int[] expected  = {0, -1, 1, 1, 0, -1, 1, -1, -1};
		
		for(int i = 0; i < words.length-1; i++){
			WordSig alpha = new WordSig(words[i]);
			WordSig beta = new WordSig(words[i+1]);
			
			int actual = alpha.compareTo(beta);
			assertEquals(expected[i],actual);
		}
	}


}
