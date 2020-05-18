##  Prueba refactor masivian

Se crea un proyecto en maven con java 8 y se coloca la clase Printer en el paquete co.com.masivian.original y se realiza refactor en el paquete co.com.masivian.refactor la cual contiene 3 clases con su propia responsabilidad las cuales explico a continuación:


## Printer.java

Clase encargada de manejar la ejecucion podria ser cambiada a que sea un servicio rest por ejemplo y no afectaria la logica.

## PagePrinter.java

Clase encargada de formatear la data que se genero si se requiere cambiar la forma de imprimir la data esta clase solo se veria afectada

## Generator.java

Clase encargada de generar una lista de números primos. Esta clase cambiará si cambia el algoritmo para calcular números primos.

## Se realizo la logica con for tradicional y con stream de java 8 en la clase Generator.java pueden encontrar dos metodos verifyNumbersPrime y verifyNumbersPrimeWitStream. En el metodo generate pueden ver que esta comentado verifyNumbersPrimeWitStream si desean ver que funcione lo pueden descomentar y comentar el verifyNumbersPrime.
