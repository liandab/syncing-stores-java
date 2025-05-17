package personal.syncing_stores_java.model;

import java.util.Objects;

public class Store {
  private String id;
  private String name;
  private String location;
  
  public Store(String id, String name, String location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  @Override
  public String toString() {
    return "Store{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", location='" + location + '\'' +
            '}';
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Store)) return false;
    Store store = (Store) o;
    return id.equals(store.id) && name.equals(store.name) && location.equals(store.location);
  }
  @Override
  public int hashCode() {
    return Objects.hash(id, name, location);
  }
  
}
