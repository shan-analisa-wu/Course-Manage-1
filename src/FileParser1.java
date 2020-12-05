
import java.io.*;

/**
 * a class for reading the given command file.
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class FileParser1 {
    private CommandsExecution ce;

    /**
     * constructor
     * 
     * @param cmdFileName
     *            the name of cmd file
     */
    public FileParser1(String cmdFileName) {
        ce = new CommandsExecution();
        readCmdFile(cmdFileName);
    }


    /**
     * A helper function for reading the .txt file
     * 
     * @param cmdFileName
     *            the name of the cmd file.
     */
    private void readCmdFile(String cmdFileName) {
        String line;
        try {
            RandomAccessFile raf = new RandomAccessFile(cmdFileName, "r");
            while ((line = raf.readLine()) != null) {
                ce.checkCommands(line);
            }
            raf.close();
        }
        catch (FileNotFoundException e) {
            System.err.println("Cannot find the file: " + cmdFileName);
        }
        catch (IOException ex) {
            System.err.println("Unable to access the file: " + cmdFileName);
        }
    }
}
