package prArrayasociativo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {
	private ArrayAsociativo array;
	private String claves[]=new String[10];
	private String valores[]=new String[10];
	@Test
	public void testsizevacio0() {
		array=new ArrayAsociativo();
		int i=array.size();
		assertEquals(new Integer(0), new Integer(i));
	}
	@Test
	public void testsizenovacio0() {
		claves[0]="Hola";
		valores[0]="Adios";
		array=new ArrayAsociativo(claves,valores);
		int i=array.size();
		assertEquals(new Integer(1), new Integer(i));
	}
}
