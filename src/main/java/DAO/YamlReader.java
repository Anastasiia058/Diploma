package DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlReader {
    public static boolean getReadConfig() {
        File file = new File("src/main/resources/configuration.yaml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            final ObjectNode node = objectMapper.readValue(file, ObjectNode.class);
            if (node.has("debug")) {
                return node.get("debug").asBoolean();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Method dosent work");
    }
}
