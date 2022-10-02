package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Service;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Course;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Learner;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAllCourses()
    {
        return courseRepository.findAll();
    }
    public Course findByCourseId(int course_id)
    {
        Optional<Course>op= courseRepository.findById(course_id);
        Course p=null;
        if(op.isPresent()) {
            p=op.get();
        }
        else
        {

            throw   new RuntimeException("Course with id: "+course_id+" not found!");
        }
        return p;
    }
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    public void deleteCourseById(int course_id)
    {
        Optional<Course>op=courseRepository.findById(course_id);
        if(op.isEmpty()) {
            throw new RuntimeException("course_id with id: " + course_id + " not found!");
        }
        courseRepository.delete(op.get());
    }
    public long findAllCourseCount()
    {
        List<Course> list=courseRepository.findAll();
        long no=list.stream().count();
        return no;

    }

    public String checkByCourseId(int course_id)
    {
        Optional<Course>op= courseRepository.findById(course_id);
        Course p=null;
        if(op.isPresent()) {
            return "Course with id= "+course_id +" Exists!!!";
        }
        else
        {

            throw   new RuntimeException("Course_id with id: "+course_id+" not found!");
        }

    }

}
