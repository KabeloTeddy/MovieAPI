package dev.teddy.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private  String body;

//custom constructor that conly generates tye body since onjectid are aurogenerated and cant be used in that  class
    public Review(String body) {
       this.body=body;
    }
}
