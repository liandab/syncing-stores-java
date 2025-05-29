import org.springframework.data.mongodb.repository.MongoRepository;

public interface YourEntityRepository extends MongoRepository<YourEntity, String> {
}

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "your_collection_name")
public class YourEntity {
    @Id
    private String id;
    private String name;

    // Getters and setters
}