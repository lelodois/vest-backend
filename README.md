## Vestibular Backend

Versão backend do sistema de vestibular

* ** Frontend ** - *Angular* - [Source code](https://github.com/lelodois/vestibular-frontend)

### Começando

Clone este projeto e execute os comandos abaixo na raiz do projeto:

```
  mvn install
  docker build -t vestibular-backend-docker .
  docker run -d -p 9099:9099 vestibular-backend-docker
```


### Pré-requisitos

```
  Java 8
  Maven
  Docker
```
### Tecnologias

* RestAPI
* Java 8
* Maven
* Spring boot
* Tomcat embeddede
* Hibernate
* Swagger
* H2
* Jackson
* JSON Web Tokens

### Endpoints

``` 
http://localhost:9099/swagger-ui.html
```

### Autor

* **Léo Costa** - *Initial work* - [Meu git](https://github.com/lelodois)

