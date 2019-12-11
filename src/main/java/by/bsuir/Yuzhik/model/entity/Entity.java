package by.bsuir.Yuzhik.model.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;

public class Entity  implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    private String id;

    /**
     * Constructor that generate id
     */
    public Entity() {
        this.id = "ID-" + (int) (Math.random() * 20);
    }

    /**
     * Getter for id
     * @return id
     */
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Entity";
    }

}
