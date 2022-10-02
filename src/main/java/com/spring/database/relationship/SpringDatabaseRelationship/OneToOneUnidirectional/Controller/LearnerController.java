package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Controller;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Learner;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Course;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Service.CourseService;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/learners")
public class LearnerController {
    @Autowired
    LearnerService learnerService;
    @Autowired
    CourseService profileService;

    @GetMapping
    public List<Learner> getAllLearner() {
        return learnerService.findAllLearners();
    }
    @GetMapping("/getlearner/{id}")
    public Learner getLearnerById(@PathVariable int id) {
        return learnerService.findByLearnerId(id);

    }
    @GetMapping("/getlearnercount")
    public long getLearnerCount() {
        return learnerService.findAllLearnersCount();

    }
    @GetMapping("/checklearner/{id}")
    public String checkLearnerById(@PathVariable int id) {
        return learnerService.checkByLearnerId(id);

    }
    @PostMapping("/addlearner")
    //@RequestMapping(method=RequestMethod.POST) //alternative used earlier
    public Learner addLearner(@RequestBody Learner p) {
        // p.setName("Sam");//this will overwrite the name send in the json in postman
        return learnerService.addLearner(p);

    }
    @DeleteMapping("/deletelearner/{id}")
    public void deleteLearner(@PathVariable int id) {
        learnerService.deleteLearnerById(id);

    }

    //one to one relationship
    @PutMapping("/{id}/course/{course_id}")
    public Learner assignDetails(@PathVariable int id, @PathVariable int course_id)
    {
        Course course =profileService.findByCourseId(course_id);
        System.out.println(course);
        return learnerService.assignProfile(id, course);

    }

    /*===============================================================================*/

    //SECTION-2

    @GetMapping("/findByEmailAddressAndLastname")
    public List<Learner> findByEmailAddressAndLastname
            (@RequestBody Map<String,String> learnerdetails)
    {
        //System.out.println(learnerService.findByEmailAddressAndLastname(learnerdetails.get("learner_email").toString(),learnerdetails.get("learner_last_name").toString()));
        return learnerService.findByEmailAddressAndLastname(
                learnerdetails.get("learner_email").toString(),
                learnerdetails.get("learner_last_name").toString()
        );
    }


    @GetMapping("/findDistinctLearnerByLastnameOrFirstname")
    public List<Learner> findDistinctLearnerByLastnameOrFirstname( @RequestBody Map<String,String> learnerdetails)
    {
        return learnerService.findDistinctLearnerByLastnameOrFirstname(
                learnerdetails.get("learner_first_name").toString(),
                learnerdetails.get("learner_last_name").toString()

        );

    }



    @GetMapping("/findByLastnameIgnoreCase")
    public List<Learner> findByLastnameIgnoreCase(@RequestBody Map<String,String> learnerdetails)
    {
        return learnerService.findByLastnameIgnoreCase(
                learnerdetails.get("learner_last_name").toString()

        );

    }

    @GetMapping("/findByLastnameOrderByFirstnameAs")
   public List<Learner> findByLastnameOrderByFirstnameAs(@RequestBody Map<String,String> learnerdetails)
    {
        return learnerService.findByLastnameOrderByFirstnameAs(
                learnerdetails.get("learner_last_name").toString()
        );

    }







}
