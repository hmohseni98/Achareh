package service.impl;

import model.Comment;
import repository.CommentRepository;
import service.CommentService;
import service.base.BaseServiceImpl;

public class CommentServiceImpl extends BaseServiceImpl<CommentRepository, Comment,Integer> implements CommentService {
    public CommentServiceImpl(CommentRepository repository) {
        super(repository, Comment.class);
    }
}
