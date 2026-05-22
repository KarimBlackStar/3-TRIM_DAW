# Práctica: Gestión de Permisos y Delegación de Control en Active Directory

Este documento recoge los ejercicios prácticos de gestión de usuarios, grupos y delegación de control mediante directivas y características avanzadas de Active Directory.

---

## Ejercicio 1: Delegación de Control Específica en la OU Aula 2

### Enunciado y Requisitos

1. Crear el usuario `Carlos Álvarez Pías` dentro del grupo `Profesores` en la Unidad Organizativa (OU) correspondiente.

2. Delegar privilegios desde el equipo con Active Directory para que Carlos pueda realizar exclusivamente en la **OU Aula 2** las siguientes tareas con las RSAT:

   - Crear y eliminar objetos de tipo equipo.
   - Crear grupos.
   - Añadir usuarios y gestionar su pertenencia a grupos.

3. Demostrar que no tiene permisos de administración en otras OU.

4. Explicar cómo revertir y retirar estos privilegios.

---

## Evidencias del Proceso (Ex1.pdf)

### 1. Inicio de sesión de Carlos

<img width="438" height="352" alt="image" src="https://github.com/user-attachments/assets/3f98b972-94b7-4ad9-bd58-10ac57614c3b" />

- **Descripción:** El usuario `Carlos Álvarez Pías` (identificado en la interfaz como Carlos Hernández Sánchez / Carlos Herman) inicia sesión correctamente en el dominio local desde una estación de trabajo autorizada.

---

### 2. Acceso a las herramientas administrativas (RSAT)

<img width="465" height="372" alt="image" src="https://github.com/user-attachments/assets/8df78e34-cd0c-4357-a593-a9449bf2ff00" />

- **Descripción:** Ejecución de la herramienta `dsa.msc` en el equipo cliente. Se comprueba que la estructura del dominio `vigo.local` (o equivalente) es visible para el usuario.

---

### 3. Verificación de restricción de permisos en otras OU

<img width="458" height="372" alt="image" src="https://github.com/user-attachments/assets/cc253255-157b-41dd-bb36-902a94d276b2" />

- **Descripción:** Demostración del principio de mínimo privilegio. El usuario Carlos intenta crear o modificar un objeto fuera de su ámbito y el sistema deniega la acción u oculta las opciones administrativas (como "Nuevo..."), confirmando que no tiene privilegios fuera de la OU Aula 2.

---

### 4. Creación y eliminación de equipos en la OU Aula 2

<img width="471" height="379" alt="image" src="https://github.com/user-attachments/assets/e34c46ea-5fde-4330-9d71-005c79f4a264" />

- **Descripción:** Carlos crea con éxito un nuevo objeto de tipo ordenador (`PC-TEST-01`) dentro de la OU asignada gracias a los permisos delegados de control de objetos de equipo.

---

### 5. Creación de grupos en la OU Aula 2

<img width="439" height="351" alt="image" src="https://github.com/user-attachments/assets/fd73e629-667b-4fbd-8f2a-f59516a3c303" />
<img width="446" height="357" alt="image" src="https://github.com/user-attachments/assets/d09852d3-7c7d-4a45-8679-945562672c59" />

- **Descripción:** Creación del grupo de seguridad local o global (ej. `GrupoCarlos`) dentro de la OU Aula 2, validando que la delegación de tareas específicas de gestión de grupos está operativa.

---

### 6. Creación de usuarios y asignación de grupos

<img width="469" height="377" alt="image" src="https://github.com/user-attachments/assets/a7cee659-8f7c-4dc5-a53d-6dfdae732fe6" />

- **Descripción:** Modificación exitosa de los atributos de pertenencia del nuevo usuario. Carlos añade el usuario al grupo creado previamente (`GrupoCarlos`), completando así el ciclo de tareas delegadas en la OU Aula 2.

---

## Procedimiento para Revocar los Privilegios de Carlos

Para retirar de forma definitiva los privilegios delegados a Carlos sobre la OU Aula 2, el administrador del dominio debe realizar los siguientes pasos:

1. Abrir la consola de **Usuarios y equipos de Active Directory** (`dsa.msc`).

2. Desplegar el menú **Ver** (View) y asegurarse de que la opción **Características avanzadas** (Advanced Features) está activada.

3. Localizar la OU **Aula 2**, hacer clic derecho sobre ella y seleccionar **Propiedades**.

4. Ir a la pestaña **Seguridad** (Security) y pulsar el botón **Opciones avanzadas** (Advanced).

5. En la lista de entradas de permisos, buscar y seleccionar la entrada correspondiente al usuario `Carlos Álvarez Pías`.

6. Pulsar el botón **Quitar** (Remove), después en **Aplicar** y finalmente en **Aceptar**.

---

## Ejercicio 2: Administración Centralizada con Herencia y Denegación Explícita

### Enunciado y Requisitos

1. Crear el usuario `Paula Hernández Sánchez` dentro del grupo `Profesores`.

2. Permitir que Paula pueda gestionar todos los equipos (crear, modificar, eliminar) en todas las OU de tipo talleres, aulas y departamentos presentes y futuros.

3. Restringir de forma explícita que Paula pueda realizar cualquier tarea de gestión de equipos en la **OU Aula 1**.

4. Justificar técnicamente las características de Active Directory empleadas para lograr este comportamiento.

---

## Evidencias del Proceso (Ex2.pdf)

### 1. Administración automatizada en las sub-OU mediante Herencia

> <img width="433" height="349" alt="image" src="https://github.com/user-attachments/assets/a94c0e6c-df25-4bc6-bc3d-3ff0aaa4d83d" />
 Clic derecho sobre una OU hija que cuelga del contenedor principal de clientes (talleres o departamentos) mostrando el menú contextual "Nuevo -> Equipo" disponible.

- **Descripción:** Validación del diseño topológico. Paula tiene acceso total para crear y gestionar objetos informáticos en cualquier contenedor que descienda del nodo raíz configurado, sin necesidad de asignar permisos uno por uno.

---

### 2. Restricción y bloqueo de permisos en la OU Aula 1

> <img width="421" height="334" alt="image" src="https://github.com/user-attachments/assets/fd8a615d-f2af-4e6a-a6c6-49579278c486" />
 Interfaz de Active Directory en la OU Aula 1 mostrando el menú contextual sin opciones de creación o con un aviso de "Acceso denegado".

- **Descripción:** Demostración de la restricción selectiva. Aunque Paula hereda permisos de administración desde el nivel superior, al intentar operar en la OU Aula 1 el sistema bloquea las acciones debido a la regla de control específica implementada en ese contenedor.

---

## Justificación Técnica del Administrador

Para resolver los requerimientos de este ejercicio de forma óptima y limpia sin caer en una sobrecarga de tareas administrativas repetitivas, basé la configuración en dos características fundamentales de Active Directory:

### Apartado 1: Automatización mediante Herencia de Permisos (Inheritance)

- **Descripción del proceso:** En lugar de delegar el control de forma manual en cada una de las aulas, talleres y departamentos actuales, apliqué la delegación de control exclusivamente en la **OU padre principal** (Clientes / Escuela).

- **Fundamento técnico:** Al activar la **Herencia de permisos**, cualquier nueva regla de seguridad o delegación aplicada en el contenedor raíz se propaga automáticamente hacia abajo a todos los contenedores hijos presentes y futuros. Esto garantiza la escalabilidad del sistema si se crean nuevas aulas más adelante.

---

### Apartado 2: Bloqueo mediante Denegación Explícita (Explicit Deny)

- **Descripción del proceso:** Para cumplir la excepción del Aula 1, accedí a las propiedades avanzadas de seguridad de la **OU Aula 1** y añadí una entrada específica para el usuario Paula con una regla de **Denegar** (Deny) para la gestión de objetos informáticos.

- **Fundamento técnico:** En la arquitectura de seguridad de Windows y Active Directory, un **permiso de Denegación Explícita (Explicit Deny) tiene prioridad absoluta** sobre cualquier permiso de "Permitir" (Allow) heredado. De este modo, se anula la herencia del nivel superior únicamente para ese contenedor hijo sin afectar al resto del dominio.
