package predictive;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Gordon Chan
 * @author gxc378
 * @version 14-02-2016
 * Private testing for MapDictionary implementation.
 */
public class MapDictionaryTest {

	MapDictionary mD = new MapDictionary("/usr/share/dict/words");

	/*
	 * Testing the signatureToWords method implemented in MapDictionary. The JUnit test completes in under 0.000s
	 * while the time to instantiate is around 0.75 seconds.
	 */
	
	@Test
	public void signatureToWordsTest(){
		//MapDictionary mD = new MapDictionary("/usr/share/dict/words");
		
		String[] expected = {"[project]", "[gravitational]","[analysis]", "[possession]", "[predictive]", "[prototype]", 
								"[yern, yeso, zero]", "[block, cloak, clock]"};
		String[] test = {"7765328","4728482846625","26259747","7677377466","7733428483","776868973","9376","25625"};
		String[] expectedWords = {"[physics]","[english]","[mathematics]","[computer, computes]",
									"[jaw, jay, kaw, kay, kaz, law, lax, lay, laz, lbw]"
										,"[politics]","[german, herman]","[geography]","[drench, french]","[history]"};
		String[] testSignatures = {"7497427","3645474","62843628427","26678837","529","76548427","437626","436472749","373624","4478679"};

		for(int i = 0; i < test.length; i++){
			String actual = mD.signatureToWords(test[i]).toString();

			assertEquals(expected[i],actual);
		}
		for(int n = 0; n < testSignatures.length; n++){
			String actual = mD.signatureToWords(testSignatures[n]).toString();
			
			assertEquals(expectedWords[n],actual);
		}
	}

}
