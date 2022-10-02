package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Controller;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Course;
import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }
    @GetMapping("/getcourse/{course_id}")
    public Course getCourseById(@PathVariable int course_id) {
        return courseService.findByCourseId(course_id);

    }
    @GetMapping("/getcoursecount")
    public long getCourseCount() {
        return courseService.findAllCourseCount();

    }@GetMapping("/checkcourse/{course_id}")
    public String checkCourseById(@PathVariable int course_id) {
        return courseService.checkByCourseId(course_id);

    }
    @PostMapping("/addcourse")
    //@RequestMapping(method=RequestMethod.POST) //alternative used earlier
    public Course addCourses(@RequestBody Course p) {
        // p.setName("Sam");//this will overwrite the name send in the json in postman
        return courseService.addCourse(p);

    }
    @DeleteMapping("/deletecourse/{course_id}")
    public void deleteCourse(@PathVariable int course_id) {
        courseService.deleteCourseById(course_id);

    }
}
