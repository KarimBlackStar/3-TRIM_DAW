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

Seleccionamos la banderita y realizamos la promoción de momento
<img width="391" height="152" alt="image" src="https://github.com/user-attachments/assets/4c33dbb9-bb51-4f4a-8c66-34fc43c676ea" />

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

