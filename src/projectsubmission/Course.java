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
public class Course {
    private String title; 
    private String stream; //java or c##
    private String type;
    private Date startDate;
    private Date endDate;
    private List<Trainer> trainers;
    private List<Student> students;
    private List<Assignment> assignments;

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
