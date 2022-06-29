package fr.diginamic.bo.entity;

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

    // ***************
    // * Constructor *
    // ***************
    public Produit() {
    }

    public Produit(Categorie categorie,
                   Marque marque,
                   String nomProduit,
                   String scoreNutritionnel,
                   List<Ingredient> ingredients,
                   Double energie100g, Double graisse100g, Double sucres100g, Double fibres100g, Double proteines100g,
                   Double sel100g, Double vitA100g, Double vitD100g, Double vitE100g, Double vitK100g, Double vitC100g,
                   Double vitB1100g, Double vitB2100g, Double vitPP100g, Double vitB6100g, Double vitB9100g, Double vitB12100g,
                   Double calcium100g, Double magnesium100G, Double iron100G, Double fer100G, Double betaCarotene100G,
                   String presenceHuilePalme,
                   List<Allergene> allergenes,
                   List<Additif> additifs) {
        this.categorie = categorie;
        this.marque = marque;
        this.nomProduit = nomProduit;
        this.scoreNutritionnel = scoreNutritionnel;
        this.energie100g = energie100g;
        this.graisse100g = graisse100g;
        this.sucres100g = sucres100g;
        this.fibres100g = fibres100g;
        this.proteines100g = proteines100g;
        this.sel100g = sel100g;
        this.vitA100g = vitA100g;
        this.vitD100g = vitD100g;
        this.vitE100g = vitE100g;
        this.vitK100g = vitK100g;
        this.vitC100g = vitC100g;
        this.vitB1100g = vitB1100g;
        this.vitB2100g = vitB2100g;
        this.vitPP100g = vitPP100g;
        this.vitB6100g = vitB6100g;
        this.vitB9100g = vitB9100g;
        this.vitB12100g = vitB12100g;
        this.calcium100g = calcium100g;
        this.magnesium100G = magnesium100G;
        this.iron100G = iron100G;
        this.fer100G = fer100G;
        this.betaCarotene100G = betaCarotene100G;
        this.presenceHuilePalme = presenceHuilePalme;
        this.ingredients = ingredients;
        this.additifs = additifs;
        this.allergenes = allergenes;
    }

    // *****************
    // * Id du produit *
    // *****************
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seqProduit")
    @GenericGenerator(name = "seqProduit", strategy = "increment")
    private Integer id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBELLE_CATEGORIE")
    private Categorie categorie;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBELLE_MARQUE")
    private Marque marque;
    @Column(name = "SCORE_NUTRITIONNEL", length = 2)
    private String scoreNutritionnel;
    @Column(name = "NOM_PRODUIT")
    private String nomProduit;

    // ***********************
    // * Valeur nutritionnel *
    // ***********************

    @Column(name = "ENERGIE_100G")
    private Double energie100g;
    @Column(name = "GRAISSE_100G")
    private Double graisse100g;
    @Column(name = "SUCRES_100G")
    private Double sucres100g;
    @Column(name = "FIBRES_100G")
    private Double fibres100g;
    @Column(name = "PROTEINES_100G")
    private Double proteines100g;
    @Column(name = "SEL_100G")
    private Double sel100g;

    @Column(name = "VITA_100G")
    private Double vitA100g;
    @Column(name = "VITD_100G")
    private Double vitD100g;
    @Column(name = "VITE_100G")
    private Double vitE100g;
    @Column(name = "VITK_100G")
    private Double vitK100g;
    @Column(name = "VITC_100G")
    private Double vitC100g;
    @Column(name = "VITB1_100G")
    private Double vitB1100g;
    @Column(name = "VITB2_100G")
    private Double vitB2100g;
    @Column(name = "VITPP_100G")
    private Double vitPP100g;
    @Column(name = "VITB6_100G")
    private Double vitB6100g;
    @Column(name = "VITB9_100G")
    private Double vitB9100g;
    @Column(name = "VITB12_100G")
    private Double vitB12100g;
    @Column(name = "CALCIUM_100G")
    private Double calcium100g;
    @Column(name = "MAGNESIUM_100G")
    private Double magnesium100G;
    @Column(name = "IRON_100G")
    private Double iron100G;
    @Column(name = "FER_100G")
    private Double fer100G;
    @Column(name = "BETACAROTENE_100g")
    private Double betaCarotene100G;
    @Column(name = "PRESENCE_HUILE_PALME")
    private String presenceHuilePalme;

    // ********
    // * List *
    // ********

    private List<Ingredient> ingredients;
    private List<Additif> additifs;
    private List<Allergene> allergenes;

    // *******************
    // * Getter & Setter *
    // *******************

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public Double getEnergie100g() {
        return energie100g;
    }

    public void setEnergie100g(Double energie100g) {
        this.energie100g = energie100g;
    }

    public Double getGraisse100g() {
        return graisse100g;
    }

    public void setGraisse100g(Double graisse100g) {
        this.graisse100g = graisse100g;
    }

    public Double getSucres100g() {
        return sucres100g;
    }

    public void setSucres100g(Double sucres100g) {
        this.sucres100g = sucres100g;
    }

    public Double getFibres100g() {
        return fibres100g;
    }

    public void setFibres100g(Double fibres100g) {
        this.fibres100g = fibres100g;
    }

    public Double getProteines100g() {
        return proteines100g;
    }

    public void setProteines100g(Double proteines100g) {
        this.proteines100g = proteines100g;
    }

    public Double getSel100g() {
        return sel100g;
    }

    public void setSel100g(Double sel100g) {
        this.sel100g = sel100g;
    }

    public Double getVitA100g() {
        return vitA100g;
    }

    public void setVitA100g(Double vitA100g) {
        this.vitA100g = vitA100g;
    }

    public Double getVitD100g() {
        return vitD100g;
    }

    public void setVitD100g(Double vitD100g) {
        this.vitD100g = vitD100g;
    }

    public Double getVitE100g() {
        return vitE100g;
    }

    public void setVitE100g(Double vitE100g) {
        this.vitE100g = vitE100g;
    }

    public Double getVitK100g() {
        return vitK100g;
    }

    public void setVitK100g(Double vitK100g) {
        this.vitK100g = vitK100g;
    }

    public Double getVitC100g() {
        return vitC100g;
    }

    public void setVitC100g(Double vitC100g) {
        this.vitC100g = vitC100g;
    }

    public Double getVitB1100g() {
        return vitB1100g;
    }

    public void setVitB1100g(Double vitB1100g) {
        this.vitB1100g = vitB1100g;
    }

    public Double getVitB2100g() {
        return vitB2100g;
    }

    public void setVitB2100g(Double vitB2100g) {
        this.vitB2100g = vitB2100g;
    }

    public Double getVitPP100g() {
        return vitPP100g;
    }

    public void setVitPP100g(Double vitPP100g) {
        this.vitPP100g = vitPP100g;
    }

    public Double getVitB6100g() {
        return vitB6100g;
    }

    public void setVitB6100g(Double vitB6100g) {
        this.vitB6100g = vitB6100g;
    }

    public Double getVitB9100g() {
        return vitB9100g;
    }

    public void setVitB9100g(Double vitB9100g) {
        this.vitB9100g = vitB9100g;
    }

    public Double getVitB12100g() {
        return vitB12100g;
    }

    public void setVitB12100g(Double vitB12100g) {
        this.vitB12100g = vitB12100g;
    }

    public Double getCalcium100g() {
        return calcium100g;
    }

    public void setCalcium100g(Double calcium100g) {
        this.calcium100g = calcium100g;
    }

    public Double getMagnesium100G() {
        return magnesium100G;
    }

    public void setMagnesium100G(Double magnesium100G) {
        this.magnesium100G = magnesium100G;
    }

    public Double getIron100G() {
        return iron100G;
    }

    public void setIron100G(Double iron100G) {
        this.iron100G = iron100G;
    }

    public Double getFer100G() {
        return fer100G;
    }

    public void setFer100G(Double fer100G) {
        this.fer100G = fer100G;
    }

    public Double getBetaCarotene100G() {
        return betaCarotene100G;
    }

    public void setBetaCarotene100G(Double betaCarotene100G) {
        this.betaCarotene100G = betaCarotene100G;
    }

    public String getPresenceHuilePalme() {
        return presenceHuilePalme;
    }

    public void setPresenceHuilePalme(String presenceHuilePalme) {
        this.presenceHuilePalme = presenceHuilePalme;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(List<Additif> additifs) {
        this.additifs = additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(List<Allergene> allergenes) {
        this.allergenes = allergenes;
    }
}
