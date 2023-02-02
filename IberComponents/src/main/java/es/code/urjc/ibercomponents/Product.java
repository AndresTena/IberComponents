package es.code.urjc.ibercomponents;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Product
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id = null;

    private String description;

    private String features;

    private String image;
    private Float price;

    private Float score;

    public Product(String descipcion, Float score, Float precio, String features, String image) {

        this.description = descipcion;
        this.score = score;
        this.price = precio;
        this.features = features;
        this.image = image;
    }

    public Product() {

    }


    public Float getPrice() {
        return price;
    }

    public Float getScore() {
        return score;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getFeatures() {
        return features;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
