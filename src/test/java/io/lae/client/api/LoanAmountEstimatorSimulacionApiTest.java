package io.lae.client.api;

import org.junit.Before;
import org.junit.Test;

import io.lae.client.ApiClient;
import io.lae.client.ApiException;
import io.lae.client.model.CatalogoEstados;
import io.lae.client.model.CatalogoSegmento;
import io.lae.client.model.DomicilioPeticion;
import io.lae.client.model.Persona;
import io.lae.client.model.PeticionFolioConsulta;
import io.lae.client.model.PeticionPersona;
import io.lae.client.model.Respuesta;
import okhttp3.OkHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoanAmountEstimatorSimulacionApiTest {
	
	private Logger logger = LoggerFactory.getLogger(LoanAmountEstimatorSimulacionApiTest.class.getName());
	private final LoanAmountEstimatorSimulacionApi api = new LoanAmountEstimatorSimulacionApi();
	private String xApiKey = "your_api_key";
	
	private ApiClient apiClient = null;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getLAEByPersonTest() throws ApiException {
		PeticionPersona request = new PeticionPersona();
		Persona persona = new Persona();
		DomicilioPeticion domicilio = new DomicilioPeticion();
		
		persona.setPrimerNombre("JUAN");
		persona.setApellidoPaterno("PRUEBA");
		persona.setApellidoMaterno("CUATRO");
		persona.setFechaNacimiento("1980-01-04");
		persona.setRFC("PUAC800104");
		
		domicilio.setDireccion("INSURGENTES SUR 1004");
		domicilio.setColoniaPoblacion("INSURGENTES SUR");
		domicilio.setDelegacionMunicipio("CIUDAD DE MEXICO");
		domicilio.setCiudad("CIUDAD DE MEXICO");
		domicilio.setEstado(CatalogoEstados.CDMX);
		domicilio.setCP("11230");
    	
		persona.setDomicilio(domicilio);
		
		request.setFolioOtorgante("1");
		request.setSegmento(CatalogoSegmento.PP);
		request.setPersona(persona);
		
		Respuesta response = api.getLAEByPerson(this.xApiKey, request);
		logger.info(response.toString());
	}

	@Test
	public void getLAEByFolioConsultaTest() throws ApiException {
		PeticionFolioConsulta request = new PeticionFolioConsulta();
		
		request.setFolioOtorgante("1");
		request.setSegmento(CatalogoSegmento.PP);
		request.setFolioConsulta("386636538");
		
		Respuesta response = api.getLAEByFolioConsulta(this.xApiKey, request);
		logger.info(response.toString());
	}

}
