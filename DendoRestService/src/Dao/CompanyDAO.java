package Dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Company;

public class CompanyDAO {

	public void addCompany(String name, String desc) {
		try {
			Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Company company = new Company();
			company.setName(name);
			company.setDesc(desc);
			session.save(company);
	        transaction.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());	
		}
	}
	
}
