package com.crud.askenehru.AskNehru.Repositories;

import com.crud.askenehru.AskNehru.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
}
