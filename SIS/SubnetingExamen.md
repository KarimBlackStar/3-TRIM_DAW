# UNIDADES DEL 3° TRIMESTRE
## UNIDAD 5: CONEXIÓN DE SISTEMAS EN REDE

### PARTE PRÁCTICA (8 pts)

#### Actividad 1: [1 pto]
1. Dadas las siguientes direcciones IP en notación CIDR, identificar qué 2 IPs pertenecen a la misma subred:
   * **Grupo 1:** 10.100.134.115/11
   * **Grupo 2:** 10.126.138.113/11
   * **Grupo 3:** 10.136.135.179/11

#### Actividad 2: [2 pts]
2. Supongamos que tenemos asignada la IP `172.16.0.0/16` a una red que es preciso dividir en 4 subredes. Indica:
   * **Nº Bits para el nº de red:** _________________
   * **Nº Bits para el nº de subred:** ______________
   * **Nº Bits para el nº de equipo:** ______________
   * **Máscara de subred que tendremos que usar en formato decimal separado por puntos:** _________________
   * **¿Cuántos ordenadores admitirá cada una de las subredes?** _________________

---

#### Actividad 3: [5 pts]
3. Dada la siguiente topología de red:

<img width="713" height="342" alt="image" src="https://github.com/user-attachments/assets/9d043d9c-2e25-4e8c-a7e7-e4f2ef5a4384" />


##### a) Completa la siguiente tabla:

| Red | Host | Dir de red | Máscara | Dir de Broadcast | Rango de direcciones válidas |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Red A** | 128 hosts | | | | |
| **Red B** | 300 hosts | | | | |
| **Red C** | 35 hosts | | | | |
| **Red D** | | | | | |
| **Red E** | | | | | |

##### b) Completa la tabla de enrutamiento:

| Red | Máscara | Interfaz | Gateway |
| :--- | :--- | :--- | :--- |
| | | | |
| | | | |
| | | | |
| | | | |

---

## UNIDAD 6: XESTIÓN DE RECURSOS NUNHA REDE

### PARTE PRÁCTICA (8 pts)

#### Actividad 1: [4 pts]
1. En el equipo Debian se encuentra instalado un servidor de SSH.
   
   **a)** Arranca el servicio SSH para que escuche en el **puerto 222**, y sólo se permita el acceso remoto por SSH al **usuario con tu nombre**.
   * Muestra las configuraciones que realices. Captura de pantallas y explicación.
   * Muestra que te conectas con el usuario con tu nombre desde un equipo cliente Debian. Captura de pantalla y explicación.

   **b)** A continuación conéctate por SSH desde el anfitrión con tu usuario. ¿Qué significado tiene el mensaje que te aparece a continuación?
   * Muestra todas las configuraciones que realices. Captura de pantalla y explicación.
   * Muestra cómo te conectas con el usuario con tu nombre desde el anfitrión. Captura de pantalla.

#### Actividad 2: [4 pts]
2. En la MV Debian proporcionada para el examen, crea un usuario con tu nombre. Crea una carpeta `Compartir_[tu nombre]` en el home de tu usuario y dentro de la carpeta un fichero `soy_[tu nombre]`.

   **a)** Comparte la carpeta `Compartir_[tu nombre]` para que **solo tu usuario pueda leer**. Muestra cómo la compartes desde el equipo Debian.
   
   **b)** Accede al recurso compartido desde W10. ¿Qué sucede si intentas crear un nuevo contenido en la carpeta o modificar el fichero `soy_[tu nombre]`? ¿Por qué? Muestra captura de cómo accedes al recurso compartido.
