package threads;

import java.util.Scanner;

public class BThread implements Runnable {
	
	private String nombre;
	private static int n;
	private long t;

	public BThread(String nombre)
	{
		Scanner l = new Scanner(System.in); 
		this.nombre = nombre;
		System.out.println("Ingrese el tiempo de sleep del thread"+nombre);
		t = l.nextLong();
	}

	public void run()
	{
		try
		{
			if(nombre.equals("Par"))
			{
				for(int i=1;i<=n;i++)
				{
					System.out.println(2*i);
					Thread.sleep(t);
				}
			}
			else if(nombre.equals("Impar"))
			{
				for(int i = 0;i<=n;i++)
				{
					System.out.println((2*i)+1);
					Thread.sleep(t);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error en la ejecucion de"+nombre);
		}

	}


	public static void main(String[] args)
	{
		Scanner l = new Scanner(System.in); 
		System.out.println("Establezca el rango del listado");
		n = l.nextInt();

		Thread a = new Thread(new BThread("Par"));
		Thread b = new Thread(new BThread("Impar"));

		a.start();
		b.start();
	}

}
