package com.stackroute.movieservice.services;

import java.util.List;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;

public interface MovieService {
	public Movie saveMovie(Movie movie);
	public List<Movie> getAllMovies();
    public Movie updateMovie(Movie movie, int movieId);
    public boolean deleteMovie(int movieId) throws MovieNotFoundException;
    public Movie getById(int movieId) throws MovieNotFoundException;
    //public Movie getMovieByName(String movieTitle);
	public List<Movie> getMovieByTitle(String movieTitle);
}
