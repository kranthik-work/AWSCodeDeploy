package com.kkalletla.AWSCodeDeploy.resources;

import com.kkalletla.AWSCodeDeploy.model.Comment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    CommentService commentService = new CommentService();

    @GET
    public List<Comment> getComment(@PathParam("messageID")long messageID){
        return commentService.getAllComments(messageID);
    }

    @GET
    @Path("/{commentID}")
    public Comment getComment(@PathParam("messageID")long messageID,
                              @PathParam("commentID") long commentID){
        return commentService.getComment(messageID,commentID);
    }

    @POST
    public Comment addComment(@PathParam("messageID")long messageID, Comment comment){
        return commentService.addComment(messageID,comment);
    }

    @PUT
    @Path("/{commentID}")
    public Comment updateComment(@PathParam("messageID")long messageID,
                                 @PathParam("commentID") long commentID,
                                 Comment  comment){
        return commentService.updateComment(messageID,commentID,comment);
    }

    @DELETE
    @Path("/{commentID}")
    public void deleteComment(@PathParam("messageID")long messageID,
                              @PathParam("commentID") long commentID){
        commentService.deleteComment(messageID,commentID);
    }
}
