package com.kkalletla.AWSCodeDeploy.service;

import org.kranthi.application.database.DatabaseClass;
import org.kranthi.application.model.Comment;
import org.kranthi.application.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CommentService {

    private Map<Long,Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageID){
        DatabaseClass.convertString();
        return new ArrayList<>(messages.
                               get(messageID).
                               getComments().values());
    }

    public Comment getComment(long messageID, long commentID){
        return messages.get(messageID).
                            getComments().
                            get(commentID);
    }

    public Comment addComment(long messageID, Comment comment){
        Map<Long,Comment> comments = messages.get(messageID).getComments();
        comment.setId(comments.size()+1);
        messages.get(messageID).getComments().put(comment.getId(),comment);
        messages.get(messageID).setComments(comments);
        return comment;
    }

    public Comment updateComment(long messageID, long commentID, Comment comment){
        if(comment.getId() <= 0)
            return null;
        comment.setId(commentID);
        messages.get(messageID).getComments().put(comment.getId(),comment);
        return comment;
    }

    public void deleteComment(long messageID, long comentID){
        messages.get(messageID).getComments().remove(comentID);
    }
}
