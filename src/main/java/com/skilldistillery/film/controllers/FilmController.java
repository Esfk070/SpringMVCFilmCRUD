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

    @RequestMapping(path = "getFilmById.do", params = "filmId", method = RequestMethod.GET)
    public ModelAndView getFilmById(@RequestParam("filmId") int filmId) {
        ModelAndView mv = new ModelAndView();
        Film film = filmdao.findFilmById(filmId);
        System.out.println("getFilmByID called");

        if (film != null) {
            mv.addObject("film", film);
            mv.setViewName("WEB-INF/result.jsp");
        } else {
            mv.addObject("message", "No film has been found with ID: " + filmId);
            mv.setViewName("WEB-INF/error.jsp");
        }
        return mv;
    }

    @RequestMapping(path = "getFilmByKeyword.do", method = RequestMethod.GET)
    public ModelAndView getFilmByKeyword(@RequestParam("keyword") String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Film> films = filmdao.findFilmByKeyword(keyword);
      
        
        for (Film film : films)
        {
        	System.out.println(film.getTitle());
        }
        
 

        System.out.println("getFilmByKEYWORD called");

        if (films != null) {
            mv.addObject("films", films);

            mv.setViewName("WEB-INF/resultForKeyword.jsp");
        } else {
            mv.addObject("message", "No film has been found with ID: " + keyword);
            mv.setViewName("WEB-INF/error.jsp");
        }
        return mv;
    }
        


    @RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
    public ModelAndView addFilm(
            @RequestParam("filmTitle") String filmTitle,
            @RequestParam(value = "filmDescription", required = false) String filmDescription,
            @RequestParam(value = "releaseYear", defaultValue = "0") int releaseYear,
            @RequestParam(value = "languageId", defaultValue = "0") int languageId,
            @RequestParam(value = "rentalDuration", defaultValue = "0") int rentalDuration,
            @RequestParam(value = "rentalRate", defaultValue = "0.0") double rentalRate,
            @RequestParam(value = "replacementCost", defaultValue = "0.0") double replacementCost,
            @RequestParam(value = "rating", required = false) String rating,
            @RequestParam(value = "specialFeatures", required = false) String specialFeatures) {

        ModelAndView mv = new ModelAndView();

        if (filmTitle == null || filmTitle.trim().isEmpty()) {
            mv.addObject("message", "Film title is required.");
            mv.setViewName("WEB-INF/error.jsp");
            return mv;
        }

        Film newFilm = new Film();
        newFilm.setTitle(filmTitle);
        newFilm.setDescription(filmDescription);
        newFilm.setRelease_year(releaseYear);
        newFilm.setLanguage_id(languageId);
        newFilm.setRental_duration(rentalDuration);
        newFilm.setRental_rate(rentalRate);
        newFilm.setReplacement_cost(replacementCost);
        newFilm.setRating(rating);
        newFilm.setSpecial_features(specialFeatures);

        boolean successfullyAdded = filmdao.addFilm(newFilm);

        if (successfullyAdded) {
            mv.addObject("film", newFilm);
            mv.setViewName("WEB-INF/result.jsp");
        } else {
            mv.addObject("message", "Failed to add new film.");
            mv.setViewName("WEB-INF/error.jsp");
        }

        return mv;
    }

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

    @RequestMapping(path = "updateFilm.do", method = RequestMethod.POST)
    public ModelAndView updateFilm(
            @RequestParam("filmId") int filmId,
            @RequestParam("filmTitle") String filmTitle,
            @RequestParam("filmDescription") String filmDescription,
            @RequestParam("releaseYear") int releaseYear,
            @RequestParam("languageId") int languageId,
            @RequestParam("rentalDuration") int rentalDuration,
            @RequestParam("rentalRate") double rentalRate,
            @RequestParam("replacementCost") double replacementCost,
            @RequestParam("rating") String rating,
            @RequestParam("specialFeatures") String specialFeatures) {

        ModelAndView mv = new ModelAndView();

        Film filmToUpdate = filmdao.findFilmById(filmId);
        if (filmToUpdate != null) {
            filmToUpdate.setTitle(filmTitle);
            filmToUpdate.setDescription(filmDescription);
            filmToUpdate.setRelease_year(releaseYear);
            filmToUpdate.setLanguage_id(languageId);
            filmToUpdate.setRental_duration(rentalDuration);
            filmToUpdate.setRental_rate(rentalRate);
            filmToUpdate.setReplacement_cost(replacementCost);
            filmToUpdate.setRating(rating);
            filmToUpdate.setSpecial_features(specialFeatures);

            boolean updated = filmdao.updateFilm(filmToUpdate);

            if (updated) {
                mv.addObject("film", filmToUpdate);
                mv.setViewName("WEB-INF/result.jsp");
            } else {
                mv.addObject("message", "Failed to update film.");
                mv.setViewName("WEB-INF/error.jsp");
            }
        } else {
            mv.addObject("message", "Film not found for ID: " + filmId);
            mv.setViewName("WEB-INF/error.jsp");
        }

        return mv;
    }
}
