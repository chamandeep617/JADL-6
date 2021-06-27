package com.example.jpa_demo.Assembler;

import com.example.jpa_demo.DTO.MovieDto;
import com.example.jpa_demo.DTO.MovieRatingsResponseDto;
import com.example.jpa_demo.Model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieAssembler {


    public Movie AssembleMovieDtoToMovie(MovieDto movieDto) {
        Movie movie = new Movie();
        movie.setLanguage(movieDto.getLanguage());
        movie.setRatings(movieDto.getRatings());
        movie.setMovieName(movieDto.getMovieName());
        movie.setActive(true);
        movie.setTimeStamp(System.currentTimeMillis());
        return movie;
    }

    public List<MovieRatingsResponseDto> AssembleMovieToMovieRatingsResponseDto(List<Movie> movies){
        List<MovieRatingsResponseDto> movieRatingsResponseDtos = new ArrayList<>();
        for(Movie movie : movies){
            movieRatingsResponseDtos.add(new MovieRatingsResponseDto(movie.getMovieName(), movie.getRatings()));
        }
        return movieRatingsResponseDtos;
    }
}
