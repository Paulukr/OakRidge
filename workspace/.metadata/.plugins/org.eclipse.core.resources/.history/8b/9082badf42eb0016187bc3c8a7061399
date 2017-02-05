package library.model.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import library.model.exceptions.InvalidInputException;


public class HttpRequestDataProcessor {
	private HttpRequestDataProcessor() {
		// utility class
	}

	public static final String SENTENCE_REGEX = "[\\w :.!?\"]+";
	public static final String WORD_REGEX = "\\w+";
	public static final String YEAR_REGEX = "\\d{4}";
	public static final String INTEGER_REGEX = "\\d{1,8}";
	public static final String LONG_REGEX = "\\d{1,13}";

//	public static final  Pattern
	public static Matcher SENTENCE_MATCHER = Pattern.compile(SENTENCE_REGEX).matcher("");
	public static Matcher WORD_MATCHER = Pattern.compile(WORD_REGEX).matcher("");
	public static Matcher YEAR_MATCHER = Pattern.compile(YEAR_REGEX).matcher("");
	public static Matcher INTEGER_MATCHER = Pattern.compile(INTEGER_REGEX).matcher("");
	public static Matcher LONG_MATCHER = Pattern.compile(LONG_REGEX).matcher("");


	public static String getString(HttpServletRequest request, String parameterName, Matcher matcher) throws InvalidInputException {
		String rawData = request.getParameter(parameterName);
		if(rawData == null)
			return null;
		String data = rawData;//String.valueOf(rawData);
		matcher.reset(data);
		if(!matcher.matches())
			throw new InvalidInputException(data + "\ndoesn't match " + matcher.pattern().toString());
		return data;
	}

	public static String getSentence(HttpServletRequest request, String attributeName) throws InvalidInputException {
		return getString(request, attributeName, SENTENCE_MATCHER);
	}
	public static String getWord(HttpServletRequest request, String attributeName) throws InvalidInputException {
		return getString(request, attributeName, WORD_MATCHER);
	}
	public static int getYear(HttpServletRequest request, String attributeName) throws InvalidInputException {
		int year = 0;
		try {
			 year = Integer.parseInt(getString(request, attributeName, YEAR_MATCHER));
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Year was accepted, but cann`t be proceeded "+ getString(request, attributeName, YEAR_MATCHER), e);
		}
		return year;
	}

	public static int getInt(HttpServletRequest request, String attributeName) throws InvalidInputException {
		int year = 0;
		try {
			 year = Integer.parseInt(getString(request, attributeName, INTEGER_MATCHER));
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Integer was accepted, but cann`t be proceeded "+ getString(request, attributeName, YEAR_MATCHER), e);
		}
		return year;
	}
	public static long getLong(HttpServletRequest request, String attributeName) throws InvalidInputException {
		int year = 0;
		try {
			 year = Integer.parseInt(getString(request, attributeName, LONG_MATCHER));
		} catch (NumberFormatException e) {
			throw new InvalidInputException("Long was accepted, but cann`t be proceeded "+ getString(request, attributeName, YEAR_MATCHER), e);
		}
		return year;
	}
}

