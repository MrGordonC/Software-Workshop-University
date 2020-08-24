package ws2_2;
import java.io.Console;

import ws2_1.List;

/** @author gxc378
 *  Gordon Chan
 *  @version 02-02-2016
 * This class contains the solution for Worksheet2
 */

public class Worksheet2 implements Worksheet2Interface{
    // Exercise 1
	/**
	 * given a list of integers, returns a new Tree containing all the elements with their signs negated,i.e. positive integers become negative and negative integers become positive.
	 * @param t for the Tree to be evaluated
	 * @return the new Tree with all elements negated as the type Tree.
	 */
    public static Tree negateAll(Tree t) {
    	if(t.getEmpty()) {
				return new Tree();
    	} else {
    		return new Tree(-t.getValue(),negateAll(t.getLeft()),negateAll(t.getRight()));
    	}
    }

    // Exercise 2
    /**
     * Given a Tree t, constructs and returns a Tree that is the mirror image of t along the left-right axis.
     * @param t for the tree that will be mirrored.
     * @return the new mirror image of t as a Tree
     */
    public static Tree mirror(Tree t) {
		if (t.getEmpty()) {
			return new Tree();
		} else {
			return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
		}
    }

    // Exercise 3
    /**
     * postorder returns a list containing all the node values stored in a Tree, by postorder traversal,i.e. for every node, all the values in the left subtree should be listed first,
     * then all values in the right subtree and then finally the value in the node itself.
     * @param t for the tree that will have its values stored in its nodes returned in postorder.
     * @return Tree t node values in postorder as a List.
     */
    public static List postorder(Tree t) {
		if(t.getEmpty()) {
			return List.empty();
		} else {
			List root = new List(t.getValue(),List.empty());
			List child = ListOps.append(postorder(t.getLeft()), postorder(t.getRight()));
			return ListOps.append(child,root);
			
		}
	}


    // Exercise 4
    /**
     * allPositive returns a boolean value indicating whether all nodes in the Tree contain positive integers, i.e >= 0. A precondition assumed is that the tree is not empty.
     * @param a for the Tree that will be checked. All nodes being positive, the method will return true, else will return false.
     * @return true if all nodes in the tree are positive, negative if at least one node is negative.
     */
    public static boolean allPositive(Tree a) {
    	if(a.getEmpty()){
    		return true;
    	} else if (a.getValue() <= 0){
    		return false;
    	} else if (allPositive(a.getLeft()) && allPositive(a.getRight())) {
    		return true;
    	} return false;
    }

		// Exercise 5: not completed 02-02-16
    // restarted 15-08-20. Boo chicka yeahhhh
    /**
     * Given a Tree of integers, returns a boolean value indicating whether it is a binary search tree.
     * @param a for the Tree that method will check for BST property.
     * @return true if Tree is a binary search tree, false if otherwise.
     */
    //public static boolean isSearchTree(Tree a) {
    //	return false;
    //}
    public static boolean isSearchTree(Tree a) {
    	if(a.getEmpty()) {
    		return true;
    	} else if(a.getValue() > getMin(a.getRight())) {
    		return false;
    	} else if(a.getValue() < getMax(a.getLeft())){
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public static int getMax(Tree tree) {
    	if(tree.getLeft().getEmpty() && tree.getRight().getEmpty()) {
    		return tree.getValue();
    	} else if(tree.getLeft().getEmpty()) {
    		return Math.max(tree.getValue(), getMax(tree.getRight()));
    	} else if(tree.getRight().getEmpty()) {
    		return Math.max(tree.getValue(), getMax(tree.getLeft()));
    	} else {
    		return Math.max(tree.getValue(), (Math.max(getMax(tree.getLeft()), getMax(tree.getRight()))));
    	}
    }
    
    public static int getMin(Tree tree) {
    	if(tree.getLeft().getEmpty() && tree.getRight().getEmpty()) {
    		return tree.getValue();
    	} else if(tree.getLeft().getEmpty()) {
    		return Math.min(tree.getValue(), getMin(tree.getRight()));
    	} else if(tree.getRight().getEmpty()) {
    		return Math.min(tree.getValue(), getMin(tree.getLeft()));
    	} else {
    		return Math.min(tree.getValue(), (Math.min(getMin(tree.getLeft()), getMin(tree.getRight()))));
    	}
    }
    
    public static void main(String[] args) {
    	Tree test = new Tree(8);
		int [] a = {0,2,4,56,1,22,7};
		for(int i = 0; i < a.length; i++){
			test = insert(a[i],test);
		}
		Tree testsub = new Tree(9);
		int [] b = {45,55,122,42,7,67};
		for(int i = 0; i < b.length; i++){
			testsub = insert(b[i],testsub);
		}
		Tree notBinary = new Tree(3, test, testsub);
		System.out.println(isSearchTree(test));
		System.out.println(isSearchTree(testsub));
		//Tree.print(test);
		
		System.out.println(isSearchTree(notBinary));
		//Tree.print(notBinary);
		
		System.out.println(getMax(testsub));
    }

    // Exercise 6
    /**
     * Given a binary search tree of integers, print all values stored in nodes in Tree a in descending order. Is a void method.
     * @param a for the Tree that contains the values that will be printed in descending order, from biggest to smallest.
     */
    public static void printDescending(Tree a) {
    	if(a.getEmpty()) {
    	} else {
    		printDescending(a.getRight());
    		System.out.print(a.getValue()+", ");
    		printDescending(a.getLeft());
    	}
    }

		// Exercise 7
    /**
     * Assuming that the argument a is a binary search tree, finds the maximum value stored in the tree. Works in O(log n) time, at most traversing one path in the Tree from the root node.
     * @param a for the Tree to be searched for the maximum value.
     * @return maximum value stored in any Tree in a, as an int.
     */
    public static int max(Tree a) {
    	if(a.getEmpty()) {
    		throw new IllegalStateException("Tree is empty");
    	} else if (!a.getRight().getEmpty()){
    		return max(a.getRight());
    	} else {
    		return a.getValue();
    	}
    }
    /**
     * Helper method to find the minimum value of a Tree.
     * @param a for the Tree to be searched for a minimum value
     * @return minimum node in the tree, i.e. with the lowest value, as an int.
     */
    public static int min(Tree a) {
    	if(a.getEmpty()) {
    		throw new IllegalStateException("Tree is empty");
    	} else if (!a.getLeft().getEmpty()){
    		return min(a.getLeft());
    	} else {
    		return a.getValue();
    	}
    }

    // Exercise 8
    /**
     * Assuming that the argument Tree a is a binary search tree, this method deletes the value x from a and returns the resulting tree. A new Tree is constructed,
     * with all values retained apart from one instance of x.
     * @param a for the Tree that will contain at least one instance of x.
     * @param x for the copy of integer x that shall be deleted as an int.
     * @return new Tree with one instance of x deleted as a binary search tree.
     */
    public static Tree delete(Tree a, int x) {
    	if(a.getEmpty()) {
    		return new Tree();
    	} else if (x==a.getValue()) {
    		if (a.getLeft().getEmpty()) {
    			return a.getRight();
    		} else {
    			return new Tree(max(a.getLeft()),delete(a.getLeft(),max(a.getLeft())),delete(a.getRight(),x));
    		}
    	} else {
    		return new Tree (a.getValue(), delete(a.getLeft(), x),delete(a.getRight(),x));
    	}
    }

		// Exercise 9
    /**
     * Given a Tree of integers a, check to see if it is height balanced, returning a boolean value.
     * @param a for the Tree that will be checked to see if it satisfies the height balanced property.
     * @return true if tree is height balanced, false if otherwise.
     */
    public static boolean isHeightBalanced(Tree a) {
    	if(a.getLeft().getEmpty() && a.getRight().getEmpty()){
    		throw new IllegalStateException("Tree has no children");
    	} else if (!a.getLeft().getEmpty() && a.getLeft().getHeight() < 1) {
    		return true;
    	} else if (!a.getRight().getEmpty() && a.getRight().getHeight() < 1) {
    		return true;
    	} else if (a.getLeft().getHeight() == a.getRight().getHeight()) {
    		return true;
    	} else if (balance(a) <= 1 && balance(a) >= -1) {
    		return true;
    	} else {
    		return false;
    	}
    }
    /**
     * balance is a helper method that returns a value that represents the balance between a tree's left and right subtrees.
     * a positive return means that the tree is right heavy, a negative return means that it is left heavy, and a return of 0 means that the tree is balanced.
     * @param a for the Tree that will have it's balance factor evaluated.
     * @return balance factor of the Tree as an int.
     */
    public static int balance(Tree a) {
    	if(a.getEmpty()){
    		return 0;
    	} else if(a.getRight().getEmpty() && a.getLeft().getEmpty()) {
    		return 0;
    	} else if(a.getRight().getEmpty()) {
    		return a.getLeft().getHeight() *-1;
    	} else if(a.getLeft().getEmpty()) {
    		return a.getRight().getHeight();
    	} else return a.getRight().getHeight()-a.getLeft().getHeight();
    }
		// Exercise 10
    /**
     * insertHB is a modified insert method that will insert a value into a height balanced tree, and will maintain the height-balanced property in doing so.
     * @param x for the element to be inserted into the Tree, as an int value.
     * @param a for the height-balanced Tree that will have value inserted into it, as type Tree.
     * @return a new height balanced Tree with the height-balanced property intact and element x inserted.
     */
    public static Tree insertHB(int x, Tree a) {
				if(a.getEmpty()) {
					return new Tree(x);
				} else if(a.getValue() > x) {
					return rotateHB(new Tree(a.getValue(), rotateHB(insertHB(x, a.getLeft())), rotateHB(a.getRight())));
    			} else if(a.getValue() < x) {
    				return rotateHB(new Tree(a.getValue(), rotateHB(a.getLeft()), rotateHB(insertHB(x, a.getRight()))));
    			} else return rotateHB(a);
    }
/**
 * Here are additional helper functions for rotations.
 */
    /**
     * rotateHB is a helper function that checks the balance factor of Trees with the balance method, and then calls a rotation on the Tree that is passed as a parameter based on that factor.
     * @param t for the Tree that will be evaluated for whether a rotation is necessary to maintain the height-balanced property.
     * @return a new Tree that is height balanced. If the tree was height balanced already it will return the same Tree.
     */
    public static Tree rotateHB(Tree t){
    	if(balance(t) > 1 ) {
    		if(balance(t.getRight()) < 0) {
    			return LR(t);
    		} else {
    			return LL(t);
    		}
    	} else if (balance(t) < -1) {
    		if (balance(t.getLeft()) > 0) {
    			return RL(t);
    		} else {
    			return RR(t);
    		}
    	} else return t;
    }
    /**
     * The rotation LL is a helper function called by rotateHB when the argument Tree is right heavy, and it rotates the Tree left.
     * @param t for the Tree to be rotated as type Tree.
     * @return new Tree such that it has been rotated to the left twice.
     */
    public static Tree LL(Tree t) {
    	if(t.getEmpty()){
    		return new Tree();
    	} else if(t.getRight().getEmpty()){
    		return t;
    	} else {
    		return new Tree(t.getRight().getValue(),new Tree(t.getValue(),t.getLeft(), t.getRight().getLeft()), t.getRight().getRight());
    	}
    }
    /**
     * RR is a helper function called by rotateHB when the argument Tree is left heavy. It rotates the Tree right.
     * @param t for the Tree to be rotated as type Tree.
     * @return new Tree that has been rotated to the right twice.
     */
    public static Tree RR(Tree t) {
    	if(t.getEmpty()){
    		return new Tree();
    	} else if(t.getLeft().getEmpty()){
    		return t;
    	} else {
    		return new Tree(t.getLeft().getValue(),t.getLeft().getLeft(), new Tree(t.getValue(),t.getLeft().getRight(),t.getRight()));
    	}
    }
    /**
     * LR is a helper function called by rotateHB when the argument Tree is right heavy and the right subtree is also left heavy. The right subtree is rotated left first, followed by its parent.
     * @param t for the Tree to be rotated.
     * @return a new Tree that has been subject to two rotations on the parent and right subtree.
     */
    public static Tree LR(Tree t) {
    	Tree left = new Tree();
    	if(t.getEmpty()){
    		return new Tree();
    	} else if(t.getLeft().getEmpty()&&t.getRight().getEmpty()){
    		return t;
    	} else {
    		if(t.getLeft().getEmpty()){
    			left = new Tree();
    		} else {
    			left = t.getLeft();
    			}
    		}
    	Tree right = RR(t.getRight());
    	return LL(new Tree(t.getValue(),left,right));
    }
    /**
     * RL is a helper function called by rotateHB when the argument Tree is left heavy and the left subtree is right heavy. The left subtree is rotated first, followed by its parent node.
     * @param t for the Tree to be rotated.
     * @return a new Tree that has been given two rotations on the parent and left subtrees,
     */
    public static Tree RL(Tree t) {
    	Tree right = new Tree();
    	if(t.getEmpty()){
    		return new Tree();
    	} else if(t.getLeft().getEmpty()&&t.getRight().getEmpty()){
    		return t;
    	} else {
    		if (t.getRight().getEmpty()){
    			right = new Tree();
    		} else {
    			right = t.getRight();
    		}
    	Tree left = LL(t.getLeft());
    	return RR(new Tree(t.getValue(),left,right));
    	}
    }
    /**
     * deleteHB is a recursive method that deletes integer x in height balanced Tree a, and will maintain the height-balanced property.
     * @param a for the original Tree.
     * @param x for the element that will be deleted as an int.
     * @return a new Tree that has one instance of x removed and has the height-balanced property.
     */
    public static Tree deleteHB(Tree a, int x) {
    	if(a.getEmpty()) {
    		return new Tree();
    	} else if (x==a.getValue()) {
    		if (a.getLeft().getEmpty()) {
    			return a.getRight();
    		} else {
    			return rotateHB(new Tree(max(a.getLeft()),rotateHB(deleteHB(a.getLeft(),max(a.getLeft()))),rotateHB(deleteHB(a.getRight(),x))));
    		}
    	} else {
    		return rotateHB(new Tree (a.getValue(), rotateHB(deleteHB(a.getLeft(), x)),rotateHB(deleteHB(a.getRight(),x))));
    	}
    }
    /**
     * Insert is a helper method that is used in testing.
     * @param n for the integer that shall be inserted.
     * @param t for the Tree that will be the target of insertion.
     * @return a new Tree with element n inserted into Tree t.
     */
    public static Tree insert(int n, Tree t) {
		if (t.getEmpty())
			return new Tree(n, new Tree(), new Tree());
		else if (n <= t.getValue())
			return new Tree(t.getValue(), insert(n, t.getLeft()), t.getRight());
		else
			return new Tree(t.getValue(), t.getLeft(), insert(n, t.getRight()));
	}

    
}
