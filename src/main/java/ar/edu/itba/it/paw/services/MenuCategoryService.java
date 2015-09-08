package ar.edu.itba.it.paw.services;

import java.util.List;

import ar.edu.itba.it.paw.dao.MenuCategoryDao;

public class MenuCategoryService {
	
	public List<String> getMenuCategories() {
		return MenuCategoryDao.getInstance().getCategoryNameList();
	}
}
