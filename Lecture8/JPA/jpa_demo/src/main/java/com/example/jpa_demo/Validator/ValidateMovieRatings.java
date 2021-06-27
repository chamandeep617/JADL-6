package com.example.jpa_demo.Validator;

import com.example.jpa_demo.DTO.MovieDto;
import org.springframework.stereotype.Component;

@Component
public class ValidateMovieRatings {

    public boolean validateMovie(MovieDto movieDto){
        if(movieDto.getRatings() >10 || movieDto.getRatings() < 0) return false;

        return true;
    }
}
