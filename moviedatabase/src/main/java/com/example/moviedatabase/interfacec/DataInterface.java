package com.example.moviedatabase.interfacec;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.moviedatabase.model.ObjectClass;
@Repository
public interface DataInterface extends JpaRepository<ObjectClass, Integer>
{
	@Query("select avg(rating) from ObjectClass temp where temp.movieId = ?1")
	double getAverageMovieRating(String movieId);
	@Query("select movieName from ObjectClass temp where temp.movieId = ?1 group by temp.movieId ")
	String getMovieNameByMovieId(String movieId);
}
