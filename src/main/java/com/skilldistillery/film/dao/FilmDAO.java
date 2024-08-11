package com.skilldistillery.film.dao;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

    // Find a film by its ID
    public Film findFilmById(int filmId);

    // Find an actor by their ID
    public Actor findActorById(int actorId);

    // Find all actors associated with a given film ID
    public List<Actor> findActorsByFilmId(int filmId);

    // Search for films by keyword in title or description
    public List<Film> findFilmByKeyword(String keyword);

    // Add a new film to the database and return the Film object with the generated ID
    public Film addFilm(Film newFilm);

    // Delete a film by its ID
    public boolean deleteFilmById(int filmId);

    // Update an existing film's details
    public boolean updateFilm(Film film);
}
