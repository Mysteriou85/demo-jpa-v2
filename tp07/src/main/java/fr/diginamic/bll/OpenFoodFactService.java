package fr.diginamic.bll;

import fr.diginamic.bo.entity.Categorie;
import fr.diginamic.bo.entity.Produit;
import fr.diginamic.dal.OpenFoodFactDAO;

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

}
