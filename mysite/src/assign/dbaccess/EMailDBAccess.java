package assign.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.EmailAddressVO;

 
/**
 * 
 * DBAccess
 *
 */

public class EMailDBAccess {
 
	/**
	 * No Argument Constructor
	 */
	public EMailDBAccess() {
		super();
	}

//Getting Connection using MS Access

	public static Connection getConnection() throws Exception{
			Connection dbConn = null;
	    try{
		String url = "jdbc:mysql://localhost:3306/test";
		Class.forName("com.mysql.jdbc.Driver");
		dbConn = DriverManager.getConnection(url, "root", "root");
		}
	     catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	return dbConn;
	}


//	Getting Connection

// Getting Connection using Oracle
//		public static Connection getConnection() throws Exception{
//				Connection dbConn = null;
//		    try{
//		    Class.forName("oracle.jdbc.driver.OracleDriver");
//			String url = "jdbc:oracle:thin:@servername:1521:dbname)";
//			dbConn = DriverManager.getConnection(url, "userid","password");
//			}
//		     catch (SQLException sqle) {
//			   sqle.printStackTrace();
//			   throw sqle;
//			}
//	             catch(Exception e) {
//			   e.printStackTrace();
//			   throw e;
//			}
//		return dbConn;
//		}
// Connection Using MYSQL	
//	public static Connection getConnection() throws Exception{
//		Connection dbConn = null;
//    try{
//    //step1:
//    Class.forName("com.mysql.jdbc.Driver");
//	//step2
//    String url = "jdbc:mysql://localhost:3306/test";
//	//step3
//	dbConn = DriverManager.getConnection(url, "root", "root");
//	}
//     catch (SQLException sqle) {
//	   sqle.printStackTrace();
//	   throw sqle;
//	}
//         catch(Exception e) {
//	   e.printStackTrace();
//	   throw e;
//	}
//return dbConn;
//}
// EMailAddress Queries
 
	//public int add(int i, int j)
	public List getEMailAddress(EmailAddressVO emailaddressVO) throws Exception{
		
		 Session session = null;
		 List ls = null;
			
		  try{
			  
		  System.out.println("Email Name = "+emailaddressVO.geteMailID());
		  System.out.println("1");
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  System.out.println("2");
		  session =sessionFactory.openSession();
		  System.out.println("3");
		  //System.out.println(countryvo.getCountryName());
		  System.out.println("4");
		  Query q = session.createQuery("from EmailAddressVO where eMailID like '"+emailaddressVO.geteMailID()+"%'");
		  System.out.println("5");
		  
		
		  
		 
		  ls = q.list();
		  
		  
		  
		 // System.out.println(ls);
		// transaction.commit();
		  System.out.println("Done");
		  
		  }catch(Exception e){
		  e.printStackTrace();
		  }finally{
		  // Actual contact insertion will happen at this step
		//  session.flush();
		//  session.close();

		  }
		  return ls;
		
		
		
		
	}

	   

	public  void addEMailAddress(EmailAddressVO inEMailAddress) throws Exception{

		
		
		System.out.println("---Into the database---");
		
		 Session session = null;

		  try{
		  // This step will read hibernate.cfg.xml 

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		  //Create new instance of Contact and set 
        Transaction transaction = session.beginTransaction();
		 System.out.println("Inserting Record");
		  session.save(inEMailAddress);
		  transaction.commit();
		  System.out.println("Done");
		  }catch(Exception e){
		  e.printStackTrace();
		  }finally{
		  // Actual contact insertion will happen at this step
			  session.flush();
			  session.close();

		  }
		
	   /* Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsInserted = 0;

	     try{
	    	 String url = "jdbc:mysql://localhost:8889/test";
	 		Class.forName("com.mysql.jdbc.Driver");
	 		dbConn = DriverManager.getConnection(url, "root", "root");
		pStmt = dbConn.prepareStatement("INSERT INTO emailaddress  VALUES (?,?,?,?,?,?,?,?)");
		
		pStmt.setString(1, inEMailAddress.geteMailID());
		pStmt.setString(2, inEMailAddress.getfName());
		pStmt.setString(3, inEMailAddress.getmName());
		pStmt.setString(4, inEMailAddress.getlName());
		pStmt.setString(5, inEMailAddress.gethPhone());
		pStmt.setString(6, inEMailAddress.getwPhone());
		pStmt.setString(7, inEMailAddress.getmPhone());
		pStmt.setString(8, inEMailAddress.getgroupID());
		
   		rowsInserted = pStmt.executeUpdate();

		if (rowsInserted != 1) {
			throw new Exception("Error in inserting the row");

   		}
	     	}catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;*/
	}


	public static void updateEMailAddress(EmailAddressVO inEMailAddress) throws Exception{
		try{
			
			
			System.out.println("1");
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.saveOrUpdate(inEMailAddress);
			tr.commit();
			session.flush();
			session.close();
				
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteEMailAddress(EmailAddressVO eMailAddress) throws Exception{
		{
			
			System.out.println("1");
			
			System.out.println(eMailAddress.geteMailID());
			
			Connection con = null;
			Session session = null;
			System.out.print(eMailAddress.getId());
			
			try{
				SessionFactory sf = new Configuration().configure().buildSessionFactory();
				
				 session = sf.openSession();
				System.out.println("2");
				Transaction tr = session.beginTransaction();
				String s = "delete from EmailAddressVO where eMailID like '"+eMailAddress.geteMailID()+"%'";
				Query q = session.createQuery(s);
				q.executeUpdate();
				System.out.println("3");
				
				tr.commit();
				System.out.println("4");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally{
				session.flush();
				session.close();
			}
				
			}
			
			
		}

	public List getAllEMailAddress(EmailAddressVO emailaddressVO) {

		 Session session = null;
		 List ls = null;
			
		  try{
			  
		  System.out.println("Email Name = "+emailaddressVO.geteMailID());
		  System.out.println("1");
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  System.out.println("2");
		  session =sessionFactory.openSession();
		  System.out.println("3");
		  //System.out.println(countryvo.getCountryName());
		  System.out.println("4");
		  Query q = session.createQuery("from EmailAddressVO");
		  System.out.println("5");
		 
		  ls = q.list();
		  
		  
		  
		 // System.out.println(ls);
		// transaction.commit();
		  System.out.println("Done");
		  
		  }catch(Exception e){
		  e.printStackTrace();
		  }finally{
		  // Actual contact insertion will happen at this step
		//  session.flush();
		//  session.close();

		  }
		  return ls;
		
		
	}

	/*public static ArrayList getAllEMailAdressEntries() throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList eMailList = new ArrayList();
	    EMailAddressVOO eMailAddress = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM emailaddress");

   		rs = pStmt.executeQuery();

		while (rs.next()) {
		eMailAddress = new EMailAddressVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
		eMailList.add(eMailAddress);
		System.out.println(eMailAddress.getfName());
                System.out.println(eMailAddress.gethPhone());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return eMailList;
	}*/

	/*public static ArrayList getAllEMailAdressEntriesbyGroup(String inGroupID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList eMailList = new ArrayList();
	    EMailAddressVOO eMailAddress = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM emailaddress groupid = ?");
		pStmt.setString(1, inGroupID);
   		rs = pStmt.executeQuery();

		if (rs.next()) {
		eMailAddress = new EMailAddressVOO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8));
		eMailList.add(eMailAddress);
		System.out.println(eMailAddress.getfName());
                System.out.println(eMailAddress.gethPhone());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return eMailList;
	}*/

// Group Queries

	/*public static GroupVO getGroup(String inGroupID) throws Exception{

	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    GroupVO group = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM Groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
   		rs = pStmt.executeQuery();

		if (rs.next()) {
		group = new GroupVO(rs.getString(1), rs.getString(2));

		System.out.println(group.getgroupID());
                System.out.println(group.getgName());

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return group;
	}

	public static void addGroup(GroupVO inGroup)  throws Exception{
		
		
		
		
		
	}*/
	   
 
	/*public static void updateGroup(GroupVO inGroup)  throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsUpdated = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("UPDATE groups SET groupId=?, firstname=?");

		pStmt.setString(1, inGroup.getgroupID());
		pStmt.setString(2, inGroup.getgName());
		
   		rowsUpdated = pStmt.executeUpdate();

		if (rowsUpdated != 1) {
			throw new Exception("Error in updating the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}

	public static void deleteGroup(String inGroupID) throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
	    int rowsDeleted = 0;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("DELETE FROM groups WHERE groupid = ?");
		pStmt.setString(1, inGroupID);
		
   		rowsDeleted = pStmt.executeUpdate();

		if (rowsDeleted != 1) {
			throw new Exception("Error in delete the row");

   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		pStmt.close();
		dbConn.close();
	     }
		return;
	}*/

	/*public static ArrayList getAllGroupEntries() throws Exception{
	    Connection dbConn = null;
	    PreparedStatement pStmt = null;
            ResultSet rs = null;
	    ArrayList groupList = new ArrayList();
	    GroupVO group = null;

	     try{
		dbConn = getConnection();
		pStmt = dbConn.prepareStatement("SELECT * FROM Groups");

   		rs = pStmt.executeQuery();

		if (rs.next()) {
		group = new GroupVO(rs.getString(1), rs.getString(2));
		groupList.add(group);
		System.out.println(group.getgroupID());
                System.out.println(group.getgName());
   		}
	     }catch (SQLException sqle) {
		   sqle.printStackTrace();
		   throw sqle;
		}
             catch(Exception e) {
		   e.printStackTrace();
		   throw e;
		}
	     finally {
		rs.close();
		pStmt.close();
		dbConn.close();
	     }
		return groupList;
	}*/

/*public static void main(String[] arg){
	EMailDBAccess eMailDBAccess = new EMailDBAccess();
	try{
	eMailDBAccess.getEMailAddress("aa@yahoo.com");
	} catch (Exception e){
		e.printStackTrace();
	}
}*/
}
 
