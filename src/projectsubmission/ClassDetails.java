/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsubmission;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nikos G
 */
public class ClassDetails {
    
    public static List<Course> askCourseDetails(boolean userInput) {
		List<Course> courses = new ArrayList<Course>();
		
		Course course1 = new Course(); //to course einai ena object typou Course kai xrhsim to costructor gia na ftiaksoyme to object
		Course course2 = new Course();
		Course course3 = new Course();

		String inputTitle;
		String inputStream;
		String inputType;
		String inputStartDate;
		String inputEndDate;
		if (userInput) {
                        Scanner sc = new Scanner( System.in );
			System.out.println( "please give me the title of the course" );
			inputTitle = sc.next(); //o user 8etei titlo gia to course

			System.out.println( "\n please give me the stream of the course" );
			inputStream = sc.next(); //o user 8etei stream gia to course

			System.out.println( "\n please give me the type of the course" );
			inputType = sc.next(); //o user 8etei type gia to course

			System.out.println( "\n please give me the start date of the course" );
			inputStartDate = sc.next(); //o user 8etei start date

			System.out.println( "\n please give me the end date of the course " );
			inputEndDate = sc.next();  //o user 8etei end date
		} else {
			inputTitle = "SyntheticTitle";
			inputStream = "SyntheticStream";
			inputType = "SyntheticType";
			inputStartDate = "01/04/2020";
			inputEndDate = "09/04/2020";
		}

		course1.setTitle( inputTitle );
		course2.setTitle( inputTitle + "_Another" );
		course3.setTitle( inputTitle + "_OneMore" );

		course1.setStream( inputStream );
		course2.setStream( inputStream + "_Another" );
		course3.setStream( inputStream + "_OneMore" );

		course1.setType( inputType );
		course2.setType( inputType + "_Another" );
		course3.setType( inputType + "_OneMore" );

		SimpleDateFormat format1 = new SimpleDateFormat( "dd/MM/yyyy" );
		Date startDate;
		try {
			startDate = format1.parse( inputStartDate );
		} catch ( ParseException e ) {
			startDate = new Date();
		}
		course1.setStartDate( startDate );
		course2.setStartDate( startDate );
		course3.setStartDate( startDate );

		Date endDate;
		try {
			endDate = format1.parse( inputEndDate );
		} catch ( ParseException e ) {
			endDate = new Date();
		}
		course1.setEndDate( endDate );
		course2.setEndDate( endDate );
		course3.setEndDate( endDate );

		courses.add( course1 );
		courses.add( course2 );
		courses.add( course3 );

		return courses;
	}
     
    public static List<Student> askStudentDetails(boolean userInput) {
		List<Student> students = new ArrayList<Student>();
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();
		Student student6 = new Student();
                Student studentInNoCourse = new Student();
                
                
		String inputFirstName;
		String inputLastName;
		String inputDateOfBirth;
		double inputTuitionFees;

		if (userInput) {
                        
			Scanner sc = new Scanner( System.in );
			System.out.println( "\n please give me the first name of the student" );
			inputFirstName = sc.next(); //o user plhktrologei to onoma toy

			System.out.println( "\n please give me the last name of the student" );
			inputLastName = sc.next(); //o user plhktroloei to epi8eto tody

			System.out.println( "\n please give me the date of birth" );
			inputDateOfBirth = sc.next(); //o user plhktrologei date birth

			System.out.println( "\n please give me your tuition fees" );
			inputTuitionFees = sc.nextDouble(); //o user plhktrologei to poso xrhmatwn ////na valoyme to error handling
		} else {
			inputFirstName = "SyntheticFirstName";
			inputLastName = "SyntheticLastName";
			inputDateOfBirth = "09/09/1999";
			inputTuitionFees = 3.2;
		}

		student1.setFirstName( inputFirstName );
		student2.setFirstName( inputFirstName + "_Another" );
		student3.setFirstName( inputFirstName + "_OneMore" );
		student4.setFirstName( inputFirstName + "_AnotherOne" );
		student5.setFirstName( inputFirstName + "_AnotherMoreOfTheMore" );
		student6.setFirstName( inputFirstName + "_OneMoreOfTheMore" );
                studentInNoCourse.setFirstName( inputFirstName + "_StudentInNoCourse" );
                
		student1.setLastName( inputLastName );
		student2.setLastName( inputLastName + "_Another" );
		student3.setLastName( inputLastName + "_OneMore" );
		student4.setLastName( inputLastName + "_AnotherOne" );
		student5.setLastName( inputLastName + "_AnotherMoreOfTheMore" );
		student6.setLastName( inputLastName + "_OneMoreOfTheMore" );
                studentInNoCourse.setLastName( inputLastName + "_StudentInNoCourse" );

		Date dateOfBirth;
		SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy" );
		try {
			dateOfBirth = format.parse( inputDateOfBirth );
		} catch ( ParseException e ) {
			dateOfBirth = new Date();
		}
		student1.setDateOfBirth( dateOfBirth );
		student2.setDateOfBirth( dateOfBirth );
		student3.setDateOfBirth( dateOfBirth );
		student4.setDateOfBirth( dateOfBirth );
		student5.setDateOfBirth( dateOfBirth );
		student6.setDateOfBirth( dateOfBirth );
                studentInNoCourse.setDateOfBirth( dateOfBirth );

		student1.setTuitionFees( inputTuitionFees );
		student2.setTuitionFees( inputTuitionFees + 0.0 );
		student3.setTuitionFees( inputTuitionFees + 0.1 );
		student4.setTuitionFees( inputTuitionFees + 0.2 );
		student5.setTuitionFees( inputTuitionFees + 0.3 );
		student6.setTuitionFees( inputTuitionFees + 0.4 );
                studentInNoCourse.setTuitionFees( inputTuitionFees + 0.5 );

		students.add( student1 );
		students.add( student2 );
		students.add( student3 );
		students.add( student4 );
		students.add( student5 );
		students.add( student6 );
                students.add( studentInNoCourse );

		return students;
	}
     
     public static List<Trainer> askTrainerDetails(boolean userInput) {
		List<Trainer> trainers = new ArrayList<Trainer>();
		Trainer trainer1 = new Trainer();
		Trainer trainer2 = new Trainer();
		Trainer trainer3 = new Trainer();

		String inputFirstName;
		String inputLastName;
		String inputSubject;
		if (userInput) {
                       Scanner sc = new Scanner( System.in );
			System.out.println( "\n please give me the first name of trainer" );
			inputFirstName = sc.next();

			System.out.println( "\n please give me the last name of trainer" );
			inputLastName = sc.next();

			System.out.print( "\n please give me the subject " );
			inputSubject = sc.next();
		} else {
			inputFirstName = "SyntheticFirstNameOfTrainer";
			inputLastName = "SyntheticLastNameOfTrainer";
			inputSubject = "SyntheticSubject";
		}

		trainer1.setFirstName( inputFirstName );
		trainer2.setFirstName( inputFirstName + "_Another" );
		trainer3.setFirstName( inputFirstName + "_OneMore" );

		trainer1.setLastName( inputLastName );
		trainer2.setLastName( inputLastName );
		trainer3.setLastName( inputLastName );

		trainer1.setSubject( inputSubject );
		trainer2.setSubject( inputSubject );
		trainer3.setSubject( inputSubject );

		trainers.add( trainer1 );
		trainers.add( trainer2 );
		trainers.add( trainer3 );

		return trainers;
	}
     
     public static List<Assignment> askAssignmentDetails(boolean userInput) {
		List<Assignment> assignments = new ArrayList<Assignment>();
		Scanner sc = new Scanner( System.in );

		Assignment assignment1 = new Assignment();
		Assignment assignment2 = new Assignment();
		Assignment assignment3 = new Assignment();
		Assignment assignment4 = new Assignment();
		Assignment assignment5 = new Assignment();

		String inputTitle;
		String inputDescription;
		String inputSubDateTime;
		if (userInput) {
			System.out.println( "\n please give me the title" );
			inputTitle = sc.next();

			System.out.println( "\n please give me the description" );
			inputDescription = sc.next();

			System.out.print( "\n please give me the subDateTime " );
			inputSubDateTime = sc.next();

		} else {
			inputTitle = "SyntheticTitle";
			inputDescription = "SyntheticDescription";
			inputSubDateTime = "01/04/2020";
		}

		assignment1.setTitle( inputTitle );
		assignment2.setTitle( inputTitle + "_One" );
		assignment3.setTitle( inputTitle + "_Another" );
		assignment4.setTitle( inputTitle + "_OneMore" );
		assignment5.setTitle( inputTitle + "_OneMoreOfTheMore" );

		assignment1.setDescription( inputDescription );
		assignment2.setDescription( inputDescription + "_One" );
		assignment3.setDescription( inputDescription + "_Another" );
		assignment4.setDescription( inputDescription + "_OneMore" );
		assignment5.setDescription( inputDescription + "_OneMoreOfTheMore" );

		SimpleDateFormat format1 = new SimpleDateFormat( "dd/MM/yyyy" );
		Date subDate;
		try {
			subDate = format1.parse( inputSubDateTime );
		} catch ( ParseException e ) {
			subDate = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime( subDate );

		assignment1.setSubDateTime( subDate );
		cal.add( Calendar.DATE, 1 );
		assignment2.setSubDateTime( cal.getTime() );
		cal.add( Calendar.DATE, 1 );
		assignment3.setSubDateTime(  cal.getTime() );
		assignment4.setSubDateTime(  cal.getTime() );
		cal.add( Calendar.DATE, 1 );
		assignment5.setSubDateTime( cal.getTime() );

		assignments.add( assignment1 );
		assignments.add( assignment2 );
		assignments.add( assignment3 );
		assignments.add( assignment4 );
		assignments.add( assignment5 );

		return assignments;
	}
     
}
