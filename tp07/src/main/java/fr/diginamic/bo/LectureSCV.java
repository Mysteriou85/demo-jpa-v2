package fr.diginamic.bo;

import fr.diginamic.bo.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LectureSCV {
    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        List<String[]> lignes = new ArrayList<>();
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                lignes.add(line.split("\\|"));
            });

            Produit produit = new Produit();
            Categorie categorie = new Categorie();
            Marque marque = new Marque();
            Ingredient ingredient = new Ingredient();
            Allergene allergene = new Allergene();
            Additif additif = new Additif();

//            em.getTransaction().begin();

            for (String[] ligne : lignes) {
                if (ligne.length == 30 && !Arrays.equals(ligne, lignes.get(0))) {
                    // * Catégorie *
                    // System.out.print("Catégorie: " + ligne[0]);
                    categorie.setLibelle(ligne[0]);
                    produit.setCategorie(categorie);

                    // * Marque *
                    // System.out.print(", Marque: " + ligne[1]);
                    marque.setLibelle(ligne[1]);
                    produit.setMarque(marque);

                    // * Nom *
                    // System.out.print(", Nom: " + ligne[2]);
                    produit.setNomProduit(ligne[2]);

                    // * Nutrition Grade *
                    // System.out.print(", Nutrition Grade:" + ligne[3]);
                    produit.setScoreNutritionnel(ligne[3]);

                    // * Ingrédient (Liste) *
                    // System.out.print(", Ingrédient:[");
                    String[] ligneIngredient = ligne[4].split(", ");
                    List<Ingredient> ingredientList = new ArrayList<>();
                    for (String s : ligneIngredient) {
                        // System.out.print(s);
                        ingredient.setLibelle(s);
                        ingredientList.add(ingredient);
                    }
                    // System.out.print("]");
                    produit.setIngredients(ingredientList);

                    // * valeurs nutritionnelles *
                    produit.setEnergie100g(String.valueOf(ligne[5]));
                    produit.setGraisse100g(String.valueOf(ligne[6]));
                    produit.setSucres100g(String.valueOf(ligne[7]));
                    produit.setFibres100g(String.valueOf(ligne[8]));
                    produit.setProteines100g(String.valueOf(ligne[9]));
                    produit.setSel100g(String.valueOf(ligne[10]));
                    produit.setVitA100g(String.valueOf(ligne[11]));
                    produit.setVitD100g(String.valueOf(ligne[12]));
                    produit.setVitE100g(String.valueOf(ligne[13]));
                    produit.setVitK100g(String.valueOf(ligne[14]));
                    produit.setVitC100g(String.valueOf(ligne[15]));
                    produit.setVitB1100g(String.valueOf(ligne[16]));
                    produit.setVitB2100g(String.valueOf(ligne[17]));
                    produit.setVitPP100g(String.valueOf(ligne[18]));
                    produit.setVitB6100g(String.valueOf(ligne[19]));
                    produit.setVitB9100g(String.valueOf(ligne[20]));
                    produit.setVitB12100g(String.valueOf(ligne[21]));
                    produit.setCalcium100g(String.valueOf(ligne[22]));
                    produit.setMagnesium100G(String.valueOf(ligne[23]));
                    produit.setIron100G(String.valueOf(ligne[24]));
                    produit.setFer100G(String.valueOf(ligne[25]));
                    produit.setBetaCarotene100G(String.valueOf(ligne[26]));

                    produit.setPresenceHuilePalme(ligne[27]);

                    // * Allergene (Liste) *
                    String[] ligneAllergene = ligne[28].split(", ");
                    List<Allergene> allergeneList = new ArrayList<>();
                    for (String s : ligneAllergene) {
                        allergene.setLibelle(s);
                        allergeneList.add(allergene);
                    }
                    produit.setAllergenes(allergeneList);

                    // * Additif (Liste) *
                    String[] ligneAdditif = ligne[29].split(", ");
                    List<Additif> additifList = new ArrayList<>();
                    for (String s : ligneAdditif) {
                        additif.setLibelle(s);
                        additifList.add(additif);
                    }
                    produit.setAdditifs(additifList);

                    // Fin ligne
                    System.out.println();

                } else {
                    System.err.println("Cette valeur n'est pas lisible !");
                }
            }
        }

    }
}
