package xai.rest.jettyserver.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */
@Path("/cil")
public class RestServerAPI {

	private static final double PI = 3.1416;
	
	/**
	 * Calculates cilinder's surface of the base
	 *
	 * @param num_1
	 * @param num_2
	 * @return
	 */
	@GET
	@Path("/surfaceBase/{num_1}")
	@Produces(MediaType.TEXT_PLAIN)
	public String surfaceBase(@PathParam("num_1") float rad) {
		LSimLogger.log(Level.INFO, "surfaceBase");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);

		double result = Integer.MIN_VALUE;
		
		/* TODO: Completar el código / Completar el codi */
		
		result = PI * rad * rad;
		
		LSimLogger.log(Level.INFO, "resultado: "+result);
				
		return Double.toString(result); 
		/* TODO: Completar el código / Completar el codi */
	}

	/**
	 * Calculates cilinder's surface of the side
	 *
	 * @param num_1
	 * @param num_2
	 * @return
	 */
	@GET
	@Path("/surfaceSide/{num_1}/{num_2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String surfaceSide(@PathParam("num_1") float rad, @PathParam("num_2") float alt) {

		LSimLogger.log(Level.INFO, "surfaceSide");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);
		LSimLogger.log(Level.INFO, "alt (num_2): "+alt);

		Object obj = null;

		/* TODO: Completar el código / Completar el codi */

		double result = 2 * PI * rad * alt;
		
		com.google.gson.Gson gson = new com.google.gson.Gson();
				
		return gson.toJson(result); /* TODO: Completar el código / Completar el codi */
	}

	/**
	 * Calculates cilinder's surface
	 *
	 * @param num_1
	 * @param num_2
	 * @return a json object containing the parameters and the result
	 */
	@GET
	@Path("/surfaceTotal/{num_1}/{num_2}")
	@Produces(MediaType.APPLICATION_JSON)
	public String surfaceTotal (@PathParam("num_1") float rad, @PathParam("num_2") float alt) {
		LSimLogger.log(Level.INFO, "surface total");
		LSimLogger.log(Level.INFO, "rad (num_1): "+rad);
		LSimLogger.log(Level.INFO, "alt (num_2): "+alt);

		Surface result = new Surface(rad, alt);

		/* TODO: Completar el código / Completar el codi */
		
		com.google.gson.Gson gson = new com.google.gson.Gson();
		
		return gson.toJson(result); /* TODO: Completar el código / Completar el codi */
	}
}
