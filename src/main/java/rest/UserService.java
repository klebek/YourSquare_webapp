package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.AdDto;
import rest.dto.UserDto;

import com.sun.org.apache.xml.internal.resolver.Catalog;

import dao.IRepositoryCatalog;
import dao.RepositoryCatalog;
import model.Ad;
import model.User;

@Path("users")
@Stateless
public class UserService {
    IRepositoryCatalog catalog;
    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager mgr;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDto> getAll(){
        List<User> users =  mgr.createNamedQuery("user.all",User.class).getResultList();
        List<UserDto> results = new ArrayList<UserDto>();
        for(User u: users)
            results.add(mapper.map(u, UserDto.class));
        return results;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getuser(@PathParam("id") int userId){
        User u = mgr.createNamedQuery("user.id", User.class)
                .setParameter("userId",userId)
                .getSingleResult();
        if(u==null)
            return Response.status(404).build();

        return	Response.ok(mapper.map(u, UserDto.class)).build();
    }


    @GET
    @Path("/{id}/ads")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdDto> getUserAds(@PathParam("id") int userId){
        User u = mgr.createNamedQuery("user.id", User.class)
                .setParameter("userId",userId)
                .getSingleResult();
        if(u==null)
            return null;
        List<AdDto> result = new ArrayList<AdDto>();
        for(Ad a: u.getAds()){
            result.add(mapper.map(a, AdDto.class));
        }
        return result;
    }
}
