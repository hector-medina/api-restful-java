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

package udp.client;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;


/**
 * @author Joan-Manuel Marques
 *
 */

public class RemoteMapUDPclient {

	public RemoteMapUDPclient() {
	}
	
	public Map<String, String> getMap (List<Key> keys) {
		Map<String, String> map = new HashMap<String, String>();
		int i = 1;
		for (Key key : keys) {
			LSimLogger.log(
					Level.TRACE,
					"["+i+"] Query for key "+key.getKey()+" at "+ key.getServerAddress() +":"+key.getServerPort()
					);

			String value = get(key.getKey(), key.getServerAddress(), key.getServerPort());

			LSimLogger.log(Level.TRACE, "["+i+"] RemoteMap("+key.getKey()+"): "+ value);
			i++;
			map.put(key.getKey(), value);
		}

		return map;
	}
	
	private String get(String key, String server_address, int server_port){
		LSimLogger.log(Level.INFO, "inici RemoteMapUDPclient.get ");
		LSimLogger.log(Level.TRACE, "key: " + key);
		LSimLogger.log(Level.TRACE, "server_address: " + server_address);
		LSimLogger.log(Level.TRACE, "server_port: " + server_port);
		
		String resposta = null;
		
		/* TODO: implementació de la part client UDP / implementación de la parte cliente UDP */
		
		
		InetAddress adr;						// Dirección de destino
		String mensaje = "";					// Mensaje
		byte[] mensaje_bytes = new byte[256];	// Mensaje en bytes
		DatagramPacket paquete;					// Datagrama a enviar
		
		try {
			 DatagramSocket socket = new DatagramSocket ();			// Inicializamos el socket con puerto aleatorio.
			 adr = InetAddress.getByName(server_address);			// Añadirmos la dirección.
			 mensaje = key;											// El mensaje es la key pasada por parámetro.
			 mensaje_bytes = mensaje.getBytes();					// Pasamos el mensaje a bytes.
			 
			 // Inicializamos el paquete a enviar con los datos correspondientes.
			 paquete = new DatagramPacket(mensaje_bytes, mensaje_bytes.length, adr, server_port);
			 // Se envía el paquete.
			 socket.send(paquete);
			 
			 
			 
			 byte[] respuesta_bytes = new byte[256]; 				// Declaramos un bugger para el datagrama respuesta.
			 // Declaramos e inicializamos el datagrama respuesta con los parámetros esperados.
			 DatagramPacket respuesta = new DatagramPacket(respuesta_bytes, respuesta_bytes.length, adr, server_port);
			 // Recibimos la respuesta.
			 socket.receive(respuesta);
			 
			 // Asignamos el valor recibido a la variable resposta que devolveremos más abajo.
			 resposta = new String(respuesta.getData()).trim();
			 
			 // Cerramos el socket, ya que es UDP y no es orientado a conexión.
			 socket.close();
		}
		catch (Exception ex){
			 LSimLogger.log(Level.INFO, "Error: "+ ex.getMessage());

		}
		
		// Devolvemos la respuesta obtenida.
		return resposta;
	}
}