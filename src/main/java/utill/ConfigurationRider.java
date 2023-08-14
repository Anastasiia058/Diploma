package utill;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.*;
import java.util.stream.Collectors;

public class ConfigurationRider {
    public Boolean isDebug() throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream("/configuration.yaml");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
             String contents = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
             ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
             final ObjectNode node = objectMapper.readValue(contents, ObjectNode.class);
            if (node.has("debug")) {
                String debugLevel = node.get("debug").asText();
                return debugLevel.equals("debug");
            } else {
                return false;
            }
        }
    }
}