## Vestibular Backend

Versão backend do sistema de vestibular

* ** Frontend ** - *Angular* - [Source code](https://github.com/lelodois/vestibular-frontend)

### Medium
[Do front-end ao back-end usando Angular 4 e Java em containers docker](https://medium.com/@locosta_61043/do-front-end-ao-back-end-usando-angular-4-e-java-em-containers-docker-5d0eba0fcbcc)


### Dockerize

```
  mvn install
  docker build -t vestback-docker .
  docker run -d -p 9099:9099 vestback-docker
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

