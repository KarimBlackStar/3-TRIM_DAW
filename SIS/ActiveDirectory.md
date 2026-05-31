## Cambiar de nombre

Servidor Local > Nombre > Cambiar

<img width="620" height="233" alt="image" src="https://github.com/user-attachments/assets/2198a3f7-3b48-4670-820c-94430500ddfe" />

<img width="588" height="554" alt="image" src="https://github.com/user-attachments/assets/fb64cf97-0b09-4ce8-af09-936723d9dc2d" />

## Configurar IP estática

Configuración de red > Ethernet > Editar

<img width="314" height="165" alt="image" src="https://github.com/user-attachments/assets/d83bf160-3a8a-4c12-8827-f06b4b7f4dd6" />

<img width="480" height="545" alt="image" src="https://github.com/user-attachments/assets/38179e90-e7c3-4791-8ca5-572fecb2becc" />

Administrar > Roles y características > Siguientes hasta llegar a Roles de sevidor > Descargamos los 3 roles, que nos interesan, DNS, DHCP y Servicios de dominio Active Directory > Siguiente hasta Confirmación > Instalar > Reiniciamos

<img width="489" height="226" alt="image" src="https://github.com/user-attachments/assets/3ae0d927-3cc8-4350-a6a0-446e910a6f60" />
<img width="837" height="623" alt="image" src="https://github.com/user-attachments/assets/66e59022-eebd-4f2e-ae05-17fa07529efb" />
<img width="311" height="177" alt="image" src="https://github.com/user-attachments/assets/4901597d-6c4e-43a4-a350-9d882874915f" />

Seleccionamos la banderita y realizamos la promoción de momento, mas tarde completamos la otra banderita, es IMPORTANTE
<img width="391" height="152" alt="image" src="https://github.com/user-attachments/assets/4c33dbb9-bb51-4f4a-8c66-34fc43c676ea" />

<img width="743" height="458" alt="image" src="https://github.com/user-attachments/assets/d5864e3c-89cc-4a33-9b25-4288ecde31ce" />

<img width="802" height="547" alt="image" src="https://github.com/user-attachments/assets/61256ebf-34cc-46cd-a1fc-036e10612374" />

VIP PONER EL .local, sino DARA ERROR
Le damos Siguiente, cargará 1 min, otra vez Siguiente sin parar hasta Instalar > Luego Cerramos hasta que se reinicie solo

Herramientas > DHCP > Click Derecho a IPv4 > Ámbito nuevo
<img width="712" height="568" alt="image" src="https://github.com/user-attachments/assets/7a0af91f-1a45-4762-a288-a56a9fa36a39" />
<img width="769" height="632" alt="image" src="https://github.com/user-attachments/assets/e2b663ce-d033-4330-9f3c-f0c242ed7dab" />

La IP final podemos poner lo que quieras

<img width="557" height="448" alt="image" src="https://github.com/user-attachments/assets/37d516bc-62b0-4ed4-a2dd-a7f62aee9c99" />

Siguiente hasta Configurar mas tarde, pero la profe nos tiene que dar la gateway > Finalizar

Ahora configuramos el DNS en Herramientas > Click derecho > Configurar servidor DNS > 
<img width="622" height="404" alt="image" src="https://github.com/user-attachments/assets/ec0abf4c-fa2a-442c-a6ad-ef87a8be57fd" />
Siguiente hasta nombre de zona > 
<img width="531" height="412" alt="image" src="https://github.com/user-attachments/assets/156136a7-816a-4bab-bc57-95cf4ac69197" />

Aqui deberiamos poner la IP que nos de la profe, sino usamos la IP designada
<img width="505" height="390" alt="image" src="https://github.com/user-attachments/assets/89a86ee7-6332-4f40-8700-ceb60ff33070" />
<img width="832" height="668" alt="image" src="https://github.com/user-attachments/assets/efb54240-c851-474c-b80f-3570664b32fd" />
<img width="792" height="709" alt="image" src="https://github.com/user-attachments/assets/7abd3a69-b416-4392-b854-ef956898457a" />
<img width="625" height="542" alt="image" src="https://github.com/user-attachments/assets/ff6fe0f3-aac0-436a-a4db-d52fbdd34209" />

EN el administrador de DNS> llegamos hasta Zonas de búsqueda, creamos una nueva > Siguiente hasta poner la IP > Siguiente hasta Finalizar
<img width="762" height="489" alt="image" src="https://github.com/user-attachments/assets/cd6106fd-a2d1-49dc-8104-e8d9d4c8eb10" />
<img width="600" height="410" alt="image" src="https://github.com/user-attachments/assets/8b0e1150-99b1-4031-9d6c-774e463d77dd" />

Nuevo puntero PTR > 

<img width="717" height="607" alt="image" src="https://github.com/user-attachments/assets/c413f526-c58b-4c84-9437-0cec77966732" />

<img width="457" height="461" alt="image" src="https://github.com/user-attachments/assets/1eb289b6-1fbd-46d7-9951-fb2a230d7f22" />

En el cmd, ponemos el comando ```nslookup ``` + la ip que creamos antes en el arpa

<img width="545" height="197" alt="image" src="https://github.com/user-attachments/assets/44b62c43-bc23-4b46-b6ea-af056597f436" />

--- 

Herramientas > Usuarios y equipos de Active Directory

<img width="504" height="748" alt="image" src="https://github.com/user-attachments/assets/21191390-6359-4243-8e59-3674f7326e30" />

<img width="631" height="447" alt="image" src="https://github.com/user-attachments/assets/28472fdb-ad57-4791-bac9-905e1513782d" />

<img width="636" height="427" alt="image" src="https://github.com/user-attachments/assets/1b48f2e7-4667-4e6b-920a-f0d482383711" />

<img width="595" height="435" alt="image" src="https://github.com/user-attachments/assets/c96e46ce-daf3-4824-a623-1147697225b8" />

<img width="586" height="415" alt="image" src="https://github.com/user-attachments/assets/1716771c-6323-423f-a3c2-065f63a8df61" />
<img width="497" height="413" alt="image" src="https://github.com/user-attachments/assets/879358aa-1ff0-4b99-9f7d-1536a3b13410" />
<img width="514" height="400" alt="image" src="https://github.com/user-attachments/assets/b8329c63-6f9d-4264-8996-b49a0ef42a9e" />
<img width="681" height="417" alt="image" src="https://github.com/user-attachments/assets/381492fa-1ef0-4ead-9052-cdba15be9d24" />

INICIAMOS POR FIN LA MV DEL CLIENTE

Para ello hay que Activar el Ámbito del IPv4

<img width="484" height="489" alt="image" src="https://github.com/user-attachments/assets/dbfe1c97-85a2-4b04-bf75-6c514fbabd2b" />

Windows+R > ncpa.cpl > Propiedades  > IPv4 > Propiedades
<img width="595" height="432" alt="image" src="https://github.com/user-attachments/assets/28bfd859-7275-4fe2-80f9-a94f8ec70472" />
<img width="645" height="501" alt="image" src="https://github.com/user-attachments/assets/d9eedf15-45e6-46a5-98be-ba8f94b88cb9" />
<img width="460" height="506" alt="image" src="https://github.com/user-attachments/assets/7f013c0e-65e0-4b05-8df3-b3b7eaa838c6" />
Cambiamos el dominio
<img width="797" height="510" alt="image" src="https://github.com/user-attachments/assets/131d0edd-6544-4572-a728-7f8b56f25c3a" />

Cerramos > reiniciamos > cmd > ipconfig /renew

<img width="571" height="570" alt="image" src="https://github.com/user-attachments/assets/7946a47e-cfaf-44c9-aad5-c6c93f1d2bfe" />
Metemos el dominio
<img width="991" height="676" alt="image" src="https://github.com/user-attachments/assets/27e16ba8-ec08-447b-a9ac-323ea77af2ae" />
Metemos el Admin y reiniciamos una vez nos salga que todo esta correcto
<img width="525" height="376" alt="image" src="https://github.com/user-attachments/assets/3d019ee3-8b01-4bcf-8c96-3f2f27ff9856" />
Añadimos el usuario nuevo 
<img width="832" height="724" alt="image" src="https://github.com/user-attachments/assets/04219e01-4fc7-40b9-8e23-f668017c726b" />

---

## Crear grupos

<img width="457" height="788" alt="image" src="https://github.com/user-attachments/assets/aa56b3bb-a02c-4a3f-ab70-bba3a9522b34" />

<img width="785" height="502" alt="image" src="https://github.com/user-attachments/assets/175698f3-15de-4fb2-835b-8842deaba1b7" />

<img width="774" height="547" alt="image" src="https://github.com/user-attachments/assets/93ca8629-d6a2-445f-bd8c-8188a1aab5bf" />

<img width="526" height="321" alt="image" src="https://github.com/user-attachments/assets/f70c7267-81bd-4b2c-9d45-9e52de561ddf" />
<img width="378" height="178" alt="image" src="https://github.com/user-attachments/assets/080f6996-b281-4029-be52-da7523b99fea" />

---

## GPO 

REVISAR ENTREGABLE

<img width="425" height="67" alt="image" src="https://github.com/user-attachments/assets/a27c79e8-ca9b-4d81-90a7-6d813f398c76" />
