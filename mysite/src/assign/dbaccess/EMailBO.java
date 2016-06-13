package assign.dbaccess;

import java.util.ArrayList;
import java.util.List;

import VO.EmailAddressVO;
import VO.GroupVO;
import assign.validation.EMailValidation;

 
/**
 * 
 * EMailBO
 *
 */

public class EMailBO {
 
	/**
	 * No Argument Constructor
	 */
	public EMailBO() {
		super();
	}

	public List getEMailAddress(EmailAddressVO emailaddressvo) throws EMailValidationException, Exception{
		List ls = null;
		EmailAddressVO emailaddressVO = new EmailAddressVO();
		StringBuffer allMessages = new StringBuffer();
		//validation
		String s = emailaddressvo.geteMailID();
		System.out.println(s);
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(s));
		if (allMessages.length() == 0){
			//database insert
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			ls= eMailDBAccess.getEMailAddress(emailaddressvo);
		}
		else{
			  throw new EMailValidationException(allMessages.toString());
		}
		return ls;
	}
	
	public List geteMailAddress(EmailAddressVO emailaddressvo) throws EMailValidationException, Exception{
		List ls = null;
		EmailAddressVO emailaddressVO = new EmailAddressVO();
		StringBuffer allMessages = new StringBuffer();
		//validation
		String s = emailaddressvo.geteMailID();
		System.out.println(s);
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(s));
		if (allMessages.length() == 0){
			//database insert
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			ls= eMailDBAccess.getAllEMailAddress(emailaddressvo);
		}
		else{
			  throw new EMailValidationException(allMessages.toString());
		}
		return ls;
	}




	public void addEMailAddress(EmailAddressVO inEMailAddressVO) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		//2a: validation
		EMailValidation eMailValidation = new EMailValidation();
		
		//emailaddress
		String errorMsg = eMailValidation.validateEmailAddress(inEMailAddressVO.geteMailID());
		allMessages.append(errorMsg);
		
		//firstname
		errorMsg = eMailValidation.validateFirstName(inEMailAddressVO.getfName());
		allMessages.append(errorMsg);
		
		//lastname
		errorMsg = eMailValidation.validateLastName(inEMailAddressVO.getlName());
		allMessages.append(errorMsg);
		
		//MiddleName
		errorMsg = eMailValidation.validateMiddleName(inEMailAddressVO.getmName());
		allMessages.append(errorMsg);
		
		//HomePhone
		errorMsg = eMailValidation.validateHomePhoneNumber(inEMailAddressVO.gethPhone());
		allMessages.append(errorMsg);
		
		
		//WorkPhone
		errorMsg = eMailValidation.validateWorkPhoneNumber(inEMailAddressVO.getwPhone());
		allMessages.append(errorMsg);
		
		
		//MobileNumber
		errorMsg = eMailValidation.validateMobileNumber(inEMailAddressVO.getmPhone());
		allMessages.append(errorMsg);
		
		
		
		//2b: no error from validation, call db component
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			EMailDBAccess.updateEMailAddress(inEMailAddressVO);
		}
		//if error return to controller
		else{
			 EMailValidationException emailValidationException = new EMailValidationException(allMessages.toString());
			 throw emailValidationException;
		}
		return;
	}


	public void deleteEMailAddress(EmailAddressVO eMailAddress) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		String s = eMailAddress.geteMailID();
		System.out.println("______GEttt"+s);
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(s));
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.deleteEMailAddress(eMailAddress);
		}
		else{
			throw new EMailValidationException(allMessages.toString());
		}
		return;
	}



	public void updateEMailAddress(EmailAddressVO inEMailAddress) throws EMailValidationException, Exception{
		StringBuffer allMessages = new StringBuffer();
		EmailAddressVO eMailAddress = null;
		EMailValidation eMailValidation = new EMailValidation();
		allMessages.append(eMailValidation.validateEmailAddress(inEMailAddress.geteMailID()));
		if (allMessages.length() == 0){
			EMailDBAccess eMailDBAccess = new EMailDBAccess();
			eMailDBAccess.updateEMailAddress(inEMailAddress);
		}
		else{
			throw new EMailValidationException(allMessages.toString());
		}
		return;
	}



	/*public ArrayList getAllEMailAddressList() throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		ArrayList eMailList = eMailDBAccess.getAllEMailAdressEntries();
		return eMailList;
	}



	public ArrayList getAllEMailAddressListbyGroup(String inGroupID) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		ArrayList eMailList = eMailDBAccess.getAllEMailAdressEntriesbyGroup(inGroupID);
		return eMailList;
	}*/


//Group Calls

	/*public GroupVO getGroup(String inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		GroupVO group = eMailDBAccess.getGroup(inGroup);
		return group;
	} 

	public void addGroup(GroupVO inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.addGroup(inGroup);
		return;
	}

	public void updateGroup(GroupVO inGroup) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.updateGroup(inGroup);
		return;
	}

	public void deleteGroup(String inGroupID) throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		eMailDBAccess.deleteGroup(inGroupID);
		return;
	}

	public ArrayList getAllGroups() throws EMailValidationException, Exception{
		EMailDBAccess eMailDBAccess = new EMailDBAccess();
		ArrayList groupList = eMailDBAccess.getAllGroupEntries();
		return groupList;
	}*/


/*public static void main(String[] arg){
	EMailBO eMailBO = new EMailBO();
	try{
	    eMailBO.getEMailAddress("");
	} catch (Exception e){
		e.printStackTrace();
	}
}*/


}
 
