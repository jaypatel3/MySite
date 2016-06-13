package assign.dbaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.AddGroupVO;
import VO.GroupVO;

public class GroupDBAccess {

	public void addGroup(GroupVO groupvo) {
		
		System.out.println("---Into the database---");
		
		 Session session = null;
		 System.out.println(groupvo.getgName());
		  try{
		  // This step will read hibernate.cfg.xml 

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		  //Create new instance of Contact and set 
       Transaction transaction = session.beginTransaction();
		 System.out.println("Inserting Record");
		  session.save(groupvo);
		  transaction.commit();
		  System.out.println("Done");
		  }catch(Exception e){
		  e.printStackTrace();
		  }finally{
		  // Actual contact insertion will happen at this step
			  session.flush();
			  session.close();

		  }	
		
		
		
		
	}

	public List fetch(GroupVO groupvo) {
		
		 Session session = null;
		 List ls = null;
		  try{
		  // This step will read hibernate.cfg.xml 
			  System.out.println("------AJAX-----");
			  System.out.println(groupvo.getgName());
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  System.out.println("1");
		 session =sessionFactory.openSession();
		 System.out.println("2");
		  //Create new instance of Contact and set 
		
		 System.out.println("3");
		 Query q = session.createQuery("from GroupVO where gName like '"+groupvo.getgName()+"%'");				
		 System.out.println("4");
		 System.out.println("fetch");
		 ls = q.list();
		
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

	public static void update(GroupVO groupvo) {
		System.out.println("---Into the database---");
		
		 Session session = null;
		 System.out.println(groupvo.getgName());
		  try{
		  // This step will read hibernate.cfg.xml 

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 session =sessionFactory.openSession();
		  //Create new instance of Contact and set 
      Transaction transaction = session.beginTransaction();
		 System.out.println("Inserting Record");
		  session.saveOrUpdate(groupvo);
		  transaction.commit();
		  System.out.println("Done");
		  }catch(Exception e){
		  e.printStackTrace();
		  }finally{
		  // Actual contact insertion will happen at this step
			  session.flush();
			  session.close();

		  }	
		
		
		
	
	}
		
	}
	
	
	
	

