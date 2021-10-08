package lilbunnyrabbit.matchmaking.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;

public class DiscordApiHelper {
    public static void printObjectAsJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(object);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static <T> void printRequest(String type, String url, HttpEntity<T> httpEntity) {
        System.out.println(type.toUpperCase() + " " + url);
        System.out.print("- Headers: ");
        System.out.println(httpEntity.getHeaders());
        System.out.print("- Body: ");
        printObjectAsJson(httpEntity.getBody());
    }
}
