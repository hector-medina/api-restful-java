/*

* Copyright (c) Joan-Manuel Marques 2013. All rights reserved.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This file is part of the practical assignment of Distributed Systems course.
*
* This code is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This code is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this code.  If not, see <http://www.gnu.org/licenses/>.
*/

package tcp.client;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;


/**
 * @author Joan-Manuel Marques
 *
 */

public class HTTPclient {

	public HTTPclient() {
	}
			
	public String get(String http_server_address, int http_server_port){
		LSimLogger.log(Level.INFO, "inici HTTPclient.get ");
		LSimLogger.log(Level.INFO, "HTTP server_address: " + http_server_address);
		LSimLogger.log(Level.INFO, "HTTP server_port: " + http_server_port);

		String resposta = "";
		
		try {
			String peticio = ""; /* TODO: Petició HTTP / Petición HTTP */
			
			// Petición OPTIONS
			peticio += "OPTIONS / HTTP/1.1 \r\n";
			peticio += "Host: "+http_server_address+"  \r\n";
			peticio += "Accept: */* \r\n";
			peticio += "\r\n";

			LSimLogger.log(Level.INFO, peticio);
			
			// Declaramos e inializamos el socket.
			Socket socket = null;											
			socket = new Socket(http_server_address, http_server_port);

			// Declaramos inicializamos los streams de entrada y salida.
		   	BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    DataOutputStream salida = new DataOutputStream(socket.getOutputStream());	    
	
			/* TODO: implementació de la part client TCP / implementación de la parte cliente TCP */
		    
		    // Enviamos la petición al servidor.
		    salida.writeBytes(peticio);
				    
		    // Recorremos la respuesta para imprimirla en pantalla y asignarla a 'resposta'
		    for (String output = entrada.readLine().trim(); !output.equals(""); output = entrada.readLine().trim()) {
		    	LSimLogger.log(Level.INFO,output);
		    	resposta += output + "\r\n";
		    }
		    
		    // Cerramos el socket.
		    socket.close();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Devolvemos la respuesta.
		return resposta;	

	}
}