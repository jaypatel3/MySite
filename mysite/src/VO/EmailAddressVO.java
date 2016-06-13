package VO;

import java.io.Serializable;
 
/**
 * 
 * EmailAddress Bean
 *
 */

public class EmailAddressVO  {
 
	private long id;
	private String eMailID;	
	private String fName;
	private String mName;
	private String lName;
	private String hPhone;
	private String wPhone;
	private String mPhone;
	private String groupID;

	/**
	 * No Argument Constructor
	 */
	public EmailAddressVO() {
	}

	/**
	 * Argument Constructor
	 */

/*public EMailAddressVOO(long id,String inEMailID, String inFName, String inMName, String inLName, String inHPhone, String inWPhone, String inMPhone, String inGroupID ) {
		id=this.id;
		eMailID = inEMailID;
		fName = inFName;
		mName = inMName;
		lName = inLName;
		hPhone = inHPhone;
		wPhone = inWPhone;
		mPhone = inMPhone;
		groupID = inGroupID;
	}
*/
// Getters
	public long getId() {
	return id;
	}
		public String geteMailID() {
		return eMailID;
	}
 
	public String getfName() {
		return fName;
	}
 

	public String getmName() {
		return mName;
	}
 
	public String getlName() {
		return lName;
	}

	public String gethPhone() {
		return hPhone;
	}

	public String getwPhone() {
		return wPhone;
	}

	public String getmPhone() {
		return mPhone;
	}

	public String getgroupID() {
		return groupID;
	}


// Setters
	public void setId(long id) {
		this.id = id;
	}

	public void seteMailID(String inEMailID) {
		eMailID = inEMailID;
	}
 
 
	public void setfName(String inFName) {
		fName = inFName;
	}
 

	public void setmName(String inMName) {
		mName = inMName;
	}
 
	public void setlName(String inLName) {
		lName = inLName;
	}

	public void sethPhone(String inHPhone) {
		hPhone = inHPhone;
	}

	public void setwPhone(String inWPhone) {
		wPhone = inWPhone;
	}

	public void setmPhone(String inMPhone) {
		mPhone = inMPhone;
	}

	public void setgroupID(String inGroupID) {
		groupID = inGroupID;
	}
	
}
 
