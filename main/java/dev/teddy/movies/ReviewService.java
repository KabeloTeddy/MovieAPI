package dev.teddy.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    //I will first look for the movie using the given imdbId and then create a new review
    //and asciate that review with the found movie
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public  Review createReview(String reviewBody, String imdbId){
//        Review review = new Review(reviewBody);
        //when you cann insert it returns the data you just pushed in your database
        Review review= reviewRepository.insert(new Review(reviewBody));

        //associate these two with one of the movies  desired


        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return  review;

    }
}
