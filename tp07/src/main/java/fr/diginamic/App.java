package fr.diginamic;

import fr.diginamic.bll.OpenFoodFactService;
import fr.diginamic.bo.entity.*;

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

    static OpenFoodFactService service;

    public static void main(String[] args) throws IOException, URISyntaxException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo-jpa");
        EntityManager em = entityManagerFactory.createEntityManager();

        List<String[]> lignes = new ArrayList<>();
        try(Stream<String> stream = Files.lines((Path.of(ClassLoader.getSystemResource("open-food-facts.csv").toURI())), StandardCharsets.UTF_8)) {
            stream.forEach(line -> {
                lignes.add(line.split("\\|"));
            });

            int limit = 0;

            for (String[] ligne : lignes) {
                if (ligne.length == 30 && !Arrays.equals(ligne, lignes.get(0)) && limit <= 10 ) {

                    TypedQuery<Categorie> rechercheCategorie = em.createQuery("SELECT e FROM Categorie e WHERE e.libelle= :libelle", Categorie.class);
                    TypedQuery<Marque> rechercheMarque = em.createQuery("SELECT e FROM Marque e WHERE e.libelle= :libelle", Marque.class);
                    TypedQuery<Ingredient> rechercheIngredient = em.createQuery("SELECT e FROM Ingredient e WHERE e.libelle= :libelle", Ingredient.class);
                    TypedQuery<Allergene> rechercheAllergene = em.createQuery("SELECT e FROM Allergene e WHERE e.libelle= :libelle", Allergene.class);
                    TypedQuery<Additif> rechercheAdditif = em.createQuery("SELECT e FROM Additif e WHERE e.libelle= :libelle", Additif.class);

                    Produit produit = new Produit();
                    Categorie categorie = new Categorie();
                    Marque marque = new Marque();

                    limit++;
                    em.getTransaction().begin();

                    // *************
                    // * Catégorie *
                    // *************
                    categorie.setLibelle(ligne[0]);
                    service.setCategorie(categorie.getLibelle());
//                    rechercheCategorie.setParameter("libelle", categorie.getLibelle());
//
//                    List<Categorie> verifCategorie = rechercheCategorie.getResultList();
//                    if(verifCategorie.isEmpty()) {
//                        produit.setCategorie(categorie);
//                        em.persist(categorie);
//                    } else {
//                        produit.setCategorie(verifCategorie.get(0));
//                    }

                    // **********
                    // * Marque *
                    // **********
                    marque.setLibelle(ligne[1]);
                    service.setMarque(marque.getLibelle());
//                    rechercheMarque.setParameter("libelle", marque.getLibelle());
//
//                    List<Marque> verifMarque = rechercheMarque.getResultList();
//                    if(verifMarque.isEmpty()) {
//                        produit.setMarque(marque);
//                        em.persist(marque);
//                    } else {
//                        produit.setMarque(verifMarque.get(0));
//                    }

                    // *******
                    // * Nom *
                    // *******
                    produit.setNomProduit(ligne[2]);

                    // *******************
                    // * Nutrition Grade *
                    // *******************
                    produit.setScoreNutritionnel(ligne[3]);

                    // **********************
                    // * Ingrédient (Liste) *
                    // **********************
                    String[] ligneIngredient = ligne[4].split("[,;]");
                    List<Ingredient> ingredientList = new ArrayList<>();
                    for (String s : ligneIngredient) {
                        Ingredient ingredient = new Ingredient();
                        ingredient.setLibelle(s.trim().toLowerCase());

                        rechercheIngredient.setParameter("libelle", ingredient.getLibelle());

                        List<Ingredient> verifIngredient = rechercheIngredient.getResultList();
                        if(verifIngredient.isEmpty()) {
                            ingredientList.add(ingredient);
                            em.persist(ingredient);
                        } else {
                            ingredientList.add(verifIngredient.get(0));
                        }
                    }
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

                    // *********************
                    // * Allergene (Liste) *
                    // *********************
                    String[] ligneAllergene = ligne[28].split("[,;]");
                    List<Allergene> allergeneList = new ArrayList<>();
                    for (String s : ligneAllergene) {
                        Allergene allergene = new Allergene();
                        allergene.setLibelle(s.trim().toLowerCase());

                        rechercheAllergene.setParameter("libelle", allergene.getLibelle());

                        List<Allergene> verifAllergene = rechercheAllergene.getResultList();
                        if(verifAllergene.isEmpty()) {
                            allergeneList.add(allergene);
                            em.persist(allergene);
                        } else {
                            allergeneList.add(verifAllergene.get(0));
                        }
                    }
                    produit.setAllergenes(allergeneList);

                    // *******************
                    // * Additif (Liste) *
                    // *******************
                    String[] ligneAdditif = ligne[29].split("[,;]");
                    List<Additif> additifList = new ArrayList<>();
                    for (String s : ligneAdditif) {
                        Additif additif = new Additif();
                        additif.setLibelle(s.trim().toLowerCase());

                        rechercheAdditif.setParameter("libelle", additif.getLibelle());

                        List<Additif> verifAdditif = rechercheAdditif.getResultList();
                        if(verifAdditif.isEmpty()) {
                            additifList.add(additif);
                            em.persist(additif);
                        } else {
                            additifList.add(verifAdditif.get(0));
                        }
                    }
                    produit.setAdditifs(additifList);

                    // Fin ligne
                    // System.out.println();

                    em.persist(produit);

                    em.getTransaction().commit();

                } else {
                    System.err.println("Cette valeur n'est pas lisible !");
                }
            }
        }

    }
}
