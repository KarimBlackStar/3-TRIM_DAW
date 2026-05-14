# Examen servidores

> Antes de nada importante configurar la red a INTERNA y poner el nombre adecuado
> <img width="820" height="502" alt="image" src="https://github.com/user-attachments/assets/17fefaba-dee6-4fd8-a5c2-2910fb9edfa3" />


## Servidor

+ 1º Abrir el servidor y cambiar el nombre(te pedirá reiniciar)
  + Para esto vamos a Servidor Local y cliclamos en el nombre del servidor, la cambiamos a nuestro gusto, y nos recordará que debemos reiniciar.
    <img width="535" height="208" alt="image" src="https://github.com/user-attachments/assets/d885b746-45dd-4224-961a-6e1640c3b3eb" />
    <img width="526" height="528" alt="image" src="https://github.com/user-attachments/assets/6ba5b950-213f-4b10-a837-6cfa943ef554" />
    <img width="424" height="481" alt="image" src="https://github.com/user-attachments/assets/5aea4973-20af-4c7a-bebe-38ce428ac29d" />

+ 2º 
<img width="1097" height="616" alt="image" src="https://github.com/user-attachments/assets/e67e1d01-0ca4-49cd-b833-0e8df72292ec" />
Posteriormente le damos a *siguiente* hasta la pestaña ***Roles de servidor**, marcamos la casilla *Servicios de dominio de Active Directory* y agregamos las características por defecto:
<img width="1011" height="534" alt="image" src="https://github.com/user-attachments/assets/0511b56c-206b-4f82-be89-570c8f421ee5" />

Después le damos a *siguiente* hasta llegar a la última pestaña, activamos la casilla de reinicio automático e instalamos!
<img width="1019" height="624" alt="image" src="https://github.com/user-attachments/assets/ff2311ce-a829-4695-b5b2-3f351d5c0887" />

Una vez terminada la instalción, le damos al botónde *Cerrar*
<img width="800" height="511" alt="image" src="https://github.com/user-attachments/assets/e9aefcd3-2018-46cd-b383-fa862b3ac7ca" />

Clicamos el símbolo de la bandera y promovemos:
<img width="769" height="587" alt="image" src="https://github.com/user-attachments/assets/dd5d7d33-2c6a-49ef-94b3-a10ef2233c59" />

Y veremos que le damos a agregar un nuevo bosque con el nombre de dominio raiz que nos digan:
<img width="764" height="549" alt="image" src="https://github.com/user-attachments/assets/f494c979-0725-44c6-8506-f89d54d89b12" />

Si nos da error volvemos a *Administrar* > *Agregar roles y características* > *Sigueinte* > hasta *Roles de servidor* y marcamos ***Servidor DNS y DHCP*** y los instalamos y reiniciamos!

Refrescar en el botóon en forma de flecha hasta que los servidores y roles estén en verde:
<img width="1097" height="468" alt="image" src="https://github.com/user-attachments/assets/6be4f634-dc42-4d0d-8597-3b37fa4b5c0b" />
Volvemos a clicar la bandera, clikamos *Promover dominio*  y le escribimos: **xilgaro.local**
Posteriormente se nos desplegará una nueva ventana
<img width="735" height="543" alt="image" src="https://github.com/user-attachments/assets/1a6941ca-54c3-4bc3-bff8-acc5c2f93a94" />

Escribimos la cpontraseña de siempre
<img width="458" height="328" alt="image" src="https://github.com/user-attachments/assets/38c1ccff-e459-4873-9b0a-6dc14ea02888" />
Le damos a siguiente hasta llegar a Opciones adicionales y escribimos *XILGARO* > *Siguiente*
<img width="462" height="338" alt="image" src="https://github.com/user-attachments/assets/474ddda1-6816-4810-8c79-d84c11f708fb" />

Las rutas las dejamos por predeterminadas > *Siguiente*
<img width="459" height="334" alt="image" src="https://github.com/user-attachments/assets/86ba4459-364c-41b3-a3b3-b983915b5df5" />

Seguimos dándole a *Siguiente* que nos salga **instalar**
<img width="455" height="342" alt="image" src="https://github.com/user-attachments/assets/30c5dd22-7b5b-404a-8703-326273d9f610" />
Y reiniciamos otra vez (***EN PRINCIPIO LO DEBERÍA DE HACER SOLO***)

Vamos a *Herramientas* > DNS 
<img width="492" height="358" alt="image" src="https://github.com/user-attachments/assets/947a35a6-4bca-43a2-a4ae-ad7322cd1e8d" />
Botón derecho > Propiedades > Reenviadores > Ponemos la ip 8.8.8.8 > Aplicamos > Aceptamos
<img width="709" height="604" alt="image" src="https://github.com/user-attachments/assets/313232bf-e4b9-4b51-90b1-592d45de2724" />

## CLiente 1



## Cliente 2
