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
        Film film = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT id, title, description, release_year, language_id, "
                       + "rental_duration, rental_rate, length, replacement_cost, "
                       + "rating, special_features FROM film WHERE id=?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                film = new Film(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
                                rs.getInt(6), rs.getDouble(7), rs.getInt(8), rs.getDouble(9), rs.getString(10),
                                rs.getString(11));

                
                film.setActors(findActorsByFilmId(film.getId()));
              
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return film;
    }

    @Override
    public Actor findActorById(int actorId) {
       
        return null;
    }

    @Override
    public List<Actor> findActorsByFilmId(int filmId) {
        List<Actor> actors = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            String sql = "SELECT a.id, a.first_name, a.last_name "
                       + "FROM actor a JOIN film_actor fa ON a.id = fa.actor_id "
                       + "WHERE fa.film_id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, filmId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Actor actor = new Actor(rs.getInt(1), rs.getString(2), rs.getString(3));
                actors.add(actor);
            }

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    @Override
    public List<Film> findFilmByKeyword(String keyword) {
        
        return null;
    }

    @Override
    public Film addFilm(Film newFilm) {
        String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, "
                   + "rental_rate, length, replacement_cost, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)){
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
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
            if (rowsAffected == 0) {
                throw new SQLException("Failed to insert film, no rows affected.");
            }
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next()) {
                int newFilmID = keys.getInt(1);
                System.out.println(newFilmID);
                newFilm.setId(newFilmID);
                System.out.println("Look Here!!!" + newFilm.getId());
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding new film to database", e);
        }
        
        return newFilm;
    }

    @Override
    public boolean deleteFilmById(int filmId) {
		Connection conn = null;

		try {
			String url = "jdbc:mysql://localhost:3306/sdvid";
			String user = "student";
			String pword = "student";
			conn = DriverManager.getConnection(url, user, pword);
			conn.setAutoCommit(false);

			String sql = "DELETE FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			System.out.println("Film ID to delete: " + filmId);

			stmt.setInt(1, filmId);
			int updateCount = stmt.executeUpdate();
			conn.commit();
			System.out.println("IS delete working????");
			if(updateCount > 0) {
				return true;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.out.println("Error trying to rollback");
				}
			}
		}
		return false;

    }
}
