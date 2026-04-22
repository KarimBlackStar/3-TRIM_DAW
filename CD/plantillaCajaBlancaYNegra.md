## PLANTILLA CAJA BLANCA

```java
import org.example.GestorEventos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanticaTestCajaBlanca {
    //private NombreClase nombreAtrib;

    @BeforeEach
    public void setUp() {
        //nombreAtrib = new NombreClase;
    }

    @Test
    public void cp1(){
        //double param1 = 0.0;
        //String param2 = 0;
        //boolean param3 = false;
        //assertEquals(//valorEsperado,nomreAtrib.nombreMetodo(param1,param2,param3));
    }

    @Test
    public void cp2(){
        //double param1 = 0.0;
        //String param2 = 0;
        //boolean param3 = false;
        //assertTrue(nombreAtrib.nombreMetodo(param1,param2,param3));
    }

    @Test
    public void cp3(){
        //double param1 = 0.0;
        //String param2 = 0;
        //boolean param3 = false;
        //assertFalse(nombreAtrib.nombreMetodo(param1,param2,param3));
    }
/*EN CASO DE ARRAYS*/
    @Test
    public void cp4(){
        //double[] param1 = {};
        //int[] param2 = {};
        //String[] param3 = false;
        //assertFalse(nombreAtrib.nombreMetodo(param1,param2,param3));
    }

}
```

## PLANTILLA CAJA NEGRA
### VIP
Acordarse de que en caja negra haremos tantos caminos como clases no validas + 1(todas validas).
Además en el test pondremos alguno con valor límite.

```java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlantillaTestCajaNegra {
    //private NombreClase nombreAtrib;

    @BeforeEach
    public void setUp() {
        //nombreAtrib = new NombreClase;
        /*EL SIGUIENTE SOLO NOS INTERESA SI QUEREMOS SIMPLEMENTE TENER SIEMPRE EL ARRAY INICIALIZADO
        * LA CAJA BLANCA TAMBIÉN PUEDE TENER UN ARRAY
        */
        //nombreAtrib.nombreMetodo(new tipoArray[]{valoresTipoArray}, new tipoArray[]{valoresTipoArray});
    }
    @Test
    public void CP_V_01() {
        /*SI TUVIERAMOS UN ARRAY DIRECTAMENTE INICIALIZAMOS LOS VALORES EN LOS PARAMETROS
        * PARA ESO NOS HEMOS MOLESTADO EN INICIALIZAR EL ARRAY EN EL BeforeEach*/
        //assertEquals(valorEsperado, nombreAtrib.nombreMetodo("", X));
    }
@Test
    public void CP_NV_01() {
        /*EN CASO DE NO HABER ARRAY, SERÍA LO MISMO QUE EN CAJA BLANCA*/
        //double[] param1 = {};
        //int[] param2 = {};
        //String[] param3 = false;
        //assertFalse(nombreAtrib.nombreMetodo(param1,param2,param3));
    }
@Test
    public void CP_NV_02() {
        /*EN CASO DE NO HABER ARRAY, SERÍA LO MISMO QUE EN CAJA BLANCA*/
        //double[] param1 = {};
        //int[] param2 = {};
        //String[] param3 = false;
        //assertFalse(nombreAtrib.nombreMetodo(param1,param2,param3));
    }
}
```
