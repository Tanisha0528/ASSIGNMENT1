package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Repository;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Learner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Learner> getAllLearner()
    {
        String getAllLearnersQuery="SELECT * FROM LearnerJDBC";
        return jdbcTemplate.query(getAllLearnersQuery,new BeanPropertyRowMapper<Learner>(Learner.class));
    }
    public Learner getLearnerById(int learner_id)
    {
        String getLearnerByIdQuery="SELECT * FROM LearnerJDBC WHERE learner_id= ?";

        return jdbcTemplate.queryForObject(getLearnerByIdQuery, new BeanPropertyRowMapper<Learner>(Learner.class),new Object[]{learner_id});
    }
    public int insertLearner(Learner learner)
    {
        String insertLearnerQuery="INSERT INTO LearnerJDBC VALUES (?,?,?,?,?,?)";

        return jdbcTemplate.update(insertLearnerQuery,new Object[]{learner.getLearner_id(),learner.getLearner_first_name(),learner.getLearner_last_name(),learner.getLearner_email(),learner.getLearner_password(),learner.getCourse()});
    }


    public int updateLearner(Learner learner)
    {
        String updateLearnerQuery="Update LearnerJDBC "+" SET learner_first_name=?,learner_last_name=?,learner_email=?,learner_password=?,course=?"+" WHERE learner_id=?";
        // will return 1 after updation
        return jdbcTemplate.update(updateLearnerQuery,new Object[]{learner.getLearner_first_name(),learner.getLearner_last_name(),learner.getLearner_email(),learner.getLearner_password(),learner.getCourse(),learner.getLearner_id()});
    }

    public int deleteLearnerById(int learner_id)
    {
        String deleteLearnerByIdQuery="DELETE  FROM LearnerJDBC WHERE learner_id= ?";


        return jdbcTemplate.update(deleteLearnerByIdQuery,new Object[]{learner_id});
    }
}
