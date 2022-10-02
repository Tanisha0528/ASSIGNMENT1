package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Service;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Learner;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Course;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepository learnerRepository;

    //section-1
    public List<Learner> findAllLearners()
    {
        return learnerRepository.findAll();
    }
    public Learner findByLearnerId(int learner_id)
    {
        Optional<Learner>op= learnerRepository.findById(learner_id);
        Learner p=null;
        if(op.isPresent()) {
            p=op.get();
        }
        else
        {

            throw   new RuntimeException("Learner with id: "+learner_id+" not found!");
        }
        return p;
    }
    public Learner addLearner(Learner learner) {
        return learnerRepository.save(learner);
    }
    public void deleteLearnerById(int learner_id)
    {
        Optional<Learner>op=learnerRepository.findById(learner_id);
        if(op.isEmpty()) {
            throw new RuntimeException("Learner with id: " + learner_id + " not found!");
        }
        learnerRepository.delete(op.get());
    }
    public Learner assignProfile(int learner_id, Course course)
    {
        Optional<Learner>op=learnerRepository.findById(learner_id);
        if(op.isEmpty()) {
            throw new RuntimeException("Learner with id: " + learner_id + " not found!");
        }
        Learner p=op.get();
        p.setCourse(course);
       return learnerRepository.save(p);
    }

    public long findAllLearnersCount()
    {
        List<Learner> list=learnerRepository.findAll();
        long no=list.stream().count();
        return no;

    }

    public String checkByLearnerId(int learner_id)
    {
        Optional<Learner>op= learnerRepository.findById(learner_id);
        Learner p=null;
        if(op.isPresent()) {
            return "Learner with id= "+learner_id+ " Exists!!!";
        }
        else
        {

            throw   new RuntimeException("Learner with id: "+learner_id+" not found!");
        }

    }


    /*==============================================================================================*/
    //Section-2

    @Transactional
    public List<Learner> findByEmailAddressAndLastname
            (String email, String last_name)
    {
        return learnerRepository.findByEmailAddressAndLastname(email,last_name);
    }


    @Transactional
    public List<Learner> findDistinctLearnerByLastnameOrFirstname(String learner_first_name,String learner_last_name)
    {
        return learnerRepository.findDistinctLearnerByLastnameOrFirstname(learner_first_name,learner_last_name);

    }



    @Transactional
   public List<Learner> findByLastnameIgnoreCase(String learner_last_name)
    {
        return learnerRepository.findByLastnameIgnoreCase(learner_last_name);

    }

    @Transactional
    public List<Learner> findByLastnameOrderByFirstnameAs(String learner_last_name)
    {
        return learnerRepository.findByLastnameOrderByFirstnameAs(learner_last_name);

    }



}
