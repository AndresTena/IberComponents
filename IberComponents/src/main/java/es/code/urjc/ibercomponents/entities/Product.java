package es.code.urjc.ibercomponents.entities;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.sql.Blob;
import java.util.List;

@Entity
public class Product
{

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "nombre", length = 100)
    private String name;

    @Column(length = 10000, name = "description")
    private String description;

    @Column(length = 3000)
    private String features;

    @Column(name = "imagen")
    private boolean imageBool;

    @Column(name = "precio")
    private double price;

    @Column(name = "puntuacionReviews")
    private double score;

    @Column(name = "resenas")
    @OneToMany
    private List<Review> reviews;


    public Product(String name, String descipcion, double d, int i, String features) {
        this.name = name;
        this.description = descipcion;
        this.score = d;
        this.price = i;
        this.features = features;
    }

    public Product(String name, String descipcion, double d, int i, String features, String image) {
        this.name = name;
        this.description = descipcion;
        this.score = d;
        this.price = i;
        this.features = features;
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

    public List<Review> getReviews(){return this.reviews;}

    public boolean getImageBool(){return this.imageBool;}

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

    public void setReviews(List <Review> reviews){this.reviews = reviews;}

    public void setImageBool(boolean imageBool){this.imageBool = imageBool;}
}
