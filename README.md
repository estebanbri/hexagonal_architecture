# Arquitectura Hexagonal

> En el paquete application esta toda el funcionalidad de negocio y modelo sin estar atado a ningun framework.
> En el paquete adapters esta la capa de input y output (aca si va la configuracion para aplicarle funcionalidades 
> de frameworks a tus clases dentro del paquete application)
> 
> Los puertos son interfaces, que van a ser implementados.
> Los servicios van a implementar los puertos IN.
> Los input adapters van a usar los puertos IN.
> Los output adapters van a implementar los puertos OUT.


Fuente:
https://github.com/jivimberg/hexagonal-architecture/tree/master/src/main/java/io/jivimberg/hexagonalarchitecture

# Arquitectura Hexagonal
Cada una de estas secciones podes definirlas en paquetes diferente dentro de un mismo proyecto
o bien podes hacer que cada uno sea un proyecto por si mismo (es decir que cada uno tenga su jar y 
despues los unis como dependencias de maven) 

## Domain
Es cualquier cosa que vamos compartir entre el CORE de la aplicación y los PORTS.
En el DOMAIN vamos a encontrar lo siguiente:
- __domain__
  - __data__: Para la transferencia de data en nuestro caso vamos a usar DTO's. (Ej: AlumnoDTO.class)
  - __exception__: Definimos la excepciones (Ej: AlumnoNotFoundException.class)
  - __port__: 
    - outbound: interface para flujo de salida del dominio. (PersistencePort)
    - inbound: interface para flujo de entrada del dominio. (ControllerPort)
    
## Core
El CORE funciona de la mano del DOMAIN. Se podria incluso meter ambos en un unico modulo,
pero al separarlos es muy importante asi de esta manera hace que el CORE sea la implementacion
de la logica de negocio unicamente.
En el CORE es donde vamos a encontrar nuestras interfaces e implementación de los servicios.
En el CORE vamos a encontrar lo siguiente:
- __core__
  - __services__: interfaces e implementaciones
Cambios en el CORE van a representar cambios en la logica de negocio y ese el motivo del porque,
para aplicaciones pequeñas no hay razon de separar los puertos de los adaptadores en modulos diferentes.
Sin embargo, a medida que aumenta la complejidad, puede llevar a dividir el CORE existente en
varios CORE con responsabilidades diferentes. Recorda siempre que los modulos externos unicamente
deben usar las interfaces y no las implementaciones.

## Persistence-JPA (Persistence)
Primero tenemos que crear la entidad que vamos a usar para almacenar la data del alumno.
Como es una entidad vamos a necesitar que tenga un id.
En el JPA vamos a encontrar lo siguiente:
- __persistence_jpa__
  - __model__: va a contener la @Entity en este caso con anotaciones JPA
  - __repository__: va a contener @Repository de la entidad.
  - __adapter__: va a tener la implementacion del puerto (PERSISTENCE OUTBOUND PORT).

## REST
En REST vamos a encontrar lo siguiente:
- __rest__
  - __adapter__: va a contener la implementacion del port controller (CONTROLLER INBOUND PORT).
  
The point is to always remember to isolate the inside from the outside and make sure that the communication is done via ports and that the implementation via adapters remains independent of the application core.
