package fr.diginamic.bll;

import fr.diginamic.bo.entity.Categorie;
import fr.diginamic.bo.entity.Ingredient;
import fr.diginamic.bo.entity.Marque;
import fr.diginamic.bo.entity.Produit;
import fr.diginamic.dal.OpenFoodFactDAO;

import java.util.ArrayList;
import java.util.List;

public class OpenFoodFactService implements OpenFoodFactServiceInterface {

    Produit produit;
    private OpenFoodFactDAO dao;

    public OpenFoodFactService(OpenFoodFactDAO dao) {
        this.dao = dao;
    }

    public void setCategorie(String ligneCategorie) {
        Categorie categorie = new Categorie();
        categorie.setLibelle(ligneCategorie);
        if(dao.getCategorie(ligneCategorie) == null) {
            produit.setCategorie(categorie);
            dao.createCategorie(categorie);
        } else {
            produit.setCategorie(dao.getCategorie(ligneCategorie));
        }
    }

    public void setMarque(String ligneMarque) {
        Marque marque = new Marque();
        marque.setLibelle(ligneMarque);
        if(dao.getMarque(ligneMarque) == null) {
            produit.setMarque(marque);
            dao.createMarque(marque);
        } else {
            produit.setMarque(dao.getMarque(ligneMarque));
        }
    }

    public void setIngredient(String[] ligne) {
        String[] ligneIngredient = ligne[4].split("[,;]");

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
        produit.setIngredients(ingredientList);
    }

}
