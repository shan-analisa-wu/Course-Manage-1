import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import student.TestCase;

/**
 * Commands Execution Test
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class CommandsExecutionTest extends TestCase {
    private CommandsExecution ce1;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();


    /**
     * setup
     */
    public void setUp() {
        ce1 = new CommandsExecution();
    }


    /**
     * test checkcommands
     */
    public void testCheckCommands() {
        String line1 = "dumpsection";
        System.setOut(new PrintStream(output));
        ce1.checkCommands(line1);
        String line2 = "";
        String line3 = "insert John Obi";
        String line4 = "  score 88";
        String line5 = "insert Susan Obi";
        String line6 = "score 15";
        String line7 = "insert susan    oBI";
        String line8 = "score 27";
        String line9 = "              insert Susan Ibrahim";
        String line10 = "insert Nancy Henry";
        String line11 = "score 71";
        String line12 = "dumpsection";
        String line13 = " score 7";
        String line14 = "";
        String line15 = "";
        String line16 = "section 2";
        String line17 = "search X Y";
        String line18 = "section 1 ";
        String line19 = "";
        String line20 = "search susan OBI";
        String line21 = "search A B";
        String line22 = "search Eva";
        String line23 = "search Susa";
        String line24 = "search Susan";
        String line25 = "score 55";
        String line26 = "search john";
        String line27 = "score 98";
        String line28 = "remove Virtual student";
        String line29 = "insert virtual student";
        String line30 = "score 77";
        String line31 = "remove John Obi";
        String line32 = "remove virtual Student";
        String line33 = "";
        String line34 = "section 2";
        String line35 = "insert David Moses";
        String line36 = "score 85";
        String line37 = "insert Sarah Moses";
        String line38 = "score 93";
        String line39 = "insert susan obi";
        String line40 = "search David Moses";
        String line41 = "score 66";
        String line42 = "search David Moses";
        String line43 = "score 666";
        String line44 = "dumpsection";
        String line45 = "removesection 3";
        String line46 = "removesection";
        String line47 = "";
        String line48 = "section 1";
        String line49 = "findpair 30";
        String line50 = "findpair";
        String line51 = "grade";
        String line52 = null;
        String line53 = "section";
        String line54 = "search";
        String line55 = "section 3";
        String line56 = "insert Adam Moss";
        String line57 = "search Adam Moss";
        String line58 = "score -30";
        String line59 = "section 4";
        String line60 = "section 3";
        String line61 = "search moss";
        String line62 = "remove Adam Moss";
        String line63 = "score 30";
        String line64 = "grade";
        String line65 = "insert Ada Kay";
        String line66 = "score 95";
        String line67 = "insert Emma Zach";
        String line68 = "score 87";
        String line69 = "insert Liz Bo";
        String line70 = "score 83";
        String line71 = "insert Ada Mal";
        String line72 = "score 77";
        String line73 = "insert Ada Eay";
        String line74 = "score 67";
        String line75 = "insert Ada Xay";
        String line76 = "score 63";
        String line77 = "insert Wda Day";
        String line78 = "score 58";
        String line79 = "insert Wda Lay";
        String line80 = "score 56";
        String line81 = "insert Wda Fay";
        String line82 = "score 53";
        String line83 = "insert Wda Gy";
        String line84 = "score 51";

        ce1.checkCommands(line2);

        ce1.checkCommands(line3);

        ce1.checkCommands(line4);

        ce1.checkCommands(line5);

        ce1.checkCommands(line6);

        ce1.checkCommands(line7);

        ce1.checkCommands(line8);

        ce1.checkCommands(line9);

        ce1.checkCommands(line10);

        ce1.checkCommands(line11);

        ce1.checkCommands(line12);

        ce1.checkCommands(line13);
        ce1.checkCommands(line14);
        ce1.checkCommands(line15);

        ce1.checkCommands(line16);

        ce1.checkCommands(line17);
        ce1.checkCommands(line18);
        ce1.checkCommands(line19);
        ce1.checkCommands(line20);
        ce1.checkCommands(line21);
        ce1.checkCommands(line22);
        ce1.checkCommands(line23);
        ce1.checkCommands(line24);
        ce1.checkCommands(line25);
        ce1.checkCommands(line26);
        ce1.checkCommands(line27);
        ce1.checkCommands(line28);
        ce1.checkCommands(line29);
        ce1.checkCommands(line30);
        ce1.checkCommands(line31);
        ce1.checkCommands(line32);
        ce1.checkCommands(line33);
        ce1.checkCommands(line34);
        ce1.checkCommands(line35);
        ce1.checkCommands(line36);
        ce1.checkCommands(line37);
        ce1.checkCommands(line38);
        ce1.checkCommands(line39);
        ce1.checkCommands(line40);
        ce1.checkCommands(line41);
        ce1.checkCommands(line42);
        ce1.checkCommands(line43);
        ce1.checkCommands(line44);
        ce1.checkCommands(line45);
        ce1.checkCommands(line46);
        ce1.checkCommands(line47);
        ce1.checkCommands(line48);
        ce1.checkCommands(line49);
        ce1.checkCommands(line50);
        ce1.checkCommands(line51);
        ce1.checkCommands(line52);
        ce1.checkCommands(line53);
        ce1.checkCommands(line54);
        ce1.checkCommands(line55);
        ce1.checkCommands(line56);
        ce1.checkCommands(line57);
        ce1.checkCommands(line58);
        ce1.checkCommands(line59);
        ce1.checkCommands(line60);
        ce1.checkCommands(line61);
        ce1.checkCommands(line62);
        ce1.checkCommands(line63);
        ce1.checkCommands(line64);
        ce1.checkCommands(line65);
        ce1.checkCommands(line66);
        ce1.checkCommands(line67);
        ce1.checkCommands(line68);
        ce1.checkCommands(line69);
        ce1.checkCommands(line70);
        ce1.checkCommands(line71);
        ce1.checkCommands(line72);
        ce1.checkCommands(line73);
        ce1.checkCommands(line74);
        ce1.checkCommands(line75);
        ce1.checkCommands(line76);
        ce1.checkCommands(line77);
        ce1.checkCommands(line78);
        ce1.checkCommands(line79);
        ce1.checkCommands(line80);
        ce1.checkCommands(line81);
        ce1.checkCommands(line82);
        ce1.checkCommands(line83);
        ce1.checkCommands(line84);
        assertEquals(output.toString(), "Section 1 dump:\n" + "Size = 0\n"
            + "John Obi inserted\n" + "Update John Obi record, score = 88\n"
            + "Susan Obi inserted\n" + "Update Susan Obi record, score = 15\n"
            + "susan oBI is already in section 1\n"
            + "010002, Susan Obi, score = 15\n"
            + "Update Susan Obi record, score = 27\n"
            + "Susan Ibrahim inserted\n" + "Nancy Henry inserted\n"
            + "Update Nancy Henry record, score = 71\n" + "Section 1 dump:\n"
            + "010004, Nancy Henry, score = 71\n"
            + "010003, Susan Ibrahim, score = 0\n"
            + "010001, John Obi, score = 88\n"
            + "010002, Susan Obi, score = 27\n" + "Size = 4\n"
            + "score command can only be called after an "
            + "insert command or a successful search command "
            + "with one exact output.\n" + "switch to section 2\n"
            + "Search failed. Student X Y doesn't exist in section 2\n"
            + "switch to section 1\n" + "Found 010002, Susan Obi, score = 27\n"
            + "Search failed. Student A B doesn't exist in section 1\n"
            + "search results for Eva:\n"
            + "Eva was found in 0 records in section 1\n"
            + "search results for Susa:\n"
            + "Susa was found in 0 records in section 1\n"
            + "search results for Susan:\n"
            + "010003, Susan Ibrahim, score = 0\n"
            + "010002, Susan Obi, score = 27\n"
            + "Susan was found in 2 records in section 1\n"
            + "score command can only be called after an "
            + "insert command or a successful search "
            + "command with one exact output.\n" + "search results for john:\n"
            + "010001, John Obi, score = 88\n"
            + "john was found in 1 records in section 1\n"
            + "Update John Obi record, score = 98\n"
            + "Remove failed. Student Virtual "
            + "student doesn't exist in section 1\n"
            + "virtual student inserted\n"
            + "Update virtual student record, score = 77\n"
            + "Student John Obi get removed from section 1\n"
            + "Student virtual Student get removed from section 1\n"
            + "switch to section 2\n" + "David Moses inserted\n"
            + "Update David Moses record, score = 85\n"
            + "Sarah Moses inserted\n"
            + "Update Sarah Moses record, score = 93\n" + "susan obi inserted\n"
            + "Found 020001, David Moses, score = 85\n"
            + "Update David Moses record, score = 66\n"
            + "Found 020001, David Moses, score = 66\n"
            + "Scores have to be integers in range 0 to 100.\n"
            + "Section 2 dump:\n" + "020001, David Moses, score = 66\n"
            + "020002, Sarah Moses, score = 93\n"
            + "020003, susan obi, score = 0\n" + "Size = 3\n"
            + "Section 3 removed\n" + "Section 2 removed\n"
            + "switch to section 1\n"
            + "Students with score difference less than or equal 30:\n"
            + "Susan Obi, Susan Ibrahim\n" + "found 1 pairs\n"
            + "Students with score difference less than or equal 0:\n"
            + "found 0 pairs\n" + "grading completed:\n"
            + "1 students with grade B-\n" + "2 students with grade F\n"
            + "switch to section 3\n" + "Adam Moss inserted\n"
            + "Found 030001, Adam Moss, score = 0\n"
            + "Scores have to be integers in range 0 to 100.\n"
            + "switch to section 4\n" + "switch to section 3\n"
            + "search results for moss:\n" + "030001, Adam Moss, score = 0\n"
            + "moss was found in 1 records in section 3\n"
            + "Student Adam Moss get removed from section 3\n"
            + "score command can only be called after an insert "
            + "command or a successful search command "
            + "with one exact output.\n"
            + "grading completed:\n" + "Ada Kay inserted\n"
            + "Update Ada Kay record, score = 95\n" + "Emma Zach inserted\n"
            + "Update Emma Zach record, score = 87\n" + "Liz Bo inserted\n"
            + "Update Liz Bo record, score = 83\n" + "Ada Mal inserted\n"
            + "Update Ada Mal record, score = 77\n" + "Ada Eay inserted\n"
            + "Update Ada Eay record, score = 67\n" + "Ada Xay inserted\n"
            + "Update Ada Xay record, score = 63\n" + "Wda Day inserted\n"
            + "Update Wda Day record, score = 58\n" + "Wda Lay inserted\n"
            + "Update Wda Lay record, score = 56\n" + "Wda Fay inserted\n"
            + "Update Wda Fay record, score = 53\n" + "Wda Gy inserted\n"
            + "Update Wda Gy record, score = 51\n");
    }

}
