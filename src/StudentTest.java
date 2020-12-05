
import student.TestCase;

/**
 * A testing class for the Student class.
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 *
 */
public class StudentTest extends TestCase {

    private Student s1;
    private Student s2;
    private Student s3;
    private Name n1;
    private Name n2;
    private Name n3;
    private String[] idList = { "10203", "20203", "30203" };
    private int[] gradeList = { 99, 58, 77 };

    /**
     * constructor, set up the testcase
     */
    public void setUp() {
        n1 = new Name("Apple", "Joy");
        n2 = new Name("David", "Aleen");
        n3 = new Name("Tom", "Aleen");
        s1 = new Student(n1);
        s2 = new Student(n2);
        s3 = new Student(n3);
        s1.setStudentId(idList[0]);
        s2.setStudentId(idList[1]);
        s3.setStudentId(idList[2]);
        s1.setScore(gradeList[0]);
        s2.setScore(gradeList[1]);
        s3.setScore(gradeList[2]);
    }


    /**
     * test getname
     */
    public void testGetName() {
        assertEquals(n1, s1.getName());
        assertEquals(n2, s2.getName());
        assertEquals(n3, s3.getName());
    }


    /**
     * test getid
     */
    public void testGetStudentId() {
        assertEquals(idList[0], s1.getStudentId());
        assertEquals(idList[1], s2.getStudentId());
        assertEquals(idList[2], s3.getStudentId());
    }


    /**
     * test getscore
     */
    public void testGetScore() {
        assertEquals(gradeList[0], s1.getScore());
        assertEquals(gradeList[1], s2.getScore());
        assertEquals(gradeList[2], s3.getScore());
    }


    /**
     * test set student id
     */
    public void testSetStudentId() {
        s1.setStudentId(idList[2]);
        assertEquals(s1.getStudentId(), idList[2]);
    }


    /**
     * test set score
     */
    public void testSetScore() {
        s3.setScore(22);
        assertEquals(s3.getScore(), 22);
    }


    /**
     * test to string
     */
    public void testToString() {
        assertEquals("10203, Apple Joy, score = 99\n", s1.toString());
    }


    /**
     * test compareTo
     */
    public void testCompareTo() {
        assertEquals(1, s1.compareTo(s2));
        assertEquals(0, s1.compareTo(s1));
        assertEquals(-1, s2.compareTo(s1));
        assertEquals(1, s3.compareTo(s2));
        assertEquals(-1, s2.compareTo(s3));
    }

}
