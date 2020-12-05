
import java.io.IOException;

/**
 * The cource manager
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class Coursemanager1 {
    /**
     * main class, create a new courseManager and execute the commands
     * 
     * @param args
     *            input, the name of the input file
     * @throws IOException
     *             If the file does not exist, throw exception.
     */
    public static void main(String[] args) throws IOException {
        new FileParser1(args[0]);
    }
}
