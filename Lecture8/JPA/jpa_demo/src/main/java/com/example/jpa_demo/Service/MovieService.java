package com.example.jpa_demo.Service;

import com.example.jpa_demo.Assembler.MovieAssembler;
import com.example.jpa_demo.DTO.MovieDto;
import com.example.jpa_demo.DTO.MovieRatingsResponseDto;
import com.example.jpa_demo.Model.Movie;
import com.example.jpa_demo.Repository.MovieRepository;
import com.example.jpa_demo.Validator.ValidateMovieRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    ValidateMovieRatings validateMovieRatings;

    @Autowired
    MovieAssembler movieAssembler;

    @Autowired
    MovieRepository movieRepository;

    public List<MovieRatingsResponseDto> getAllMovies(String language) {
        List<Movie> movies = movieRepository.findByLanguage(language);
        return movieAssembler.AssembleMovieToMovieRatingsResponseDto(movies);
    }

    public String saveMovie(MovieDto movieDto) {
        if(validateMovieRatings.validateMovie(movieDto)){
            Movie movie = movieAssembler.AssembleMovieDtoToMovie(movieDto);
            movieRepository.save(movie);
            return "Saved the Movie !!";
        }else{
            return "Please enter a valid ratings";
        }
    }
}
