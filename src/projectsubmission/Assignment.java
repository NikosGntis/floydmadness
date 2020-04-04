/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsubmission;

import java.util.Date;

/**
 *
 * @author Nikos G
 */
public class Assignment {
    private String title;
    private String description;
    private Date subDateTime;
    

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(Date subDateTime) {
        this.subDateTime = subDateTime;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Date getSubDateTime() {
        return subDateTime;
    }
}
