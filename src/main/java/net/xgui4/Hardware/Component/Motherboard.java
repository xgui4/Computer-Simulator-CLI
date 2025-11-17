package net.xgui4.Hardware.Component;

import net.xgui4.Exception.*;
import net.xgui4.Hardware.Component.Memory.RAM;
import net.xgui4.Hardware.Component.Memory.StorageDevice;
import net.xgui4.Hardware.Component.Processors.CPU;
import net.xgui4.Hardware.Component.Processors.GPU;
import net.xgui4.Software.Firmware.Firmware;

/**
 * Cette classe représente une carte mère
 */
public class Motherboard {
    private CPU processor;
    private GPU graphicCard;
    private RAM memory;
    private StorageDevice storageDevice;
    private final Firmware firmware;

    /**
     * Contructeur d'une carte mère vide
     * @param firmware : le micrologiciel de la carte mère
     */
    public Motherboard(Firmware firmware) {
        this.processor = null;
        this.graphicCard = null;
        this.memory = null;
        this.storageDevice = null;
        this.firmware = firmware;
    }

    /**
     * Le constructeur avec les composants en paramètre
     * @param processor : le processeur central (CPU)
     * @param graphicCard : la carte graphic dédié (GPU)
     * @param memory : la mémoire vive (RAM)
     * @param storageDevice : le péripérique de stockage
     * @param firmware : le micrologiciel de la carte mère
     */
    public Motherboard(CPU processor, GPU graphicCard, RAM memory, StorageDevice storageDevice, Firmware firmware) {
        this.processor = processor;
        this.graphicCard = graphicCard;
        this.memory = memory;
        this.storageDevice = storageDevice;
        this.firmware = firmware;
    }

    /**
     * Met le processeur dans le socket de la carte mère
     * @param processor : le processeur a placé dans la carte mère
     * @throws SocketAlreadyOccupiedException si le socket a déjà un processeur
     */
    public void putProcessor(CPU processor) {
        if (this.processor == null) this.processor = processor;
        else throw new SocketAlreadyOccupiedException("Cannot add CPU, socket already occupied");
    }

    /**
     * Enlève le processeur de la carte mère
     * @throws EmptySocketException si le socket est vide
     */
    public void removeProcessor() {
        if (this.processor != null) this.processor = null;
        else throw new EmptySocketException("Cannot remove CPU if the CPU socket is empty");
    }

    /**
     * Ajoute la carte graphique a la carte mère
     * @param graphicCard : la carte graphique a ajouté
     * @throws GPUAlreadyOccupiedException si la carte graphique est déja présente
     */
    public void putGraphicCard(GPU graphicCard) {
        if (this.graphicCard == null) this.graphicCard = graphicCard;
        else throw new GPUAlreadyOccupiedException("Cannot add GPU, graphic card already occupied");
    }

    /**
     * Enlève la carte graphique de la carte mère
     * @throws NoGPUFoundException si la carte graphique n'est pas présente
     */
    public void removeGraphicCard() {
        if (this.graphicCard != null) this.graphicCard = null;
        else throw new NoGPUFoundException("Cannot remove GPU : no gpu found");
    }

    /**
     * Ajout un baton de RAM à la carte mère
     * @param memory - le baton de RAM à ajouter
     * @throws MemoryAtMaxCapcityException si la capicité de baton de ram est dépassé
     */
    public void putRAMSick(RAM memory) {
        if (this.memory == null) this.memory = memory;
        else throw new MemoryAtMaxCapcityException("Cannot add ram : ram at full capacity");
    }

    /**
     * Enlève le baton de RAM de la carte mère
     * @throws NoMemoryException s'il n'y a pas de de baton de RAM
     */
    public void removeRAMStick() {
        if (this.graphicCard != null) this.graphicCard = null;
        else throw new NoMemoryException("Cannot remove RAM: no ram stick found");
    }

    /**
     * Ajout un périphériqye de stockage la carte mère
     * @param storageDevice - le prériphérique de stockage à ajouter
     * @throws NoFreeStorageConnectorLeftException s'il y a déjà un périphérique de stockage dans la carte mère
     */
    public void putStorageDevice(StorageDevice storageDevice) {
        if (this.storageDevice == null) this.storageDevice = storageDevice;
        else throw new NoFreeStorageConnectorLeftException("Cannot add Storage Device : no free storage device connector found");
    }

    /**
     * Enlève le périphérique de stockage de la carte mère
     * @throws NoStorageException s'il n'y a pas de de périphérique de stockage de la carte mère
     */
    public void removeStorageDevice() {
        if (this.storageDevice != null) this.storageDevice = null;
        else throw new NoStorageException("Cannot remove Storage Device : no Storage Device found");
    }

    /**
     * le gettet du processeur
     * @return processor - le processeur central (CPU)
     * @throws EmptySocketException si le socket du CPU est vide
     */
    public CPU getProcessor() {
        if (processor ==  null) throw new EmptySocketException("Cannot get the CPU, the socket is empty");
        return processor;
    }

    /**
     * Le getter de la carte graphic
     * @return graphicCard - lc carte graphique dédié (GPU)
     * @throws NoGPUFoundException si aucune GPU trouvé
     */
    public GPU getGraphicCard() {
        if (graphicCard == null) throw new NoGPUFoundException("No GPU Found");
        return graphicCard;
    }

    /**
     * Le getter de la mémoire vive (RAM)
     * @return memory - RAM
     * @throws NoMemoryException si la mémoire est vide
     */
    public RAM getMemory() {
        if (memory == null) throw new NoMemoryException("No RAM sick connected to the motherboard found");
        return memory;
    }

    /**
     * Le getter de périphérique de stockage
     * @return storageDevice - le préiphérique de stockage
     * @throws NoStorageException - si aucun périphérique de stockage trouvé
     */
    public StorageDevice getStorageDevice() {
        if (storageDevice == null) throw new NoStorageException("No storage device detected");
        return storageDevice;
    }

    /**
     *  Le getter du firmware
      * @return fimware - le micrologiciel de la carte mère
     */
    public Firmware getFirmware() {
        return firmware;
    }
}
