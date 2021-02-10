import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonDemo {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        String carsListJson = "[{\"color\":\"red\", \"type\":\"BMW\", \"euro\": 4}," +
                " {\"color\":\"black\", \"type\":\"lada priora\"}]";

        List<Car> carsList = objectMapper.readValue(carsListJson, new TypeReference<List<Car>>() {});

        carsList.forEach(System.out::println);

        System.out.println("-------- \n");

        carsList.get(0).isRepaired = true;

        System.out.println(
                objectMapper.writeValueAsString(carsList.get(0))
        );

        System.out.println("----чтение без десериализации ---- \n");

        String response = "{\n" +
                " \"name\": \"Ivan\",\n" +
                " \"education\": {\n" +
                "   \"school\": \"School #52\",\n" +
                "   \"university\": [{\n" +
                "     \"degree\": \"master\",\n" +
                "     \"name\": \"SPbGU\"\n" +
                "   }, {}, {}, {}]\n" +
                " }\n" +
                "}\n";

        JsonNode universityName = objectMapper
                .readTree(response)
                .at("/education/university/0/name");

        System.out.println(universityName.asText());

        System.out.println("------- \n");
        Person p = new Person();
        p.setAge(15);
        p.setName("Alex");

        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        System.out.println(
                objectMapper.writeValueAsString(p)
        );
    }
}
