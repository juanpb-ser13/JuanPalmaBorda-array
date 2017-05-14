package prArrayasociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {
	private ArrayAsociativo array;
	private String claves[];
	private String valores[];
	@Test
	public void testsizevacio0() {
		array=new ArrayAsociativo();
		int i=array.size();
		assertEquals(new Integer(0), new Integer(i));
	}
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
	@Test
	public void testsizenovacio() {
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(2), new Integer(i));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testgetvacio(){
		array=new ArrayAsociativo();
		String resultado=array.get("hola");
	}
	@Test
	public void testgetnovacio(){
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
	@Test (expected = NoSuchElementException.class)
	public void testgetnovacioerror(){
		claves=new String[2];valores=new String[2];
		claves[0]="Hola";valores[0]="Adios";
		claves[1]="Hola1";valores[1]="Adios2";
		array=new ArrayAsociativo(claves,valores);
		String resultado=array.get("kola");
	}
	@Test 
	public void insertarvacio(){
		array=new ArrayAsociativo();
		array.put("Hola", "Adios");
		String resultado=array.get("Hola");
		assertEquals("Adios",resultado);
	}
}
