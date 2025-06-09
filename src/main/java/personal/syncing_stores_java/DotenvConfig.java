package personal.syncing_stores_java;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {
    static {
        Dotenv dotenv = Dotenv.configure().load();
        String mongoUri = dotenv.get("MONGODB_URI");
        System.out.println(".................1."+ mongoUri);
        if (mongoUri == null || mongoUri.isEmpty()) {
            throw new IllegalStateException("MONGODB_URI is not set in the .env file");
        }
        System.setProperty("MONGODB_URI", mongoUri);
        System.out.println("MONGODB_URI: " + System.getProperty("MONGODB_URI"));
    }
}