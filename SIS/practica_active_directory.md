# Práctica: Xestión de Permisos e Delegación de Control en Active Directory

Este documento recolle os exercicios prácticos de xestión de usuarios, grupos e delegación de control mediante directivas e características avanzadas de Active Directory.

---

## Exercicio 1: Delegación de Control Específica na OU Aula 2

### Enunciado e Requisitos

1. Crear o usuario `Carlos Álvarez Pías` dentro do grupo `Profesores` na Unidade Organizativa (OU) correspondente.

2. Delegar privilexios dende o equipo con Active Directory para que Carlos poida realizar exclusivamente na **OU Aula 2** as seguintes tarefas coas RSAT:

   - Crear e eliminar obxectos de tipo equipo.
   - Crear grupos.
   - Engadir usuarios e xestionar a súa pertenza a grupos.

3. Demostrar que non ten permisos de administración noutras OU.

4. Explicar como reverter e retirar estes privilexios.

---

## Evidencias do Proceso (Ex1.pdf)

### 1. Início de sesión de Carlos

> **Captura de pantalla:** Pantalla de login de Windows 10/11 Pro no equipo cliente.

- **Descrición:** O usuario `Carlos Álvarez Pías` (identificado na interface como Carlos Hernández Sánchez / Carlos Herman) inicia sesión de xeito correcto no dominio local dende unha estación de traballo autorizada.

---

### 2. Acceso ás ferramentas administrativas (RSAT)

> **Captura de pantalla:** Consola de "Usuarios e equipos de Active Directory" aberta dende o cliente.

- **Descrición:** Execución da ferramenta `dsa.msc` no equipo cliente. Comprobase que a estrutura do dominio `vigo.local` (ou equivalente) é visible para o usuario.

---

### 3. Verificación de restrición de permisos noutras OU

> **Captura de pantalla:** Mensaxe de erro ou opcións de creación deshabilitadas ao facer clic dereito noutra OU (ex. Alumnos ou Profes).

- **Descrición:** Demostración do principio de menor privilexio. O usuario Carlos tenta crear ou modificar un obxecto fóra do seu ámbito e o sistema denega a acción ou oculta as opcións administrativas (como "Nuevo..."), confirmando que non ten privilexios fóra da OU Aula 2.

---

### 4. Creación e eliminación de equipos na OU Aula 2

> **Captura de pantalla:** Ventá de diálogo "Nuevo objeto - Equipo" dentro do contedor `Escuela -> Aula 2`.

- **Descrición:** Carlos crea con éxito un novo obxecto de tipo ordenador (`PC-TEST-01`) dentro da OU asignada grazas aos permisos delegados de control de obxectos de equipo.

---

### 5. Creación de grupos na OU Aula 2

> **Captura de pantalla:** Asistente de creación "Nuevo objeto - Grupo" cos campos de nome de grupo cubertos.

- **Descrición:** Creación do grupo de seguridade local ou global (ex. `GrupoCarlos`) dentro da OU Aula 2, validando que a delegación de tarefas específicas de xestión de grupos está operativa.

---

### 6. Creación de usuarios e asignación de grupos

> **Captura de pantalla:** Pestana "Miembro de" (Member Of) dentro das propiedades do usuario creado (ex. Arthur Pendragon).

- **Descrición:** Modificación exitosa dos atributos de pertenza do novo usuario. Carlos engade o usuario ao grupo creado previamente (`GrupoCarlos`), completando así o ciclo de tarefas delegadas na OU Aula 2.

---

## Procedemento para Revogar os Privilexios de Carlos

Para retirar de xeito definitivo os privilexios delegados a Carlos sobre a OU Aula 2, o administrador do dominio debe realizar os seguintes pasos:

1. Abrir a consola de **Usuarios e equipos de Active Directory** (`dsa.msc`).

2. Despregar o menú **Ver** (View) e asegurarse de que a opción **Características Avanzadas** (Advanced Features) está activada.

3. Localizar a OU **Aula 2**, facer clic dereito sobre ela e seleccionar **Propiedades**.

4. Ir á pestana **Seguridade** (Security) e premer no botón **Opcions avanzadas** (Advanced).

5. Na lista de entradas de permisos, buscar e seleccionar a entrada correspondente ao usuario `Carlos Álvarez Pías`.

6. Premer no botón **Quitar** (Remove), despois en **Aplicar** e finalmente en **Aceptar**.

---

## Exercicio 2: Administración Centralizada con Herdanza e Denegación Explícita

### Enunciado e Requisitos

1. Crear o usuario `Paula Hernández Sánchez` dentro do grupo `Profesores`.

2. Permitir que Paula poida xestionar todos os equipos (crear, modificar, eliminar) en todas as OU de tipo talleres, aulas e departamentos presentes e futuros.

3. Restrinxir de xeito explícito que Paula poida realizar calquera tarefa de xestión de equipos na **OU Aula 1**.

4. Xustificar tecnicamente as características de Active Directory empregadas para acadar este comportamento.

---

## Evidencias do Proceso (Ex2.pdf)

### 1. Administración automatizada nas sub-OU mediante Herdanza

> **Captura de pantalla:** Clic dereito sobre unha OU fillo que colga do contedor principal de clientes (talleres ou departamentos) mostrando o menú contextual "Nuevo -> Equipo" dispoñible.

- **Descrición:** Validación do deseño topolóxico. Paula ten acceso total para crear e xestionar obxectos informáticos en calquera contedor que descenda do nodo raíz configurado, sen necesidade de asignar permisos un por un.

---

### 2. Restrición e bloqueo de permisos na OU Aula 1

> **Captura de pantalla:** Interface de Active Directory na OU Aula 1 amosando o menú contextual sen opcións de creación ou cun aviso de "Acceso denegado".

- **Descrición:** Demostración da restrición selectiva. Aínda que Paula herda permisos de administración dende o nivel superior, ao intentar operar na OU Aula 1 o sistema bloquea as accións debido á regra de control específica implementada nese contedor.

---

## Xustificación Técnica do Administrador

Para resolver os requirimentos deste exercicio de xeito óptimo e limpo sen caer nunha sobrecarga de tarefas administrativas repetitivas, baseei a configuración en dúas características fundamentais de Active Directory:

### Apartado 1: Automatización mediante Herdanza de Permisos (Inheritance)

- **Descrición do proceso:** En lugar de delegar o control de xeito manual en cada unha das aulas, talleres e departamentos actuais, apliquei a delegación de control exclusivamente na **OU pai principal** (Clientes / Escuela).

- **Fundamento técnico:** Ao activar a **Herdanza de permisos**, calquera nova regra de seguridade ou delegación aplicada no contedor raíz propágase de xeito automático cara abaixo a todos os contedores fillos presentes e futuros. Isto garante a escalabilidade do sistema se se crean novas aulas máis adiante.

---

### Apartado 2: Bloqueo mediante Denegación Explícita (Explicit Deny)

- **Descrición do proceso:** Para cumprir a excepción da Aula 1, accedín ás propiedades avanzadas de seguridade da **OU Aula 1** e engadín unha entrada específica para o usuario Paula cunha regra de **Denegar** (Deny) para a xestión de obxectos informáticos.

- **Fundamento técnico:** Na arquitectura de seguridade de Windows e Active Directory, un **permiso de Denegación Explícita (Explicit Deny) ten prioridade absoluta** sobre calquera permiso de "Permitir" (Allow) herdado. Deste xeito, anúlase a herdanza do nivel superior unicamente para ese contedor fillo sen afectar ao resto do dominio.
