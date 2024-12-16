package com.crud.askenehru.AskNehru.Services.ServiceImpl;

import com.crud.askenehru.AskNehru.Repositories.CommentRepository;
import com.crud.askenehru.AskNehru.Dto.CommentDto;
import com.crud.askenehru.AskNehru.Entities.CommentEntity;
import com.crud.askenehru.AskNehru.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    public CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto payload){
        CommentEntity comment = convertToEntity(payload);
        CommentEntity savedEntity = commentRepository.save(comment);
        return convertToDto(savedEntity);
    }

    @Override
    public CommentDto updateComment(CommentDto payload, Long id){
                 CommentEntity commentEnt =  commentRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Data with the id : " + id + " is not fuond"));
                commentEnt.setPhone(payload.getPhone());
                commentEnt.setUsername(payload.getUsername());
                commentEnt.setComment(payload.getComment());
                commentEnt.setTerms(payload.getTerms());
                CommentEntity comment =  commentRepository.save(commentEnt);
                return convertToDto(comment);
    }
    @Override
    public String deleteById(Long id){
        CommentEntity comment=  commentRepository.findById(id).orElseThrow(()-> new RuntimeException("The data with id : " + id + "not found"));
        commentRepository.delete(comment);
        return "The data with the id " + id + " deleted successfully";

    }

    @Override
    public List<CommentDto> getAllComments(){
            List<CommentEntity> comments = commentRepository.findAll();
            return comments.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CommentDto getById(Long id){
        CommentEntity comment = commentRepository.findById(id).orElseThrow(()-> new RuntimeException("The data with id : " + id + "not found"));
            return convertToDto(comment);
    }


    public CommentEntity convertToEntity(CommentDto payload){
        CommentEntity entity = new CommentEntity();
        entity.setUsername(payload.getUsername());
        entity.setTerms(payload.getTerms());
        entity.setComment(payload.getComment());
        entity.setId(payload.getId());
        entity.setPhone(payload.getPhone());
        return entity;    }

    public CommentDto convertToDto(CommentEntity entity){

        CommentDto commentDto = new CommentDto();
        commentDto.setComment(entity.getComment());
        commentDto.setId(entity.getId());
        commentDto.setPhone(entity.getPhone());
        commentDto.setTerms(entity.getTerms());
        commentDto.setUsername(entity.getUsername());
        return commentDto;
    }
}
