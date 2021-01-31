package threads;

import java.util.Scanner;

public class AThread extends Thread {

	private String tipo;
	private static int n;
	private long t;

	public AThread(String tipo)
	{
		Scanner l = new Scanner(System.in); 
		this.tipo = tipo;
		System.out.println("Ingrese el tiempo de sleep del thread"+tipo);
		t = l.nextLong();
	}

	public void run()
	{
		try
		{
			if(tipo.equals("Par"))
			{
				for(int i=1;i<=(n/2);i++)
				{
					System.out.println(2*i);
					Thread.sleep(t);
				}
			}
			else if(tipo.equals("Impar"))
			{
				for(int i = 0;i<=((n/2)-1);i++)
				{
					System.out.println((2*i)+1);
					Thread.sleep(t);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}


	public static void main(String[] args)
	{
		Scanner l = new Scanner(System.in); 
		System.out.println("Establezca el rango del listado");
		n = l.nextInt();
	
		AThread a = new AThread("Impar");
		AThread b = new AThread("Par");

		a.start();
		b.start();
	}
}

