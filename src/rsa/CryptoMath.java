package rsa;

public class CryptoMath
{
	public static boolean isPrimeOver2(long n)
	{
		for(int i = 3; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0) return false;
		}
		return true;
	}
	
	public static boolean isPrime(long n)
	{
		if (n < 2) return false;
		else if (n == 2) return true;
		else return isPrimeOver2(n);
	}
	
	public static long gcd(long x, long y)
	{
		while(x != y)
		{
			if (x < y) y -= x;
			else x -= y;
		}
		return x;
	}
	
	public static long modularExponentiation(long a, long b, long c)
	{
		long result = 1;
		for(int i = 1; i <= b; i++)
		{
			result = (result * a) % c;
		}
		return result;
	}
}
