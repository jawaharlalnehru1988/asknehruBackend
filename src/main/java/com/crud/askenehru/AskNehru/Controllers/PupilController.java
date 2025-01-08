package com.crud.askenehru.AskNehru.Controllers;

import com.crud.askenehru.AskNehru.Dto.PupilDTO;
import com.crud.askenehru.AskNehru.Services.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pupils")
public class PupilController {
    @Autowired
    private PupilService pupilService;

    @PostMapping("/create")
    public ResponseEntity<PupilDTO> createPupil(@RequestBody PupilDTO pupil) {
        PupilDTO people = pupilService.savePupil(pupil);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PupilDTO> updatePupil(@RequestBody PupilDTO pupil, @PathVariable Integer id) {
        PupilDTO updatedPupil = pupilService.updatePupil(pupil, id);
        return new ResponseEntity<>(updatedPupil, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<PupilDTO>> getAllCourseOfPupil(){
        List<PupilDTO> pupil = pupilService.getAllCourseOfAPupil();
        return new ResponseEntity<>(pupil, HttpStatus.OK);
    }
}
