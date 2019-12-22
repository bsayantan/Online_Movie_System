package com.example.movie.model;

public class ObjectClass {
	private int id;
	private String userid;
	private String username;
	private String movieId;
	private String movieName;
	private double rating;
	public ObjectClass() {
		
	}
	public ObjectClass(int id,String userid, String username, String movieId, double rating,String movieName) {
		this.id=id;
		this.userid = userid;
		this.username = username;
		this.movieId = movieId;
		this.rating = rating;
		this.movieName=movieName;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMovieId() {
		return movieId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	@Override
	public String toString() {
		return "ObjectClass [id=" + id + ", userid=" + userid + ", username=" + username + ", movieId=" + movieId
				+ ", movieName=" + movieName + ", rating=" + rating + "]";
	}
	

}
