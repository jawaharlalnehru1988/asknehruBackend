package com.crud.askenehru.AskNehru.Services;

import com.crud.askenehru.AskNehru.CommentRepository;
import com.crud.askenehru.AskNehru.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto createComment(CommentDto payload);
    public CommentDto updateComment(CommentDto payload, Long id);
    public String deleteById(Long id);
    public List<CommentDto> getAllComments();
    public CommentDto getById(Long id);
}
