package models;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This program establishes the "Student" class for the athlete management app. The student class
 * will establish important attributes for each student athlete and obtain the number of points they
 * have accumlated based on what teams they have played on.
 *
 *
 * @version 1.0
 * @author Scrum Group 1 (Brandon, Simon, Nathan, Tudor, Paris)
 */

@Entity
public class Student extends BaseModel {
    
    @Id
    public int studentNumber;
    public int oen;
    public String firstName;
    public String lastName;
    public int grade;
    public String email;
    public String sex;
    public Payment[] payments;
    public Team[] teams;
    
    /**
     * Displays the last name and first name of a student
     * @return String value of the students name in the format lastName,firstName
     */
    public String toString() {
        return lastName + ", " + firstName;
    }
    
    /**
     * Takes an integer value of school year and identifies the number of points a student accumulated in that year.
     * @param schoolYear Integer value of the year a student played sports
     * @return integer value of points accumulated during that year
     */
    
    /**
     * Totals the number of points a student accumulated throughout their high school career
     * @return integer value of the total number of points scored by a particular student
     */
    public Integer getPoints(){
        int total = 0;
        for (int i=0; i < teams.length; i++){
            total += teams[i].sport.pointValue;
        }
        return total;
    }
}
