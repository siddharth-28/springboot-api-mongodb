//package com.stackroute.movieservice.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.stackroute.movieservice.domain.Movie;
//import com.stackroute.movieservice.exceptions.MovieNotFoundException;
//@Qualifier
//@Service
//public class MovieServiceDummy implements MovieService {
//
//	@Override
//	public Movie saveMovie(Movie movie) {
//		System.out.println("movied saved");
//		return null;
//	}
//
//	@Override
//	public List<Movie> getAllMovies() {
//	System.out.println("all movies");
//		return null;
//	}
//
//	@Override
//	public Movie updateMovie(Movie movie, int movieId) {
//		System.out.println("updated movie");
//		return null;
//	}
//
//	@Override
//	public boolean deleteMovie(int movieId) throws MovieNotFoundException {
//		System.out.println("movie deleted");
//		return false;
//	}
//
//	@Override
//	public Movie getById(int movieId) throws MovieNotFoundException {
//		System.out.println("movied id");
//		return null;
//	}
//
//	@Override
//	public List<Movie> getMovieByTitle(String movieTitle) {
//	System.out.println("movie title");
//		return null;
//	}
//
//}
