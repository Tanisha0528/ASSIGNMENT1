package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Repository;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Integer> {


    @Modifying
    @Query("SELECT l FROM Learner l WHERE l.learner_email = :email AND l.learner_last_name = :last_name")
    List<Learner> findByEmailAddressAndLastname(@Param("email") String email, @Param("last_name") String last_name);



    @Modifying
    //@Query("SELECT DISTINCT  l.learner_first_name,l.learner_last_name FROM Learner l WHERE  l.learner_id in (SELECT l1.learner_id FROM Learner l1 WHERE l1.learner_first_name=:learner_first_name AND l1.learner_last_name= :learner_last_name )  ")
    @Query("SELECT DISTINCT l FROM Learner l WHERE  l.learner_first_name=:learner_first_name AND l.learner_last_name= :learner_last_name")
    List<Learner> findDistinctLearnerByLastnameOrFirstname(@Param("learner_first_name") String learner_first_name,@Param("learner_last_name") String learner_last_name);




    @Modifying
    @Query("SELECT l FROM Learner l WHERE UPPER(l.learner_last_name ) = UPPER(:learner_last_name)")
    List<Learner> findByLastnameIgnoreCase(@Param("learner_last_name") String learner_last_name);

    @Modifying
    @Query("SELECT l FROM Learner l WHERE l.learner_last_name = :learner_last_name ORDER BY l.learner_first_name")
    List<Learner> findByLastnameOrderByFirstnameAs(@Param("learner_last_name") String learner_last_name);

}
