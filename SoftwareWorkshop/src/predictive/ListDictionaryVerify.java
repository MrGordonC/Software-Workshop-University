package predictive;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Alexandros Evangelidis
 *
 *
 *  Simple test to check your solution.
 *
 */

public class ListDictionaryVerify {

	private ListDictionary ld;

	@Before
	public void setUp() throws IOException {
		ld = new ListDictionary("/usr/share/dict/words");
	}

	@Test
	public void test1() {

		Set<String> expected = new TreeSet<String>();

		expected.add("good");
		expected.add("gone");
		expected.add("home");
		expected.add("hone");
		expected.add("hood");
		expected.add("hoof");
		expected.add("ioof");
		expected.add("ione");
		expected.add("inne");
		expected.add("gome");
		expected.add("gond");
		expected.add("hond");
		expected.add("goof");

		Set<String> result = ld.signatureToWords("4663");

		assertEquals(expected, result);
	}

}
