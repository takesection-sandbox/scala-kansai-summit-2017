Akka HTTP
=========

```
$ sbt

> docker:stage
> docker:publishLocal
> exit

$ docker run -d -p 8080:8080 --rm akka-http:0.1.0-SNAPSHOT

$ curl http://localhost:8080/
$ curl http://localhost:8080/123
```