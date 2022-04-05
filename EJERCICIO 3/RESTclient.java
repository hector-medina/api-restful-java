package xai.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;
import xai.rest.jettyserver.api.Surface;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RESTclient {

	public double surfaceBase(String address, int port, float value1) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/surfaceBase/"+value1);
		LSimLogger.log(Level.INFO, "media type: text/plain");

		/* TODO: Completar el código / Completar el codi */
		
		Client client = ClientBuilder.newClient();
		
		Response respuesta = (Response) client.target( "http://"+address+":"+port+"/cil/surfaceBase/"+value1).request("text/plain").get();

		Double respuestaDouble = Double.parseDouble(respuesta.readEntity(String.class));
				
		return respuestaDouble;
	}
	
	public double surfaceSide(String address, int port, float value1, float value2) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/surfaceSide/"+value1+"/"+value2);
		LSimLogger.log(Level.INFO, "media type: application/json");
		
		/* TODO: Completar el código / Completar el codi */
		
		return Double.MIN_VALUE;
	}

	public Surface surfaceTotal(String address, int port, float value1, float value2) {
		LSimLogger.log(Level.INFO, "http://"+address+":"+port+"/cil/surfaceTotal/"+value1+"/"+value2);
		LSimLogger.log(Level.INFO, "media type: application/json");

		/* TODO: Completar el código / Completar el codi */
		
		return null;
	}
}