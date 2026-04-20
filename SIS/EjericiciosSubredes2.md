# 🌐 Actividades Básicas: Subneting

### 1. Cálculos de Red y Rango
* **Dirección de Red:** Si tienes la dirección IP `192.168.56.1` y la máscara de subred `255.255.255.0`, calcula cuál será la dirección de red.
* **Rango y Broadcast:** Desde la red `172.16.0.0/16`, indica cuál sería el rango válido de direcciones IP y la dirección de broadcast.

### 2. Pertenencia a Red
De la siguientes direcciones IP indica cuáles **sí** y cuáles **no** pertenecería a la red `192.168.20.0/22`:
* `192.160.20.5`
* `192.168.20.5`
* `192.168.22.5`
* `192.168.24.5`

### 3. División en Subredes
* Divide la siguiente red en **cuatro subredes**: `192.168.10.0/24`.

---

### 4. Identificación de Clases y Hosts
Indica la máscara por defecto, la dirección de red e el número de hosts que se pueden incluir en cada red para las siguientes direcciones IP:

| Dir. IP | Clase | Máscara defecto | Dir. Rede | Hosts / Rede |
| :--- | :--- | :--- | :--- | :--- |
| 177.100.18.4 | | | | |
| 119.18.45.0 | | | | |
| 191.249.234.191 | | | | |
| 223.23.223.109 | | | | |
| 10.10.250.1 | | | | |
| 126.123.23.1 | | | | |
| 223.69.230.250 | | | | |
| 192.12.35.105 | | | | |
| 77.251.200.51 | | | | |
| 189.210.50.1 | | | | |
| 88.45.65.35 | | | | |
| 128.212.250.254 | | | | |
| 193.100.77.83 | | | | |
| 125.125.250.1 | | | | |
| 1.1.10.50 | | | | |
| 220.90.130.45 | | | | |
| 134.125.34.9 | | | | |
| 95.250.91.99 | | | | |
| 156.25.35.89 | | | | |
| 127.0.25.250 | | | | |

---

### 5. Establecimiento de Direcciones IP
Establece las direcciones IP de una red que conste de la siguientes subredes (usa una dirección de red Clase A, B o C que se ajuste a las necesidades):
* 10 subredes de 310 equipos.
* 18 subredes de 90 equipos.
* 23 subredes de 110 equipos.
* 12 subredes de 40 equipos.

**Se pide:**
1. La dirección IP de la red y la clase (escoger una red cualquiera de la clase adecuada).
2. Direcciones de los **5 primeros segmentos** de red de cada tipo, sus direcciones de broadcast y el rango de direcciones para los equipos en cada una de ellas.

---

### 6. Casos Prácticos
* **División VLSM:** A partir de la dirección de red `172.16.0.0/16` realizar la división de subredes para la topología del gráfico.
* **Administrador de Colegio:** El ISP proporciona la dirección `177.19.156.0` con la máscara `255.255.252.0`.
    * **Nota:** Empieza a asignar IPs en la dirección: `177.19.157.0`.