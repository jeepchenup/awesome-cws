package info.chen.awsome_cws_persist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import info.chen.awsome_cws_persist.util.HibernateUtils;
import junit.framework.TestCase;

public class DepartmentDaoTest extends TestCase{
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Override
	protected void setUp() throws Exception {
		sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@Override
	protected void tearDown() throws Exception {
		transaction.commit();
		if(session != null) {
			session.close();
		}
		sessionFactory.close();
	}

	@Test
	public void testSessionFactoryNotNull() {
		assertNotNull(sessionFactory);
	}
	
	@Test
	public void testGetDepartmentById() {
		
	}
	
}
