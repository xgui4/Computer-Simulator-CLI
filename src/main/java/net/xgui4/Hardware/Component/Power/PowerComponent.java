package net.xgui4.Hardware.Component.Power;

public interface PowerComponent {

    /**
     * le getter de la capacité
     *
     * @return la capacité
     */
    int getCapacity();

    /**
     * Le getter de l'attribut modèle
     *
     * @return la string du model
     */
    String getModel();

    /**
     * Le getter de l'attribut name
     *
     * @return le nom
     */
    String getName();

    /**
     * Le getter de l'attribut manufacturer
     *
     * @return le manufacturier
     */
    String getManufacturer();

    /**
     * Génère les détailles lisible de l'unité d'alimentation.
     *
     * @return les détailles de la batterie
     */
    String getSummary();

    /**
     * Réduit la santé de  l'unité d'alimentation.
     */
    void degradeHealth();
}
