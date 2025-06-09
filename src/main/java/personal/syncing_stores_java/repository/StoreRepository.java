package personal.syncing_stores_java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import personal.syncing_stores_java.model.Store;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public interface StoreRepository extends MongoRepository<Store, String> {
}

// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
