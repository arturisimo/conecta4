# Conecta 4 Model View Controlador Inversion de control

El control del flujo de la ejecuci�n pasa a los controllers

### Patron visitor

El patr�n visitor es una forma de separar el algoritmo de la estructura de un objeto.

La idea b�sica es que se tiene un conjunto de clases elemento que conforman la estructura de un objeto. Cada una de estas clases elemento tiene un m�todo aceptar (accept()) que recibe al objeto visitante (visitor) como argumento. El visitante es una interfaz que tiene un m�todo visit diferente para cada clase elemento; por tanto habr� implementaciones de la interfaz visitor de la forma: visitorClase1, visitorClase2... visitorClaseN. El m�todo accept de una clase elemento llama al m�todo visit de su clase. Clases concretas de un visitante pueden entonces ser escritas para hacer una operaci�n en particular.

Cada m�todo visit de un visitante concreto puede ser pensado como un m�todo que no es de una sola clase, sino de un par de clases: el visitante concreto y clase elemento particular. As� el patr�n visitor simula el env�o doble (en ingl�s este t�rmino se conoce como **Double-Dispatch**) en un lenguaje convencional orientado a objetos de env�o �nico (Single-Dispatch), como son Java o C++.

El patr�n visitor tambi�n especifica c�mo sucede la interacci�n en la estructura del objeto. En su versi�n m�s sencilla, donde cada algoritmo necesita iterar de la misma forma, el m�todo accept de un elemento contenedor, adem�s de una llamada al m�todo visit del objeto visitor, tambi�n pasa el objeto visitor como argumento al llamar al m�todo accept de todos sus elementos hijos. 