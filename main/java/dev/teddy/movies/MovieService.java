package dev.teddy.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //database access methods

    @Autowired //we want the framework to instantiate the ovieRepository class for us,
    //you need the reference of the repository
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {

       // System.out.print(movieRepository.findAll().toString());
        return  movieRepository.findAll();
    }


    public Optional<Movie> singleMovie(String imdbId){
        //Added otional instead of list because the findbyId method may not find the movie ith that id  due to an unknown id or non existing id
        //in those cases it wil have to retun null. We let java know that it might retun null by using <optional>
        return  movieRepository.findMovieByImdbId(imdbId);

    }
}
