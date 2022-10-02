package com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Repository;

import com.spring.database.relationship.SpringDatabaseRelationship.OneToOneUnidirectional.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
}
