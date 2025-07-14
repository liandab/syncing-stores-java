package personal.syncing_stores_java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import personal.syncing_stores_java.model.Store;
import personal.syncing_stores_java.repository.StoreRepository;
import personal.syncing_stores_java.services.CacheConnector;

@RestController
@RequestMapping("/store1/sync")
public class SyncController {

    @Autowired
    private CacheConnector cacheConnector;

    @Autowired
    private StoreRepository storeRepository;

    @PostMapping
    public String sync(@RequestBody Store store) {
        try {
            System.out.println("Received store object: " + store);
            return new ObjectMapper().writeValueAsString(store);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{\"error\": \"Failed to process the store object\"}";
        }
    }

    @GetMapping("/redis/test")
    public String testRedis() {
        String key = "ping";
        String value = "{\"msg\": \"pong\"}";
        cacheConnector.apply(key, value, false);
        return cacheConnector.getCache(key);
    }

    @GetMapping("/mongo/test")
    public String testMongo() {
        Store store = new Store("test1", "Maharashtra", "India", "Bandra");
        storeRepository.save(store);
        return storeRepository.findById("test1").map(Store::toString).orElse("Not found");
    }
}
