package rest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.AdDto;
import rest.dto.UserDto;
import dao.IRepositoryCatalog;
import model.Ad;
import model.User;

@Path("ads")
@Stateless
public class AdService {
    IRepositoryCatalog catalog;
    Mapper mapper = new DozerBeanMapper();

    @PersistenceContext
    EntityManager mgr;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdDto> getAll() throws SQLException{

        List<Ad> ads =  mgr.createNamedQuery("ad.all",Ad.class).getResultList();
        List<AdDto> results = new ArrayList<AdDto>();
        for(Ad a: ads)
            results.add(mapper.map(a, AdDto.class));

        return results;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getad(@PathParam("id") int adId){
        Ad a = mgr.createNamedQuery("ad.id", Ad.class)
                .setParameter("adId",adId)
                .getSingleResult();
        if(a==null)
            return Response.status(404).build();

        return	Response.ok(mapper.map(a, AdDto.class)).build();
    }


}