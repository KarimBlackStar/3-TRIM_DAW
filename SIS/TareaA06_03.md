# Exercicio de GPOs en Windows Server

## 1. Prohibir o acceso á unidade C: para os usuarios da OU Alumnos

### Obxectivo
Aplicar unha directiva de grupo que impida aos usuarios da OU **Alumnos** acceder á unidade `C:`.

### Pasos realizados

1. Abrir **Administración de directivas de grupo** no servidor.
2. Crear unha nova GPO chamada:
   - `Bloquear_C_Alumnos`
3. Vincular a GPO á OU:
   - `Alumnos`
4. Editar a GPO e navegar ata:
   - `Configuración de usuario > Plantillas administrativas > Compoñentes de Windows > Explorador de ficheiros`
5. Activar a directiva:
   - **Impedir o acceso ás unidades desde O meu PC**
6. Seleccionar:
   - `Restringir só a unidade C`
  
<img width="812" height="571" alt="image" src="https://github.com/user-attachments/assets/17b43384-2ceb-4fa8-a9d7-76e75ae117ca" />

<img width="991" height="602" alt="image" src="https://github.com/user-attachments/assets/720b6ff4-d3d3-45a3-b585-0226747142ca" />

### Comprobación

1. Iniciar sesión cun usuario pertencente á OU **Alumnos**.
2. Abrir o **Explorador de ficheiros**.
3. Intentar facer dobre clic sobre `Disco local (C:)`.

### Resultado observado

Ao intentar acceder á unidade `C:`, aparece unha mensaxe indicando que a operación foi cancelada debido ás restricións establecidas polo administrador do sistema.

### Evidencias

- `Ex1.jpg`
  - Captura da ventá de Administración de directivas de grupo mostrando onde está vinculada a GPO.

---

# 2. Impedir o acceso ao Panel de Control aos usuarios do dominio

## Obxectivo

Evitar que os usuarios do dominio poidan acceder ao Panel de Control.

## Pasos realizados

1. Crear unha nova GPO chamada:
   - `Bloquear_Panel_Control`
2. Vincular a GPO ao dominio.
3. Editar a directiva e acceder a:
   - `Configuración de usuario > Plantillas administrativas > Panel de control`
4. Activar:
   - **Prohibir o acceso ao Panel de control e á configuración do PC**

## Comprobación

### Cun profesor

1. Iniciar sesión cun usuario profesor.
2. Intentar abrir o Panel de control.

### Cun administrador do dominio

1. Iniciar sesión co administrador do dominio nun cliente.
2. Intentar abrir o Panel de control.

## Resultado observado

- O profesor non pode acceder ao Panel de control.
- O administrador do dominio tampouco pode acceder, xa que a directiva aplícase a todos os usuarios do dominio.

## Evidencias

- `Ex2`
  - Vídeo mostrando o efecto da directiva no cliente.
- `Ex2.jpg`
  - Captura da Administración de directivas de grupo mostrando a vinculación da GPO.

---

<img width="816" height="307" alt="image" src="https://github.com/user-attachments/assets/eeb0bd0a-0a11-4c19-ae12-cc8a235e8cff" />
<img width="660" height="326" alt="image" src="https://github.com/user-attachments/assets/1dcb3f43-2af5-464c-8f8a-5aa6b06a87e5" />
<img width="995" height="532" alt="image" src="https://github.com/user-attachments/assets/162590ae-40c5-4663-b910-cfa3c2673969" />
<img width="848" height="809" alt="image" src="https://github.com/user-attachments/assets/e18105a9-0d94-4521-bbe5-03d3f3833828" />

# 3. Configuración de WSUS mediante GPO

## Obxectivo

Configurar os equipos do dominio para que se actualicen diariamente ás 19:00 utilizando un servidor WSUS interno coa IP:


```txt
10.1.0.200
```
<img width="1261" height="703" alt="image" src="https://github.com/user-attachments/assets/9ee8435a-b83d-40b5-b447-196e0beee6e6" />
<img width="1282" height="600" alt="image" src="https://github.com/user-attachments/assets/81645c2d-a163-48fa-be21-d6ea5c89572d" />
<img width="894" height="432" alt="image" src="https://github.com/user-attachments/assets/58ec504b-2920-45ca-a108-da9f5f3fe213" />

#☻ 4.Eliminar todas las GPO creadas

<img width="749" height="513" alt="image" src="https://github.com/user-attachments/assets/fb36accc-24a9-4f86-b590-b7ac96c86313" />
<img width="729" height="443" alt="image" src="https://github.com/user-attachments/assets/fb21d800-5ec0-4674-8dd2-8a6d68f3bad1" />
<img width="884" height="546" alt="image" src="https://github.com/user-attachments/assets/e5e63dd3-336e-4185-8773-963408f7ff7a" />
<img width="489" height="490" alt="image" src="https://github.com/user-attachments/assets/acca1e6d-6eec-4af0-9ef3-0a040f3552c9" />

