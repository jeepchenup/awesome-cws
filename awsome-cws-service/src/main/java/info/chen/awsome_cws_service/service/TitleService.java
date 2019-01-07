package info.chen.awsome_cws_service.service;

import java.util.List;

import info.chen.awsome_cws_persist.entity.Title;

public interface TitleService {

	List<Title> getTitlesByEmployeeID(Integer id);
}
