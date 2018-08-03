package com.stackroute.movieservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.repository.MovieRepository;

@Qualifier
@Service
public class MovieServiceImpl implements MovieService {
	MovieRepository movieRepo;

	@Autowired
	
	public MovieServiceImpl(MovieRepository movieRepo) {
		this.movieRepo = movieRepo;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		/*
		 * 1 step1: save in cloud step2: save to a database step3: send to mail service
		 */
		Movie movieObj = movieRepo.save(movie);

		return movieObj;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = (List<Movie>) movieRepo.findAll();
		return movieList;
	}

	@Override
	public Movie updateMovie(Movie movie, int movieId) {
		movie.setMovieId(movieId);
		movieRepo.save(movie);
		return movie;
	}

	@Override
	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
		Optional<Movie> movieObj = movieRepo.findById(movieId);
		if (!(movieObj.isPresent())) {
			throw new MovieNotFoundException("Movie is not found");
		} else {
			movieRepo.deleteById(movieId);
			return true;
		}
	}

	@Override
	public Movie getById(int movieId) throws MovieNotFoundException {
		Optional<Movie> movieObj = movieRepo.findById(movieId);
		if (!(movieObj.isPresent())) {

			throw new MovieNotFoundException("Could not find movie");
		} else {
			return movieObj.get();
		}

	}

	@Override
	public List<Movie> getMovieByTitle(String movieTitle) {
		List<Movie> movieList = movieRepo.getMovieByTitle(movieTitle);
		return movieList;
	}

}
