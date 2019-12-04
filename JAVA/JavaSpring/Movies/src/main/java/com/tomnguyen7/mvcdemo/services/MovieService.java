package com.tomnguyen7.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tomnguyen7.mvcdemo.models.Movie;
import com.tomnguyen7.mvcdemo.repositories.MovieRepository;

@Service
public class MovieService {
	private final MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> findAllMovies(){
		return this.movieRepository.findAll();
	}
	
	public Movie createMovie(Movie m) {
		return this.movieRepository.save(m);
	}
	
	public Movie findMovieById(Long id) {
		Optional<Movie> movieOptional = this.movieRepository.findById(id);
		if(movieOptional.isPresent()) {
			return movieOptional.get();
		}else {
			return null;
		}
	}
}
