# Ejercicio de Redes: Esquema de Subredes

## A) Diseño de Subredes
La empresa quiere organizar sus equipos según el esquema proporcionado, partiendo de la dirección de red **192.168.1.0**.

### Requisitos de Host
* **Subredes A, B y C:** 50 equipos cada una
* **Subredes D y E:** 20 equipos cada una

### Nuevas Máscaras de Red
* **SRA, SRB y SRC:** La máscara será **255.255.255.192** (/26)
* **SRD y SRE:** La máscara será **255.255.255.224** (/27)

---

## B) Tabla de Subredes (Resumen)

| Nombre subred | IP de red | Máscara (decimal) | 1ª IP hosts | Última IP hosts | IP Broadcast |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **SRA** | 192.168.1.0 | 255.255.255.192 | 192.168.1.1 | 192.168.1.62 | 192.168.1.63 |
| **SRB** | 192.168.1.64 | 255.255.255.192 | 192.168.1.65 | 192.168.1.126 | 192.168.1.127 |
| **SRC** | 192.168.1.128 | 255.255.255.192 | 192.168.1.129 | 192.168.1.190 | 192.168.1.191 |
| **SRD** | 192.168.1.192 | 255.255.255.224 | 192.168.1.193 | 192.168.1.222 | 192.168.1.223 |
| **SRE** | 192.168.1.224 | 255.255.255.224 | 192.168.1.225 | 192.168.1.254 | 192.168.1.255 |

---

## C) Tabla de Direcciones de R1 (Router 1)

Configuración basada en la primera IP válida de cada subred:

| Nombre subred | Interfaz | IP/Máscara (CIDR) |
| :--- | :--- | :--- |
| **SRA** | eth0 | 192.168.1.1/26 |
| **SRB** | eth1 | 192.168.1.65/26 |
| **SRC** | eth2 | 192.168.1.129/26 |
| **SRD** | eth3 | 192.168.1.193/27 |
| **SRE** | eth4 | 192.168.1.225/27 |

---

## D) Preguntas Teóricas

**¿Cuántas IPs se pierden al crear estas redes?**
* Se pierden un total de **10 IPs**.

**¿A qué se debe?**
* Por cada una de las 5 subredes creadas, se reservan **2 direcciones no asignables a equipos**: una para la dirección de la propia red y otra para la dirección de difusión o broadcast.