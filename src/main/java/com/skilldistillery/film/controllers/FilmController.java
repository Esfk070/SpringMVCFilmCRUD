package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.dao.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO filmdao;

	@RequestMapping(path = { "index.do", "/" })
	public String index() {
		return "WEB-INF/index.jsp";
	}
	
	// Get Film by ID 
	@RequestMapping(path = "getFilmById.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		Film film = filmdao.findFilmById(filmId);
		
		if (film != null) {
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/result.jsp");
		} else {
			mv.addObject("message", "No film found with ID: " + filmId);
			mv.setViewName("WEB-INF/error.jsp");
		}
		return mv;
	}
	
	// Get Film by Keyword 
	@RequestMapping(path = "getFilmByKeyword.do", method = RequestMethod.GET)
    public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Film> films = filmdao.findFilmByKeyword(keyword);
        
        if (!films.isEmpty()) {
            mv.addObject("films", films);
            mv.setViewName("WEB-INF/filmList.jsp"); // Make sure this JSP is set up to handle a list of films
        } else {
            mv.addObject("message", "No films found with keyword: " + keyword);
            mv.setViewName("WEB-INF/error.jsp");
        }
        return mv;
    }
	
	// Add Film 
	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(
	    @RequestParam("filmTitle") String filmTitle,
	    @RequestParam(value = "languageId", defaultValue = "0") int languageId,
	    @RequestParam(value = "rentalDuration", defaultValue = "0") int rentalDuration,
	    @RequestParam(value = "rentalRate", defaultValue = "0.0") double rentalRate,
	    @RequestParam(value = "replacementCost", defaultValue = "0.0") double replacementCost) {
	    
	    ModelAndView mv = new ModelAndView();

	    if (filmTitle == null || filmTitle.trim().isEmpty()) {
	        mv.addObject("message", "Film title is required.");
	        mv.setViewName("WEB-INF/error.jsp");
	        return mv;
	    }

	    Film addedFilm = new Film();
	    addedFilm.setTitle(filmTitle);
	    addedFilm.setDescription(null); 
	    addedFilm.setRelease_year(0); 
	    addedFilm.setLanguage_id(languageId);
	    addedFilm.setRental_duration(rentalDuration);
	    addedFilm.setRental_rate(rentalRate);
	    addedFilm.setLength(0); 
	    addedFilm.setReplacement_cost(replacementCost);
	    addedFilm.setRating(null); 
	    addedFilm.setSpecial_features(null); 

	    addedFilm = filmdao.addFilm(addedFilm); 

	    if (addedFilm != null) {
	        mv.addObject("film", addedFilm);
	        mv.setViewName("WEB-INF/result.jsp");
	    } else {
	        mv.addObject("message", "Failed to add new film.");
	        mv.setViewName("WEB-INF/error.jsp");
	    }

	    return mv;
	}
	
	// Update Film 
	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(
	    @RequestParam("filmId") int filmId,
	    @RequestParam("filmTitle") String filmTitle,
	    @RequestParam(value = "languageId", defaultValue = "0") int languageId,
	    @RequestParam(value = "rentalDuration", defaultValue = "0") int rentalDuration,
	    @RequestParam(value = "rentalRate", defaultValue = "0.0") double rentalRate,
	    @RequestParam(value = "replacementCost", defaultValue = "0.0") double replacementCost) {
	    
	    ModelAndView mv = new ModelAndView();

	    Film film = filmdao.findFilmById(filmId);
	    if (film == null) {
	        mv.addObject("message", "Film not found.");
	        mv.setViewName("WEB-INF/error.jsp");
	        return mv;
	    }

	    film.setTitle(filmTitle);
	    film.setLanguage_id(languageId);
	    film.setRental_duration(rentalDuration);
	    film.setRental_rate(rentalRate);
	    film.setReplacement_cost(replacementCost);

	    boolean updated = filmdao.updateFilm(film);

	    if (updated) {
	        mv.addObject("film", film);
	        mv.setViewName("WEB-INF/result.jsp");
	    } else {
	        mv.addObject("message", "Failed to update film.");
	        mv.setViewName("WEB-INF/error.jsp");
	    }

	    return mv;
	}
	
	//  Delete Film 
	@RequestMapping(path = "deleteFilm.do", params = "filmId", method = RequestMethod.POST)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		boolean deleted = filmdao.deleteFilmById(filmId);
		
		if (deleted) {
			mv.addObject("message", "Film has been deleted.");
			mv.setViewName("WEB-INF/resultDelete.jsp");
		} else {
			mv.addObject("message", "Failed to delete film.");
			mv.setViewName("WEB-INF/error.jsp");
		}
		return mv;
	}
}
