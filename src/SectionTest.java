import student.TestCase;

/**
 * A testing class that demonstrates the functionalities of the Section class.
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class SectionTest extends TestCase {
    private Section s1;

    /**
     * setup
     */
    public void setUp() {
        s1 = new Section(100, 2);
        s1.dumpSection();
        s1.insertStudent(new Name("John", "Obi"));
        s1.score(2);
        s1.score(3);
        s1.insertStudent(new Name("Obi", "Susan"));
        s1.score(86);
        s1.insertStudent(new Name("Susan", "Ibrahim"));
        s1.score(66);
        s1.insertStudent(new Name("Nancy", "Henry"));
        s1.score(77);
        s1.insertStudent(new Name("ada", "sunan"));
        s1.score(23);
        s1.dumpSection();
    }


    /**
     * test section
     */
    public void testSection() {
        assertEquals(s1.getSectionNumber(), 2);
    }
    
    
    /**
     * test getNumerOfStudent
     */
    public void testGetNumberOfStudent() {
        assertEquals(s1.getNumberOfStudent(), 5);
    }

}
