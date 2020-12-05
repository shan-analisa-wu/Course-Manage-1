
import java.io.IOException;
import student.TestCase;

/**
 * This class tests the Coursemanager class and the
 * FileParser1 class
 * @author Shan Wu
 * @version 9.22.2019
 */
public class Coursemanager1Test extends TestCase {
    
    /**
     * Test the main method
     * @throws IOException throw the exception if the
     * file cannot be open
     */
    public void testMain() throws IOException {
        Coursemanager1 manager = new Coursemanager1();
        assertNotNull(manager);
        String[] input = new String[1];
        input[0] = "SampleInput3.txt";
        Coursemanager1.main(input);
    }
}
