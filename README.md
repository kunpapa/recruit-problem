# **Recruit-Problem EasyGOband**

Proyecto destinado a la resolución de un problema dado. Consiste en mostrar la máxima cantidad de datos de la respuesta de una API y realizar búsquedas sobre una columna.

Para resolverlo se ha utilizado Spring + Datatables.

El proyecto se puede resolver de otras formas muy simples, pero dado que se busca demostrar la capacidad del programador se intenta generar una arquitectura Front+Backend lo más sencilla y completa.

Para ejecutar completamente el proyecto es suficiente con lanzar el siguiente comando de Maven:
- mvn clean install tomcat:run

Utilizar la siguiente URL para acceder a la página:
- http://localhost:8080/easyGOband/

El resultado es el siguiente:
![enter image description here](https://i.imgur.com/LSx5ik3.png)

Preguntas técnicas
-------

**¿Has aplicado los principios SOLID?**

    - Se han intentado aplicar en la medida de lo posible.
    
**¿Cuánto tiempo has estado pensando y escribiendo los tests del código? Si hubieras tenido mucho más tiempo... ¿que habrías añadido?**

    - Sobre media hora matizando la trayectoria a seguir para finalizar el proyecto para elegir métodos y tecnologías a utilizar. Alrededor de 3 horas teniendo en cuenta la instalación de librerías y puesta a punto del proyecto.
    
    - Si existiera la posibilidad de datos más extensos se hubiera barajado el tratamiento de las búsquedas en el servidor y un sistema de paginación o segmentación de los datos. Mejorado los estilos de la parte Front.
**¿Por qué motivo has elegido el lenguaje que has usado para este test?**

    - Se ha escogido Java para el Backend por comodidad y experiencia, como Framework Spring. La parte de Front se ha utilizado JS y algo de HTML, se han utilizado librerías genéricas como Datatables o jQuery por la sencillez a la hora de mostrar tablas de datos.
    
**¿Cómo mejorarías la API que has usado?**

    - Cambiaria el sistema de autenticación y permitiría directamente realizar búsquedas en el entorno de la API.
    
**¿Qué Framework y lenguaje crees que se ha usado para exponer esta API REST? Consejo: En el protocolo HTTP viaja mucha información**

    - Por lo que veo como entorno se ha utilizado AWS que trabaja con Cloudfront para ofrecer servicios en la nube. La API parece haber sido construida con Node y Express.
    
**¿Crees que esta API soporta peticiones CORS? ¿Cómo has llegado a esa conclusión?**

	- Si, realizando una llamada AJAX desde local a la API. Ejemplo:
		
    $.ajax({
    		url: "https://pnny0h3cuf.execute-api.eu-west-1.amazonaws.com/dev/providers/1",
    		cache: false,
    		type: "GET",
    		headers: {
    			'Authorization':'Basic cJmAc71jah17sgqi1jqaksvaksda='
    		},
    		success: function(response) {
    				alert("yes");
    		},
    		error: function(xhr) {
    				alert("no");
    		}
    	});

**¿En qué infraestructura crees que está alojada la API? ¿Por qué crees que hemos tomado esa decisión?**

	- Está alojada en AWS. Para ofrecer alta disponibilidad y escalabilidad.
  
**¿Cómo rastrearías un problema de rendimiento en producción? ¿Alguna vez has tenido que hacerlo?**

	- Mediante pruebas de estrés. Si, pero han sido más problemas de base de datos e índices.
  
**Descríbete a ti mismo usando JSON.**

    {
      "name" : "Ernesto",
      "age": 28,
      "male": true,
      "country" : "Spain",
      "city" : "Castellón",
      "interests" : [
        "programming",
        "football",
        "beer"
        ]
    }

