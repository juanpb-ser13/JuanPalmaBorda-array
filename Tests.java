package prArrayasociativo;
/*
 *  Alumno: Juan Palma Borda
 *  Curso: 2º Software
 */
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class Tests {
	private ArrayAsociativo array;
	private String claves[];
	private String valores[];
	@Before
	public void inicializar(){
		array=new ArrayAsociativo();
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
	}
	@After
	public void destruir(){
		array=null;
		claves=null;
		valores=null;
	}
	@Test
	public void testsizevacio0() {
		int i=array.size();
		assertEquals(new Integer(0), new Integer(i));
	}
	@Test
	public void testsizenovacio0() {
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Adios1";
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(1), new Integer(i));
	}
	@Test
	public void testsizenovacio() {
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(2), new Integer(i));
	}
	@Test (expected = NoSuchElementException.class)
	public void testgetvacio(){
		array.get("hola");
	}
	@Test
	public void testgetnovacio(){
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Test (expected = NoSuchElementException.class) 
	public void testgetnovacioerror(){
		array=new ArrayAsociativo(claves,valores);
		array.get("kola");
	}
	@Test 
	public void insertarvacio(){
		array=new ArrayAsociativo();
		array.put("Hola", "Adios");
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Test 
	public void insertarnovacio(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Adios1";
		array=new ArrayAsociativo(claves,valores);
		array.put("Hola", "Adios");
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Test 
	public void insertarrepetido(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		array.put("Hola1", "Adios");
		String resultado=array.get("Hola1");
		assertEquals("Adios",resultado);
	}
	@Test 
	public void getorelsevacio(){
		array=new ArrayAsociativo();
		String resultado=array.getOrElse("Hola1","No esta");
		assertEquals("No esta",resultado);
	}
	@Test 
	public void getorelsenovacio(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.getOrElse("Hola1","No esta");
		assertEquals("Hasta Luego",resultado);
	}
	@Test 
	public void getorelsenoencontrada(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.getOrElse("Hola","No esta");
		assertEquals("No esta",resultado);
	}
	@Test 
	public void searchvacio(){
		array=new ArrayAsociativo();
		boolean resultado=array.containskey("Hola1");
		assertEquals(false,resultado);
	}
	@Test 
	public void searchnovacio(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		boolean resultado=array.containskey("Hola1");
		assertEquals(true,resultado);
	}
	@Test 
	public void searchnoestar(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		boolean resultado=array.containskey("Hola");
		assertEquals(false,resultado);
	}
	@Test 
	public void borrarvacio(){
		array=new ArrayAsociativo();
		boolean resultado=array.remove("Hola1");
		assertEquals(false,resultado);
	}
	@Test 
	public void borrarnovacioboolean(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		boolean resultado=array.remove("Hola1");
		assertEquals(true,resultado);
	}
	@Test (expected = NoSuchElementException.class) 
	public void borranorvacioerror(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		array.remove("Hola1");
		array.get("Hola1");
	}
	@Test 
	public void borranoexisteclaver(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Hasta Luego";
		array=new ArrayAsociativo(claves,valores);
		boolean resultado=array.remove("Hola");
		assertEquals(false,resultado);
	}
}
