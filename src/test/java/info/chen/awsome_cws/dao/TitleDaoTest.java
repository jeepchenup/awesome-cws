package info.chen.awsome_cws.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.chen.awsome_cws.configuration.HibernateConfiguration;
import info.chen.awsome_cws.entity.Title;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfiguration.class})
@WebAppConfiguration
public class TitleDaoTest {

	@Autowired
	TitleDao titleDao;
	
	@Test
	public void testTitleDaoNotNull() {
		assertNotNull(titleDao);
	}
	
	@Test
	public void testGetTitlesByEmployeeID() {
		List<Title> titles = titleDao.getTitlesByEmployeeID(10009);
		for(Title title : titles) {
			System.out.println(title);
		}
	}
}
