package com.westeros.movies.controllers;

import com.westeros.data.repositories.ICatalogData;
import com.westeros.movies.updater.IUpdateMovies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("updater")
public class UpdaterController{

    private final IUpdateMovies moviesUpdater;

    @GetMapping
    public ResponseEntity<String> update(@RequestParam LocalDate from,@RequestParam LocalDate to){

        moviesUpdater.updateByDateRange(from, to);
        return ResponseEntity.ok("OK");
    }
}
