package org.dmetzler.isen.puissance4.jaxrs;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.dmetzler.isen.puissance4.jpa.Puissance4Adapter;

public class Puissance4GameResource {


    @Context
    UriInfo info;

    private Puissance4Adapter game;

    public Puissance4GameResource(Puissance4Adapter game) {
        this.game = game;
    }


    @GET
    public Puissance4Adapter  doGet() throws IOException {
        return game;
    }


    @POST
    @Path("{srcCol}/{srcRow}/{destCol}/{destRow}/")
    public Response playColumn(@PathParam("srcCol") int srcCol, @PathParam("srcRow") int srcRow,@PathParam("destCol") int destCol, @PathParam("destRow") int destRow ) throws IOException {
        game.play(game.getCurrentTurn(), srcCol, srcRow,destCol, destRow);
        return Response
                .status(Response.Status.SEE_OTHER)
                .header(HttpHeaders.LOCATION,
                        info.getBaseUri() + game.getToken())
                .build();

    }


}
