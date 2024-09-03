# Optimal Road App

Optimal Road App es un programa que tiene como objetivo encontrar el camino optimo hacia un destino entre estaciones.

## Prerequisitos

Deberás tener instalado lo siguiente

- **Java**: Version 17.
- **Maven**: Version 3.8.1, importante para correr la app desde un IDE
- **Docker**: Para correr la aplicación dockerizada.
- **Postman Agent**: Para poder realizar las requests.
- **IntelliJ**: U otro para poder correr la app desde un IDE.
 
## Paso a Paso

### 1. Clonar el Repositorio

Abre una terminal y clona el repositorio usando Git:

```bash
git clone https://github.com/aramirez00-dev/OptimalRoadApp.git
```

Navega hasta donde fue clonada (y abrir la app en un IDE).

### 2. Correr la aplicacion

Correr Maven con:

```bash
mvn clean install
```

y darle a ejecutar. Alternativamente:

Corre Docker con:

```bash
docker build -t optimal-road-app .
```

y

```bash
docker run --name optimal-road-app -p 8080:8080 optimal-road-app
```

### 3. Probar los endpoints

Ingresa a Postman, y prueba los endpoints, como por ejemplo:

```bash
PUT localhost:8080/stations/10

request:

{
  "name": "Amsterdam"
}
```

```bash
PUT localhost:8080/roads/4

request:

{
    "cost": 4000,
    "source_id": 10,
    "destination_id": 7
}
```

```bash
GET localhost:8080/roads/7/8

(agregar varias stations/roads antes)
```


## Características principales

- Agrega estaciones y caminos.
- Busca el camino menos costoso hacia un destino
- Maneja errores de request
- Tests básicos para los tres endpoints

## Pendientes

- **Documentacion**: Agregar documentacion Swagger para los endpoints
- **Corregir redundancias**: Ver que se puede eliminar para mejorar performance.
- **Reformular ejercicio**: Rediseñar el ejercicio en una nueva branch, pero bajo los principios de TDD.

