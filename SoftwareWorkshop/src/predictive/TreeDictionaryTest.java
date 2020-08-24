package predictive;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Gordon Chan
 * @author gxc378
 * @version 16-02-2016
 * Private testing for TreeDictionary class.
 */
public class TreeDictionaryTest {
	
	TreeDictionary tD = new TreeDictionary("/usr/share/dict/words"); // The TreeDictionary takes at least 2s to instantiate, usually less than 3s.

	/*
	 * Testing the signatureToWords method implemented in TreeDictionary. This JUnit test case completes in around 0.001s
	 */
	@Test
	public void signatureToWordsTest(){
		
		String[] expected = {"[project, prolect]", "[gravitational]","[analysis]", "[possession]", "[predictive]", "[prototype]", 
								"[wepm, werm, wern, wero, xero, yerm, yern, yeso, zerm, zern, zero]", "[almal, block, cloak, clock]"};
		String[] test = {"7765328","4728482846625","26259747","7677377466","7733428483","776868973","9376","25625"};
		String[] expectedWords = {"[physhar, physics]","[english]","[mathematics]","[computer, computes]",
									
										"[politics]","[german, geroco, herman, hernan]","[geography]","[drench, french]","[history]"};
		String[] testSignatures = {"7497427","3645474","62843628427","26678837","76548427","437626","436472749","373624","4478679"};

		for(int i = 0; i < test.length; i++){
			String actual = tD.signatureToWords(test[i]).toString();

			assertEquals(expected[i],actual);
		}
		for(int n = 0; n < testSignatures.length; n++){
			String actual = tD.signatureToWords(testSignatures[n]).toString();
			
			assertEquals(expectedWords[n],actual);
		}
	}
	/*
	 * Test case for the rangeCheck method, which verifies whether the argument index is a valid reference to a sub TreeDictionary.
	 * JUnit test is finished after around 1.380 seconds.
	 */
	@Test
	public void rangeCheckTest(){
		boolean[] expected = {true,false,true,true,false,true,false,true};
		int index[] = {1,-1,2,3,8,5,10,6};
		for(int i = 0; i < expected.length; i++){
			boolean actual = tD.rangeCheck(index[i]);
			assertEquals(expected[i], actual);
		}
		
	}

}
