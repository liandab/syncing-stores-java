package personal.syncing_stores_java.controller;

import personal.syncing_stores_java.model.Store;

import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/store1/sync")
public class SyncController {
  
  @PostMapping
  public String sync(@RequestBody Store store) {
    // Logic to handle synchronization
    try {
      System.out.println("Received store object: " + store);
      // Convert the Store object to a JSON string
      return new ObjectMapper().writeValueAsString(store);
    } catch (JsonProcessingException e) {
      // Handle the exception and return an error message
      e.printStackTrace(); // Log the exception for debugging
      return "{\"error\": \"Failed to process the store object\"}";
    }
  }
}
