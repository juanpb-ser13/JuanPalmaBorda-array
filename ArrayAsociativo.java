package prArrayasociativo;
/*
 *  Alumno: Juan Palma Borda
 *  Curso: 2� Software
 */
import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	private int size;
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
		size=0;
	}
	public ArrayAsociativo(String claves, String valores){
		primero = new Nodo(claves, valores,null);;
		size=1;
	}
	 public ArrayAsociativo(ArrayAsociativo array) {
	        Nodo src = array.primero;
	        Nodo dst = null;
	        
	        while (src != null) {
	            
	            if (dst == null) {
	              primero = new Nodo(src.clave,src.valor,null);
	                dst = primero;
	            }
	            else
	                dst.sig = new Nodo(src.clave, src.valor, null);
	            
	            src = src.sig;
	        }
	        
	        size = array.size;
	    }

	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			size++;
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
				size++;
			}
		}
	}

	
	//M�todos de instancia
	
	public int size() {
		return size;
		}

		public String get(String string) {
			if(size==0){
				throw new NoSuchElementException("Lista vac�a");
			}
			boolean encontrado=false;
			Nodo busqueda=primero;
			String palabra = null;
			while(!encontrado){
				if(busqueda.clave==string){
					palabra=busqueda.valor;
					encontrado=true;
				}else{
					if(busqueda.sig==null){
						throw new NoSuchElementException("Elemento no encontrado");
					}
					busqueda=busqueda.sig;
				}
			}
			return palabra;
		}

		public void put(String string, String string2) {
			Nodo busqueda=primero;
			if(busqueda==null){
				primero= new Nodo(string, string2,primero);
				size++;
			}else if(busqueda.clave==string){
				busqueda.valor=string2;
			}else	{
				Nodo busqueda2=primero.sig;
				while(busqueda2!=null){
					if(busqueda.clave==string){
						busqueda.valor=string2;
						break;
					}
					busqueda=busqueda.sig;
					busqueda2=busqueda2.sig;
				}
				if(busqueda2==null){
					busqueda2 = new Nodo(string, string2,null);
					busqueda.sig=busqueda2;
					size++;
				}	
			}
			}

		public String getOrElse(String string, String string2) {
			String devolucion;
			try{
				devolucion=get(string);
			}catch( NoSuchElementException e){
				devolucion=string2;
			}
			return devolucion;
		}

		public boolean containskey(String string) {
			boolean resultado=false;
			try{
				get(string);
				resultado=true;
			}catch( NoSuchElementException e){
				resultado=false;
			}
			return resultado;
		}

		public boolean remove(String string) {
			Nodo busqueda=primero;
			boolean hecho=false;
			if(busqueda!=null&&busqueda.clave==string){
				primero=busqueda.sig;
				hecho=true;
				size--;
			}else if(busqueda!=null){
				Nodo busqueda2=busqueda.sig;
				while(busqueda2!=null){
					if(busqueda2.clave==string){
						hecho=true;
						busqueda.sig=busqueda2.sig;
						size--;
						break;
					}
					busqueda=busqueda.sig;
					busqueda2=busqueda2.sig;
				}
			}
			return hecho;
		}
}
