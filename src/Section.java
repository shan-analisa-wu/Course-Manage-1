/**
 * Section Class
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 *
 */
public class Section {

    private BinarySearchTree<Student> bst;
    private int numOfStudents = 0;
    private Student lastestStudent;
    private int sectionNumber = 1;
    private int[] scoreRecords = new int[12];
    private int stdNumInHistory = 0;

    /**
     * Construtor, create a new Section object
     * 
     * @param sectionSize
     *            size of section
     * @param sectionNumber
     *            section number
     */
    public Section(int sectionSize, int sectionNumber) {
        bst = new BinarySearchTree<>();
        this.sectionNumber = sectionNumber;
    }


    /**
     * This method assign a score to a specific
     * student if the student was in the section.
     * 
     * @param score The score to be assigned to
     *              the student.
     */
    public void score(int score) {
        if (bst.find(lastestStudent) != null) {
            bst.find(lastestStudent).setScore(score);
            System.out.println("Update " + lastestStudent.getName()
                + " record, score = " + score);
        }
    }


    /**
     * The method searches whether a student with
     * given name(can be first nem or last name) is
     * in the current section
     * 
     * @param name
     *            the name of the student
     * @return the number of students with the 
     *         given name
     */
    public int searchStudentByOneName(String name) {
        String formalName = name.substring(0, 1).toUpperCase() + name.substring(
            1).toLowerCase();
        int numStudent = 0;
        Student lastStudent = null;
        System.out.println("search results for " + name + ":");
        for (Student student1 : bst) {
            if (student1.getName().getFirstName().equals(formalName) || student1
                .getName().getLastName().equals(formalName)) {
                numStudent++;
                lastStudent = student1;
                System.out.print(student1.toString());
            }
        }
        if (numStudent == 1) {
            lastestStudent = lastStudent;
        }
        System.out.println(name + " was found in " + numStudent
            + " records in section " + this.getSectionNumber());
        return (numStudent);

    }


    /**
     * a method to search student with given 
     * first name and last name in the current
     * section
     * 
     * @param targetName the name to be searched(a name
     *                   object created according to the
     *                   given first name and last name
     * @return return 1 if the target student was found, otherwise
     *         return 0.
     */
    public int searchStudent(Name targetName) {
        Student findStudent = bst.find(new Student(new Name(targetName
            .getFirstName(), targetName.getLastName())));
        if (findStudent != null) {
            lastestStudent = findStudent;
            System.out.print("Found " + findStudent.toStringForCommand());
            return 1;
        }
        else {
            System.out.println("Search failed. " + "Student " + targetName
                .getFirstName() + " " + targetName.getLastName() + " "
                + "doesn't exist in section " + sectionNumber);
            return 0;
        }
    }


    /**
     * Insert a student with given name into
     * the current section
     * 
     * @param name
     *            name of student
     * @return Return 1 if the student was successfully
     *         inserted. Return 0 if the student was already
     *         in the section.
     */
    public int insertStudent(Name name) {
        Student tmpStudent = new Student(name);
        String studentID = "N/A";
        if (bst.find(tmpStudent) == null) {
            studentID = idGenarator(sectionNumber, stdNumInHistory);
            tmpStudent.setStudentId(studentID);
            bst.insert(tmpStudent);
            numOfStudents++;
            stdNumInHistory++;
            lastestStudent = tmpStudent;
            System.out.println(name.toString() + " inserted");
            return 1;
        }
        else {
            System.out.println(name + " is already in section "
                + sectionNumber);
            System.out.print(bst.find(tmpStudent).toStringForCommand());
            return 0;

        }

    }


    /**
     * The method prints out the information of 
     * students that are in the current section.
     */
    public void dumpSection() {
        System.out.println("Section " + sectionNumber + " dump:");
        System.out.println(bst + "Size = " + numOfStudents);
    }


    /**
     * This method generate a student
     * id for student to be inserted into
     * the current section
     * 
     * @param sectNum
     *            the section number
     * @param stdNum
     *            number of student already in the section
     * @return id The new id generated
     */
    private String idGenarator(int sectNum, int stdNum) {
        String idFirst = "0";
        String id = idFirst.concat(String.valueOf(sectNum));
        String stdNumInHistoryStr = String.valueOf(stdNum + 1);
        int stdNumInHistoryLen = stdNumInHistoryStr.length();
        int numOfZero = 4 - stdNumInHistoryLen;
        for (int count = 0; count < numOfZero; count++) {
            id = id.concat("0");
        }
        id = id.concat(stdNumInHistoryStr);
        return id;
    }


    /**
     * a method to get the section number of the
     * current section
     * 
     * @return the section number
     */
    public int getSectionNumber() {
        return sectionNumber;
    }


    /**
     * The method reports the number of 
     * students with each letter grade in
     * the current section.
     */
    public void grade() {
        String[] gradeList = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-",
            "D+", "D", "D-", "F" };
        inOrderGrader(bst.getRoot());
        for (int i = 0; i < scoreRecords.length; i++) {
            if (scoreRecords[i] != 0) {
                System.out.println(scoreRecords[i] + " students with grade "
                    + gradeList[i]);
            }
        }
    }


    /**
     * a method to remove the whole section
     */
    public void removeSection() {
        if (numOfStudents != 0) {
            bst = new BinarySearchTree<>();
            numOfStudents = 0;
            stdNumInHistory = 0;
            lastestStudent = null;
            scoreRecords = new int[12];
        }
    }


    /**
     * a method to remove a student with given
     * first name and last name from the current
     * section 
     * 
     * @param name The name of the student to be removed
     */
    public void removeStudent(Name name) {
        Student targetStudent = new Student(name);
        Boolean success = bst.remove(targetStudent);
        if (!success) {
            System.out.println("Remove failed. Student " + name
                + " doesn't exist in section " + sectionNumber);
        }
        else {
            numOfStudents--;
            System.out.println("Student " + name + " get removed from section "
                + sectionNumber);
        }
    }


    /**
     * The method iterates the whole section
     * and counts the number of students with
     * a specific letter grade and store the
     * result in scoreRecords
     * 
     * @param root
     *            the root of the binary search tree
     */
    private void inOrderGrader(BinaryNode<Student> root) {
        int tmp = 0;
        if (root != null) {
            if (root.getLeft() != null) {
                inOrderGrader(root.getLeft());
            }
            tmp = root.getElement().getScore();
            scoreRecords[addScoreRecord(tmp)]++;
            if (root.getRight() != null) {
                inOrderGrader(root.getRight());
            }
        }
    }


    /**
     * get the whole bst
     * 
     * @return the bst
     */
    public BinarySearchTree<Student> getBST() {
        return bst;
    }


    /**
     * A method to determine the letter grade of
     * a specific student by the score
     * 
     * @param score
     *            the number score of a student
     * @return the indicator of a specific letter grade
     */
    private int addScoreRecord(int score) {
        if (score >= 90 && score <= 100) {
            return 0; // A
        }
        else if (score >= 85 && score < 90) {
            return 1; // A-
        }
        else if (score >= 80 && score < 85) {
            return 2; // B+
        }
        else if (score >= 75 && score < 80) {
            return 3; // B
        }
        else if (score >= 70 && score < 75) {
            return 4; // B-
        }
        else if (score >= 65 && score < 70) {
            return 5; // C+
        }
        else if (score >= 60 && score < 65) {
            return 6; // C
        }
        else if (score >= 57 && score < 60) {
            return 7; // C-
        }
        else if (score >= 55 && score < 57) {
            return 8; // D+
        }
        else if (score >= 52 && score < 55) {
            return 9; // D
        }
        else if (score >= 50 && score < 52) {
            return 10; // D-
        }
        else {
            return 11; // F
        }
    }


    /**
     * The method iterates the current
     * section and find the number of
     * pairs of students that the difference
     * of their scores are within the given
     * range. If no difference of scores
     * are specified, it is regarded as 0.
     * 
     * @param score
     *            the expected difference of
     *            two students' score
     * @return The number of pairs of students
     *         whose score are within the specific
     *         range of difference
     */
    public int findPair(String score) {
        int numScore;
        int numPairs = 0;
        if (score == null) {
            numScore = 0;
        }
        else {
            numScore = Integer.parseInt(score);
        }
        for (Student student1 : bst) {
            for (Student student2 : bst) {
                int difference = student1.getScore() - student2.getScore();
                if (Math.abs(difference) <= numScore && student1.compareTo(
                    student2) < 0) {
                    System.out.println(student2.getName().getFirstName() + " "
                        + student2.getName().getLastName() + ", " + student1
                            .getName().getFirstName() + " " + student1.getName()
                                .getLastName());
                    numPairs++;
                }
            }
        }
        return numPairs;
    }


    /**
     * get number of student in the
     * current section
     * 
     * @return number of sutdent
     */
    public int getNumberOfStudent() {
        return this.numOfStudents;
    }
}
