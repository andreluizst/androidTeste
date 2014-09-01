/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursos;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author AndreLuiz
 */
@Path("usuarios")
public class UsuariosRecurso {

    @Context
    private UriInfo context;
    private ArrayList<User> usuarios;

    /**
     * Creates a new instance of UsuariosRecurso
     */
    public UsuariosRecurso() {
        usuarios = new ArrayList();
        usuarios.add(new User(1, "Manoel", "12345"));
        usuarios.add(new User(2, "Marília", "124"));
        usuarios.add(new User(3, "Fulano", "1234567"));
    }

    /**
     * Retrieves representation of an instance of recursos.UsuariosRecurso
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(usuarios);
    }
    
    @Path("{usrID}")
    @GET
    @Produces("application/json")
    public String getUsuario(@PathParam("usrID") String id){
        Gson gson = new Gson();
        for (User u : usuarios){
            if (u.getId() == Long.valueOf(id)){
                return gson.toJson(u);
            }
        }
        return gson.toJson("Usuário não encontrado!");
    }

    /**
     * PUT method for updating or creating an instance of UsuariosRecurso
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
