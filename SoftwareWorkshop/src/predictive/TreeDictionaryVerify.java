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
 *         Simple test to check your solution.
 * 
 */
public class TreeDictionaryVerify {

	private TreeDictionary td;

	@Before
	public void setUp() throws IOException {
		td = new TreeDictionary("/usr/share/dict/words");
	}

	@Test
	public void test() {

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
		expected.add("gnof");
		expected.add("imme");
		expected.add("inme");
		expected.add("inod");
		expected.add("inof");
		expected.add("inoe");
		expected.add("hooe");
		expected.add("gooe");
		expected.add("gonf");
		expected.add("honf");

		Set<String> result = td.signatureToWords("4663");

		assertEquals(expected, result);
	}

}
