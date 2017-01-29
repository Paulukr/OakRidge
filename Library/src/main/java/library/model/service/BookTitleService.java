package library.model.service;

import javax.servlet.http.HttpServletRequest;

import library.controller.ViewConstants;
import library.model.entity.BookTitle;

public class BookTitleService {
	public BookTitle getAddBookTitleRequestData(HttpServletRequest request) throws InvalidInputException {

		BookTitle bookTitle = new BookTitle();

		try {
			bookTitle.setTitle(HttpRequestDataProcessor.getSentence(request, ViewConstants.TITLE_NAME));
			bookTitle.setType(HttpRequestDataProcessor.getWord(request, ViewConstants.TITLE_TYPE));
			bookTitle.setPublishedYear(HttpRequestDataProcessor.getYear(request, ViewConstants.TITLE_YEAR));
			bookTitle.setAuthor(HttpRequestDataProcessor.getSentence(request, ViewConstants.TITLE_AUTHOR));
			// tutor.setId(Integer.valueOf(String.valueOf(request.getSession().getAttribute(AttributesHolder.ID))));

			// course.setTutor(tutor);
			//
			// Date startDate =
			// pickDate(request.getParameter(AttributesHolder.START_DATE));
			// Date endDate =
			// pickDate(request.getParameter(AttributesHolder.END_DATE));
			// course.setStartDate(startDate);
			// course.setEndDate(endDate);
			// logger.info(LoggingMessagesHolder.SUCCESSFUL_PICK_DATA);
			return bookTitle;
		} catch (InvalidInputException invalidInputException) {
			// TODO log
			throw invalidInputException;
		}
	}
}
