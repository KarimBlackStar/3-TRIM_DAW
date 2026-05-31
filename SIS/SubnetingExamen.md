# UNIDADES DEL 3° TRIMESTRE
## UNIDAD 5: CONEXIÓN DE SISTEMAS EN REDE

### Actividad 1: [1 pto] Dadas las siguientes direcciones IP en notación CIDR, identificar qué 2 IPs pertenecen a la misma subred:
   * **Grupo 1:** 10.100.134.115/11
   * **Grupo 2:** 10.126.138.113/11
   * **Grupo 3:** 10.136.135.179/11

/11 = 11111111.11100000.00000000.00000000

11100000=224

256-224=32 bloques

0,32,64,96,128

+ 100 está entre 96 y 128

+ 126 está entre 96 y 128

+ 136 NO está entre 96 y 128

*El grupo 1 y 2 pertenecen a la misma subred!*

### Actividad 2: [2 pts] Supongamos que tenemos asignada la IP `172.16.0.0/16` a una red que es preciso dividir en 4 subredes. Indica:
   * **Nº Bits para el nº de red:** --> 16 (La pista nos la da la máscara)
   * **Nº Bits para el nº de subred:** --> 2
     
2<sup>n</sup> = 4

n?

2<sup>2</sup> = 4

n=2

   * **Nº Bits para el nº de equipo:** --> 14 bits

32-(BR+BS) = 32-(16+2) = 14
   * **Máscara de subred que tendremos que usar en formato decimal separado por puntos:** --> 255.255.192.0

16+2=18

11111111.11111111.11000000.00000000

    8  +    8    +    2    +  0  =  18
    
   * **¿Cuántos ordenadores admitirá cada una de las subredes?** --> 16382

$$\text{Ordenadores} = 2^{14} - 2 = 16384 - 2 = \mathbf{16382}$$

## 🧮 Fórmulas de Subnetting (IPv4)

### 1. Identificación de Bits Iniciales
Los bits de la red principal vienen dados directamente por la notación CIDR original del enunciado:

$$\text{Bits de Red (BR)} = X \quad \text{(de la IP base } /X\text{)}$$

### 2. Cálculo de Bits de Subred
Para calcular cuántos bits ($n$) necesitamos pedir prestados, buscamos la potencia de 2 que iguale o supere el número de subredes deseadas:

$$2^n \ge \text{Subredes Requeridas}$$

$$\text{Bits de Subred (BS)} = n$$

### 3. Cálculo de Bits de Host (Equipos)
Como una dirección IPv4 tiene un tamaño fijo de 32 bits, el resto de bits disponibles se asignan a los equipos:

$$\text{Bits de Host (BH)} = 32 - (\text{BR} + \text{BS})$$

### 4. Número de Hosts Disponibles por Subred
Calculamos las combinaciones posibles con los bits de host y restamos $2$ (la dirección de red y la dirección de broadcast, que no se pueden asignar a ningún equipo):

$$\text{Hosts Útiles} = 2^{\text{BH}} - 2$$

### 5. Nueva Máscara de Subred
La nueva máscara total en formato CIDR es la suma de los bits de red y subred:

$$\text{Nueva Máscara (CIDR)} = /(\text{BR} + \text{BS})$$

> 💡 **Para pasar a formato decimal:** Escribe tantos `1` seguidos como indique la suma $(\text{BR} + \text{BS})$ hasta completar los 4 octetos (32 bits), rellena el resto con `0` y traduce cada bloque de 8 bits a decimal.
---

#### Actividad 3: [5 pts]
3. Dada la siguiente topología de red:

<img width="713" height="342" alt="image" src="https://github.com/user-attachments/assets/9d043d9c-2e25-4e8c-a7e7-e4f2ef5a4384" />


##### a) Completa la siguiente tabla:

| Red | Host | Dir de red | Máscara | Dir de Broadcast | Rango de direcciones válidas |
| :--- | :--- | :--- | :--- | :--- | :--- |
| Red B | 300 | 172.16.0.0 | 255.255.254.0 /23 | 172.16.1.255 | 172.16.0.1 - 172.16.1.254 |
| Red A | 128 | 172.16.2.0 | 255.255.255.0 /24 | 172.16.2.255 | 172.16.2.1 - 172.16.2.254 |
| Red C | 35 | 172.16.3.0 | 255.255.255.192 /26 | 172.16.3.63 | 172.16.3.1 - 172.16.3.62 |
| Red D | 2 | 172.16.3.64 | 255.255.255.252 /30 | 172.16.3.67 | 172.16.3.65 - 172.16.3.66 |
| Red E | 2 | 172.16.3.68 | 255.255.255.252 /30 | 172.16.3.71 | 172.16.3.69 - 172.16.3.70 |

<img width="793" height="227" alt="image" src="https://github.com/user-attachments/assets/1d15fba9-9b2d-4879-a09d-b722973d03ec" />


##### b) Completa la tabla de enrutamiento:

| Red | Máscara | Interfaz | Gateway |
| :--- | :--- | :--- | :--- |
| **Para R1:** | | | |
| `172.16.0.0` (Red B) | `255.255.254.0` | `eth0` | `172.16.3.66` |
| `172.16.3.0` (Red C) | `255.255.255.192` | `eth0` | `172.16.3.66` |
| `172.16.3.68` (Red E) | `255.255.255.252` | `eth0` | `172.16.3.66` |
| **Para R2:** | | | |
| `172.16.2.0` (Red A) | `255.255.255.0` | `eth0` | `172.16.3.65` |
| `172.16.3.0` (Red C) | `255.255.255.192` | `eth1` | `172.16.3.70` |
| **Para R3:** | | | |
| `172.16.2.0` (Red A) | `255.255.255.0` | `eth0` | `172.16.3.69` |
| `172.16.0.0` (Red B) | `255.255.254.0` | `eth0` | `172.16.3.69` |
| `172.16.3.64` (Red D) | `255.255.255.252` | `eth0` | `172.16.3.69` |
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

---

