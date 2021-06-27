package com.example.jpa_demo.DTO;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieRatingsResponseDto {
    private String Name;
    private int ratings;
}
