package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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

    public int studentNumber;
    public int oen;
    public String firstName;
    public String lastName;
    public int grade;
    public String email;
    public String sex;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Payment> payments;
    @OneToMany(cascade = CascadeType.ALL)
    public List <Spot> spots;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Displays the last name and first name of a student
     * @return String value of the students name in the format lastName,firstName
     */
    public String toString() {
        return lastName + ", " + firstName;
    }
    
    /**
     * Totals the number of points a student accumulated depending on their positionson(s) on various teams 
     * @return integer value of the total number of points earned by a particular student
     */
    public Integer getTotalPoints(){
        int total = 0;
        for (int i = 0; i < spots.size(); i++){
            total += spots.get(i).points;
        } 
        return total;
    }
    
    public Integer getPoints(){
        int total = 0;
        for (int i = 0; i < spots.size(); i++){
            if (spots.get(i).team.schoolYear == SchoolYear.currentSchoolYear()){
                total += spots.get(i).points;
            }
        }
        return total;
    }
}
