package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
    private static final String USER = "student";
    private static final String PASS = "student";

    @Override
    public Film findFilmById(int filmId) {
     
        return null;
    }

    @Override
    public Actor findActorById(int actorId) {
     
        return null;
    }

    @Override
    public List<Actor> findActorsByFilmId(int filmId) {
       
        return null;
    }

    @Override
    public List<Film> findFilmByKeyword(String keyword) {
     
        return null;
    }

    @Override
    public void addFilm(Film newFilm) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, " +
                     "rental_rate, length, replacement_cost, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, newFilm.getTitle());
            stmt.setString(2, newFilm.getDescription());
            stmt.setInt(3, newFilm.getReleaseYear());
            stmt.setInt(4, newFilm.getLanguageId());
            stmt.setInt(5, newFilm.getRentalDuration());
            stmt.setDouble(6, newFilm.getRentalRate());
            stmt.setInt(7, newFilm.getLength());
            stmt.setDouble(8, newFilm.getReplacementCost());
            stmt.setString(9, newFilm.getRating());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert film, no rows affected.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding new film to database", e);
        }
    }

	@Override
	public boolean deleteFilmById(Film filmToDelete) {
	
		return false;
	}
}
