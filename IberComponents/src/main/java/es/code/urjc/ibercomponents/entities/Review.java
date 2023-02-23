package es.code.urjc.ibercomponents.entities;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "score", length = 100)
    private int score;

    @Column(length = 10000, name = "comment")
    private String comment;


    public Review(int score) {
        this.score = score;
    }

    public Review() {

    }

    public int getScore(){
        return this.score;
    }

    public String getComment(){
        return this.comment;
    }

    public void setScore(int score){
        this.score = score;
    }

    public void setComment(String comment){
        this.comment = comment;
    }
}
