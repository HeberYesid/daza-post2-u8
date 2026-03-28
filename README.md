# daza-post2-u8

ExtensiÃƒÂ³n del CRUD de Estudiante con relaciÃƒÂ³n @ManyToMany bidireccional entre Estudiante y Curso, mÃƒÂ¡s gestiÃƒÂ³n de inscripciones.

## Estructura por capas

- model: Estudiante, Curso
- repository: EstudianteRepository, CursoRepository (incluye JOIN FETCH)
- service: EstudianteService, CursoService
- controller: EstudianteController, CursoController
- templates/estudiantes: lista, formulario, confirmar-eliminar
- templates/cursos: lista, formulario, inscripcion

## Prerrequisitos

- JDK 17+
- Maven 3.8+
- MySQL 8+
- Base de datos estudiantes_db

## Funcionalidades

- CRUD de estudiantes
- CRUD bÃƒÂ¡sico de cursos
- InscripciÃƒÂ³n estudiante-curso con tabla intermedia estudiante_curso
- Consulta optimizada de cursos con estudiantes usando JOIN FETCH

## ConfiguraciÃƒÂ³n BD sugerida

- URL: jdbc:mysql://localhost:3306/estudiantes_db
- Usuario: appuser
- Clave: apppass

## EjecuciÃƒÂ³n

1. Crear base de datos y usuario en MySQL
2. Ajustar credenciales en application.properties
3. Ejecutar: mvn spring-boot:run
4. Abrir: <http://localhost:8080/estudiantes>
5. Gestionar cursos e inscripciones en /cursos

## Capturas

Guardar evidencias en capturas/.

