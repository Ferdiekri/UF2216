# UF2216
Examen de la unidad formativa UF2216.

ENUNCIADO 

Crear una aplicaci�n que nos solicite datos por pantalla para poder crear nuevos registros en nuestro CMS.
Nuestro CMS se encarga de gestionar REVISTAS, por lo cual la aplicaci�n debe solicitar los siguientes datos:

1. Titulo                          tama�o m�nimo 3 letras, m�ximo 150
2. ISBN                            n�mero de longitud 10
3. N�mero de P�ginas               m�nimo 1
4. Formato ( digital o papel )     true == digital / false == papel

Cada campo que solicitamos deber� ser comprobado que tiene un formato valido, en caso de no cumplir el formato se solicitar� de nuevo el mismo campo. 
Si el formato es correcto solicita el siguiente campo. 

Cuando termina de solicitar todos los campos debe mostrar un resumen del revista a ingresar en el CMS, para pedir una confirmaci�n si se quiere guardar.

Adem�s deber� tener las siguientes funcionalidades:

� Listar revistas insertados ( ordenado por numero de p�ginas )
� Guardar en un fichero.txt todos las revistas
� Todas las revistas deben implementar una interfaz vac�a Leible
� *Usar un DAO y patron Sngleton es opcional
 
PUNTUACI�N

� Crear Revista                         3 puntos
� Listar Revistas                       1 puntos
� Ordenaci�n revistas                   1 punto
� Mensajes al usuario UX                2 punto
� C�digo optimo y bien estructurado     1 punto
� Junit para Revista                    1 punto
� Guardar en Fichero Texto              1 punto


MODO ENTREGA

Para entregar el proyecto, debemos guardar todas las clases necesarias en un package  "com.ipartek.formacion.uf2216"
El proyecto debe tener el nombre y dos apellidos del alumno.
