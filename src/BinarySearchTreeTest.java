
import java.util.Iterator;
import student.TestCase;

/**
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class BinarySearchTreeTest extends TestCase {
    private BinarySearchTree<Integer> bst1;
    private BinarySearchTree<Integer> bst2;
    private BinarySearchTree<Integer> bst3;
    private BinarySearchTree<Integer> bst4;
    private BinarySearchTree<Integer> bst5;
    private BinarySearchTree<Integer> bst6;


    /**
     * Setup
     */
    public void setUp() {
        bst1 = new BinarySearchTree<>();
        bst2 = new BinarySearchTree<>();
        bst3 = new BinarySearchTree<>();
        bst4 = new BinarySearchTree<>();
        bst5 = new BinarySearchTree<>();
        bst6 = new BinarySearchTree<>();
        bst1.insert(22);
        bst1.insert(23);
        bst1.insert(50);
        bst1.insert(2);
        bst3.insert(8);
        bst3.insert(9);
        bst3.insert(1);
    }


    /**
     * test insert method
     */
    public void testInsert() {
        bst1.insert(99);
        assertEquals(5, bst1.getSize());
        bst1.insert(99);
        assertEquals(6, bst1.getSize());
        bst1.insert(1);
        bst3.insert(6);
        assertEquals("1689", bst3.toString());
        bst3.insert(10);
        assertEquals("168910", bst3.toString());
    }


    /**
     * test remove method
     */
    public void testRemove() {
        bst1.remove(2);
        bst1.remove(50);
        bst1.remove(23);
        bst1.remove(22);

        assertFalse(bst1.remove(77));

        bst2.insert(22);
        assertTrue(bst2.remove(22));

        bst4.insert(100);
        assertTrue(bst4.remove(100));
        assertFalse(bst4.remove(0));

        bst5.insert(100);
        bst5.insert(90);
        bst5.insert(85);
        bst5.insert(95);
        bst5.insert(92);
        bst5.insert(97);
        bst5.insert(80);
        assertTrue(bst5.remove(95));
        assertTrue(bst5.remove(85));
        assertTrue(bst5.remove(92));

        bst6.insert(100);
        bst6.insert(90);
        bst6.insert(85);
        bst6.insert(95);
        bst6.insert(92);
        bst6.insert(97);
        bst6.insert(96);
        assertTrue(bst6.remove(95));

    }


    /**
     * test find method
     */
    public void testFind() {
        bst1.find(22);
        assertNull(bst1.find(88));
    }


    /**
     * test makeempty method
     */
    public void testMakeEmpty() {
        bst1.makeEmpty();
        assertTrue(bst1.isEmpty());
    }


    /**
     * test isempty method
     */
    public void testIsEmpty() {
        assertFalse(bst1.isEmpty());
    }


    /**
     * test getsize method
     */
    public void testGetSize() {
        assertEquals(4, bst1.getSize());
    }


    /**
     * test setroot method
     */
    public void testSetRoot() {
        BinaryNode<Integer> s = new BinaryNode<>(22);
        bst1.setRoot(s);
        assertEquals(bst1.getRoot(), s);
    }


    /**
     * test to string method
     */
    public void testToString() {
        assertEquals("2222350", bst1.toString());
        assertEquals("", bst4.toString());
    }


    /**
     * test the iterator
     */
    public void testIterator() {
        Iterator<Integer> a = bst1.iterator();
        a.next();
        assertTrue(a.hasNext());
        bst4.insert(100);
        Iterator<Integer> b = bst4.iterator();
        b.next();
        assertFalse(b.hasNext());
        b.next();
        bst4.remove(100);
        bst4.insert(100);
        bst4.insert(90);
        bst4.insert(85);
        bst4.insert(95);
        bst4.insert(92);
        bst4.insert(97);
        Iterator<Integer> c = bst4.iterator();
        c.next();
        c.next();
        c.next();
        c.next();
        c.next();
        c.next();
    }

}
