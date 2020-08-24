package ws2_1;
/** @author  gxc378
 *  Gordon Chan
 *  @version 20-01-16
 * This class contains the solution for Worksheet1
 */

public class Worksheet1 implements Worksheet1Interface{
/**
 * Recursive algorithm discussed in class. Raises int m to the power of int n(both non-negative. Takes log(n)^2 time
 * @param m for the int to be raised
 * @param n for the int power
 * @return m^n as an int.
 */
	 public static int power(int m, int n) {
	  	  if(n==0){
	  		  return 1;
	  	  } else {
	  		  return m*power(m,n-1);
	  	  } 
	  	}
/**
 * Recursive algorithm fastPow discussed in class. Takes log(n) time
 * @param m for the int to be raised
 * @param n for the int power
 * @return m^n as an int. 
 */
	 public static int fastPower(int m, int n) {
	    	if(n==0){
	    		return 1;
	    	} else if (n%2==0){
	    		return (fastPower(m,n/2))*(fastPower(m,n/2));
	    	} else {
	    		return m *fastPower(m, n-1);
	    	}
	}
/**
 * Given a list of integers a, returns a new list with all elements of a with the sign negated, i.e positive integers become negative and negative integers become positive
 * @param a
 * @return
 */
	public static List negateAll(List a) {
			if (a.isEmpty()){
				throw new IllegalArgumentException("No elements in list");
			} else if(a.getTail().isEmpty()) {
				return List.cons(a.getHead()*-1,List.empty());
			} else {
				return List.cons(a.getHead()*-1, negateAll(a.getTail()));
			}
	}
/**
 * Given an integer x, which is assumed to be in the List a, returns the position of the first occurrence of x in a. If x does not appear in List a then an IllegalStateException is thrown.
 * @param x for the element to search for as type int.
 * @param a for the list to be searched through as type List.
 * @return index of element x in List a, or an IllegalStateException if the List a is empty or if the element x is not in the list.
 */
	public static int find(int x, List a) {
		if(a.isEmpty()){
			throw new IllegalStateException("list does not contain integer x.");
		} else if(a.getHead() == x){
			return 0;
		} else {
			return 1+ find(x, a.getTail());
		} 
	}
/**
 * Given a list of integers a, returns a boolean value indicating whether all its elements are positive, i.e. >= 0
 * @param a for the list that shall be checked that all elements contained are positive as type List.
 * @return true if all elements of List a are positive, false if one or more elements are negative.
 */
	public static boolean allPositive(List a) {
		if(a.isEmpty()) {
			return true;
		} else if(a.getHead()<=0) {
			return false;
		} else {
			return allPositive(a.getTail());
		}
	}
/**
 * Given a List of integers a, return a new List which contains all the positive elements of a. The elements appear in the smae relative order as in a.
 * @param a for the list that will have all non-positive integers removed as type List.
 * @return 
 */
	public static List positives(List a) {
		if (a.isEmpty()){
			throw new IllegalStateException("No elements in List a");
		} else if(a.getTail().isEmpty()){
			if(a.getHead()>0){
				return a;
			} else {
				return List.empty();
			}
		} else if(a.getHead()>0){
			return List.cons(a.getHead(), positives(a.getTail()));
		} else {
			return positives(a.getTail());
		}
	}
/**
 * Given a List of integers a, this method returns a boolean value indicating whether List a is sorted in increasing order(duplicates are allowed, and in a sorted List will be grouped together.
 * @param a for the List to be evaluated for sortedness, as type List.
 * @return true is the list is sorted in ascending order, false if else.
 */
	public static boolean sorted(List a) {
		if(a.isEmpty()){
			throw new IllegalStateException("No elements in List a to evaluate for sortedness");
		} else if(a.getTail().isEmpty()){
			return true;
		} else if(a.getHead() > a.getTail().getHead()) {
			return false;
		} else 
			return sorted(a.getTail());
		}
/**
 * Given two sorted Lists a and b, method returns a new sorted List that contains all the elements of a and the elements of b. Any duplicate copies of elements in a and b or their combinations are retained.			
 * @param a for the first list to be merged, of type List. Must be sorted in ascending order.
 * @param b for the second list to be merged, of type List. Must be sorted in ascending order.
 * @return a new sorted list that retains all elements of Lists a and b in ascending order and with duplicates retained.
 */
	public static List merge(List a, List b) {
		if(a.isEmpty()){
			return b;
		} else if(b.isEmpty()){
			return a;
		} else if(a.getHead() > b.getHead()){
			return List.cons(b.getHead(), merge(a,b.getTail()));
		} else {
			return List.cons(a.getHead(), merge(b,a.getTail()));
		}
	}
/**
 * Given a sorted List a, this method returns a copy of the List a with all duplicate copies removed. Takes 0(n)^2 time
 * @param a for the List that will have all duplicates removed. Type List and should be sorted in ascending order.
 * @return new List with all elements that appeared in original List a but with no duplicated elements.
 */
	public static List removeDuplicates(List a) {
		if(a.isEmpty()){
			throw new IllegalStateException("List is empty");
		} else if(a.getTail().isEmpty()){
			return a;
		} else if (a.getHead()==a.getTail().getHead()) {
			List b = List.cons(a.getHead(),(a.getTail().getTail()));
			return removeDuplicates(b);
		} else {
			return List.cons(a.getHead(), removeDuplicates(a.getTail()));
		}
	}

}
