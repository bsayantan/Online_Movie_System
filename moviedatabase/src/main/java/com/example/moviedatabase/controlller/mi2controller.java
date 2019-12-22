package com.example.moviedatabase.controlller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviedatabase.interfacec.DataInterface;

import com.example.moviedatabase.model.ObjectClass;
@RestController
public class mi2controller {
	@Autowired
	DataInterface d;
	
	@PostMapping(value="/saveMovieRating")
	public ObjectClass saveMovieRating(@RequestBody ObjectClass obj)
	{
		String movieName=obj.getMovieName();
		obj.setMovieName(movieName.toUpperCase());
		ObjectClass savedObject=d.save(obj);
		return savedObject;
	}
	@GetMapping(value="/getAvgRating/{movieId}")
	public ObjectClass getAverageMovieRating(@PathVariable String movieId)
	{
		String movieName=d.getMovieNameByMovieId(movieId);
		double averageRating= d.getAverageMovieRating(movieId);
		ObjectClass result = new ObjectClass();
		result.setMovieId(movieId);
		result.setRating(averageRating);
		result.setMovieName(movieName);
		return result;	
	}
	@GetMapping(value="/getAllRating")
	public List<ObjectClass> getAllRating(){
		return d.findAll();
	}
}
