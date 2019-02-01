package info.chen.awsome.cws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:junitBeans.xml"})
public class TitleServiceTest {

	@Autowired
	private TitleService titleService;
	
	@Test
	public void testTitleServiceNotNull() {
		assertNotNull(titleService);
	}
	
	@Test
	public void testGetTitlesByEmployeeID() throws TitleException {
		List<Title> titles = titleService.getTitlesByEmployeeID(10001);
		assertEquals(1, titles.size());
	}
}
