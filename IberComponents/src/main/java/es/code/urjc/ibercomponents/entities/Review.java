package es.code.urjc.ibercomponents.entities;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id ;

    @Column(name = "score", length = 100)
    private long score;



    public Review(long score) {
        this.score = score;
    }

    public Review() {

    }

    public long getScore(){
        return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

}
