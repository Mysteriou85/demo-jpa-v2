package fr.diginamic.bll;

import fr.diginamic.bo.entity.*;
import fr.diginamic.dal.OpenFoodFactDAO;

import java.util.ArrayList;
import java.util.List;

public class OpenFoodFactService implements OpenFoodFactServiceInterface {

    Produit produit;
    private OpenFoodFactDAO dao;

    public OpenFoodFactService(OpenFoodFactDAO dao) {
        this.dao = dao;
    }

    public Categorie getCategorie(String ligneCategorie) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(ligneCategorie);
        if(dao.getCategorie(ligneCategorie) == null) {
            dao.createCategorie(categorie);
            return categorie;
        } else {
            return dao.getCategorie(ligneCategorie);
        }
    }

    public Marque getMarque(String ligneMarque) {
        Marque marque = new Marque();
        marque.setLibelle(ligneMarque);
        if(dao.getMarque(ligneMarque) == null) {
            dao.createMarque(marque);
            return marque;
        } else {
            return dao.getMarque(ligneMarque);
        }
    }

    public List<Ingredient> getIngredient(String ligne) {
        String[] ligneIngredient = ligne.split("[,;]");

        List<Ingredient> ingredientList = new ArrayList<>();
        for (String s : ligneIngredient) {
            Ingredient ingredient = new Ingredient();
            ingredient.setLibelle(s.trim().toLowerCase());

            if(dao.getIngredient(ingredient.getLibelle()) == null) {
                ingredientList.add(ingredient);
                dao.createIngredient(ingredient);
            } else {
                ingredientList.add(dao.getIngredient(ingredient.getLibelle()));
            }
        }
        return ingredientList;
    }

    public List<Allergene> getAllergene(String ligne) {
        String[] ligneAllergene = ligne.split("[,;]");

        List<Allergene> allergeneList = new ArrayList<>();
        for (String s : ligneAllergene) {
            Allergene allergene = new Allergene();
            allergene.setLibelle(s.trim().toLowerCase());

            if(dao.getAllergene(allergene.getLibelle()) == null) {
                allergeneList.add(allergene);
                dao.createAllergene(allergene);
            } else {
                allergeneList.add(dao.getAllergene(allergene.getLibelle()));
            }
        }
        return allergeneList;
    }

    public List<Additif> getAdditif(String ligne) {
        String[] ligneAdditif = ligne.split("[,;]");

        List<Additif> additifList = new ArrayList<>();
        for (String s : ligneAdditif) {
            Additif additif = new Additif();
            additif.setLibelle(s.trim().toLowerCase());

            if(dao.getAdditif(additif.getLibelle()) == null) {
                additifList.add(additif);
                dao.createAdditif(additif);
            } else {
                additifList.add(dao.getAdditif(additif.getLibelle()));
            }
        }
        return additifList;
    }

}
