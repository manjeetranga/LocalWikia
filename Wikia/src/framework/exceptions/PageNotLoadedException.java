package framework.exceptions;

@SuppressWarnings("serial")
public class PageNotLoadedException extends WikiaTestException{
	public PageNotLoadedException(String message) {
		super(message);
	}
}
