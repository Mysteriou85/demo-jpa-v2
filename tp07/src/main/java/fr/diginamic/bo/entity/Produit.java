package fr.diginamic.bo.entity;

import fr.diginamic.bo.entity.elementProduit.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {

    // Ordre dans le CSV :
    // 1 : categorie | 2 : marque | 3 : nom | 4 : nutritionGradeFr | 5 : ingredients |
    // 6 : energie100g | 7 : graisse100g | 8 : sucres100g | 9 : fibres100g |
    // 10 : proteines100g | 11 : sel100g | 12 : vitA100g | 13 : vitD100g |
    // 14 : vitE100g | 15 : vitK100g | 16 : vitC100g | 17 : vitB1100g |
    // 18 : vitB2100g | 19 : vitPP100g | 20 : vitB6100g | 21 : vitB9100g |
    // 22 : vitB12100g | 23 : calcium100g | 24 : magnesium100g | 25 : iron100g |
    // 26: fer100g | 27 : betaCarotene100g | 28 : presenceHuilePalme |
    // 29 : allergenes | 30 : additifs |

    // *****************
    // * Id du produit *
    // *****************
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqProduit")
    @GenericGenerator(name = "seqProduit", strategy = "increment")
    private Integer id;

    @Column(name = "CATEGORIE")
    private Categorie categorie;
    @Column(name = "MARQUE")
    private Marque marque;
    @Column(name = "SCORE_NUTRITIONNEL", length = 2)
    private String scoreNutritionnel;

    // ***********************
    // * Valeur nutritionnel *
    // ***********************

    @Column(name = "ENERGIE_100G")
    private String energie100g;
    @Column(name = "GRAISSE_100G")
    private String graisse100g;
    @Column(name = "SUCRES_100G")
    private String sucres100g;
    @Column(name = "FIBRES_100G")
    private String fibres100g;
    @Column(name = "PROTEINES_100G")
    private String proteines100g;
    @Column(name = "SEL_100G")
    private String sel100g;

    @Column(name = "VITA_100G")
    private String vitA100g;
    @Column(name = "VITD_100G")
    private String vitD100g;
    @Column(name = "VITE_100G")
    private String vitE100g;
    @Column(name = "VITK_100G")
    private String vitK100g;
    @Column(name = "VITC_100G")
    private String vitC100g;
    @Column(name = "VITB1_100G")
    private String vitB1100g;
    @Column(name = "VITB2_100G")
    private String vitB2100g;
    @Column(name = "VITPP_100G")
    private String vitPP100g;
    @Column(name = "VITB6_100G")
    private String vitB6100g;
    @Column(name = "VITB9_100G")
    private String vitB9100g;
    @Column(name = "VITB12_100G")
    private String vitB12100g;
    @Column(name = "CALCIUM_100G")
    private String calcium100g;
    @Column(name = "MAGNESIUM_100G")
    private String magnesium100G;
    @Column(name = "IRON_100G")
    private String iron100G;
    @Column(name = "FER_100G")
    private String fer100G;
    @Column(name = "BETACAROTENE_100g")
    private String betaCarotene100G;
    @Column(name = "PRESENCE_HUILE_PALME")
    private String presenceHuilePalme;

    // ********
    // * List *
    // ********

    private List<Ingredient> ingredients;
    private List<Additif> additifs;
    private List<Allergene> allergenes;
}
