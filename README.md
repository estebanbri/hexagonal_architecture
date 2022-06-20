# Arquitectura Hexagonal

<img src="https://github.com/estebanbri/hexagonal_architecture/blob/master/arquitectura-diagrama.png" alt="diag1" width="900"/>
Como ves en el siguiente imagen del diagrama de arquitectura hexagonal, vas
a ver que tiene fechas con puntas blancas y negras.
Las fechas con puntas negras significa que DEPENDEN DE (AKA "usa con asociacion") los componentes conectados. (Ej: El adaptador web depende del puerto de entrada)
Las fechas con puntas blancas significa que IMPLEMENTAN los puertos asociados.(Ej: El adaptador de persistencia implementa el puerto de salida)

Graficamente siguiendo el flujo de izq a der:
Adaptador Web (usa Puerto de entrada para conectarse con) -> facade (usa Puerto de salida para conectarse con) -> Adaptador de Persistencia

Fuente:
https://wkrzywiec.medium.com/ports-adapters-architecture-on-example-19cab9e93be7
https://www.youtube.com/watch?v=tMHO7_RLxgQ
___

Suponiendo que tenes el siguiente proyecto:
- Nombre de proyecto: Liberia: 
- Descripcion general: es un sistema de administracion para manejo de libros y usuarios de una libreria.

Un domain puede ser descripto como una pequeña parte de una aplicación, pero la division esta hecha
basada en contexto de negocio.

El domain aplica el principio INVERSION DE CONTROL (CONTROL INVERSION), es decir el domain no depende de nada de los exterior
el exterior es el que va a depender del domain. Es decir el domain va a encargarse de definir interfaces y el exterior al domain
va a tener que darle implementacion. Es decir el exterior va a depender del las interfaces del domain.


Leyendo la descripcion del proyecto te da una pista que tu aplicación va a tener mas de un domain y
cada doamin va a ser responsable de una parte diferente de la logica de negocio, es decir: 

- domain usuario: se encargara de la administracion de los usuarios.
- domain inventario: se encargara del manejo de inventario de libros.
- domain borrowing: se encargara de todo el reserva, prestamo, devolucion de libros.

Estructura de paquetes:
Nota 1: tus servicios aqui se van a llamar, por ej usuario lo que llamarias UserService, UserFacade (Implementacion) 
y son los adapters de los puertos de entrada. Dichos Facade contendran la logica de negocio implementada. En caso de necesitar
comunicase con el exterior del core del cual el mismo reside, tiene que hacerlo mediante uso de puertos de salida. (Ojo no confundir
los rest controller no son adapters de los puertos de entrada porque fijate que no hace implements de los puertos de entrada sino
que los usa directamente, los adapters de entrada son unicamente los Facade que sirven para darle implementacion a los puertos de entrada)
Nota 2: a las capas podes definirlas en paquetes diferente dentro de un mismo proyecto
o bien podes hacer que cada uno sea un proyecto por si mismo (es decir que cada uno tenga su jar y
despues los unis como dependencias de maven).

Si te fijas en el controller, va a estar usando como tipo de las referencias a los puertos de entrada,
es decir no usa directamente al facade, con esto logramos desacoplarlo de la implementación concreta.
Y si te fijas los nombres de los tipos de referencias contienen el verbo/accion. (ej AddNewUsuario)
Como el puerto de entrada ya va a tener el verbo en el nombre de la clase no hace falta tener un metodo
que vuelva a nombrar el verbo es decir siguiente el ejemplo AddNewUsuario el metodo principal lo podes llamar
handle(), de esta manera cuando le haces call a dicho metodo sobre la referencia no queda muy verborrajico.

Teoria:

El concepto básico de la arquitectura hexagonal (AKA, puertos y adaptadores)
es dividir tu aplicación en 3 partes principales:
<img src="https://github.com/estebanbri/hexagonal_architecture/blob/master/arquitectura-diagrama2.png" alt="diag1" width="900"/>

- application: define cómo el mundo exterior va a interactuar con tu aplicación, es un gateway al core de tu application. (El punto de entrada de tu app puede ser via endpoints rest, consumo de mensajes (RabbitMQ), linea de comandos, @Scheduled, etc)
- core: aqui es donde va a estar la logica de negocio. El objetivo es que sea escrita en un ingles plano para que alguien no tecnico pueda entender.
Es decir dentro del core vamos a utilizar un lenguaje especifico del dominio para nombrar las cosas (clases, metodos, etc).
Ej: RegistrarIngresoLibro.class es valido, pero no seria valido tener una clase RegistrarIngresoLibroRabbitMQ.class por ejemplo,
no se me ocurrio otro ejemplo pero se entiende que las cosas tienen que estar nombradas solo con lenguaje de dominio, no
tiene que haber nombres que tengan que ver con cosas tecnicas en esta parte. 
Y lo mas importante es que NO PUEDE TENER NADA RELACIONADO A ALGUN FRAMEWORK. Es decir esta parte es agnostica de frameworks. (En esta parte 
no vas a encontrar anotaciones (nada de jpa por ej,ni bean validacion via hibernate.validator), ni librerias externas (apache.commons), ni frameworks (jpa, spring))
Si necesitamos comunicarnos con sistemas externos,
base de datos, queue, servidores en esta parte unicamente usamos los puertos de salida (los cuales unicamente definen ¿Que es lo que vamos
a necesitar de los sitemas externos para cumplir la logica de negocio? pero no definen el como, el como esta encargado la siguiente capa de infra)
- infrastructure: define como tu aplicacion va a hacer uso de sistemas externos (por ej database, queue, sFTP server). En parte decimos 
¿COMO vamos a implementar? la comunicacion con los sitemas externos. (Aqui podemos usar cualquier tipo de framework para la comunicacion ext, es
decir si necesitamos pesistencia ej Hibernate, plain Jdbc, jOOQ)

En resumen a diferencia de la arquitectura de 3 capas, en esta arquitectura el core
no conoce de la capa de application ni de la capa de infrastructure. No debe conocer ni saber nada del mundo exterior.
Esto lo hace mediante el uso de puertos (que son interfaces que sirven de contrato/api para exterior del mismo)
los cuales definen las todas las interacciones que pueden tener con el core (es decir definen el Que? pero no el Como?).
Estos puertos pueden ser:
- puertos de entrada al core: es responsable de definir ¿que? podes hacer con el core de negocio.
- puertos de salida del core: es usado por el core para hablar con sistemas externos a el.

> Te estaras preguntando porque los puertos de entrada los hizo uno por cada accion/verbo separados
> y el puerto de salida en un unico archivo. Esto se hizo asi porque el tener los puertos de entrada separados
> no obligas al cliente a tener acciones que no necesita, es decir si el cliente (ej un RestController) solo necesita
> guardar va a usar unicamente el puerto de entrada llamada AddNewUser.class, en cambio por otro lado en los puertos de salida
> tenes que poner todas las acciones juntas en la clase porque tu adapter tiene que saber que tiene que darle implementacion
> a todos los metodos que le aparezcan cuando haga el implements del puerto de salida, ya que si no lo hace no va a funcionar la logica
> de negocio del core.

El ¿como? va a llevarse a cabo la comunicacion de entrada y salida esta llevada a cabo por los adapters.
Asi como tenemos puertos de entrada y salida, tenemos adaptadores de entrada (ej: UserFacade) y adaptadores de salida (UserDatabaseAdapter).
(Ojo: lo que definis en application ya sea un restcontroller, @Schedule o lo que sea para llamar a la logica de negocio del core NO SON ADAPTERS DE ENTRADA fijate que no implementan el puerto de entrada
solo lo usan directamente por composicion)
Los adapter definen el Como? se va a ser la implementacion de las interfaces/contratos dados por los puertos del core.

Temas importantes:
### STRICT DTO's versus ABUSE DTO's?
Spoiler: Es mejor que cada dto sea especifico (STRICT DTO) a una casuistica en especifica es decir,
tener un unico DTO que sirve para todo es decir crear, actualizar, borrar una entidad se llama DTO ABUSE (Abuso de dto).
Por ej el dto de request para crear un usuario no tiene sentido tener el field createdDate ya que va a llegar null al backend.
Ventaja de tener STRICT's DTO's: Pensando a lo grande imaginate que tenes un dto con 50 fields y para el update solo usas 5 de esos vas a llegar al backend con 45 field en null
y vas a tener que ver la logica para ver cuales fields es correcto que esten en null y cuales son especificos de la casuistica que no pueden llegar null
En resumen: Crear STRICT DTO's (dichos dto no pueden tener useless fields que no use dependiendo contexto de su uso).

### Value Objects versus Entities versus DTO's donde los ubico a cada uno?
Cada uno de ellos tienen un modulo distinto. Es decir por ej nunca vas a poner dto dentro de tu domain core porque un dto es algo del cliente quien hace el request.
Es decir en resumen vas a tener los siguientes modelos en cada capa:
-- application: dto
-- core: value object
-- infrastructure: entity (database) o dto (external services)

### Value Objects (STRUCTURAL EQUALITY) versus Entity (IDENTIFIER EQUALITY)
Como notaste lo objetos model que tenes dentro del domain core son Value Objects porque no tienen field id.
En resumen la diferencia radica en que las entidades tienen IDENTIFIER EQUALITY (es decir un id que los identifica a cada una)
versus los value objects tienen STRUCTURAL EQUALITY.
Ejemplo: 
__Entidad__=> La entidad Usuario { id: 1, name: "Object"} es igual a entidad { id: 1, name: "Obj"} porque tienen mismo id. Es decir la identidad esta dada por el campo id unicamente, indistintamente que tengan diferntes valores de los otros fields.
__Value Object__=> El Value Object  { calle: Brown123, pais: "Argentina"} es igual al objeto { calle: Brown123, pais: "Argentina"} porque tienen los mismos valores identicos de cada field. Es decir la identidad esta dada por la sumatoria de field y no por un campo en especifico
Fuente: https://enterprisecraftsmanship.com/posts/entity-vs-value-object-the-ultimate-list-of-differences/#:~:text=The%20main%20difference%20between%20entities,while%20value%20objects%20don't.