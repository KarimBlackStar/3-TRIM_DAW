# 🌐 Actividades Básicas: Subneting

### 1. Cálculos de Red y Rango
* **Dirección de Red:** Si tienes la dirección IP `192.168.56.1` y la máscara de subred `255.255.255.0`, calcula cuál será la dirección de red.
192.168.56.1 → 11000000.10101000.00111000.00000001
255.255.255.0 → 11111111.11111111.11111111.00000000
AND → 11000000.10101000.00111000.00000000
Dir Red → 192.168.56.0

* **Rango y Broadcast:** Desde la red `172.16.0.0/16`, indica cuál sería el rango válido de direcciones IP y la dirección de broadcast.
32-16=16
Dir Red : 172.16.0.0
Dir Broadcast: 172.16.255.255(172.16.11111111.11111111)

### 2. Pertenencia a Red
De la siguientes direcciones IP indica cuáles **sí** y cuáles **no** pertenecería a la red `192.168.20.0/22`:
* `192.160.20.5`
* `192.168.20.5`
* `192.168.22.5`
* `192.168.24.5`

### 3. División en Subredes
* Divide la siguiente red en **cuatro subredes**: `192.168.10.0/24`.
192.168.20.0 → [192.168.000101][00.00000000] dir red
192.168.23.255 → [192.168.000101][11.11111111] dir broadcast
Rango [192.168.20.1-192.168.23.254]
SI→b,c
NO→a,d

---

### 4. Identificación de Clases y Hosts
Indica la máscara por defecto, la dirección de red e el número de hosts que se pueden incluir en cada red para las siguientes direcciones IP:

4 SUBREDES = 2^2 -> 2 bits a mayores del 4 octeto para hacer las 4 subredes 
[192.168.10.00][000000] 

32-26= 6 bits para hosts

Red 1: [192.168.10.00][000000] Dir red -> 192.168.10.0   Dir BoradCast -> 192.168.10.63 [192.168.10.00][111111] 
   Rango [192.168.10.0 - 192.168.10.62]
   
Red 2: [192.168.10.01][000000] Dir red -> 192.168.10.64   Dir BoradCast -> 192.168.10.127 [192.168.10.01][111111]
   Rango [192.168.10.65 - 192.168.10.126]
   
Red 3: [192.168.10.10][000000] Dir red -> 192.168.10.128   Dir BoradCast -> 192.168.10.191 [192.168.10.10][111111]
   Rango [192.168.10.129 - 192.168.10.190]
   
Red 4: [192.168.10.11][000000] Dir red -> 192.168.10.192   Dir BoradCast -> 192.168.10.255 [192.168.10.11][111111]
   Rango [192.168.10.193 - 192.168.10.254]

   
| Dir. IP | Clase | Máscara defecto | Dir. Rede | Hosts / Rede |
| :--- | :--- | :--- | :--- | :--- |
| :177.100.18.4 | B | 255.255.0.0/16 | 177.100.0.0 | Host: 2^16 |
| :119.18.45.0 | A | 255.0.0.0 /8 | 119.0.0.0 | Host: 2^24 |
| :191.249.234.191 | B | 255.255.0.0 /16 | 191.249.0.0 | Host: 2^16 |
| :223.23.223.109 | C | 255.255.255.0 /24 | 223.23.223.0 | Host: 2^8 |
| :10.10.250.1 | A | 255.0.0.0 /24 | 10.0.0.0 | Host: 2^24 |
| :126.123.23.1 | A | 255.0.0.0 /24 | 126.0.0.0 | Host: 2^24 |
| :223.69.230.250 | C | 255.255.255.0 /24 | 223.69.230.0 | Host: 2^8 |
| :192.12.35.105 | | | | |
| :77.251.200.51 | | | | |
| :189.210.50.1 | | | | |
| :88.45.65.35 | | | | |
| :128.212.250.254 | | | | |
| :193.100.77.83 | | | | |
| :125.125.250.1 | | | | |
| :1.1.10.50 | | | | |
| :220.90.130.45 | | | | |
| :134.125.34.9 | | | | |
| :95.250.91.99 | | | | |
| :156.25.35.89 | | | | |
| :127.0.25.250 | | | | |

---

### 5. Establecimiento de Direcciones IP
Establece las direcciones IP de una red que conste de la siguientes subredes (usa una dirección de red Clase A, B o C que se ajuste a las necesidades):
* 10 subredes de 310 equipos -> 3.100 equipos
* 18 subredes de 90 equipos -> 1.620 equipos
* 23 subredes de 110 equipos -> 2.530 equipos
* 12 subredes de 40 equipos -> 480 equipos

**Se pide:**
1. La dirección IP de la red y la clase (escoger una red cualquiera de la clase adecuada).
2. Direcciones de los **5 primeros segmentos** de red de cada tipo, sus direcciones de broadcast y el rango de direcciones para los equipos en cada una de ellas.

---

### 6. Casos Prácticos
* **División VLSM:** A partir de la dirección de red `172.16.0.0/16` realizar la división de subredes para la topología del gráfico.
* **Administrador de Colegio:** El ISP proporciona la dirección `177.19.156.0` con la máscara `255.255.252.0`.
    * **Nota:** Empieza a asignar IPs en la dirección: `177.19.157.0`.
