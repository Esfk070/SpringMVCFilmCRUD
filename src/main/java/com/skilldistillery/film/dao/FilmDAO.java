package com.skilldistillery.film.dao;

import java.util.List;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	/*
	Film findFilmById(int filmId);
    Actor findActorById(int actorId);
    List<Actor> findActorsByFilmId(int filmId);
    List<Film> findFilmByKeyword(String keyword);
    boolean addFilm(Film newFilm);
    
    boolean deleteFilmById(int filmId);
    boolean updateFilm(Film film);
*/


	public Film findFilmById(int filmId);
	public Actor findActorById(int actorId);
	public List<Actor> findActorsByFilmId(int filmId);
	public List<Film> findFilmByKeyword (String keyword);
	
	public boolean addFilm(Film newFilm);

	public boolean updateFilm(Film film);
	
	// public boolean deleteFilmById (Film filmToDelete);
	public boolean deleteFilmById (int filmId);

}
