import { ActorRole } from './contracts/actor-role';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import {Observable, of, Subject} from 'rxjs';
import {MovieSummary} from './contracts/movie-summary';
import {Movie} from "./contracts/movie";
import {SearchParams} from "./contracts/search-params";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseURL = "http://localhost:8080/api/v1/movies";

  constructor(private httpClient: HttpClient) { }

  getMoviesList(): Observable<MovieSummary[]>{
    return this.httpClient.get<MovieSummary[]>(`${this.baseURL}?pageSize=10`);
  }

  searchMoviesList(searchParams: SearchParams): Observable<MovieSummary[]>{
    let url = `${this.baseURL}?pageSize=${searchParams.pageSize}`;

    if(searchParams.page>1) url+=`&page=${searchParams.page}`;
    if(searchParams.title) url+=`&title=${searchParams.title}`;
    if(searchParams.dateTo)url+=`&dateTo=${searchParams.dateTo}`;
    if(searchParams.dateFrom)url+=`&dateFrom=${searchParams.dateFrom}`;
    if(searchParams.language)url+=`&language=${searchParams.language}`;
    if(searchParams.runtime)url+=`&runtime=${searchParams.runtime}`;

    return this.httpClient.get<MovieSummary[]>(url);
  }



  createMovie(movie: Movie): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, movie);
  }

  getMovieById(id: number): Observable<Movie>{
    return this.httpClient.get<Movie>(`${this.baseURL}/${id}`);
  }

  updateMovie(id: number, movie: Movie): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, movie);
  }

  deleteMovie(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  addActor(movieId:number, actor:ActorRole): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/${movieId}/actors`, actor);
  }

  getActorsList(movieId:number): Observable<ActorRole[]>{
    return this.httpClient.get<ActorRole[]>(`${this.baseURL}/${movieId}/actors`);
  }
}
