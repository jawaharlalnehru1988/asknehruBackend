package com.crud.askenehru.AskNehru.Repositories;

import com.crud.askenehru.AskNehru.Entities.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepository extends JpaRepository<Pupil, Integer> {

}
