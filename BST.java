import java.util.ArrayList;
import java.util.Stack;

/*
 * Name: abstractTree.java
 * Description: This is the BST class containing all methods for traversing the tree
 * Authors: Leslie Ledeboer & Natalie Weingart
 * Question 1: Leslie Ledeboer
 * Question 2: Natalie Weingart
 * Question 3: Leslie Ledeboer
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
    public ArrayList<E> bstTraversal = new ArrayList<>();

    // empty constructor
    public BST() {
    }
   
    // check if it is empty
    public boolean isEmpty() {
        // if the root has nothing then there can be no tree. so True
        if (root == null) {
            return true;
        }

        else {
            return false;
        }
    } // end isEmpty

    // Looks for an item in the tree
    public boolean search(E e) {
        String element = (String) e;
        String rootElement = (String) root.element;

        if (element.compareToIgnoreCase(rootElement) == 0) {
            return true;
        } 
      
        else if (element.compareToIgnoreCase(rootElement) < 0) {
            if (root.left == null) {
                return false;
            }

            else {
                BST current =  new BST();
                current.root = this.root.left;
                return current.search(element);
            }
        }

        else if (element.compareToIgnoreCase(rootElement) > 0) {
            if (root.right == null) {
                return false;
            }
            
            else {
                BST current = new BST ();
                current.root = this.root.right;
                return current.search(element);
            }
        }

        return false;
    } // end search method

    public void insert(E e) {  
        String element = (String) e;
        final int initialSize = size;
        TreeNode node = new TreeNode(e);
            
        if (root == null) {
             root = node;
        }

        else {
            TreeNode currentNode = root;

            while (initialSize == size) {

                if (element.compareToIgnoreCase((String) currentNode.element) < 0) {
                    if (currentNode.left == null) {
                            currentNode.left = node;
                            ++size;
                        }

                        else {
                            currentNode = currentNode.left;
                        }
                }

                else if (element.compareToIgnoreCase((String) currentNode.element) > 0) {
                    if (currentNode.right == null) {
                            currentNode.right = node;
                            ++size;
                        }

                        else {
                            currentNode = currentNode.right;
                        }
                }

                else {
                    return;
                }
            }
        }
    }

    public boolean delete(E e) {
        TreeNode parent = null;
        boolean blResult = false;
        boolean direction = false; // true = left, false = right
        String element = (String) e;
        final int initialSize = size;
        TreeNode currentNode = (TreeNode) root;

            if (root != null) {
                while (initialSize == size) {

                    if (element.compareToIgnoreCase((String) currentNode.element) < 0) {
                        if (currentNode.left == null) {
                                return false;
                            }

                            else {
                                direction = true;
                                parent = currentNode;
                                currentNode = currentNode.left;
                            }
                    }

                    else if (element.compareToIgnoreCase((String) currentNode.element) > 0) {
                        if (currentNode.right == null) {
                                return false;
                            }

                            else {
                                direction = false;
                                parent = currentNode;
                                currentNode = currentNode.right;
                            }
                    }

                    else {
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
                                TreeNode successorParent = null;
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
                    }
                }
            }
            
        return blResult;
    }

    // returns the size of the tree
    public int getSize(){
        return size;
    } // end getSize

    // Question 1: (Implement postorder traversal without using recursion)  
    public ArrayList<E>  postorderNoRecursion() 
    {
	    ArrayList<E> nonRecursivePostorder= new ArrayList<>();

        TreeNode previous = null;
        TreeNode currentNode = (TreeNode) root;
        Stack<TreeNode> nodes = new Stack<>();

        while (!nodes.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            else {
                if (nodes.peek().right != null && previous != nodes.peek().right) {
                    currentNode = nodes.peek().right;
                }

                else {
                    nonRecursivePostorder.add((E) nodes.peek().element);
                    previous = nodes.pop();
                }
            }
        }
       
	    return nonRecursivePostorder;
    }
   
    // Question 2: get the Number of non-leaves.
    public int getNumberofNonLeaves() {
        nonleaves = 0;

        TreeNode currentNode = root;
        Stack<TreeNode> nodes = new Stack<>();

        while (!nodes.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            else {
                currentNode = nodes.pop();

                if (currentNode.left != null || currentNode.right != null) {
                    nonleaves++;
                }

                currentNode = currentNode.right;
            }
        }

        return nonleaves;
    }
   
    // Question 3: (Implement inorder traversal without using recursion) 
    public ArrayList<E>  inorderNoRecursion() {
	    ArrayList<E> nonRecursiveInorder= new ArrayList<>();
	   
        TreeNode currentNode = root;
        Stack<TreeNode> nodes = new Stack<>();

        while (!nodes.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodes.push(currentNode);
                currentNode = currentNode.left;
            }

            else {
                currentNode = nodes.pop();
                nonRecursiveInorder.add((E) currentNode.element);
                currentNode = currentNode.right;
            }
        }

	   return nonRecursiveInorder;
    }
   
    // traversal with recursion
    public ArrayList<E> inorder() {
        if (root == null) {
            return inOrderTraversal;
        }

        BST leftTree = new BST();
        leftTree.root = root.left;
        leftTree.inOrderTraversal = inOrderTraversal;

        leftTree.inorder();

        inOrderTraversal.add((E) root.element);

        BST rightTree = new BST();
        rightTree.root = root.right;
        rightTree.inOrderTraversal = inOrderTraversal;

        rightTree.inorder();

	    return inOrderTraversal;
    } //end inorder
   
    public ArrayList<E> preorder() {
        if (root == null) {
            return preOrderTraversal;
        }

        preOrderTraversal.add((E) root.element);
    
        BST leftTree = new BST();
        leftTree.root = root.left;
        leftTree.preOrderTraversal = preOrderTraversal;

        leftTree.preorder();

        BST rightTree = new BST();
        rightTree.root = root.right;
        rightTree.preOrderTraversal = preOrderTraversal;

        rightTree.preorder();

	    return preOrderTraversal;
    } // end preorder

    public ArrayList<E> postorder() {
        if (root == null) {
            return postOrderTraversal;
        }

        BST leftTree = new BST();
        leftTree.root = root.left;
        leftTree.postOrderTraversal = postOrderTraversal;

        leftTree.postorder();

        BST rightTree = new BST();
        rightTree.root = root.right;
        rightTree.postOrderTraversal = postOrderTraversal;

        rightTree.postorder();

        postOrderTraversal.add((E) root.element);
       
	    return postOrderTraversal;
    } // end postorder
} // end class BST