# Blockbuster

Blockbuster es un proyecto desarrollado para gestionar una tienda de películas de forma ordenada.

Este proyecto forma parte de Fullstack 1.

## Herramientas utilizadas

### [HeidiSQL](https://www.heidisql.com/download.php)
HeidiSQL es la herramienta que utilizaremos para gestionar la base de datos, en la cual guardaremos los datos mediante un POST.

### [Laragon](https://laragon.org/download)
Laragon es una herramienta que utilizaremos para levantar la base de datos.

### [Postman](https://www.postman.com/downloads/)
Postman lo utilizaremos para utilizar todo el método CRUD de nuestro proyecto.

### [Visual Studio Code](https://code.visualstudio.com/download)
Visual Studio Code es lo que usaremos para visualizar el código del proyecto.

# Estructura del Proyecto
Este proyecto está organizado de la siguiente forma:

* **Model:** Contiene las entidades Director, Película y Productora.
* **Repository:** Contiene las interfaces del acceso a los datos.
* **Service:** Contiene la lógica del programa y las operaciones principales del sistema.
* **Controller:** Contiene los endpoints de las API's y maneja las solicitudes HTTP.
* **DTO:** Contiene los objetos necesarios para transferir datos entre capas de forma segura y organizada.
* **Exception:** Contiene las excepciones personalizadas y el manejo de errores del proyecto.

## Funciones Principales
El sistema permite crear, listar, editar y eliminar entidades como películas, directores y productoras, para tener un buen control del catálogo disponible.

## Funciones Extra
El sistema igualmente cuenta con la API Open-Meteo para tener acceso al clima en tiempo real de Santiago, Chile, y de una ubicación personalizada.

## Cómo ejecutarlo
Para ejecutar el sistema en tu entorno local, completa los siguientes pasos:

#### 1. Requisitos mínimos
* Tener instalado Java.
* Tener instalado HeidiSQL para ver y administrar las tablas creadas de forma local.
* Tener instalado Laragon para levantar el entorno SQL de forma local.
* Tener instalado Visual Studio Code con las extensiones Extension Pack for Java y Spring Boot Extension Pack.

#### 2. Abrir y poblar la base de datos
El sistema está configurado para tener una conexión a una base de datos local y generar las tablas de forma automática.

1- Inicia Laragon y clickea en "Iniciar todo".
2- Abre HeidiSQL y asegúrate de que el puerto sea el correcto.
3- Crea una base de datos con el nombre de: "blockbuster".
4- Usar Postman para hacer los JSON de los datos que quieras agregar o modificar.

--------------------------------------------------------------------------------------------------------------------------------

## Autor

**[Benjamin Labrin](https://github.com/Benjamin-Labrin)**

Estudiante Ingeniería Informática DUOC UC
