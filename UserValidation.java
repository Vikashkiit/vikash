package com.ing.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.ing.exceptions.InvalidDateFormatException;
import com.ing.exceptions.InvalidUserNameException;

public class UserValidation {
	
	private static final String EMAIL_PATTERN =
			"^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,25}([@$#])*$";

	
	
	public String validateUserName(final String userName){
		Pattern pattern = Pattern.compile(USERNAME_PATTERN);
		Matcher matcher = pattern.matcher(userName);
		
		if(!matcher.matches()){
			throw new InvalidUserNameException("INVALID_USERNAME");
		}
		return "INVALID_USERNAME";
		
	}
	
	
	public boolean validateUserEmail(final String userEmailId){
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(userEmailId);

		return matcher.matches();
	}
	
	public boolean validateUserDateOdBirth(final String dateOfBirth) {
		DateTimeFormatter dateTimePattern = DateTimeFormat.forPattern(DATE_FORMAT);
		DateTime userDateOfBirth = null;
		try {
			userDateOfBirth = dateTimePattern.parseDateTime(dateOfBirth);
		} catch (IllegalArgumentException exception) {
			throw new InvalidDateFormatException(exception.getMessage());
		}

		return userDateOfBirth.isBeforeNow();
	} 
	
	public boolean validateContactNumber(final Integer contactNumber){
		return true;
	}

}
