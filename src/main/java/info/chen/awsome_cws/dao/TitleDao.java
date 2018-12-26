package info.chen.awsome_cws.dao;

import java.util.List;

import info.chen.awsome_cws.entity.Title;

public interface TitleDao {

	List<Title> getTitlesByEmployeeID(Integer id);
}
