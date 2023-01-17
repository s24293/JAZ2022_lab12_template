package com.westeros.data.repositories;

import com.westeros.data.model.Movie;

import java.util.List;

public interface IMoviesEntitiesRepository {
    List<Movie> getAll(String byTitle);
}
