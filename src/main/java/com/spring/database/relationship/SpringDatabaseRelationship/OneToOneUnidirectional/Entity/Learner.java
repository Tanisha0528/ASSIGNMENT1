package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity;


import javax.persistence.*;


@Entity
@Table(name="Learner")
public class Learner {

    @Id
    @GeneratedValue
    private int learner_id;


    private String learner_first_name;


    private String learner_last_name;


    private String learner_email;


    private String learner_password;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id_ref", referencedColumnName = "course_id")
    private Course course;
    public Learner() {
    }

    public Learner(int learner_id, String learner_first_name, String learner_last_name, String learner_email, String learner_password, Course course) {
        this.learner_id = learner_id;
        this.learner_first_name = learner_first_name;
        this.learner_last_name = learner_last_name;
        this.learner_email = learner_email;
        this.learner_password = learner_password;
        this.course = course;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    @Override
    public String toString() {
        return "Learner{" +
                "learner_id= " + learner_id +
                ", learner_first_name= " + learner_first_name  +
                ", learner_last_name= " + learner_last_name  +
                ", learner_email= " + learner_email  +
                ", learner_password= " + learner_password  +
                ", course_id= " + course  +
                '}';

    }
}
