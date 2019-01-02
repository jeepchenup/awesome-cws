package info.chen.awsome_cws_persist.dao;

import java.util.List;

import info.chen.awsome_cws_persist.entity.Title;

public interface TitleDao {

	List<Title> getTitlesByEmployeeID(Integer id);
}
