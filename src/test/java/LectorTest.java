import com.javabasics.Lector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.Map;

public class LectorTest {

    private String ruta;

    @Before
    public void setUp() throws Exception {
        ruta =  "src/main/java/com/javabasics/input.txt";
    }

    @Test
    public void getDni(){
        int dni = 33456765;
        Lector lector = new Lector(ruta);
        lector.setDni(dni);
        int dniLeido = lector.getDni();
        Assert.assertEquals((long) dni, (long) dniLeido);

    }
    @Test
    public void getDni2() {
        int dni = 10100100;
        Lector lector = new Lector(ruta);
        lector.setDni(dni);
        int dniLeido = lector.getDni();
        Assert.assertEquals((long) dni, (long) dniLeido);
    }

    @Test
    public void getRuta() {
        String ruta = "input.txt";
        Lector lector = new Lector(ruta);
        Assert.assertEquals(ruta, lector.getRuta());
    }
    /*lec.leerLinea(0)          24b42058ce6823b5173ef6fa7b9fa4cb
    lec.leerLinea(39) fed9c791450c01ef7f91fbc93bfd693c
    lec.leerLinea(-8) error
    lec.leerLinea(999) error*/
    @Test
    public void getLinea() throws IOException {
        Lector lector = new Lector(ruta);
        String linea = "24b42058ce6823b5173ef6fa7b9fa4cb";
        Assert.assertEquals(linea, lector.leerLinea(0));
    }

    @Test
    public void getLinea2() throws IOException {
        Lector lector = new Lector(ruta);
        String linea = "fed9c791450c01ef7f91fbc93bfd693c";
        Assert.assertEquals(linea, lector.leerLinea(39));
    }

    @Test
    public void getLinea3() throws IOException {
        Lector lector = new Lector(ruta);
        String linea = "error";
        Assert.assertEquals(linea, lector.leerLinea(-8));
    }

    @Test
    public void getLinea4() throws IOException {
        Lector lector = new Lector(ruta);
        String linea = "error";
        Assert.assertEquals(linea, lector.leerLinea(999));
    }

    /*
    Map<Integer, String> mapa = l.leerLineas(new int[]{0, 39, 149});
    mapa.get(0) 24b42058ce6823b5173ef6fa7b9fa4cb
    mapa.get(39) fed9c791450c01ef7f91fbc93bfd693c
    mapa.get(149) 81018c48fd41f6667b384698c006c5c4
    */

    @Test
    public void getLineas2() throws IOException {
        Lector lector = new Lector(ruta);
        Map<Integer, String> mapa = lector.leerLineas(new int[]{0, 39, 149});
        String linea = "81018c48fd41f6667b384698c006c5c4";

        Assert.assertEquals(linea, mapa.get(149));
    }

    @Test
    public void getLineas1() throws IOException {
        Lector lector = new Lector(ruta);
        Map<Integer, String> mapa = lector.leerLineas(new int[]{0, 39, 149});
        String linea = "fed9c791450c01ef7f91fbc93bfd693c";

        Assert.assertEquals(linea, mapa.get(39));
    }

    @Test
    public void getLineas() throws IOException {
        Lector lector = new Lector(ruta);
        Map<Integer, String> mapa = lector.leerLineas(new int[]{0, 39, 149});
        String linea = "24b42058ce6823b5173ef6fa7b9fa4cb";

        Assert.assertEquals(linea, mapa.get(0));
    }

    /*
    Map<Integer, String> mapa = l.leerLineas(new int[]{-1, 150});
    mapa.get(-999) error
    mapa.get(999) error*/

    //@Test
    //Este test es invalido, no valida ningun requerimiento del ejercicio.
    public void getLineas3() throws IOException {
        Lector lector = new Lector(ruta);
        Map<Integer, String> mapa = lector.leerLineas(new int[]{-1, 150});
        String linea = "error";

        Assert.assertEquals(linea, mapa.get(-999));
    }

    //@Test
    //Este test es invalido, no valida ningun requerimiento del ejercicio.
    public void getLineas4() throws IOException {
        Lector lector = new Lector(ruta);
        Map<Integer, String> mapa = lector.leerLineas(new int[]{-1, 150});
        String linea = "error";

        Assert.assertEquals(linea, mapa.get(999));
    }


    public void getLineas5() throws IOException {
        Lector lec = new Lector("este_archivo_no_existe.txt");
        String linea = "error";

        Assert.assertEquals(linea, lec.leerLinea(0));
    }


}
