# Base de datos

Nota
=========

Debes tener instalado Docker en tu maquina.


## Postgres

Debes ejecutar el siguiente comando

```
docker run -it --rm=true -d --name postgres -e POSTGRES_USER=hansfullstack -e POSTGRES_PASSWORD=hansfullstack -e POSTGRES_DB=game -p 5432:5432 postgres:14.1
```
