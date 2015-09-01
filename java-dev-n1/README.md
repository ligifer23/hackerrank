Spring Core + Spring Boot + Spring Data + H2 in-memory
	- Os ceps disponiveis no inmemory são somente da cidade de sp

#Exercício 1 - Busca de CEP

##URI
/cep/{ID}

##Run app
$mvn spring-boot:run

##Debug app
$mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
