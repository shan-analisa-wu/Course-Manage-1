
/**
 * This class creates a new Student object.
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class Student implements Comparable<Student> {
    private Name name;
    private String studentID;
    private int score = 0;


    /**
     * Construtor, create a new Student object
     * 
     * @param name
     *            The name of the student
     */
    public Student(Name name) {
        this.name = name;
    }


    /**
     * This method get the name of a student
     * 
     * @return name The name of a student
     */
    public Name getName() {
        return name;
    }


    /**
     * This command returns the student id of a student
     * 
     * @return id The student id of a student
     */
    public String getStudentId() {
        return studentID;
    }


    /**
     * This command returns the score of a student
     * 
     * @return score The score of a student
     */
    public int getScore() {
        return score;
    }


    /**
     * This method assign a student id to a specific student
     * 
     * @param id
     *            The student id to be assigned to a student
     */
    public void setStudentId(String id) {
        studentID = id;
    }


    /**
     * This method assign a score to a specific student
     * 
     * @param score
     *            The score to be assigned to a specific student
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * This method print out the student id, full name and the score of a
     * specific student.
     * 
     * @return output The id, name and score of a student
     *         as a string
     */
    public String toString() {
        StringBuilder str = new StringBuilder(studentID);
        str.append(", " + name.getFirstName() + " " + name.getLastName() + ", "
            + "score = " + score + "\n");
        return str.toString();
    }


    /**
     * This method print out the student id, full name and the score of a
     * specific student.
     * 
     * @return output The id, name and score of a student
     *         as a string
     */
    public String toStringForCommand() {
        StringBuilder str = new StringBuilder(studentID);
        str.append(", " + name.getFirstName() + " " + name.getLastName() + ", "
            + "score = " + score + "\n");
        return str.toString();
    }


    /**
     * This method compares the name of two students.
     * Compare last name first, if the last name of two
     * students are the same then compare first name.
     * 
     * @param other
     *            the other student to compare
     * @return Return -1 if the name of the student precedes other
     *         student to be compared. Return 1 of the name of the
     *         student follows other student to be compared. Return
     *         0 if two names are equal.
     */
    public int compareTo(Student other) {
        if (name.getLastName().toLowerCase().compareTo(other.getName()
            .getLastName().toLowerCase()) < 0) {
            return -1;
        }
        else if (name.getLastName().toLowerCase().compareTo(other.getName()
            .getLastName().toLowerCase()) > 0) {
            return 1;
        }
        else { // 2: First name
            if (name.getFirstName().toLowerCase().compareTo(other.getName()
                .getFirstName().toLowerCase()) < 0) {
                return -1;
            }
            else if (name.getFirstName().toLowerCase().compareTo(other.getName()
                .getFirstName().toLowerCase()) > 0) {
                return 1;
            }
            else {
                // they are equal
                return 0;
            }
        }
    }

}
