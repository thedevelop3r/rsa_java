package rsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cracker
{
	long p = 0;
	long n;
	long e;

	public Cracker(PublicKey key)
	{
		this.n = key.getKeyProduct();
		this.e = key.getPublicExponent();
	}
	
	public Cracker(long n, long e)
	{
		this.n = n;
		this.e = e;
	}

	public Keypair Crack()
	{
		if (n % 2 == 0) p = 2;
		else
		{
			p = 3;
			try
			{
				@SuppressWarnings("resource")
				Scanner s = new Scanner(new File("./res/primes1.txt")).useDelimiter(" ");
				while(s.hasNextInt() && (n % (p = s.nextInt())) != 0);
				s.close();
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Error: Primes File not Found");
			}
			finally
			{
				while (p <= Math.sqrt(n) && n % p != 0)
				{
					p += 2;
				}
			}
		}
		
		return new Keypair(p, n / p, n, e);
	}
}
