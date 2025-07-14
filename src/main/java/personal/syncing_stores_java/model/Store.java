package personal.syncing_stores_java.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "store")
public class Store {

    @Id
    private String id;
    private String state;
    private String country;
    private String address;

    public Store() {
    }

    public Store(String id, String state, String country, String address) {
        this.id = id;
        this.state = state;
        this.country = country;
        this.address = address;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
