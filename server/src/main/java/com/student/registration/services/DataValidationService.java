package com.student.registration.services;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import com.student.registration.model.Student;

@Service
public class DataValidationService {

	boolean isLeapYear(int year){
		return (year % 4 == 0) ? ((year % 100 == 0) ? ((year % 400==0) ? true:false):true): false;
	};

	boolean isOnlyLetterAndSpaces (String s) {
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (Character.isLetter(ch) || ch == ' ') {
				continue;
			}
			return false;
		}
		return true;	
	}


	// date validation Function

	public String validateDate(Student student) {

		int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
		Integer shortMonths[] = {2,4,6,9,11};

		int dd = Integer.parseInt(student.getDobDay()) ;
		int mm = Integer.parseInt(student.getDobMonth()) ;
		int yy = Integer.parseInt(student.getDobYear()) ;

		if((dd<1 || dd>31)) return "Invalid Day";
		if((mm<1|| mm>12)) return "Invalid Month";
		if(Arrays.asList(shortMonths).contains(mm)&&dd==31) return "Invalid Date";
		if((yy<(CURRENT_YEAR -100)||(yy>CURRENT_YEAR-4 ))) return "Invalid Year";
		if(mm==2 && dd==30) return "Invalid Date";
		if(mm==2 && !isLeapYear(yy) && dd==29) return "Invalid date";


		return null;
	}


	// name validation function

	public String validateName(Student student) {
		String name = student.getName();
		if(!isOnlyLetterAndSpaces(name)) return "Invalid Name";	
		if(!Character.isUpperCase(name.charAt(0))) return "Invalid Name";				

		return null;

	}



	// class validation function

	public String validateClass(Student student) {
		String classArray[] = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII"};
		String divisionArray[]= {"A","B","C"};

		if(!Arrays.asList(classArray).contains(student.getGrade())) return "Invalid Class";
		if(!Arrays.asList(divisionArray).contains(student.getDivision())) return "Invalid Division";

		return null;
	}



	// gender validation function

	public String validateGender(Student student) {
		String genderArray[] = {"Male","Female","Other"};
		if(!Arrays.asList(genderArray).contains(student.getGender())) return "Invalid Gender";

		return null;
	}




}
