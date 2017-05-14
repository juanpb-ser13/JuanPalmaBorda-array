package prArrayasociativo;

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

	
	//Métodos de instancia
	
	public int size() {
		return size;
		}

		public String get(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
