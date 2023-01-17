package com.westeros.webapi.controllers;

import com.westeros.data.model.Movie;
import com.westeros.data.repositories.ICatalogData;
import com.westeros.data.repositories.IMoviesEntitiesRepository;
import com.westeros.webapi.contract.MovieDto;
import com.westeros.webapi.services.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.support.RequestContext;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MovieController {

    private final IMovieService movieService;
    private final IMoviesEntitiesRepository repo;

    @PostMapping
    public ResponseEntity saveMovie(@RequestBody MovieDto movie){
        var id = movieService.saveMovie(movie);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(value = "pageSize", required = false) int pageSize,
            @RequestParam(value = "dateTo", required = false)LocalDate date){
        //var result = repo.getAll();
        return ResponseEntity.ok(movieService.getAll());
    }
}
