# Arquitectura Hexagonal
Cada una de los paquetes que vas a ver 
- core
- persistence_jpa
- rest

tambien podes definirlas en paquetes diferente dentro de un mismo proyecto
o bien podes hacer que cada uno sea un proyecto por si mismo (es decir que cada uno tenga su jar y 
despues los unis como dependencias de maven).

Como ves en el siguiente imagen del diagrama de arquitectura hexagonal, vas
a ver que tiene fechas con puntas blancas y negras.
Las fechas con puntas negras significa que DEPENDEN DE (AKA "usa con asociacion") los componentes conectados. (Ej: El adaptador web depende del puerto de entrada)
Las fechas con puntas blancas significa que IMPLEMENTAN los puertos asociados.(Ej: El adaptador de persistencia implementa el puerto de salida)

Como ves aunque los adaptadores estan relacionados con los puertos, difieren en responsabilidad. Es decir,
los __adaptadores de entrada__ simplemente llaman a los puertos de entrada mediante un __usecase__ (case de uso)
mientras que un __usecase__ no necesita saber como el sistema recupero o persistio la informacion, sino que llama
a un __puero de salida__ que se implementa mediante un adaptador de salida.

Graficamente siguiendo el flujo de izq a der:
Adaptador Web (usa Puerto de entrada para conectarse con) -> usecase (usa Puerto de salida para conectarse con) -> Adaptador de Persistencia

Fuente:
https://medium.com/@demisgomes/rumo-ao-hexa-a-arquitetura-hexagonal-parte-1-161a000c0a0
https://medium.com/@demisgomes/rumo-ao-hexa-a-arquitetura-hexagonal-parte-2-1298b6a5e3a5


Proyecto “library”. It seems to be pretty simple — it’s a management system for handling books & users in a local library
