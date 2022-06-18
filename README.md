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