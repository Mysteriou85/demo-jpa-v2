package fr.diginamic.bo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LectureSCV {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("tp07/src/main/resources/open-food-facts.csv");
        List<String>lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        String[] ligne = lines.get(1).split("\\|");

        for (String element : ligne) {
            System.out.println(element);
        }
    }
}
