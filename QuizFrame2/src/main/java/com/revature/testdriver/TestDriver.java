package com.revature.testdriver;

import com.revature.daos.QuizJoinDao;
import com.revature.daos.UserDao;
import com.revature.models.QuizJoin;
import com.revature.models.User;

public class TestDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserDao userDao = UserDao.currentImplementation;
QuizJoinDao rDao = QuizJoinDao.currentImplementation;
		QuizJoinDao reimbDao = QuizJoinDao.currentImplementation;
	//	Reimbursement r = new Reimbursement();
	//	r.setReimbId(28);
	//	r.setReimbResolver(3);
	//	r.setReimbStatusId(1);
	//	 User loggedInUser = userDao.findByUsernameAndPassword("admin", "pass");

		// System.out.println(reimbDao.findAll());

		// System.out.println("The seperator");
	//	System.out.println(reimbDao.update(r));

		// System.out.println(reimbDao.findByAuthorId(3));
		//System.out.println(reimbDao.findByStatusId(1));
//		System.out.println(reimbDao.findByStatusId(3));
		/*
		 * System.out.println("just saying"); //System.out.println(userDao.findAll());
		 * System.out.println(userDao.findByUsernameAndPassword("admin", "admin"));
		 * 
		 */
	
	//System.out.println(userDao.findAll());
//	System.out.println(userDao.findByUsernameAndPassword("admin", "pass"));
	
	System.out.println(rDao.findAll());
	}

}
