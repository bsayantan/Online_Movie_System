package com.example.movie.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movie.model.ObjectClass;

@RestController
public class moviecontroller {
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(value="/saveMovieRating")
	public ObjectClass saveMovieRating(@RequestBody ObjectClass obj)
	{
		//System.out.println("-----------------"+obj);
		ObjectClass savedObject=restTemplate.postForEntity("http://localhost:8082/saveMovieRating", obj, ObjectClass.class).getBody();
		System.out.println("After postfor entity------"+savedObject);
		return savedObject;
	}
	@GetMapping(value="/getAvgRating/{movieId}")
	public ObjectClass getAverageMovieRating(@PathVariable String movieId)
	{

		ObjectClass searchObject=restTemplate.getForEntity("http://localhost:8082/getAvgRating/"+movieId, ObjectClass.class).getBody();
		return searchObject;
	}
	@GetMapping(value="/getAllRating")
	public List<ObjectClass> getAllRating(){
		List<ObjectClass> list=restTemplate.exchange("http://localhost:8082/getAllRating",HttpMethod.GET,
				  null, new ParameterizedTypeReference<List<ObjectClass>>(){}).getBody();
		return list;
	}
	



}
