package rsa;

import rsa.CryptoMath;

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

	public Keypair(long p, long q, long n, long phi, long e, long d)
	{
		this.prime1 = p;
		this.prime2 = q;
		this.keyProduct = n;
		this.keyTotient = phi;
		this.publicExponent = e;
		this.privateExponent = d;
	}

	public Keypair(long p, long q, long n, long e)
	{
		this.prime1 = p;
		this.prime2 = q;
		this.keyProduct = n;
		this.publicExponent = e;
		calcTotient();
		calcPrivateExponent();
	}

	public Keypair(long p, long q)
	{
		this.prime1 = p;
		this.prime2 = q;
		this.keyProduct = p * q;
		calcTotient();
		calcPublicExponent();
		calcPrivateExponent();
	}

	// Overridden methods
	// ----------------------------------------------------

	public String toString()
	{
		return "RSA Public/Private Keypair:\n  p = " + prime1 + "\n  q = " + prime2 + "\n  n = " + keyProduct + "\n  phi = "
				+ keyTotient + "\n  e = " + publicExponent + "\n  d = " + privateExponent;
	}

	// Functional methods
	// --------------------------------------------------------

	public long calcTotient()
	{
		this.keyTotient = (this.prime1 - 1) * (this.prime2 - 1);
		return keyTotient;
	}

	public long calcPublicExponent()
	{
		for (publicExponent = 2; publicExponent < keyTotient; publicExponent++)
		{
			if (CryptoMath.gcd(publicExponent, keyTotient) == 1)
				return publicExponent;
		}
		return -1; // shut up compiler
	}

	public long calcPrivateExponent()
	{
		privateExponent = publicExponent + 1;
		while ((privateExponent * publicExponent - 1) % keyTotient != 0)
		{
			privateExponent++;
		}
		return privateExponent;
	}

	public long encrypt(long value) throws NotInEncryptionRangeException
	{
		if (value < keyProduct)
		{
			return CryptoMath.modularExponentiation(value, publicExponent, keyProduct);
		}
		else
		{
			throw new NotInEncryptionRangeException();
		}
	}

	public long decrypt(long value)
	{
		return CryptoMath.modularExponentiation(value, privateExponent, keyProduct);
	}

	// Getters and Setters
	// --------------------------------------------------

	public PublicKey getPublicKey()
	{
		return new PublicKey(keyProduct, publicExponent);
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
