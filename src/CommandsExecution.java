
/**
 * Commands Execution
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class CommandsExecution {
    private static final int DEFAULT_SECTION_SIZE = 120;
    private String lastestCommand;
    private Section[] sections; // 3 sections
    private int sectionFlag;

    /**
     * Constructor, create a new CommandsExecution object.
     * 
     */

    public CommandsExecution() {
        sectionFlag = 0;
        sections = new Section[3];
        sections[0] = new Section(DEFAULT_SECTION_SIZE, 1);
        sections[1] = new Section(DEFAULT_SECTION_SIZE, 2);
        sections[2] = new Section(DEFAULT_SECTION_SIZE, 3);
    }


// private void checkCommands() {
    /**
     * check commands in the .txt file
     * line by line and determine which
     * command to execute according to
     * the input file
     * 
     * @param line A line that specifies a command
     *             to be executed.
     */
    public void checkCommands(String line) {
        if (line != null) {
            line = line.trim();
            String[] words = line.split("\\s+"); // for whitespace splits
            switch (words[0]) {
                // to switch over among three sections
                case "section":
                    if (words.length == 1) {
                        sectionFlag = 0; // default value is 1
                    }
                    else {
                        System.out.println("switch to section " + words[1]);
                        switch (words[1]) {
                            case "1":
                                sectionFlag = 0;
                                break;
                            case "2":
                                sectionFlag = 1;
                                break;
                            case "3":
                                sectionFlag = 2;
                                break;
                            default:
                                sectionFlag = 0;
                                break;
                        }
                    }
                    lastestCommand = words[0];
                    break;
                case "insert":
                    Name name = new Name(words[1], words[2]);
                    sections[sectionFlag].insertStudent(name);
                    lastestCommand = words[0];
                    break;

                case "search": // there are two possible parameters
                    int numOfResults = 0;
                    if (words.length == 3) {
                        numOfResults = sections[sectionFlag].searchStudent(
                            new Name(words[1], words[2]));
                        lastestCommand = words[0];
                    }
                    else if (words.length == 2) {
                        numOfResults = sections[sectionFlag]
                            .searchStudentByOneName(words[1]);
                    }
                    if (numOfResults == 1) {
                        lastestCommand = words[0];
                    }
                    else {
                        lastestCommand = "SearchSingleName";
                    }

                    break;
                case "score":
                    if (lastestCommand.equals("insert") || lastestCommand
                        .equals("search")) {
                        int score = Integer.parseInt(words[1]);
                        if (!(score > 100 || score < 0)) {
                            sections[sectionFlag].score(score);
                        }
                        else {
                            System.out.println("Scores have to be integers in "
                                + "range 0 to 100.");
                        }
                    }
                    else {
                        System.out.println(
                            "score command can only be called after an "
                                + "insert command or a successful "
                                + "search command" + " with one exact output.");
                    }
                    lastestCommand = words[0];
                    break;

                case "remove":
                    Name targetName = new Name(words[1], words[2]);
                    sections[sectionFlag].removeStudent(targetName);
                    lastestCommand = words[0];
                    break;

                case "removesection":
                    int removedSectionNumber = sectionFlag;
                    if (words.length == 2) {
                        removedSectionNumber = Integer.parseInt(words[1]) - 1;
                    }
                    sections[removedSectionNumber].removeSection();
                    System.out.println("Section " + (removedSectionNumber + 1)
                        + " removed");

                    lastestCommand = words[0];
                    break;
                case "dumpsection":
                    sections[sectionFlag].dumpSection();
                    lastestCommand = words[0];
                    break;
                case "grade":
                    System.out.println("grading completed:");
                    sections[sectionFlag].grade();
                    lastestCommand = words[0];
                    break;
                case "findpair":
                    if (words.length == 1) {
                        System.out.println("Students with score difference "
                            + "less than or equal " + "0" + ":");
                        int numOfPairs = sections[sectionFlag].findPair("0");

                        System.out.println("found " + numOfPairs + " pairs");
                    }
                    if (words.length == 2) {
                        System.out.println("Students with score difference "
                            + "less than or equal " + words[1] + ":");
                        int numOfPairs = sections[sectionFlag].findPair(
                            words[1]);

                        System.out.println("found " + numOfPairs + " pairs");
                    }
                    lastestCommand = words[0];
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * get lastest command
     * 
     * @return lastest command
     */
    public String getLastestCommand() {
        return lastestCommand;
    }
}
