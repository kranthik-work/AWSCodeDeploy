package com.kkalletla.AWSCodeDeploy.resources;

import org.kranthi.application.model.Comment;
import org.kranthi.application.model.Message;
import org.kranthi.application.service.MessageService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value ={MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Singleton
public class MessageResources {

    MessageService msc = new MessageService();
    CommentResource commentResource = new CommentResource();

    @GET
    public List<Message> getMessages(@QueryParam("year") short year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size){

        if(year != 0)
            return msc.getAllMessagesForYear(year);
        if(start >=0 && size >0 )
            return msc.getAllMessagesPaginated(start,size);
        return msc.getMessages();
    }

    @GET
    @Path("/{messageID}")
    public Message getMessage(@PathParam("messageID") Long messageID){
        return msc.getMessage(messageID);
    }

    @POST
    public Message addMessage(Message message){
        return msc.addMessage(message);
    }

    @PUT
    @Path("/{messageID}")
    public Message updateMessage(@PathParam("messageID") Long messageID, Message message){
        message.setId(messageID);
        return msc.updateMessage(message);
    }

    @DELETE
    @Path("/{messageID}")
    public void deleteMessage(@PathParam("messageID") Long messageID){
        msc.removeMessage(messageID);
    }

    @Path("/{messageID}/comments")
    public CommentResource getCommentResource(){
        return commentResource;
    }
}
