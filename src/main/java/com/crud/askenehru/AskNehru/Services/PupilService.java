package com.crud.askenehru.AskNehru.Services;

import com.crud.askenehru.AskNehru.Dto.PupilDTO;

import java.util.List;

public interface PupilService {
 PupilDTO savePupil(PupilDTO pupilDTO);
 PupilDTO updatePupil(PupilDTO pupilDTO, Integer id);
 List<PupilDTO> getAllCourseOfAPupil();

}
