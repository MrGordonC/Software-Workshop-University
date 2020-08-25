package ws2_2;

import java.util.Stack;

public class IterativeExt {
	
	// Iterative function to perform in-order traversal of the tree
	public static void inorderIterative(Tree root)
	{
		// create an empty stack
		Stack<Tree> stack = new Stack<Tree>();

		// start from root node (set current node to root node)
		Tree curr = root;

		// if current node is null and stack is also empty, we're done
		while (!stack.empty() || !curr.getEmpty())
		{

			// if current node is not null, push it to the stack (defer it)
			// and move to its left child
			if (!curr.getEmpty())
			{
				stack.push(curr);
				curr = curr.getLeft();
			}
			else
			{
				// else if current node is null, we pop an element from stack,
				// print it and finally set current node to its right child
				curr = stack.pop();
				System.out.print(curr.getValue() + " ");

				curr = curr.getRight();
			}
		}
	}
	
	public static void preorderIterative(Tree curr) {
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(curr);
		
		while (!stack.empty()) {
			if(!curr.getEmpty()) {
				System.out.print(curr.getValue()+ " ");
				stack.push(curr.getRight());
				curr = curr.getLeft();
				//stack.pop();
	
			} else {
				curr = stack.pop();
			}
		
		}
	}

	public static void postorderIterative(Tree curr) {
		Stack<Tree> stack = new Stack<Tree>();
		stack.push(curr);

		while(true) { 
			while(curr!= null) { 
				stack.push(curr); 
				stack.push(curr); 
				curr = curr.getLeft(); 
			} 

			// Check for empty stack 
			if(stack.empty()) return; 
				curr = stack.pop(); 

				if(!stack.empty() && stack.peek() == curr) {
					curr = curr.getRight(); 
				} else { 
					System.out.print(curr.getValue() + " ");
					curr = null; 
				} 
		} 

	}
	
	public static void main(String[] args) {
		Tree test = new Tree(5,new Tree(1,new Tree(-5),new Tree(4,new Tree(2),new Tree())),new Tree(10,new Tree(),new Tree(41,new Tree(22), new Tree(60)))); 
		Tree.print(test);

		System.out.println();
		inorderIterative(test);
		System.out.println();
		
		//5 1-5 4 2 10 41 22 60
		preorderIterative(test);
		System.out.println();
		
		// -5, 2, 4, 1, 22, 60, 41, 10, 5
		System.out.println(Worksheet2.postorder(test));
		postorderIterative(test);
		
		
	}

}
