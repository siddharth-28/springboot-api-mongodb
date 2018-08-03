package com.stackroute.movieservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.services.MovieService;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {
	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
@RequestMapping(value="/movie", method =RequestMethod.POST, produces = "application/json")
public ResponseEntity<?> saveMovie(@RequestBody Movie movie ) {
	
	Movie movieObj=movieService.saveMovie(movie);
	
	return new ResponseEntity<Movie>(movieObj , HttpStatus.OK);
	
	
}
@RequestMapping(value="/movies", produces = "application/json")
public ResponseEntity<List<Movie>> getMovies(){
	List<Movie> list=movieService.getAllMovies();
	return new ResponseEntity<List<Movie>>(list, HttpStatus.ACCEPTED);
}
@DeleteMapping(value="/movie/{id}", produces = "application/json")
public ResponseEntity<?> delete(@PathVariable int id){
	//Movie movieObj=null;
	try {
		movieService.deleteMovie(id);
	}
	catch(MovieNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
//	movieService.deleteMovie(id);
	return new ResponseEntity<String>("deleted",HttpStatus.BAD_REQUEST);
}
@RequestMapping(value="/movie/{movieId}", method=RequestMethod.PUT, produces="application/json")
public ResponseEntity<?> updateMovie(@RequestBody Movie movie,@PathVariable int movieId){
	Movie movieObj=movieService.updateMovie(movie,movieId);
	return new ResponseEntity<Movie>(movieObj, HttpStatus.ACCEPTED);
}
@RequestMapping(value = "/movie/{movieId}", method = RequestMethod.GET)
public ResponseEntity<?> getMovieById(@PathVariable int movieId) throws MovieNotFoundException {

    Movie movieObj = null;
    try {
        movieObj = movieService.getById(movieId);
    } catch (MovieNotFoundException ex) {
        String result=ex.getMessage();
        return new ResponseEntity<String>(result, HttpStatus.OK);
        }

    return new ResponseEntity<Movie>(movieObj, HttpStatus.OK);
}
@RequestMapping(value="searchName/movie/{mname}" , method=RequestMethod.GET , produces="application/json")
public ResponseEntity<?> getMovieByName(@PathVariable String mname){
    List<Movie> movieList = movieService.getMovieByTitle(mname);
    return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
}

}
