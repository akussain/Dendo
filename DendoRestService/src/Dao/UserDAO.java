package Dao;

import java.util.Date;

import methods.BCrypt;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import util.HibernateUtil;
import Models.User;

public class UserDAO {

	public void registerUser(String userName, String firstName, String lastName, String password, String email, String phone, Date birthDate) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            User user = new User();
            user.setUserName(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
            user.setEmail(email);
            user.setBirthDate(birthDate);
            user.setPhone(phone);
            session.save(user);
            transaction.commit();
            
            System.out.println("User created");
		}catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("Error");
		}
	}
	
	public User getUser(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User where userName = :username").setParameter("username", userName);
        User user = (User) query.uniqueResult();
        
        return user;
	}
	
}
