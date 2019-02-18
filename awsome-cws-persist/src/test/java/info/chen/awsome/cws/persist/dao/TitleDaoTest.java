package info.chen.awsome.cws.persist.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
@Transactional
public class TitleDaoTest {

	@Autowired
	private TitleDao titleDao;
	
	@Test
	public void testTitleDaoNotNull() {
		assertNotNull(titleDao);
	}
	
	@Test
	public void testGetTitlesByEmployeeID() throws TitleException {
		List<Title> titles = titleDao.getTitlesByEmployeeID(10002);
		assertEquals(1, titles.size());
		for(Title title : titles) {
			System.out.println(title);
		}
	}
	
	/*********************** Test Exception ***********************/
	
	@Test(expected = TitleException.class)
	public void testGetTitlesByEmployeeIDException() throws TitleException {
		titleDao.getTitlesByEmployeeID(-1);
	}
}
