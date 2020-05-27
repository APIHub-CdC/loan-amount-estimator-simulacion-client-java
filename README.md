# loan-amount-estimator-simulacion-client-java

Predice el desempeño crediticio futuro para una cuenta específica aprobada previamente. Contiene un conjunto de Scores para cada cuenta representados por un puntaje numérico en un rango definido.

## Requisitos

1. Java >= 1.7
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:

```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***src/test/java/io/lae/client/api/LoanAmountEstimatorSimulacionApiTest.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
@Before()
public void setUp() {
	this.apiClient = api.getApiClient();
	this.apiClient.setBasePath("the_url");
	OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
	apiClient.setHttpClient(okHttpClient);
}
```

En el archivo **LoanAmountEstimatorSimulacionApiTest**, que se encuentra en ***src/test/java/io/lae/client/api/LoanAmountEstimatorSimulacionApiTest.java*** se deberá modificar el siguiente fragmento de código con los datos correspondientes:

```java
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
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```