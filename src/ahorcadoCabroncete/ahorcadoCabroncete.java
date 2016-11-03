package ahorcadoCabroncete;

import java.util.Scanner;


public class ahorcadoCabroncete {

	public static void main(String[] args) {
		String palabraOculta = "quimera";
		String coincidencias="";
		int numIntentos=0;
		String noEncontrado="";
		
		
		coincidencias=ponerGuiones(palabraOculta); 
		do{ //flujo del programa 
			System.out.println(coincidencias);
			String caracter = pideDatos("Instroduzca Una Letra:"); //llama al metodo pidedatos
			String jugada=""; //variable para almacenar la jugada de cada pasada del bucle
			if(palabraOculta.contains(caracter)){ //evaluamos si el caracter esta en nuesta palabra
				jugada = colocaCaracteres(palabraOculta,caracter); //si esta se almacena en jugada
				coincidencias=sumaCadena(jugada,coincidencias); //coincidencias junta las cadenas de jugada y coincidencias
			}else{ //resta vidas, y almacena la letra fallida.
				numIntentos++;
				noEncontrado=noEncontrado+caracter+" ";
			}
			//evalua que acabado el juego cuando no hay guiones bajos.
			if(!coincidencias.contains("-")){
				System.out.println("Has Ganado CRACK!!");
				System.out.println("Muy Bien la Palabra era "+palabraOculta);
				break;
				
			}
			
			System.out.println("Te Quedan "+numIntentos+" Vidas");
			System.out.println("Tus Fallos son: "+noEncontrado);
			System.out.println(" ");
			
			
			
		}while (numIntentos!=10); //mientras vidas no sea 0
		
	}
	//metodo para poner Guiones segun longitud de palabra.
	public static String ponerGuiones(String palabraOculta){
		String coincidenciasGuiones="";
		int numeroCaracteres = palabraOculta.length(); //hacemos un metodo length para ver el numero de caracteres
		for (int i=2;i<numeroCaracteres; i++){	//recorremos el bucle poniendo un guion en cada uno de los caracteres que encuentre.
			 coincidenciasGuiones=coincidenciasGuiones+"-"; //lo almacenamos en la variable coincidencias.
		}
		return coincidenciasGuiones;
	}
	// metodo para pedir datos
	public static String pideDatos(String msg){
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		String caracter=sc.next();
		return caracter;
		
		
	}
	
	//coloca los caracteres en el string
	public static String colocaCaracteres(String palabraOculta, String caracter){
		String caracteresCoincide = new String(); //creo un string nuevo (objeto)
		int numeroCaracteres = palabraOculta.length(); //necesito crear un int para recorrer el bucle de debajo/ de la plabra
		for (int i=0; i<numeroCaracteres; i++){  //recorro el bucle para hayar las coincidencias
			if (palabraOculta.charAt(i)== caracter.charAt(0)){
				caracteresCoincide= caracteresCoincide+caracter; // si coincide poner el caracter en el string caracteres coincide.
				
			
			}else{
				caracteresCoincide= caracteresCoincide+"-"; //si no pues poner "_".
				System.out.println(caracteresCoincide);
				
			}
		
		}
		
		return caracteresCoincide; //devuelve el valor.
	
	
	}
	//Metodo que compara las cadenas y pone las letas si hay ralla
	public static String sumaCadena(String jugada, String coincidencias){ //recive jugada y coincidencias
		int numeroCaracteres= coincidencias.length(); //para que pueda recorer la palabra 
		String resultado=""; //creo la variable resultado para que sea la suma de los 2 Strings
		for (int i=0;i<numeroCaracteres;i++){
			if (jugada.charAt(i)!= "-".charAt(0)){ //si es difernete de - se le suma la jugada.
				resultado=resultado+jugada.charAt(i); 
				
			}else{
				resultado=resultado+coincidencias.charAt(i); //
			}
		}
		return resultado;
	}
}
