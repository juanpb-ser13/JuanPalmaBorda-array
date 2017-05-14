package prArrayasociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class Tests {
	private ArrayAsociativo array;
	private String claves[];
	private String valores[];
	@Ignore
	@Test
	public void testsizevacio0() {
		array=new ArrayAsociativo();
		int i=array.size();
		assertEquals(new Integer(0), new Integer(i));
	}
	@Ignore
	@Test
	public void testsizenovacio0() {
		claves=new String[1];
		valores=new String[1];
		claves[0]="Hola";
		valores[0]="Adios";
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(1), new Integer(i));
	}
	@Ignore
	@Test
	public void testsizenovacio() {
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(2), new Integer(i));
	}
	@Ignore
	@Test (expected = NoSuchElementException.class)
	public void testgetvacio(){
		array=new ArrayAsociativo();
		String resultado=array.get("hola");
	}
	@Ignore
	@Test
	public void testgetnovacio(){
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Ignore
	@Test (expected = NoSuchElementException.class) 
	public void testgetnovacioerror(){
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.get("kola");
	}
	@Ignore
	@Test 
	public void insertarvacio(){
		array=new ArrayAsociativo();
		array.put("Hola", "Adios");
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Ignore
	@Test 
	public void insertarnovacio(){
		claves=new String[1];valores=new String[1];
		claves[0]="Hola1";valores[0]="Adios1";
		array=new ArrayAsociativo(claves,valores);
		array.put("Hola", "Adios");
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Ignore
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
	public void search(){
		array=new ArrayAsociativo();
		boolean resultado=array.search("Hola1");
		assertEquals(false,resultado);
	}
}
