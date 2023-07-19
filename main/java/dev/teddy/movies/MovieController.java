package dev.teddy.movies;

import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")//any request to this url will be handles by this controller
public class MovieController {

    // I need reference to the service class and autowire annotation too
    @Autowired
    private MovieService movieService;
    @GetMapping
        public  ResponseEntity<List<Movie>>getAllMovies(){
        return  new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);

    }

    @GetMapping("/{imdbId}")
    //lets the framewok know that we will be passing imfo we got in th mapping as a path variable or we will be using the info passed  in the path variable as a object I'd
    public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return  new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId),HttpStatus.OK);

    }
    }

