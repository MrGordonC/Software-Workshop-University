package predictive;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Gordon Chan
 * @author gxc378
 * @version 12-02-2016
 * Private tests for PredictiveProtype implementation of predictive text entry.
 */

public class PredictivePrototypeTest {
	/*
	 * test case for wordtoSignature method
	 */
	@Test
	public void wordToSignatureTest() {
		String[] expected = {"7765328","4728482846625","26259747","7677377466","7733428483","776868973","9376","2476464426"};
		String[] test = {"project", "gravitational","analysis", "possession", "predictive", "prototype", "zero", "Birmingham"};
		for(int i = 0; i < test.length; i++){
			String actual = PredictivePrototype.wordToSignature(test[i]);
			
			assertEquals(expected[i],actual);
		}
	}
	/*
	 * Testing the signatureToWords method
	 */
	@Test
	public void signatureToWordsTest(){
		String[] expected = {"[project]", "[gravitational]","[analysis]", "[possession]", "[predictive]", "[prototype]", "[yern, yeso, zero]", "[block, cloak, clock]"};
		String[] test = {"7765328","4728482846625","26259747","7677377466","7733428483","776868973","9376","25625"};

		for(int i = 0; i < test.length; i++){
			String actual = PredictivePrototype.signatureToWords(test[i]).toString();
			
			assertEquals(expected[i],actual);
		}
	}
	/*
	 * test case for isValidWord method.
	 */
	@Test
	public void isValidWordTest(){
		boolean[] expected= {true,false,true,false,false,true,true,false};
		String[] test = {"queue","1der","IntelligentDataAnalysis","wonder4","Birmingh4m","computer","science","recu72ion"};

		for(int i = 0; i < test.length; i++){
			boolean actual = PredictivePrototype.isValidWord(test[i]);
			
			assertEquals(expected[i],actual);
		}
	}

}
