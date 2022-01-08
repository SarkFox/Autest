README INSTRUCCIONES DE EJECUCIÓN PRUEBA TECNICA AUTEST

REQUERIMIENTOS:
Spring boot
MySQL.


Importar el proyecto en cualquier editor, recomendado VSCODE, Intellij.
Aplicar cambios en el archivo "application.properties"
Ubicado en src/main/resources
La aplicación corre en el localhost:8050 y se conecta a la base de datos por el puerto 3306
Es necesario modificar el archivo en las lineas:
spring.datasource.url=jdbc:mysql://localhost:3306/springboot
	Puerto para la base de datos-----^		^----Nombre de la base de datos
spring.datasource.username=root (Username para la conexión,reemplazar o conservar root)
spring.datasource.password=pass (Contraseña de la conexión,reemplazar o conservar)

Se recomienda crear una base de datos en mysql con el mismo nombre, puerto, username y password


Ejecutar autest como una aplicación de spring boot.

Realizar las pruebas añadiendo numeros mediante metodos REST POST con el uso de POSTMAN o cualquier API similar

Formato POST para añadir numeros:
{
"num":x
}
Siendo x cualquier numero a añadir

Añadir cuantos numero se quieran para la prueba.



Formato POST para añadir un operador:
{
"operator": "x",
"value":0
}
Siendo x cualquier operador entre los soportados: (+, - , *, /)
value 0 representa un valor cualquiera para el comando, sin embargo el valor es cambiado por el metodo retornando el
valor de la operación indicada.
En caso de indicar valor 0, solo se guardara el valor del operador en la base de datos sin realizar ninguna operación adicional.

EJEMPLO DE RESPUESTA DEL METODO DE OPERADOR EN POSTMAN:

Los datos actuales son: 1,2,3

{
"operator": "+",
"value":0
}

RESPONSE: 200
{
id:1,
operator: "+",
value: 6
}

adicionalmente se tienen servicios de consulta basicos implementados en:
http://localhost:8050/nums para listar los numeros introducidos
http://localhost:8050/operators para listar los operadores introducidos


Desarrollado por Felipe Velásquez Jaramillo.