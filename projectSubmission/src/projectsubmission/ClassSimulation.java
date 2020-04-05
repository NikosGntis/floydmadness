/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsubmission;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Nikos G
 */
public class ClassSimulation {

    /**
     *
     * @param args
     */
    public static void main (String[]args){
        
        List<Course> courses=new ArrayList();    
        List<Student> students=new ArrayList();
        List<Trainer> trainers=new ArrayList();
        List<Assignment> assignments=new ArrayList();
        
        
        Scanner sc=new Scanner(System.in);
            System.out.println(
				"Welcome to our private school! \n Press number 1 for unput or 2 if you want to add synthetic data" );
		int choice = sc.nextInt();

		switch ( choice ) {
		case 1:
			students = ClassDetails.askStudentDetails( true );
			courses = ClassDetails.askCourseDetails( true );
			trainers = ClassDetails.askTrainerDetails( true );
			assignments = ClassDetails.askAssignmentDetails( true );
			break;
		case 2:
			students = ClassDetails.askStudentDetails( false );
			courses = ClassDetails.askCourseDetails( false );
			trainers = ClassDetails.askTrainerDetails( false );
			assignments = ClassDetails.askAssignmentDetails( false );
			break;
		default:
			System.out.println( "wrong choice the programm will terminate" );
			return;
		}
            
           
                Course course0 = courses.get( 0 );
		Course course1 = courses.get( 1 );
		Course course2 = courses.get( 2 );

		// associate trainers with courses
		List<Trainer> courseTrainers = new ArrayList<Trainer>();
		courseTrainers.add( trainers.get( 0 ) );
		course0.setTrainers( courseTrainers );

		courseTrainers.add( trainers.get( 1 ) );
		course1.setTrainers( courseTrainers );
                
                courseTrainers.add( trainers.get( 2 ) );
		course2.setTrainers( courseTrainers );
                
                Assignment assignment0=assignments.get(0);
                Assignment assignment1=assignments.get(1);
                Assignment assignment2=assignments.get(2);
                Assignment assignment3=assignments.get(3);
                Assignment assignment4=assignments.get(4);
                
               // associate assignments with courses
		course0.setAssignments( Arrays.asList( assignment0, assignment1 ) );
		course1.setAssignments( Arrays.asList( assignment2 ) );
		course2.setAssignments( Arrays.asList( assignment3, assignment4 ) );
                
                // assign completed assignments to all students for Assignment0 and Assignment1
		for (int i=0; i<students.size(); i++) {
			ArrayList<CompletedAssignment> completedAssignments = new ArrayList<CompletedAssignment>();
			completedAssignments.add( new CompletedAssignment( assignment0.getTitle(), i*9, i*i*1 ) );
			completedAssignments.add( new CompletedAssignment( assignment1.getTitle(), i*6, i*i*6 ) );

			students.get( i ).setCompletedAssignments( completedAssignments );
		}

		// assign completed assignments for students at positions 0,1 and 2 for Assignment2
		students.get( 0 ).getCompletedAssignments().add( new CompletedAssignment( assignment2.getTitle(), 9, 1 ) );
		students.get( 1 ).getCompletedAssignments().add( new CompletedAssignment( assignment2.getTitle(), 2, 8 ) );
		students.get( 2 ).getCompletedAssignments().add( new CompletedAssignment( assignment2.getTitle(), 7, 3 ) );

		// assign completed assignments for students at positions 3,4 and 5 for Assignment3 and Assignment4
		students.get( 3 ).getCompletedAssignments().add( new CompletedAssignment( assignment3.getTitle(), 6, 4 ) );
		students.get( 3 ).getCompletedAssignments().add( new CompletedAssignment( assignment4.getTitle(), 9, 1 ) );
		students.get( 4 ).getCompletedAssignments().add( new CompletedAssignment( assignment3.getTitle(), 99, 1 ) );
		students.get( 4 ).getCompletedAssignments().add( new CompletedAssignment( assignment4.getTitle(), 5, 1 ) );
		students.get( 5 ).getCompletedAssignments().add( new CompletedAssignment( assignment3.getTitle(), 1, 4 ) );
		students.get( 5 ).getCompletedAssignments().add( new CompletedAssignment( assignment4.getTitle(), 4, 6 ) );
            // course0 contains all existing students
		course0.setStudents( students );
		
		//course1 contains only the students who are located at positions 0, 1 and 2 of the list students
		List<Student> course1Students = new ArrayList<Student>();
		course1Students.add( students.get( 0 ) );
		course1Students.add( students.get( 1 ) );
		course1Students.add( students.get( 2 ) );
		course1.setStudents( course1Students );

		//course2 contains only the students who are located at positions 3, 4 and 5 of the list students
		List<Student> course2Students = new ArrayList<Student>();
		course2Students.add( students.get( 3 ) );
		course2Students.add( students.get( 4 ) );
		course2Students.add( students.get( 5 ) );
		course2.setStudents( course2Students );
            
                
                printAllStudents(students);
                printAllTrainers(trainers);
                printAllAssignments(assignments);
                printAllCourses(courses);
                printStudentsPerCourse(courses);
                printTrainersperCourse(courses);
                printAssignmentsperCourse(courses);
                printAssignmenstPerStudent(students);
                printStudentsWhoBelongToMoreThanOneCourses(courses);
                
            System.out.println("Can you give me date");
            String input=sc.next();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
            Date date = null;
            try {
                    date = simpleDateFormat.parse( input );
            } catch ( ParseException e ) {

            }
            LocalDate localDate = Instant.ofEpochMilli( date.getTime() )
                            .atZone( ZoneId.systemDefault() )
                            .toLocalDate();
            DayOfWeek dayOfWeek = DayOfWeek.from( localDate );

		LocalDate startOfTheWeek = null;
		LocalDate endOfTheWeek = null;
		switch ( dayOfWeek.getValue() ) {
		case 1:
			startOfTheWeek = localDate;
			endOfTheWeek = localDate.plusDays( 4 );
			break;
		case 2:
			startOfTheWeek = localDate.minusDays( 1 );
			endOfTheWeek = localDate.plusDays( 3 );
			break;
		case 3:
			startOfTheWeek = localDate.minusDays( 2 );
			endOfTheWeek = localDate.plusDays( 2 );
			break;
		case 4:
			startOfTheWeek = localDate.minusDays( 3 );
			endOfTheWeek = localDate.plusDays( 1 );
			break;
		case 5:
			startOfTheWeek = localDate.minusDays( 4 );
			endOfTheWeek = localDate;
			break;
		case 6:
			startOfTheWeek = localDate.minusDays( 5 );
			endOfTheWeek = localDate.minusDays( 1 );
			break;
		case 7:
			startOfTheWeek = localDate.minusDays( 6 );
			endOfTheWeek = localDate.minusDays( 2 );
		}


		String start = startOfTheWeek.format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) );
		String end = endOfTheWeek.format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) );

		Date startOfTheWeekInDate = null;
		Date endOfTheWeekInDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			startOfTheWeekInDate = sdf.parse( start );
			endOfTheWeekInDate = sdf.parse( end );
		} catch ( ParseException e ) {

		}
		List<String> assignmentTitlesToPrint = new ArrayList<>();
		for ( int i = 0; i < assignments.size(); i++ ) {
			Assignment assignment = assignments.get( i );
			Date assignmentSubDate = assignment.getSubDateTime();
			if ( assignmentSubDate.after( startOfTheWeekInDate ) && assignmentSubDate.before( endOfTheWeekInDate ) ) {
				System.out.println( "submDate: " + assignmentSubDate );
				assignmentTitlesToPrint.add( assignment.getTitle() );
			}
		}

		System.out.println( "Students who need to submit between " + startOfTheWeekInDate + " and " +  endOfTheWeekInDate + " are: " );
		for ( int i=0;i<students.size(); i++) {
			Student student = students.get( i );
			List<CompletedAssignment> completedAssignments = student.getCompletedAssignments();
			for (int j = 0; j<completedAssignments.size(); j++) {
				if (assignmentTitlesToPrint.contains( completedAssignments.get( j ).getAssignmentTitle() ) ) {
					System.out.println( student.getFirstName() );
				}
			}
		} 
            
            
    }
    public static void printAllStudents(List<Student> students) {  
        System.out.println("All students are: ");
            for (int i=0; i<students.size(); i++) {
                Student studenti=students.get(i);
                System.out.println(studenti.getFirstName());
            }  
    }
    public static void printAllTrainers(List<Trainer> trainers){
        System.out.println("All trainers are: ");
            for (int i=0; i<trainers.size(); i++) {
                Trainer traineri=trainers.get(i);
                System.out.println(traineri.getFirstName());
            }
    }   
    public static void printAllAssignments(List<Assignment> assignments){
           System.out.println("All assignments are: ");
            for (int i=0; i<assignments.size(); i++) {
                Assignment assignmenti=assignments.get(i);
                System.out.println(assignmenti.getTitle());
            }    
    }       
    public static void printAllCourses(List<Course> courses){
           System.out.println("All courses are: ");
            for (int i=0; i<courses.size(); i++){
                Course coursei=courses.get(i);
                System.out.println(coursei.getTitle());  
             }
    }
    public static void printStudentsPerCourse(List<Course> courses) {
            for (int i=0; i<courses.size(); i++) {
               Course coursei=courses.get(i);
                List<Student> students=coursei.getStudents();
                System.out.println("The students for course: "+ coursei.getTitle() + " are: ");
                for (int y=0; y<students.size(); y++) {
                    System.out.println(students.get(y).getFirstName());
                }
            }  
    } 
    public static void printTrainersperCourse(List<Course> courses) {
            for (int i=0; i<courses.size(); i++){
                Course coursei=courses.get(i);
                List<Trainer> trainers=coursei.getTrainers();
                System.out.println("The trainers for course: "+coursei.getTitle()+ " are: ");
                for (int y=0; y<trainers.size(); y++){
                    System.out.println("Each trainer for each course is"+trainers.get(y).getFirstName());
                }
            }
    }
    public static void printAssignmentsperCourse(List<Course> courses) {
            for (int i=0; i<courses.size(); i++){
                Course coursei=courses.get(i);
                List<Assignment> assignments=coursei.getAssignments();
                System.out.println("The assignments for course: "+coursei.getTitle()+ " are: ");
                for (int y=0; y<assignments.size(); y++) {
                    System.out.println("Each assignment for each course is"+assignments.get(y).getTitle());
                }
            }
    }
    public static void printStudentsWhoBelongToMoreThanOneCourses(List<Course> courses) {
        System.out.println( "Students who belong to more than one courses are: " );
		List<Student> oneTimeOccurence = new ArrayList<>();
		List<Student> moreThanOneTimeOccurence = new ArrayList<>();
		for (int i=0; i<courses.size(); i++) {
			Course coursei = courses.get(i);
			List<Student> courseiStudents = coursei.getStudents();
			for ( int j=0; j<courseiStudents.size(); j++ ) {
				Student studenti = courseiStudents.get( j );
				if ( oneTimeOccurence.contains( studenti ) ) {
					moreThanOneTimeOccurence.add( studenti );
				} else {
					oneTimeOccurence.add( studenti );
				}
			}
		}
		for ( int i=0; i< moreThanOneTimeOccurence.size(); i++ ) {
			System.out.println( moreThanOneTimeOccurence.get( i ).getFirstName() );
		}
    }
    public static void printAssignmenstPerStudent(List<Student> students) {
        System.out.println("Assignnments per student: ");
        for (int i=0; i<students.size(); i++) {
            Student student=students.get(i);
            System.out.println("For student " + student.getFirstName());
            List<CompletedAssignment> completedAssignments=student.getCompletedAssignments();
            for (int j=0; j< completedAssignments.size(); j++) {
                System.out.println(completedAssignments.get(j).getAssignmentTitle());
            }
            
        }   
    }
    
    
}   



    

