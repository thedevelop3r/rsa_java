package rsa;

public class Keypair
{
	private long prime1;
	private long prime2;
	private long keyTotient;
	private long publicExponent;
	private long privateExponent;
	private long keyProduct;
	
	// Constructors
	// ------------------------------------------------------
	
	public Keypair(long p, long q)
	{
		this.prime1 = p;
		this.prime2 = q;
		this.keyProduct = p * q;
		calcTotient();
		calcPublicExponent();
		calcPrivateExponent();
	}
	
	// Functional methods
	// --------------------------------------------------------
	
	public void calcTotient()
	{
		this.keyTotient = (this.prime1 -1) * (this.prime2 - 1);
	}
	
	public void calcPublicExponent()
	{
		for(publicExponent = 2; publicExponent < keyTotient; publicExponent++)
		{
			if(gcd(publicExponent, keyTotient) == 1) return;
		}
	}
	
	public void calcPrivateExponent()
	{
		privateExponent = publicExponent + 1;
		while((privateExponent * publicExponent - 1) % keyTotient != 0)
		{
			privateExponent++;
		}
	}
	
	public long encrypt(long value) throws NotInEncryptionRangeException
	{
		if(value < keyProduct)
		{
			return modularExponentiation(value, publicExponent, keyProduct);
		}
		else
		{
			throw new NotInEncryptionRangeException();
		}
	}
	
	public long decrypt(long value)
	{
		return modularExponentiation(value, privateExponent, keyProduct);
	}
	
	// Static functional method
	// ---------------------------------------------------------
	
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

	// Getters and Setters
	// --------------------------------------------------
	
	public publicKey getPublicKey()
	{
		return new publicKey(keyProduct, publicExponent);
	}
	
	public long getPrime1()
	{
		return prime1;
	}

	public void setPrime1(long prime1)
	{
		this.prime1 = prime1;
	}

	public long getPrime2()
	{
		return prime2;
	}

	public void setPrime2(long prime2)
	{
		this.prime2 = prime2;
	}

	public long getKeyTotient()
	{
		return keyTotient;
	}

	public void setKeyTotient(long keyTotient)
	{
		this.keyTotient = keyTotient;
	}

	public long getPublicExponent()
	{
		return publicExponent;
	}

	public void setPublicExponent(long publicExponent)
	{
		this.publicExponent = publicExponent;
	}

	public long getPrivateExponent()
	{
		return privateExponent;
	}

	public void setPrivateExponent(long privateExponent)
	{
		this.privateExponent = privateExponent;
	}

	public long getKeyProduct()
	{
		return keyProduct;
	}

	public void setKeyProduct(long keyProduct)
	{
		this.keyProduct = keyProduct;
	}
	
}
