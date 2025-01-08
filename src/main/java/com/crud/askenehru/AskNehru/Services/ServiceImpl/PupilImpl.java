package com.crud.askenehru.AskNehru.Services.ServiceImpl;

import com.crud.askenehru.AskNehru.Dto.CoursesDTO;
import com.crud.askenehru.AskNehru.Dto.PupilDTO;
import com.crud.askenehru.AskNehru.Entities.Courses;
import com.crud.askenehru.AskNehru.Entities.Pupil;
import com.crud.askenehru.AskNehru.Repositories.CoursesRepository;
import com.crud.askenehru.AskNehru.Repositories.PupilRepository;
import com.crud.askenehru.AskNehru.Services.PupilService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class PupilImpl implements PupilService {

    @Autowired
    private PupilRepository pupilRepository;
    private CoursesRepository coursesRepository;

    @Override
    public PupilDTO savePupil(PupilDTO pupilDTO){
          Pupil savePupilData = convertToEntity(pupilDTO);
            Pupil savedPupil = pupilRepository.save(savePupilData);
            return convertToDTO(savedPupil);
    }

    @Override
    public List<PupilDTO> getAllCourseOfAPupil(){
        return pupilRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PupilDTO updatePupil(PupilDTO pupilDTO, Integer id){
        Pupil pupil = pupilRepository.findById(id).orElseThrow(() -> new RuntimeException("Data with the id : " + id + " is not found"));
        pupil.setPupilName(pupilDTO.getPupilName());
        pupil.setAbout(pupilDTO.getAbout());

        if(pupilDTO.getCourses() != null) {
            List<Courses> existingCourses = pupil.getCourses();
            Map<Integer, CoursesDTO> coursesDTOMap = pupilDTO.getCourses().stream().filter(coursesDTO -> coursesDTO.getCourseId() != null )
                    .collect(Collectors.toMap(CoursesDTO::getCourseId, coursesDTO -> coursesDTO));

       // Update or remove existing courses
            existingCourses.removeIf(course -> {
                if(coursesDTOMap.containsKey(course.getCourseId())){
                CoursesDTO coursesDTO = coursesDTOMap.get(course.getCourseId());
                    course.setCourseName(coursesDTO.getCourseName());
                    course.setCourseDuration(coursesDTO.getCourseDuration());
                    course.setCourseDescription(coursesDTO.getCourseDescription());
                    coursesRepository.save(course);
                    coursesDTOMap.remove(course.getCourseId());
                    return false;
                }else{
                    coursesRepository.delete(course);
                    return true;
                }
            });

            // Add new courses (those not already in existing courses)

            for (CoursesDTO coursesDTO : coursesDTOMap.values()) {
                Courses newCourse = new Courses();
                newCourse.setCourseName(coursesDTO.getCourseName());
                newCourse.setCourseDuration(coursesDTO.getCourseDuration());
                newCourse.setCourseDescription(coursesDTO.getCourseDescription());
                newCourse.setPupil(pupil);
                existingCourses.add(newCourse);
            }



        }
        Pupil savePupilData = pupilRepository.save(pupil);
        return convertToDTO(savePupilData);
    }



    private PupilDTO convertToDTO(Pupil pupil){
        if(pupil == null) return null;

        List<CoursesDTO> coursesDTO = new ArrayList<>();
        if(pupil.getCourses() != null) {
            for (Courses courses : pupil.getCourses()) {
                CoursesDTO coursesDTO1 = new CoursesDTO();
                coursesDTO1.setCourseId(courses.getCourseId());
                coursesDTO1.setCourseName(courses.getCourseName());
                coursesDTO1.setCourseDuration(courses.getCourseDuration());
                coursesDTO1.setCourseDescription(courses.getCourseDescription());
                coursesDTO.add(coursesDTO1);
            }
        }

        return new PupilDTO(pupil.getPupilId(), pupil.getPupilName(), pupil.getAbout(), coursesDTO);
    }

    private Pupil convertToEntity(PupilDTO pupilDTO){
        if(pupilDTO == null) return null;

        Pupil pupil = new Pupil();
        if (pupilDTO.getPupilId() != null) {
            pupil.setPupilId(pupilDTO.getPupilId());
        }
        pupil.setPupilName(pupilDTO.getPupilName());
        pupil.setAbout(pupilDTO.getAbout());

        List<Courses> courses = new ArrayList<>();
        if(pupilDTO.getCourses() != null) {
            for (CoursesDTO coursesDTO : pupilDTO.getCourses()) {
                Courses courses1 = new Courses();
                courses1.setCourseName(coursesDTO.getCourseName());
                courses1.setCourseDuration(coursesDTO.getCourseDuration());
                courses1.setCourseDescription(coursesDTO.getCourseDescription());
                courses1.setPupil(pupil);
                courses.add(courses1);
            }
        }

        pupil.setCourses(courses);
        return pupil;

    }

}
