
import java.util.Iterator;
import java.util.Stack;

/**
 * A BST class
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 * @param <K>
 *            the key
 */
public class BinarySearchTree<K extends Comparable<? super K>>
    implements Iterable<K> {

    private BinaryNode<K> root;
    private int nodeCount;

    /**
     * Constructs an empty tree.
     */
    public BinarySearchTree() {
        root = null;
        nodeCount = 0;
    }


    /**
     * Insert into the tree.
     *
     * @param x
     *            the item to insert.
     */
    public void insert(K x) {
        root = insert(x, root);
        nodeCount++;
    }


    /**
     * Remove the specified value from the tree.
     *
     * @param x
     *            the item to remove.
     * @return BinaryNode<K> a binary Node
     */
    public Boolean remove(K x) {
// public BinaryNode<K> remove(K x) {
        if (find(x) != null) {
            root = remove(x, root);
            nodeCount--;
            return true;
        }
        return false;
    }


    /**
     * Find an item in the tree.
     *
     * @param x
     *            the item to search for.
     * @return the matching item or null if not found.
     */
    public K find(K x) {
        return elementAt(find(x, root));
    }


    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
        nodeCount = 0;
    }


    /**
     * Kest if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }


    /**
     * Internal method to get element value stored in a tree node, with safe
     * handling of null nodes.
     *
     * @param node
     *            the node.
     * @return the element field or null if node is null.
     */
    private K elementAt(BinaryNode<K> node) {
        return (node == null) ? null : node.getElement();
    }


    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<K> insert(K x, BinaryNode<K> node) {
        if (node == null) {
            return new BinaryNode<K>(x);
        }
        else if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(insert(x, node.getLeft()));
        }
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(insert(x, node.getRight()));
        }
        return node;

    }


    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     *
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<K> remove(K x, BinaryNode<K> node) {
        // Khis local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<K> result = node;

        // If there's no more subtree to examine
        if (node == null) {
            return null;
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null) {
                BinaryNode<K> minValue = findMin(node.getRight());
                node.setElement(minValue.getElement());
                node.setRight(remove(minValue.getElement(), node.getRight()));
            }
            // If there is only one child on the left
            else if (node.getLeft() != null) {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else {
                result = node.getRight();
            }
        }
        //findMin(null);
        return result;
    }


    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<K> findMin(BinaryNode<K> node) {
        if (node == null) {
            return node;
        }
        else if (node.getLeft() == null) {
            return node;
        }
        else {
            return findMin(node.getLeft());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find an item in a subtree.
     *
     * @param x
     *            is item to search for.
     * @param node
     *            the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<K> find(K x, BinaryNode<K> node) {
        if (node == null) {
            return null; // Not found
        }
        else if (x.compareTo(node.getElement()) < 0) {
            // Search in the left subtree
            return find(x, node.getLeft());
        }
        else if (x.compareTo(node.getElement()) > 0) {
            // Search in the right subtree
            return find(x, node.getRight());
        }
        else {
            return node; // Match
        }
    }


    /**
     * The size
     * 
     * @return the size
     */
    public int getSize() {
        return nodeCount;
    }


    /**
     * The root
     * 
     * @return BinaryNode<K> the root
     */
    public BinaryNode<K> getRoot() {
        return root;
    }


    /**
     * set root
     * 
     * @param newRoot
     *            ne wroot
     * @return BinaryNode<K> new root
     */
    public BinaryNode<K> setRoot(BinaryNode<K> newRoot) {
        root = newRoot;
        return root;
    }


    /**
     * Gets an in-order string representation of the tree
     * If the tree holds 5
     * / \
     * 2 6
     * \
     * 3
     * It would print (2, 3, 5, 6)
     * 
     * @return an in-order string representation of the tree
     */
    @Override
    public String toString() {
        if (root == null) {
            return "";
        }
        else {
            return root.toString();
        }
    }

    /**
     * Iterator
     * 
     * @author anali99
     *
     */
    private class PreIterator implements Iterator<K> {
        private Stack<BinaryNode<K>> treeStack;

        /**
         * constructor, creates a new PreIterator object
         */
        PreIterator() {
            treeStack = new Stack<BinaryNode<K>>();
            pushNode();
        }


        /**
         * This method push the element onto the stack
         */
        public void pushNode() {
            BinaryNode<K> node = root;
            while (node != null) {
                treeStack.push(node);
                node = node.getLeft();
            }
        }


        /**
         * This method return the next element in the binary search tree
         * 
         * @return The next element in the binary search tree
         */
        public K next() {
            BinaryNode<K> current = null;
            K element = null;
            if (!treeStack.empty()) {
                current = treeStack.pop();
                element = current.getElement();
                if (current.getRight() != null) {
                    current = current.getRight();
                    while (current != null) {
                        treeStack.push(current);
                        current = current.getLeft();
                    }
                }

            }
            return element;
        }


        /**
         * This method determines whether there is a next element
         * 
         * @return return true if there is a next element,
         *         otherwise return false.
         */
        public boolean hasNext() {

            return !treeStack.isEmpty();
        }

    }

    /**
     * The method creates a new PreIterator object
     */
    @Override
    public Iterator<K> iterator() {
        return new PreIterator();
    }

}
