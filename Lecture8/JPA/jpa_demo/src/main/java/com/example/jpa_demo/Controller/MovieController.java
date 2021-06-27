package com.example.jpa_demo.Controller;

import com.example.jpa_demo.DTO.MovieDto;
import com.example.jpa_demo.DTO.MovieRatingsResponseDto;
import com.example.jpa_demo.DTO.ResponseDto;
import com.example.jpa_demo.Model.Movie;
import com.example.jpa_demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/saveMovie")
    public ResponseDto<String> saveMovie(@RequestBody MovieDto movieDto){
        String status = movieService.saveMovie(movieDto);
        return new ResponseDto<>(status, HttpStatus.OK);
    }


    @GetMapping("/getMoviesRating/{language}")
    public ResponseDto<List<MovieRatingsResponseDto>> getAllMovie(@PathVariable String language){
        List<MovieRatingsResponseDto> movieRatingsResponseDtos = movieService.getAllMovies(language);
        return new ResponseDto<>(movieRatingsResponseDtos,HttpStatus.OK);
    }

}
