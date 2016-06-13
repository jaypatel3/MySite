package assign.interfaces;

 
/**
 * 
 * ErrorMessageCodes
 *
 */

public interface ErrorMessageCodes {
	//addemailaddress page errors
	String EMAIL_ID_NULL = "EMailID Required<br>";
	
	public static final String EMAIL_ID_INVALID = "Invalid EMailId. for eg: a@b.c<br>";
	public static final String FIRST_NAME_IS_BLANK = "First Name is blank<br>";
	public static final String LAST_NAME_IS_BLANK = "Last Name is blank<br>";
	public static final String Middle_NAME_IS_BLANK = "Middle Name is blank<br>";;
	public static final String HOME_NUMBER_BLANK = "Home Number is blank<br>";;
	public static final String WORK_NUMBER_BLANK = "Work Number is blank<br>";;
	public static final String MOBILE_NUMBER_BLANK = "Mobile Number is blank<br>";;
	public static final String HOME_PHONE_INVALID = "Home phone shoul be number<br>";;
	
	
	public static final String HOME_PAGE = "/jsp/home.jsp";
}
 
