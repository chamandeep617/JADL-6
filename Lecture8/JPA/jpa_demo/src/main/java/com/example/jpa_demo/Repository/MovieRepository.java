package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

//    @Query(value = "",nativeQuery = true)
    public List<Movie> findByLanguage(String language);

}
