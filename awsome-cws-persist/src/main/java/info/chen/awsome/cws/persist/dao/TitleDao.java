package info.chen.awsome.cws.persist.dao;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Title;
import info.chen.awsome.cws.persist.exception.TitleException;

public interface TitleDao {

	List<Title> getTitlesByEmployeeID(Integer id) throws TitleException;
}
