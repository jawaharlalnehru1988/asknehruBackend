package com.crud.askenehru.AskNehru.Controllers;

import com.crud.askenehru.AskNehru.Dto.CommentDto;
import com.crud.askenehru.AskNehru.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:57676" })
public class CommentController {
    @Autowired
    public CommentService commentService;

    @PostMapping("create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto dto){
             CommentDto comment =  commentService.createComment(dto);
             return  new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CommentDto> updateComment(@RequestBody CommentDto dto, @PathVariable Long id){
        CommentDto updatedComment = commentService.updateComment(dto, id);
        return  new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
            String message=  commentService.deleteById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<CommentDto>> getAllComment(){
        List<CommentDto> comments = commentService.getAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<CommentDto> getDataById(@PathVariable Long id){
            CommentDto commentDto = commentService.getById(id);
            return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

}
