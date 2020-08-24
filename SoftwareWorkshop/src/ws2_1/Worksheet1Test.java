package ws2_1;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
/** @gxc378 
 *  Gordon Chan
 * This class contains the test cases for Worksheet1 solutions.
 *  Test cases written below.
 */

public class Worksheet1Test extends Worksheet1{
	
/**
 * Exercise 1: Power of integers test cases.
 */
	@Test //output when raising to power of zero.
	public void test1() {
		assertEquals(1, power(5,0));
		assertEquals(1, power(10,0));
		assertEquals(1, power(15,0));
	}
	@Test //output of pow.
	public void test2() {
		assertEquals(125, power(5,3));
		assertEquals(4096, power(4,6));
		assertEquals(65536, power(2,16));
	}
	@Test //output of fast pow with same values.
	public void test3() {
		assertEquals(125, fastPower(5,3));
		assertEquals(4096, fastPower(4,6));
		assertEquals(65536, fastPower(2,16));
	}
/**
 * Exercise 2: Negate a list method testing.
 */
	@Test //result when List A is empty
	public void test4() {
		assertEquals("[]",List.empty().toString());
	}
	@Test //Negate a mixed list of positive List of integers with negatives at the start, middle and end of the list.
	public void test5() {
		List n0 = List.empty();
		int[] n = {-1,2,3,4,-5,-6,7,-9};
		for (int counter = n.length-1; counter >= 0; counter--) {
			n0 = List.cons(n[counter],n0);
		}
		assertEquals("[1, -2, -3, -4, 5, 6, -7, 9]", negateAll(n0).toString());
		
	}
	
	@Test //Negate a mixed list of integers, then test that negating twice matches the output to original List A.
	public void test6() {
		List n1 = List.empty();
		int[] n = {1,34,67,78,234,-3, 45, -25};
		for (int counter = n.length-1; counter >= 0; counter--) {
			n1 = List.cons(n[counter],n1);
		}
		assertEquals("[-1, -34, -67, -78, -234, 3, -45, 25]", negateAll(n1).toString());
		assertEquals("[1, 34, 67, 78, 234, -3, 45, -25]", negateAll(negateAll(n1)).toString());
	}
	@Test //test output when list consists of -1,0 and 1.
	public void test7() {
		List n2 = List.empty();
		int[] n = {-1,0,1,0,-1,1};
		for (int counter = n.length-1; counter >= 0; counter--) {
			n2 = List.cons(n[counter],n2);
		}
		assertEquals("[1, 0, -1, 0, 1, -1]", negateAll(n2).toString());
	}
/**
 * Exercise 3: Searching for an element testing.
 */
	@Test //test that elements at the start, middle and end of the List can be found.
	public void test8() {
		List f0 = List.empty();
		int[] f = { -5, -5, 1, 2, 3, 5, 5, 7, 8, 8, 9,9};
		for (int counter = f.length-1; counter >= 0; counter--) {
			f0 = List.cons(f[counter],f0);
		}
		assertEquals("0",find(-5,f0)+"");
		assertEquals("5",find(5,f0)+"");
		assertEquals("10",find(9,f0)+"");
	}
	@Test(expected = Exception.class) //test that searching for elements that don't appear in the original List throw an exception.
	public void test9() {
		List f1 = List.empty();
		int[] f = { -5, -4, 0, 0, 1, 2, 4, 5, 6, 6, 6,11};
		for (int counter = f.length-1; counter >= 0; counter--) {
			f1 = List.cons(f[counter],f1);
		}
		assertEquals("",find(-20,f1)+"");
		assertEquals("",find(-1,f1)+"");
		assertEquals("",find(20,f1)+"");
	}
/**
 * Exercise 4: Check all positive method testing.
 */
	@Test // check that original List p0 is positive before verifying that cons'ing non-positive integers to the start of the List will return false.
	public void test10() {
		List p0 = List.empty();
		int[] p = {1,2,3,4,5,6,7,8,9,10};
		for (int counter = p.length-1; counter >= 0; counter--) {
			p0 = List.cons(p[counter],p0);
		}
		assertEquals(true, allPositive(p0));
		p0  = List.cons(-1, p0);
		assertEquals(false, allPositive(p0));
		p0 = List.cons(0,p0.getTail());
		assertEquals(false, allPositive(p0));
		p0 = p0.getTail();
		assertEquals(true, allPositive(p0));
	}
	@Test // a single negative number in the middle of the List gives a boolean false return.
	public void test11() {
		List p1 = List.empty();
		int[] p = {1,2,3,4,-5,6,7,8,9,10};
		for (int counter = p.length-1; counter >= 0; counter--) {
			p1 = List.cons(p[counter],p1);
		}
		assertEquals(false, allPositive(p1));

	}
	@Test //  single non-positive number at the end of the List gives a boolean false value.
	public void test12() {
		List p2 = List.empty();
		int[] p = {1,2,3,4,5,6,7,8,9,0};
		for (int counter = p.length-1; counter >= 0; counter--) {
			p2 = List.cons(p[counter],p2);
		}
		assertEquals(false, allPositive(p2));
	}
	@Test //zero is non-positive and so using the allPositive method will return false.
	public void test13() {
		List p3 = List.empty();
		int[] p = {0};
		for (int counter = p.length-1; counter >= 0; counter--) {
			p3 = List.cons(p[counter],p3);
		}
		assertEquals(false, allPositive(p3));
	}
/**
 * Exercise 5: Find the positives in list method test.
 */
	@Test // given a List with negatives at the start, middle and end, returns a new List of positive integers with duplicates retained.
	public void test14() {
		List findPositives = List.empty();
		int[] fP = {-212,-7-1,0,1,3,5,6,-5,8,9,9,-9,10,45,-200};
		for (int counter = fP.length-1; counter >= 0; counter--) {
			findPositives = List.cons(fP[counter],findPositives);
		}
		assertEquals("[1, 3, 5, 6, 8, 9, 9, 10, 45]", positives(findPositives).toString());

	}
	
/**
 * Exercise 6: Sortedness testing.
 */
	@Test //tests a List of sorted elements with duplicate elements will return true.
	public void test15() {
		List sorted1 = List.empty();
		int[] l1  = {1,1,2,4,5,5,6,7,8,9,10,11,11};
		for(int counter = l1.length-1; counter >= 0; counter--)
			sorted1 = List.cons(l1[counter],sorted1);
		assertEquals(true, sorted(sorted1));
		
		
	}
	@Test //A List with a negative element in the middle will return false.
	public void test16() {
		List sorted2 = List.empty();
		int[] l1  = {0,1,1,2,4,5,5,-6,7,8,9,10,11,11};
		for(int counter = l1.length-1; counter >= 0; counter--)
			sorted2 = List.cons(l1[counter],sorted2);
		assertEquals(false, sorted(sorted2));
	}
	@Test //A List with a negative element at the end will return false, when all prior elements were sorted.
	public void test17() {
		List sorted3 = List.empty();
		int[] l1  = {1,1,2,4,5,5,7,8,9,10,11,-11};
		for(int counter = l1.length-1; counter >= 0; counter--)
			sorted3 = List.cons(l1[counter],sorted3);
		assertEquals(false, sorted(sorted3));
		
		
	}
/**
 * Exercise 7: Merging method test cases
 */
	@Test //merges two Lists with all duplicates retained, and with all negative, zero and positive elements of the two Lists sorted in ascending order.
	public void test18() {
		List m0 = List.empty();
		List m1 = List.empty();
		int[] l1  = {-25, 0, 1, 4, 6, 7, 8, 10, 11};
		int[] l2  = {-1, 1, 3, 5, 5, 6, 6, 9};
		for(int counter0 = l1.length-1; counter0 >= 0; counter0--)
			m0 = List.cons(l1[counter0],m0);
		for(int counter1 = l2.length-1; counter1 >= 0; counter1--)
			m1 = List.cons(l2[counter1],m1);
		
		String expected = "[-25, -1, 0, 1, 1, 3, 4, 5, 5, 6, 6, 6, 7, 8, 9, 10, 11]";
		assertEquals(expected, merge(m0,m1).toString());
	}
/**
 * Exercise 8: Remove duplicates method testing
 */
	@Test //removes all duplicates in a List, given non positive values, with duplicates in the original List at the start, middle and end. Greater duplicates than two are also removed.
	public void test19() {
		List rd0 = List.empty();
		int[] r0  = {-1,-1,0,0,1,1,1,1,1,2,4,5,5,7,7,7,8,9,10,11,12,12};
		for(int counter = r0.length-1; counter >= 0; counter--) {
			rd0 = List.cons(r0[counter],rd0);
		}
		assertEquals("[-1, 0, 1, 2, 4, 5, 7, 8, 9, 10, 11, 12]",removeDuplicates(rd0).toString());
	}

}
