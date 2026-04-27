# 🌐 Cálculo de Segmentos y Direccionamiento VLSM

![alt text](capturas/image.png)

## 1. Identificación de Segmentos de Red

Para saber cuántos segmentos de red hay en un esquema de red, eliminamos mentalmente los routers, puesto que estos dispositivos están interconectados a las redes.

* **Regla de oro:** Todas las partes que queden aisladas, aunque solo sean un cable, son una red.
* **Resultado:** Cada segmento de red físico dará lugar a una subred.

---

## 2. Aplicación de VLSM (Máscaras de Longitud Variable)

Utilizando la dirección de red **172.16.0.0**, realiza los siguientes ejercicios:

### A. Número de Subredes

* **Pregunta:** Indica el número de subredes a direccionar según el esquema propuesto:
*(Espacio para respuesta)*

### B. Tabla de Planificación de Bloques

Completa la siguiente tabla calculando el tamaño necesario para cada subred:

| Red | Hosts | Tamaño del bloque             | Máscara de subred        |
|:----|:------|:------------------------------|:-------------------------|
| B   | 300+2 | 2<sup>n</sup>=302 -> n=9(512) | 32-9=23->255.255.254.0   |
| A   | 128+2 | 2<sup>n</sup> ->n=8(256)      | 32-8=24->255.255.255.0   |
| C   | 35+2  | 2<sup>n</sup> -> n=6(64)      | 32-6=26 255.255.255.192  |
| D   | 2+2   | 2<sup>n</sup> -> n=2(4)       | 32-2= 30 255.255.255.252 |
| E   | 2+2   | 2<sup>n</sup> -> n=2(4)       | 32-2= 30 255.255.255.252 |

### C. Registro Detallado de Subredes

Ordena las subredes de **mayor a menor** número de hosts y completa la tabla de direccionamiento:
*nota se pone el + 2 porque hay que reservar para dirección de red y broadcast*

| Red | Hosts | Dir. Red    | Máscara de subred | Dir. Broadcast | Rango de direc. válidas     |
|:----|:------|:------------|:------------------|:---------------|:----------------------------|
| B   | 300+2 | 172.16.0.0  | /23               | 172.16.1.255   | [172.16.0.1 - 172.16.1.254] |
| A   | 126+2 | 172.16.2.0  | /24               | 172.16.2.255   | [172.16.2.1 - 172.16.2.254] |
| C   | 35+2  | 172.16.3.0  | /26               | 172.16.3.63    | [172.16.3.1 - 172.16.3.62]  |
| D   | 2+2   | 172.16.3.64 | /30               | 172.16.3.67    | [172.16.3.65 - 172.16.3.66] |
| E   | 2+2   | 172.16.3.68 | /30               | 172.16.3.71    | [172.16.3.69 - 172.16.3.70] |

---

## 3. Asignación de Direcciones a las Interfaces

Una vez que las redes están identificadas mediante su dirección de red, se procede a asignar una dirección a cada una de las interfaces de red que tiene presencia en la red.

* **Norma general:** Aunque se puede asignar cualquier dirección válida (entre la de red y broadcast), es costumbre asignar la **primera dirección útil al router (puerta de enlace)** y el resto a los hosts.
* **Configuración Estática:** Se realiza de forma manual en dispositivos que deben permanecer fijos (routers y servidores).
* **Configuración Dinámica:** Para los hosts comunes, se aplican procedimientos automáticos basados en el protocolo **DHCP**.

---

## 4. Tablas de Enrutamiento (R1 y R2)

Para que un paquete IP pueda llegar a su destino, los routers deben tener configurada su tabla de enrutamiento. Esta indica, para cada red de destino, la interfaz de salida y el siguiente salto (gateway).

**Columnas esenciales de la tabla:**

1. Dirección de red de destino.
2. Máscara de la red de destino.
3. Interfaz de salida.
4. Gateway (Siguiente salto).

Tabla enrutamiento del router R1

| Red         | Máscara | Interfaz | Gateway     |
|:------------|:--------|:---------|:------------|
| 172.16.0.0  | /23     | Eth0     | 172.16.3.66 |
| 172.16.2.0  | /24     | Eth1     | -           |
| 172.16.3.0  | /26     | Eth0     | 172.16.3.66 |
| 172.16.3.64 | /30     | Eth0     | -           |
| 172.16.3.68 | /30     | Eth0     | 172.16.3.66 |

Tabla enrutamiento del router R2 ***POR HACER***

| Red         | Máscara | Interfaz | Gateway     |
|:------------|:--------|:---------|:------------|
| 172.16.0.0  | /23     | Eth0     |172.16.3.69  |
| 172.16.2.0  | /24     | Eth0     |172.16.3.69  |
| 172.16.3.0  | /26     | Eth1     | -           |
| 172.16.3.64 | /30     | Eth0     | 172.16.3.69 |
| 172.16.3.68 | /30     | Eth0     | -           |
