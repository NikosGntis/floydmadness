
package projectsubmission;


public class CompletedAssignment {
    private float oralMark;
    private float totalMark;
    private String assignmentTitle;
    public CompletedAssignment(String assignmentTitle,float oralMark,float totalMark){
    this.oralMark= oralMark;
    this.totalMark= totalMark;
    this.assignmentTitle= assignmentTitle;
           }
   
    public float getOralMark() {
        return oralMark;
    }

    public float getTotalMark() {
        return totalMark;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setOralMark(float oralMark) {
        this.oralMark = oralMark;
    }

    public void setTotalMark(float totalMark) {
        this.totalMark = totalMark;
    }

    public void setAssignmentTitle(String AssignmentTitle) {
        this.assignmentTitle = AssignmentTitle;
    }
    
}
