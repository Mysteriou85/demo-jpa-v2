package fr.diginamic;

import fr.diginamic.bll.OpenFoodFactService;
import fr.diginamic.bo.entity.*;
import fr.diginamic.dal.OpenFoodFactDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        OpenFoodFactDAO dao = new OpenFoodFactDAO(em);
        OpenFoodFactService service = new OpenFoodFactService(dao);

        List<String[]> lignes = new ArrayList<>();
        try (Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                lignes.add(line.split("\\|"));
            });

            int limit = 0;

            for (String[] ligne : lignes) {
                if (ligne.length == 30 && !Arrays.equals(ligne, lignes.get(0)) && limit <= 10) {

                    TypedQuery<Allergene> rechercheAllergene = em.createQuery("SELECT e FROM Allergene e WHERE e.libelle= :libelle", Allergene.class);
                    TypedQuery<Additif> rechercheAdditif = em.createQuery("SELECT e FROM Additif e WHERE e.libelle= :libelle", Additif.class);

                    Produit produit = new Produit();

//                    limit++;
//                    em.getTransaction().begin();

                    // Catégorie
                    Categorie categorie = service.getCategorie(ligne[0]);
                    produit.setCategorie(categorie);

                    // Marque
                    Marque marque = service.getMarque(ligne[1]);
                    produit.setMarque(marque);

                    // Nom
                    produit.setNomProduit(ligne[2]);

                    // Nutrition Grade
                    produit.setScoreNutritionnel(ligne[3]);

                    // Ingrédient (Liste)
                    List<Ingredient> ingredientList = service.getIngredient(ligne[4]);
                    produit.setIngredients(ingredientList);

                    // ***************************
                    // * valeurs nutritionnelles *
                    // ***************************
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

                    // Allergene (Liste)
                    List<Allergene> allergeneList = service.getAllergene(ligne[28]);
                    produit.setAllergenes(allergeneList);

                    // Additif (Liste)
                    List<Additif> additifList = service.getAdditif(ligne[29]);
                    produit.setAdditifs(additifList);

                    // Fin ligne
                    // System.out.println();
                    dao.createProduit(produit);

                    //em.persist(produit);


                } else {
                    System.err.println("Cette valeur n'est pas lisible !");
                }
            }
        }

    }
}
