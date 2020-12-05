/**
 * Represents a person name that contains the first name and the last name.
 * 
 * @author Shan Wu, Ko Yat Chan
 * @version 09.20.2019
 */
public class Name {
    /**
     * The first name of a person.
     */
    private String firstName;
    /**
     * The last name of a person.
     */
    private String lastName;


    /**
     * Name constructor includes two parameters: firstName and lastName.
     * 
     * @param firstName
     *            the first name.
     * @param lastName
     *            the last name.
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    /**
     * Getter for the first name.
     * 
     * @return firstName the first name
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Setter for the last name.
     * 
     * @return lastName the last name of a person
     */
    public String getLastName() {
        return lastName;
    }


    /**
     * Setter for the first name
     * 
     * @param newFirstName
     *            a new first name
     * @return firstName a new first name
     */
    public String setFirstName(String newFirstName) {
        firstName = newFirstName;
        return firstName;
    }


    /**
     * Setter for the last name.
     * 
     * @param newLastName
     *            a new last name
     * @return lastName a new last name
     */
    public String setLastName(String newLastName) {
        lastName = newLastName;
        return lastName;
    }


    /**
     * Represents the output when I print Name:
     * The format is: "firstName lastName"
     * 
     * @return a printable result for the name object.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.firstName + " " + this.lastName);
        return str.toString();
    }
}
