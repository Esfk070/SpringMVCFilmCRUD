package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	
	private int id;		
	private String title;	
	private String description;	
	private Integer release_year;	//  Nullable
	private int language_id;	
	private int rental_duration;	
	private double rental_rate;		
	private Integer length;				// Nullable
	private double replacement_cost;	
	private String rating;		
	private String special_features;	
	private List<Actor> actors;		
	
	private String languageName;	 // 
	
	static {
		
	}

	
	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(double replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	
	public Film() {
		super();
	}

	public Film(int id, String title, String description, int release_year, int language_id, int rental_duration,
			double rental_rate, int length, double replacement_cost, String rating, String special_features) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.release_year = release_year;
		this.language_id = language_id;
		this.rental_duration = rental_duration;
		this.rental_rate = rental_rate;
		this.length = length;
		this.replacement_cost = replacement_cost;
		this.rating = rating;
		this.special_features = special_features;
	}


	
	@Override
	public String toString() {
		return "title=" + title + ", release_year=" + release_year + ", rating=" + rating
				+ ", description=" + description + ", language=" + languageName + ", Actors=" + actors;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, id, language_id, length, rating, release_year, rental_duration, rental_rate,
				replacement_cost, special_features, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && id == other.id && language_id == other.language_id
				&& length == other.length && Objects.equals(rating, other.rating) && release_year == other.release_year
				&& rental_duration == other.rental_duration
				&& Double.doubleToLongBits(rental_rate) == Double.doubleToLongBits(other.rental_rate)
				&& Double.doubleToLongBits(replacement_cost) == Double.doubleToLongBits(other.replacement_cost)
				&& Objects.equals(special_features, other.special_features) && Objects.equals(title, other.title);
	}

	public int getReleaseYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getLanguageId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRentalDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getRentalRate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getReplacementCost() {
		// TODO Auto-generated method stub
		return 0;
	}
/*
	public List<Actor> getFilmCast() {
		return filmCast;
	}

	public void setFilmCast(List<Actor> filmCast) {
		this.filmCast = filmCast;
	}
*/


}


