/**
 * Suposto Coleccións e traballo con ficheiros
 *
 * Obxectivos: 
 * <ul>
 *  <li>Traballar coa API de Collections</li>
 *  <li>Ler ficheiro liña a liña</li>
 * </ul>
 */
package es.usc.supostos;

import es.usc.supostos.domain.Alumno;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Suposto sobre collections
 *
 * @author vifito
 */
public class App {

    /**
     * Main
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        App app = new App();
        
        // Cargar lista de alumnos do ficheiro /datos.csv (dentro jar)
        TreeSet<Alumno> alumnoList;
        alumnoList = app.loadFile();
                
        System.out.println("Lista de alumnos: ");
        app.dump(alumnoList);
        
    }

    /**
     * Cargar de ficheiro os datos dos usuarios
     * Solucion: 
     *      En vez de cargar a una Lista cargamos en TreeSet
     *      Ordenado (Sorted) y elimina duplicados
     *
     * @return
     */
    public TreeSet<Alumno> loadFile() {
        TreeSet<Alumno> alumnos = new TreeSet<Alumno>();

        // Método para cargar un ficheiro incluído no jar
        InputStream is = getClass().getResourceAsStream("/datos.csv");
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        try {
            // Ler por liñas cunha sentencia for, alternativa a while
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println("Linea: " + line);
                
                // Parsear texto con StringTokenizer, tamén se podería utilizar Scanner
                StringTokenizer st = new StringTokenizer(line, ",");

                if (st.hasMoreTokens()) {
                    alumnos.add(new Alumno(st.nextToken(), st.nextToken(), st.nextToken()));
                }
                
                /**
                 * Código alternativo con Scanner
                 * Scanner sc = new Scanner(line);
                 * sc.useDelimiter(",");
                 * alumnos.add(sc.next(), sc.next(), sc.next());
                 */
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return alumnos;
    }

    /**
     * Imprimir collection
     *
     * @param items
     * @see Alumno#toString()
     */
    public void dump(Collection<Alumno> items) {
        Iterator<Alumno> it = items.iterator();
        
        System.out.println("*****************************");
        
        Alumno alumno;
        while (it.hasNext()) {
            alumno = it.next();
            System.out.println(alumno);
        }
        
        System.out.println("*****************************");
    }

}
