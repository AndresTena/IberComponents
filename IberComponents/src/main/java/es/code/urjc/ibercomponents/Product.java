package es.code.urjc.ibercomponents;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Entity
public class Product
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

     //@Column(name = "nombre")
    private String name;

    //@Column(name = "descripcion")
    private String description;

    //@Column(name = "detalles")
    private String features;

    //@Column(name = "imagen")
    private String image;

    //@Column(name = "precio")
    private double price;


    //@Column(name = "puntuacion reviews")
    private double score;

    public Product(String name, String descipcion, double d, int i, String features, String image) {
    	this.name = name;
        this.description = descipcion;
        this.score = d;
        this.price = i;
        this.features = features;
        this.image = image;
    }

    public Product() {

    }


    public double getPrice() {
        return price;
    }

    public double getScore() {
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
