package ws2_2;
import static org.junit.Assert.*;
import org.junit.Test;

import ws2_1.List;
import ws2_2.IterativeExt;
/**
 * @author gxc378
 * Gordon Chan
 * @version 02-02-2106
 */

public class Worksheet2Test extends Worksheet2{
	
	/**
	 * Exercise 1: negateAll test cases.
	 */
		@Test //Test that negateAll on tree with allPositive elements returns all negative Tree.
		public void test1() {
			Tree test = new Tree();
			
			int[] n0= {5,3,4,1,2,9,7,10,8,6};
			for(int i = 0; i < n0.length; i++) {
				test = insert(n0[i],test);
			}
			
			Tree left = new Tree(-3,new Tree(-1, new Tree(),new Tree(-2)),new Tree(-4));
			Tree right = new Tree(-9,new Tree(-7,new Tree(-6),new Tree(-8)), new Tree(-10));
			Tree actual = new Tree(-5,left,right);
			
			Tree expected = negateAll(test);
			assertTrue(expected.equals(actual));
		}
		@Test //Test that negateAll on tree will all negative elements returns all positive Tree
		public void test2() {

			Tree test = new Tree();
			
			int[] n0= {-5,-3,-4,-1,-2,-9,-7,-10,-8,-6};
			for(int i = 0; i < n0.length; i++) {
				test = insert(n0[i],test);
			}
			
			Tree left = new Tree(9,new Tree(10),new Tree(7,new Tree(8),new Tree(6)));
			Tree right = new Tree(3,new Tree(4), new Tree(1,new Tree(2),new Tree()));
			Tree actual = new Tree(5,left,right);
			
			Tree expected = negateAll(test);
			assertTrue(expected.equals(actual));
		}
		@Test //Tests that the middle root, left tree and right tree are negated.
		public void test3() {
			Tree test = new Tree(4,new Tree(2),new Tree(8));
			Tree actual = new Tree(-4,new Tree(-2),new Tree(-8));
			Tree expected = negateAll(test);
			
			assertTrue(expected.equals(actual));
		}
		/**
		 * Exercise 2: Testing mirror method
		 */
		@Test //Tests tree with two children will return a mirrored tree
		public void test4() {
			Tree test = new Tree(22,new Tree(7), new Tree(8));
			Tree actual = new Tree(22, new Tree(8), new Tree(7));
			Tree expected = mirror(test);
			assertTrue(expected.equals(actual));
		}
		@Test // Tests that a tree with two children on its left subtree, when reversed, will have two children on its right subtree
		public void test5() {
			Tree test = new Tree(54,new Tree(5,new Tree(11), new Tree(52)),new Tree(101));
			Tree actual = new Tree(54, new Tree(101), new Tree(5,new Tree(52), new Tree(11)));
			Tree expected = mirror(test);
			
			assertTrue(expected.equals(actual));
			
		}
		@Test // Calling mirror on a tree with only right hand children will return a tree with only left hand children.
		public void test6() {
			Tree test = new Tree(5,new Tree(),new Tree(8, new Tree(),new Tree(21,new Tree(), new Tree(33,new Tree(), new Tree (75)))));
			Tree actual = new Tree(5,new Tree(8,new Tree(21,new Tree(33,new Tree(75),new Tree()),new Tree()),new Tree()) , new Tree());
			Tree expected = mirror(test);
			
			assertTrue(expected.equals(actual));
		}
		/**
		 * Exercise 3: postorder traversal test cases.
		 */
		@Test //postorder tree testing
		public void test7() {
			Tree test = new Tree(5,new Tree(1,new Tree(-5),new Tree(4,new Tree(2),new Tree())),new Tree(10,new Tree(),new Tree(41,new Tree(22), new Tree(60)))); 
			List actual = List.empty();
			int[] p = {-5,2,4,1,22,60,41,10,5};
			for(int counter = p.length-1; counter >= 0; counter--) {
				actual = List.cons(p[counter], actual);
			}
			List expected = postorder(test);
			assertTrue(expected.equals(actual));
		}
		/**
		 * Exercise 4: allPositive method test cases
		 */
		@Test // test method returns true when all elements are positive integers.
		public void test8() {
			Tree test = new Tree();
			int [] a = {131,2314,532,63463,34,2,5,7,8};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			boolean expected = allPositive(test);
			assertTrue(expected);
		}
		@Test //When root node is non-positive, like 0 is, allPositive method returns false.
		public void test9() {
			Tree test = new Tree(8);
			int [] a = {0,2,4,56,1,22,45,55,122,42,4,67};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			boolean expected = allPositive(test);
			assertFalse(expected);
			
		}
		@Test //false test case 1, where non-positive value is inserted last into the Tree.
		public void test10() {
			Tree test = new Tree();
			int [] a = {36,16,25,9,4,1,81,64,49,-100};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			boolean expected = allPositive(test);
			assertFalse(expected);
			
		}
		@Test //false test case 2, where non-positive value is inserted into a intermediary position in the Tree
		public void test11() {
			Tree test = new Tree();
			int [] a = {36,16,25,9,4,-1,81,64,49,100};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			boolean expected = allPositive(test);
			assertFalse(expected);
			
		}
		/**
		 * Exercise 7 : Max method of a given Tree test cases.
		 */
		@Test //Test max with all positive integers
		public void test12() {
			Tree test = new Tree();
			int [] a = {10,3,5,32,78,13,78,325,723,2,45,6};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			int expected = 723;
			int actual = max(test);
			assertEquals(expected,actual);
		}
		@Test // Tests max method with non-positive integers
		public void test13() {
			Tree test = new Tree();
			int [] a = {-23,-2314,-34,-1,-4,0,-4,-5,-53,-6};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			int expected = 0;
			int actual = max(test);
			assertEquals(expected,actual);
		}
		@Test //Tests max method when max value is root node.
		public void test14() {
			Tree test = new Tree();
			int [] a = {100,16,25,9,4,1,81,64,49,36};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			int expected = 100;
			int actual = max(test);
			assertEquals(expected,actual);
		}
		/**
		 * Exercise 8: Delete node method testing
		 */
		@Test //Tests that deleting the original root node with delete will take the max of the left subtree and use that value for the new value of the root node.
		public void test15() {
			Tree test = new Tree();
			int [] a = {36,16,25,9,4,1,81,64,49,100};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			Tree expected = new Tree();
			int [] b = {25,16,9,4,1,81,64,49,100};
			for(int j = 0; j < b.length; j++){
				expected = insert(b[j],expected);
			}
			
			Tree actual = delete(test,36);
			assertTrue(expected.equals(actual));
		}
		@Test // Test delete method when deleting a subtree with two children.
		public void test16() {
			Tree test = new Tree();
			int [] a = {36,16,25,9,4,1,81,64,49,100,72};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			Tree expected = new Tree();
			int [] b = {36,16,25,9,4,1,81,49,72,100};
			for(int j = 0; j < b.length; j++){
				expected = insert(b[j],expected);
			}
			
			Tree actual = delete(test,64);

			assertTrue(expected.equals(actual));
		}
		@Test //Test delete method on negative integers and bigger positive integers.
		public void test17() {
			Tree test = new Tree();
			int [] a = {5,1000,1444,500,250,750,0,-4,-2,-3};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}
			Tree expected = new Tree();
			int [] b = {5,750,500,250,0,-2,-3};
			for(int j = 0; j < b.length; j++){
				expected = insert(b[j],expected);
			}
			
			Tree actual = delete(test,1000);
			actual = delete(actual,1444);
			actual = delete(actual,-4);
			
			assertTrue(expected.equals(actual));
		}
		/**
		 * Exercise 9: Test cases for isHeightBalanced method. Returns boolean.
		 */
		@Test //Assert if binary search tree is height balanced
			public void test18() {
			Tree test = new Tree();
			int [] a = {36,16,25,25,9,4,1,81,64,49,100};
			for(int i = 0; i < a.length; i++){
				test = insert(a[i],test);
			}

			assertTrue(isHeightBalanced(test));
		}
		@Test //Test method returns false when tree is left subtree heavy
		public void test19() {
		Tree test = new Tree();
		int [] a = {5,0,-4,-2,-3,-250};
		for(int i = 0; i < a.length; i++){
			test = insert(a[i],test);
		}

		assertFalse(isHeightBalanced(test));
		}
		@Test //Test method returns false when tree is right subtree heavy
		public void test20() {
		Tree test = new Tree();
		int [] a = {5,70,50,144,169,256};
		for(int i = 0; i < a.length; i++){
			test = insert(a[i],test);
		}

		assertFalse(isHeightBalanced(test));
		}
		/**
		 * Exercise 10: insertion with height balancing test cases
		 */
		@Test // RR rotation after an insert
		public void test21() {
		Tree test = new Tree();
		Tree expected = new Tree();
		
		int [] a = {3,5,4,6,1,0};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
		}

		int [] b = {4,5,1,3,6,0,-1};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
		}

		Tree actual = insertHB(-1,test);
		assertEquals(expected,actual);

		}
		@Test // LL rotation after an insert
		public void test22() {
		Tree test = new Tree();
		Tree expected = new Tree();
	
		int [] a = {12,10,15,11,4,16};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
		}

		int [] b = {12,10,15,11,4,16,20};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
		}

		Tree actual = insertHB(20,test);
		assertEquals(expected,actual);

		}
		@Test // LR rotation after an insert
		public void test23() {
		Tree test = new Tree();
		Tree expected = new Tree();
	
		int [] a = {7,9};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
		}

		int [] b = {7,9,8};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
		}

		Tree actual = insertHB(8,test);
		assertEquals(expected,actual);

		}
		@Test // RL rotation after an insert
		public void test24() {
		Tree test = new Tree();
		Tree expected = new Tree();
	
		int [] a = {10,5,8};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
			}

		int [] b = {8,5,10};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
			}

		Tree actual = insertHB(8,test);
		assertEquals(expected,actual);
		}
		/**
		 * Exercise 10: Deletion with height balancing method test cases
		 */
		@Test // LR rotation after a deletion.
		public void test25() {
		Tree test = new Tree();
		Tree expected = new Tree();
	
		int [] a = {25,17,44,71,36,30};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
			}

		int [] b = {44,25,36,30,71};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
			}

		Tree actual = deleteHB(test,17);
		assertEquals(expected,actual);
		}
		@Test // LR rotation after a deletion.
		public void test26() {
		Tree test = new Tree();
		Tree expected = new Tree();
	
		int [] a = {-17,-10,-20,-14};
		for(int i = 0; i < a.length; i++){
			test = insertHB(a[i],test);
			}

		int [] b = {-14,-17,-10};
		for(int i = 0; i < b.length; i++){
			expected = insertHB(b[i],expected);
			}

		Tree actual = deleteHB(test,-20);
		assertEquals(expected,actual);
		}
		
}
