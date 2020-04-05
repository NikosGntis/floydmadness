/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsubmission;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Nikos G
 */
public class Student {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double tuitionFees;
    private List<CompletedAssignment> completedAssignments;

    public List<CompletedAssignment> getCompletedAssignments() {
        return completedAssignments;
    }

    public void setCompletedAssignments(List<CompletedAssignment> completedAssignments) {
        this.completedAssignments = completedAssignments;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
    
}
