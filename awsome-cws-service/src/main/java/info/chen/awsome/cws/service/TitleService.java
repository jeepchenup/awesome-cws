package info.chen.awsome.cws.service;

import java.util.List;

import info.chen.awsome.cws.persist.entity.Title;

public interface TitleService {

	List<Title> getTitlesByEmployeeID(Integer id);
}
