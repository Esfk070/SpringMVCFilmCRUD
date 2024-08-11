package com.skilldistillery.film.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDaoJdbcImpl implements FilmDAO {

											
    private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
    private static final String USER = "student";
    private static final String PASS = "student";

    public FilmDaoJdbcImpl() {
    	System.out.println("FilmDaoJdbcImpl constructor working");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Error loading MySQL Driver");
            throw new RuntimeException("Unable to load MySQL Driver class");
        }
    }

    @Override
    public Film findFilmById(int filmId) {
    	System.out.println("FilmDaoJdbcImpl called PRE");
        Film film = null;
        String sql = "SELECT id, title, description, release_year, language_id, "
                + "rental_duration, rental_rate, length, replacement_cost, "
                + "rating, special_features FROM film WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
        		System.out.println("FilmDaoJdbcImpl called");

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
                        rs.getString(11));

                List<Actor> actors = findActorsByFilmId(filmId);
                film.setActors(actors);
                film.setFilmCast(actors);
                
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    @Override
    public Actor findActorById(int actorId) {
        Actor actor = null;

        String sql = "SELECT id, first_name, last_name FROM actor WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, actorId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actor;
    }

    @Override
    public List<Actor> findActorsByFilmId(int filmId) {
        List<Actor> actors = new ArrayList<>();
        String sql = "SELECT a.id, a.first_name, a.last_name "
                + "FROM actor a JOIN film_actor fa ON a.id = fa.actor_id WHERE fa.film_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
                actors.add(actor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    @Override
    public List<Film> findFilmByKeyword(String keyword) {
    	System.out.println("FilmDAOJdbcImpl.java findFilmByKeyword() called");
        List<Film> films = new ArrayList<>();
        String sql = "SELECT id, title, description, release_year, language_id, rental_duration, "
                + "rental_rate, length, replacement_cost, rating, special_features "
                + "FROM film WHERE title LIKE ? OR description LIKE ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

        	System.out.println("FilmDAOJdbcImpl.java findFilmByKeyword() called try part");
            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Film film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                        rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
                        rs.getString(11));

                film.setActors(findActorsByFilmId(film.getId()));

                films.add(film);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }

    @Override
    public boolean addFilm(Film newFilm) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, "
                + "rental_rate, length, replacement_cost, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, newFilm.getTitle());
            stmt.setString(2, newFilm.getDescription());
            stmt.setInt(3, newFilm.getRelease_year());
            stmt.setInt(4, newFilm.getLanguage_id());
            stmt.setInt(5, newFilm.getRental_duration());
            stmt.setDouble(6, newFilm.getRental_rate());
            stmt.setInt(7, newFilm.getLength());
            stmt.setDouble(8, newFilm.getReplacement_cost());
            stmt.setString(9, newFilm.getRating());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    newFilm.setId(keys.getInt(1));
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteFilmById(int filmId) {
        String sql = "DELETE FROM film WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, filmId);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateFilm(Film film) {
        String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, "
                + "rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitle());
            stmt.setString(2, film.getDescription());
            stmt.setInt(3, film.getRelease_year());
            stmt.setInt(4, film.getLanguage_id());
            stmt.setInt(5, film.getRental_duration());
            stmt.setDouble(6, film.getRental_rate());
            stmt.setInt(7, film.getLength());
            stmt.setDouble(8, film.getReplacement_cost());
            stmt.setString(9, film.getRating());
            stmt.setString(10, film.getSpecial_features());
            stmt.setInt(11, film.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
