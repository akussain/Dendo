package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Models.Discount;
import util.HibernateUtil;

public class DiscountDAO {

	public void addDiscount(String title, String desc, String sourcePortal, String discountUrl, String discountLabel) {
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = session.beginTransaction();
			Discount discount = new Discount();
			discount.setTitle(title);
			discount.setDesc(desc);
			discount.setSourcePortal(sourcePortal);
			discount.setDiscountUrl(discountUrl);
			discount.setDiscountLabel(discountLabel);
			discount.setIsActive(1);
			session.save(discount);
	        transaction.commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
