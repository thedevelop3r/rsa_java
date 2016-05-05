package rsa;

public class PublicKey
{
	private long publicExponent;
	private long keyProduct;
	
	// Constructors
	// -------------------------------------
	
	public PublicKey(long n, long e)
	{
		this.publicExponent = e;
		this.keyProduct = n;
	}
	
	// Overridden methods
	// -----------------------------------
	
	@Override
	public String toString()
	{
		return "Public Key:\n  n = " + keyProduct + "\n  e = " + publicExponent;
	}

	// Getters and Setters
	// ------------------------------------
	
	public long getPublicExponent()
	{
		return publicExponent;
	}

	public void setPublicExponent(long e)
	{
		this.publicExponent = e;
	}

	public long getKeyProduct()
	{
		return keyProduct;
	}

	public void setKeyProduct(long n)
	{
		this.keyProduct = n;
	}
	
	
}
