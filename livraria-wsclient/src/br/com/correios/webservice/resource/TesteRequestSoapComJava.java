package br.com.correios.webservice.resource;

import java.rmi.RemoteException;

public class TesteRequestSoapComJava {

	public static void main(String[] args) throws RemoteException {

		Eventos eventosWS = new Eventos();
		
		System.out.println(eventosWS.getCidade());

		//Destinos[] destinos = eventosWS.getDestino();
		
		//System.out.println(destinos);
		
		/*for (Destinos destino : destinos) {
			System.out.println(destino.getCidade());
			System.out.println(destino.getUf());
		}*/
	}

}
