package funciones;

/**
 * Funciones varias relacionadas con la asignatura de Matemáticas.
 * @author Sergio
 *
 */
public class Utilidades {

	/**
	 * Constante con las horas máximas de una jornada laboral regular.
	 * (valor actual: {@value})
	 */
	public static final int HORASJORNADA = 38;
	
	
	/**
	 * Devuelve un texto con el tipo de nota en función de su valor numérico, 
	 * o una excepción si el valor no está entre 0 y 10.
	 * @param nota Valor numérico de la nota.
	 * @return Texto con el tipo de nota (Suspenso, Bien, Notable, Sobresaliente
	 * y Matrícula).
	 * @throws ArithmeticException cuando la nota no está entre 0 y 10.
	 */
	public String devuelveNota(double nota) {
		String descripcion = "Matrícula";
		
		if (nota<0.0 || nota >10) {
			throw new ArithmeticException("La nota debe estar entre 0.0 y 10");
		} else if (nota<5.0) {
			descripcion="Suspenso";
		} else if (nota <6.5) {
			descripcion = "Bien";
		} else if (nota<8.5) {
			descripcion ="Notable";
		} else if (nota<10) {
			descripcion ="Sobresaliente";
//		} else {
//			descripcion = "Matrícula";
		}
		return descripcion;
	}
	
	/**
	 * Devuelve el salario en función de las horas trabajadas, teniendo en cuenta que
	 * las horas extra empiezan a partir de {@link HORASJORNADA}.
	 * @param numHoras Número de horas trabajadas.
	 * @param precioHoras Precio de las horas regulares.
	 * @param precioExtras Precio de las horas extra.
	 * @return Salario final.
	 * @throws ArithmeticException cuando los parámetros sean cero o negativos.
	 */
	public double calculaSalario(int numHoras, double precioHoras, double precioExtras) {
		int extras=0;
		int horas=numHoras;
		if(numHoras<=0 || precioHoras<=0 || precioExtras<=0) {
			throw new ArithmeticException();
		}
		if (numHoras>HORASJORNADA) {
			extras = numHoras-HORASJORNADA;
			horas = HORASJORNADA;
		}
		return horas*precioHoras+extras*precioExtras;		
	}
	
	/**
	 * Devuelve el número de divisores del número pasado como parámetro, contando el 1 y el
	 * propio número.
	 * @param num Número al que queremos calcular los divisores.
	 * @return Número de divisores de <strong>num</strong>.
	 */
	public int cuentaDivisores(int num) {
		int cuenta=0;
		
		for (int i = 1; i <= Math.abs(num); i++) {
			if (num%i==0) {
				cuenta++;
			}
		}
		return cuenta;
	}
	
	/**
	 * Devuelve el valor más bajo de un vector de enteros.
	 * @param v Vector de enteros.
	 * @return Valor más bajo del vector <strong>v</strong>.
	 */
	public double devuelveMenor(int v[]) {
		double menor=v[0];
		for (int i = 0; i < v.length; i++) {
			if (v[i] < menor) {
				menor=v[i];
			}
		}
		return menor;
	}
	
	/**
	 * Devuelve un vector de enteros ordenado de menor a mayor, 
	 * utilizando el método de ordenación de la burbuja.
	 * El vector pasado como parámetro también quedará ordenado.
	 * @param v Vector a ordenar.
	 * @return Vector ordenado de menor a mayor.
	 */
	public int [] burbuja(int[] v)
    {
      int auxiliar;
      int[] ordenado;
      for(int i = 1; i < v.length; i++)
      {
        for(int j = 0; j < v.length-i; j++)
        {
          if(v[j] > v[j+1])
          {
            auxiliar = v[j];
            v[j] = v[j+1];
            v[j+1] = auxiliar;
          }   
        }
      }
      ordenado = v;
      return ordenado;
    }
}
