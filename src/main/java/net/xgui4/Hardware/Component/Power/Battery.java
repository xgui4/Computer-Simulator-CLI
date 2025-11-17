package net.xgui4.Hardware.Component.Power;

/**
 * Cette classe abstraite représente une batterie
 */
public abstract class Battery implements PowerComponent {
    private final String manufacturer;
    private final String model;
    private final String name;
    private int capacity;

    /**
     * Le contructueur de Battery
     *
     * @param capacity -> la capacité de la batterie
     * @param manufacturer -> le manufacturier de la batterie
     * @param model -> le modèle de la batterie
     * @param name -> le nom de la batterie
     */
    public Battery(String manufacturer, String model, String name, int capacity) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = name;
        this.capacity = capacity;
    }

    /**
     * le getter de la capacité
     *
     * @return la capacité
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Le getter de l'attribut modèle
     *
     * @return la string du model
     */
    @Override
    public String getModel() {
        return model;
    }

    /**
     * Le getter de l'attribut name
     *
     * @return le nom
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Le getter de l'attribut manufacturer
     *
     * @return le manufacturier
     */
    @Override
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Génère les détailles lisible de la batterie.
     *
     * @return les détailles de la batterie
     */
    @Override
    public String getSummary() {
        return "Manufacturer : " + getManufacturer() + "\n" +
                "Model : " + getModel() + "\n" +
                "Name : " + getName() + "\n" +
                "Capacity : " + getCapacity() + "\n";
    }

    /**
     * Réduit la santé de la batterie
     */

    @Override
    public abstract void degradeHealth();
}
