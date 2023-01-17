package com.westeros.data.repositories;

import com.westeros.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MoviesRepository extends JpaRepository<Movie, Long> {

    @Query("select movie from Movie movie join fetch movie.genres where movie.id=:id")
    Movie findAllWithRoles(@Param("id")long id);

    List<Movie> findMoviesByReleaseDateAfterAndReleaseDateBefore(LocalDate from, LocalDate to);

    List<Movie> findMoviesByBudgetBetween(int from, int to);

    @Query("SELECT m FROM Movie m WHERE m.releaseDate > :from AND m.releaseDate<:to")
    List<Movie> findByDateRange(
           @Param("from") LocalDate from,
           @Param("to") LocalDate to);
}
