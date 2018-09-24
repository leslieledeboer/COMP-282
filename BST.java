
import java.util.ArrayList;
import java.util.Stack;

/**
 * NAME: abstractTree.java
 * Description: This is the BST class containing all methods for traversing the tree
 * Author: Question 1:
 *         Question 2:
 *         Question 3:
 */


public class  BST<E> implements TreeInterface<E> {

   // Data fields
   public TreeNode root;
   // Store the number of Nodes in this class variables   
   public int size = 0;
   //Store the number of Non Leaf nodes in this class variables
   public int nonleaves;
   
   public ArrayList<E> inOrderTraversal = new ArrayList<>();
   public ArrayList<E> preOrderTraversal = new ArrayList<>();
   public ArrayList<E> postOrderTraversal = new ArrayList<>();
   public ArrayList<E> bstTraversal= new ArrayList<>();
  

   // empty constructor
   public BST(){
   }
   
      // check if it is empty
public boolean isEmpty() {
       // if the root has nothing then there can be no tree. so True
      if (root == null) {
               return true;
       } else {
            return false;
      }
}// end isEmpty

   // Looks for an item in the tree
   public boolean search(E e){
            boolean blResult = false;

            /** TODO: INSERT YOUR CODE HERE 
             * 
             * SEARCH FOR THE ITEM PASSED AS PARAMETER AND RETURN TRUE IF FOUND
             * ELSE RETURN FALSE
             * 
             * 
             */
            return blResult;
   } // end search method



   public void insert(E e) {
         
            final int initialSize = size;
            TreeNode node = new TreeNode(e);
            
            if (root == null) {
                root = node;
            }

            else {
                TreeNode currentNode = root;

                while (initialSize == size) {
                    switch(e.compareToIgnoreCase(currentNode.element)) {
                        case -1: {

                            if (currentNode.left == null) {
                                currentNode.left = node;
                                ++size;
                            }

                            else {
                                currentNode = currentNode.left;
                            }
            
                            break;
                        }

                        case 0: {
                            return;
                        }

                        case 1: {

                            if (currentNode.right == null) {
                                currentNode.right = node;
                                ++size;
                            }

                            else {
                                currentNode = currentNode.right;
                            }
                            
                            break;
                        }
                    }
                }
            }

   }



      public boolean delete(E e) {

            TreeNode parent;
            boolean blResult = false;
            boolean direction = false; // true = left, false = right
            TreeNode currentNode = root;
            final int initialSize = size;

            if (root != null) {
                while (initialSize == size) {
                    switch(e.compareToIgnoreCase(currentNode.element)) {
                        case -1: {

                            if (currentNode.left == null) {
                                return false;
                            }

                            else {
                                direction = true;
                                parent = currentNode;
                                currentNode = currentNode.left;
                            }
            
                            break;
                        }

                        case 0: {
                            
                            if (currentNode.left == null && currentNode.right == null) {
                                if (direction) {
                                    parent.left = null;
                                }

                                else {
                                    parent.right = null;
                                }
                            }

                            else if (currentNode.left == null) {
                                if (direction) {
                                    parent.left = currentNode.right;
                                }

                                else {
                                    parent.right = currentNode.right;
                                }
                            }

                            else if (currentNode.right == null) {
                                if (direction) {
                                    parent.left = currentNode.left;
                                }

                                else {
                                    parent.right = currentNode.left;
                                }
                            }

                            else {
                                TreeNode successorParent;
                                TreeNode successor = currentNode.right;

                                while (successor.left != null) {
                                    successorParent = successor;
                                    successor = successor.left;
                                }

                                if (successor.right == null) {
                                    currentNode = successor;
                                }

                                else {
                                    successorParent.left = successor.right;
                                    currentNode = successor;
                                }
                            }

                            blResult = true;
                            --size;

                            break;
                        }

                        case 1: {

                            if (currentNode.right == null) {
                                return false;
                            }

                            else {
                                direction = false;
                                parent = currentNode;
                                currentNode = currentNode.right;
                            }
                            
                            break;
                        }
                    }
                }
            }
            
            return blResult;

      }

   // returns the size of the tree
   public int getSize(){
            /**
             * TODO: INSERT YOUR CODE HERE
             * FIND THE NUMBER OF NODES IN THE TREE AND STORE THE VALUE IN CLASS VARIABLE "size"
             * RETURN THE "size" VALUE
             * 
             * HINT: THE NMBER OF NODES CAN BE UPDATED IN THE "size" VARIABLE EVERY TIME A NODE IS INSERTED OR DELETED FROM THE TREE. 
             */

      return size;
   }// end getSize

   //Question1: (Implement postorder traversal without using recursion)  
   public ArrayList<E>  postorderNoRecursion() 
   {
	   ArrayList<E> nonRecursivePostorder= new ArrayList<>();
	   
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE POST ORDER TRAVERSAL OF THE TREE WITHOUT USING RECURSION AND RETURN THE RESULT TRAVEL SEQUENCE IN ARRAYLIST nonRecursivePostorder
	       */

	   return nonRecursivePostorder;
   }
   
  
  
   // Question 2: get the Number of non-leaves.
   public int getNumberofNonLeaves() {
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE NUMBER OF NON_LEAF NODES IN THE TREE AND RETURN
	       */
      return nonleaves;
   }
   
   //Question3: (Implement inorder traversal without using recursion) 
   public ArrayList<E>  inorderNoRecursion() 
   {
	   ArrayList<E> nonRecursiveInorder= new ArrayList<>();
	   
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE IN ORDER TRAVERSAL OF THE TREE WITHOUT USING RECURSION AND RETURN THE RESULT TRAVEL SEQUENCE IN ARRAYLIST nonRecursiveInorder
	       */

	   return nonRecursiveInorder;
   }
   
  
   // traversal with recursion
   public ArrayList<E> inorder() {
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE IN ORDER TRAVERSAL OF THE TREE AND RETUN THE RESULT TRAVEL SEQUENCE IN ARRAYLIST inOrderTraversal
	       */

	   return inOrderTraversal;
      }//end of inorder
 
   
   public ArrayList<E> preorder() {
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE PRE ORDER TRAVERSAL OF THE TREE AND RETUN THE RESULT TRAVEL SEQUENCE IN ARRAYLIST preOrderTraversal
	       */

	   return preOrderTraversal;

   }// end preorder


   public ArrayList<E> postorder() {
	   /**
	       * TODO: INSERT YOUR CODE HERE
	       * FIND THE POST ORDER TRAVERSAL OF THE TREE AND RETUN THE RESULT TRAVEL SEQUENCE IN ARRAYLIST postOrderTraversal
	       */
	return postOrderTraversal;
   }

  

}// end class BST

