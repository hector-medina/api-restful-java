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

package udp.servidor;

import java.nio.ByteBuffer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import edu.uoc.dpcs.lsim.logger.LoggerManager.Level;
import lsim.library.api.LSimLogger;

/**
 * @author Joan-Manuel Marques
 *
 */

public class RemoteMapUDPservidor {
	
	public RemoteMapUDPservidor(int server_port, Map<String, String> map){
		LSimLogger.log(Level.INFO, "Inici RemoteMapUDPservidor ");
		LSimLogger.log(Level.INFO, "server_port: " + server_port);
		LSimLogger.log(Level.INFO, "map: " + map);

		/* TODO: implementació de la part servidor UDP / implementación de la parte servidor UDP */
		
		// Declaramsos e inializamos variable de control. Mientras running sea true, se escuchará en el puerto
		boolean running = true;
			try {
				 // Creamos un socket en el puerto por parámetro.
				 DatagramSocket socket = new DatagramSocket (server_port);
				 // Creamos un buffer donde se almacenará lo que se ha leído del socket. 
				 byte[] buf = new byte[256];
				 // Creamos un paquete
				 DatagramPacket packet = new DatagramPacket(buf, 256); 
				 
				 while(running) {
				 // Leemos del socket y almacenamos en paquete.
				 socket.receive(packet);
				 
				 // Guardamos la petición (key)
				 String paquete_recibido = new String(packet.getData()).trim();
				  
				 // Obtenemos la el objeto a partir de la key.
				 String respuesta = map.get(paquete_recibido);

				 // Tratamos la respuesta como bytes.
				 byte[] respuesta_bytes = respuesta.getBytes();
				 
				 // Declaramos e inicializamos el datagrama de respuesta.
				 DatagramPacket paquete_respuesta = new DatagramPacket(respuesta_bytes, respuesta_bytes.length, packet.getAddress(), packet.getPort());
				 
				 // Enviamos el datagramapor el socket.
				 socket.send(paquete_respuesta);
				 }
				 // Cerramos el socket una vez que running = false
				 socket.close();
			}
			catch (Exception ex){
				 LSimLogger.log(Level.INFO, "Error: "+ ex.getMessage());
			}
	}
}
