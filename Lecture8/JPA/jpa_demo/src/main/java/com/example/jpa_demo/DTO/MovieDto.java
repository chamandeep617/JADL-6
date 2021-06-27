package com.example.jpa_demo.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MovieDto {

    private String movieName;
    private String language;
    private int ratings;

}
