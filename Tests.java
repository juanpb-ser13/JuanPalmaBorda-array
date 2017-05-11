package prArrayasociativo;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class Tests {
	private ArrayAsociativo array;
	@Test
	public void testsizevacio0() {
		array=new ArrayAsociativo();
		int i=array.size();
		assertEquals(new Integer(0), new Integer(i));
	}

}
