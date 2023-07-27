package DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mysql.cj.jdbc.result.ResultSetImpl;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlReader {

    private static String debugLevel;

    public static void printDebug(String debugSting){
        if (debugLevel.equals("debug")){
            System.out.println(LocalDateTime.now() + " debug level: " + debugSting);
        }
    }

/*    public static void printDebug(ResultSet resultSet) throws SQLException {
        ResultSet resultSet1 = new ResultSetImpl(resultSet);
        if (debugLevel.equals("debug")){
            System.out.println(LocalDateTime.now() + "debug level: ");
            List<Map<String, Object>> result = new ArrayList<>();

            while (resultSet.next()) {
                Map<String, Object> resMap = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    resMap.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
                }
                result.add(resMap);
            }
            result.stream().forEach(row -> System.out.println("\t" + row.toString()));
        }
    }*/

    static {
        File file = new File("src/main/resources/configuration.yaml");
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            final ObjectNode node = objectMapper.readValue(file, ObjectNode.class);
            if (node.has("debug")) {
                debugLevel = node.get("debug").asText();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
