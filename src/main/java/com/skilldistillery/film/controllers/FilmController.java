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

	@RequestMapping(path = { "index.do", "/" }	)
	public String index() {
		return "WEB-INF/index.jsp";
	}
	
// == Get Film by ID == 
	@RequestMapping(path = "getFilmById.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("filmId")int filmId) { // 
		ModelAndView mv = new ModelAndView();
		Film film = filmdao.findFilmById(filmId); // Need to update - and parameter above.
		
		// If successful - index.jsp 	vs.	if UNSUCCESSFUL - error.jsp
		if (film!= null) {
			mv.addObject("film", film);
			mv.setViewName("WEB-INF/result.jsp"); 
		} else {
			mv.addObject("message", "No film has been found with ID: " + filmId);
			mv.setViewName("WEB-INF/error.jsp");
		}
		return mv;
	}
	
// == Get Film by Keyword == 
	@RequestMapping(path = "getFilmByKeyword.do", method = RequestMethod.GET)
    public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Film> films = filmdao.findFilmByKeyword(keyword);
        
        if (!films.isEmpty()) {
            mv.addObject("films", films);
            mv.setViewName("WEB-INF/result.jsp"); // TO DO
        } else {
            mv.addObject("message", "No films have been found with keyword: " + keyword);
            mv.setViewName("WEB-INF/error.jsp");
        }
        return mv;
    }
	
// == ADD FILM == 

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView addFilm(
	
			@RequestParam("filmTitle") String filmTitle,
	        @RequestParam(value = "languageId", defaultValue = "0") int languageId,
	        @RequestParam(value = "rentalDuration", defaultValue = "0") int rentalDuration,
	        @RequestParam(value = "rentalRate", defaultValue = "0.0") double rentalRate,
	        @RequestParam(value = "replacementCost", defaultValue = "0.0") double replacementCost) {
	    
	    ModelAndView mv = new ModelAndView();

	    // CHECK FOR FILM's NAME - if empty, send user over to error. (should resolve 400)
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

	    // boolean successfullyAddedFilm = filmdao.addFilm(addedFilm); 
	    boolean successfullyAddedFilm = filmdao.addFilm(addedFilm); 

	    if (successfullyAddedFilm) {
	        mv.addObject("film", addedFilm);
	        mv.setViewName("WEB-INF/result.jsp");
	    } else {
	        mv.addObject("message", "Failed to add new film.");
	        mv.setViewName("WEB-INF/error.jsp");
	    }

	    return mv;
	}
	
	
/*	
	@RequestMapping(path = "addFilm.do", params = {"filmTitle", "languageId", "rentalDuration", "rentalRate", 
			"replacementCost"}, method = RequestMethod.POST	)
	public ModelAndView addFilm(@RequestParam("filmTitle") String filmTitle, @RequestParam("languageId") int languageId, 
			@RequestParam("rentalDuration") int rentalDuration, @RequestParam("rentalRate") double rentalRate,
			@RequestParam("replacementCost") double replacementCost) {
		ModelAndView mv = new ModelAndView();
		
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
		
		
		
		
		
		filmdao.addFilm(addedFilm);
		
		if (addedFilm != null) {
			mv.addObject("film", addedFilm);
			mv.setViewName("WEB-INF/result.jsp"); // TO DO
		} else {
			mv.addObject("message", "Failed to add new film.");
			mv.setViewName("WEB-INF/error.jsp");
		}
		return mv;
	}
*/	
	
	
	
//	
//// == UPDATE FILM == 
//	@RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
//	public ModelAndView updateFilm(Film film) {
//		ModelAndView mv = new ModelAndView();
//		Film updatedFilm = filmdao.updateFilm(film); // TO DO
//		
//		if (		) {
//			mv.addObject("film", film);
//			mv.setViewName("WEB-INF/index.jsp"); // TO DO
//		} else {
//			mv.addObject("message", "Failed to update film.");
//			mv.setViewName("WEB-INF/error.jsp");
//		}
//		return mv;
//	}
//	
//// == DELETE FILM == 
	
	
	
	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
	public ModelAndView deleteFilm(Film film) {
		ModelAndView mv = new ModelAndView();
		filmdao.deleteFilmById(film);
		
		
		if (filmdao.findFilmById(film.getId())==null) {
			mv.addObject("message", "Film has been deleted.");
			mv.setViewName("WEB-INF/result.jsp"); // TO DO
		} else {
			mv.addObject("message", "Failed to delete film.");
			mv.setViewName("WEB-INF/error.jsp");
		}
		return mv;
	}
//	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.POST)
//	public ModelAndView deleteFilm(Film film) {
//		ModelAndView mv = new ModelAndView();
//		Film updatedFilm = filmdao.set // TO DO
//		
//		if (		) {
//			mv.addObject("message", "Film has been deleted.");
//			mv.setViewName("WEB-INF/index.jsp"); // TO DO
//		} else {
//			mv.addObject("message", "Failed to delete film.");
//			mv.setViewName("WEB-INF/error.jsp");
//		}
//		return mv;
//	}
//	
	// Will need to look at WEB-INF next. ---- TO DO
	// 1 JSP for add, 1 for update,
	// 1 for error JSP
	
	// every time you do something differently
	// form - add form - 
	
	
}

