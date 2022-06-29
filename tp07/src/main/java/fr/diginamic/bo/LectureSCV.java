package fr.diginamic.bo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LectureSCV {
    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<String[]> lignes = new ArrayList<>();
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                lignes.add(line.split("\\|"));
            });
            for (String[] ligne : lignes) {
                if (ligne.length == 30) {
                    // *************
                    // * Catégorie *
                    // *************

                    // **********
                    // * Marque *
                    // **********

                    System.out.println(ligne);

                }
            }
        }



        // *
        // * TEST Global
        // *
//        int id = 0;
//
//        do {
//
//            String[] ligne = lines.get(id).split("\\|");
//
//            for (String element : ligne) {
//                System.out.print(element + " | ");
//            }
//
//            id++;
//        } while (lines.iterator().hasNext());

    }
}
