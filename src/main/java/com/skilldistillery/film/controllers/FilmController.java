package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private FilmDAO filmdao;

	@RequestMapping(path = { "index.do", "/" })
	public String index() {
		ModelAndView mv = new ModelAndView(" "); // TO-DO?
		return "WEB-INF/index.jsp";
	}
	
	// USER STORY 1
	// A user can enter a Film's ID and see the details of the film in a web page. 
	// If the film is not found, they see an appropriate message.
// == Get Film by ID == 
	@RequestMapping(path = "getFilmById.do", method = RequestMethod.GET)
	public ModelAndView getFilmById(int filmId) { // 
		ModelAndView mv = new ModelAndView();
		Film film = filmdao.findFilmById(filmId); // Need to update - and parameter above.
		mv.addObject("film", film);
		mv.setViewName(null); // Need to update - WEBINF...instead of null
		return mv;
	}
	
// == Get Film by Keyword == 

}
