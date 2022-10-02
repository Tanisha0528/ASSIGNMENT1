package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity;

import javax.persistence.*;

@Entity
@Table(name="LearnerJDBC")
public class LearnerJDBC {

    @Id
    @Column(name="learner_id")
    private int learner_id;

    @Column(name="learner_first_name")
    private String learner_first_name;
    @Column(name="learner_last_name")
    private String learner_last_name;
    @Column(name="learner_email")
    private String learner_email;
    @Column(name="learner_password")
    private String learner_password;

    public LearnerJDBC() {
    }

    public LearnerJDBC(int learner_id, String learner_first_name, String learner_last_name, String learner_email, String learner_password) {
        this.learner_id = learner_id;
        this.learner_first_name = learner_first_name;
        this.learner_last_name = learner_last_name;
        this.learner_email = learner_email;
        this.learner_password = learner_password;
        }

    public int getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(int learner_id) {
        this.learner_id = learner_id;
    }

    public String getLearner_first_name() {
        return learner_first_name;
    }

    public void setLearner_first_name(String learner_first_name) {
        this.learner_first_name = learner_first_name;
    }

    public String getLearner_last_name() {
        return learner_last_name;
    }

    public void setLearner_last_name(String learner_last_name) {
        this.learner_last_name = learner_last_name;
    }

    public String getLearner_email() {
        return learner_email;
    }

    public void setLearner_email(String learner_email) {
        this.learner_email = learner_email;
    }

    public String getLearner_password() {
        return learner_password;
    }

    public void setLearner_password(String learner_password) {
        this.learner_password = learner_password;
    }



    @Override
    public String toString() {
        return "Learner{" +
                "learner_id= " + learner_id +
                ", learner_first_name= " + learner_first_name  +
                ", learner_last_name= " + learner_last_name  +
                ", learner_email= " + learner_email  +
                ", learner_password= " + learner_password  +
                '}';

    }

}
