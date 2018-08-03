package com.stackroute.movieservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Configuration
public class DBLoader implements CommandLineRunner {
	private MovieRepository movieRepo;
	private Movie movie;

	public DBLoader(MovieRepository movieRepo) {

		this.movieRepo = movieRepo;
	}

	private final Logger logger = LoggerFactory.getLogger(DBLoader.class);

	@Override
	public void run(String... args) throws Exception {
		logger.info("Loading the data..");
		Movie movieObj = new Movie();
		movieObj.setMovieTitle("khiladi");
		movieObj.setMovieId(1);
		movieRepo.save(movieObj);

	}

}
