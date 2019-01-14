package info.chen.awsome.cws.persist.dao;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Title;

public interface TitleDao {

	List<Title> getTitlesByEmployeeID(Integer id);
}
