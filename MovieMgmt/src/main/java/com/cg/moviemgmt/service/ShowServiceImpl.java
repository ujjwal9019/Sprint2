package com.cg.moviemgmt.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.moviemgmt.dao.IShowDao;
import com.cg.moviemgmt.entities.Show;

public class ShowServiceImpl implements IShowService {

	@Autowired
	private IShowDao dao ;

	@Override
	public Show Save(Show s) {
	    Show sh = dao.save(s) ;
		return sh;
	}

	@Override
	public String DeleteShow(int showId) {
		Show sh = fetchById(showId) ;
		dao.delete(sh);
 		return "Deleted Succesfully";
	}

	@Override
	public List<Show> fetchAll() {
		List<Show> shows = dao.findAll();
		return shows;
	}

	@Override
	public Show fetchById(int showId) {
		Optional<Show> optional = dao.findById(showId);
		if(optional.isPresent()) {
			Show sh = optional.get();
			return sh ;
		}
		return null;
	}

}
