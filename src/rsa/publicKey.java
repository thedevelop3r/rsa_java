package rsa;

public class publicKey
{
	private long publicExponent;
	private long keyProduct;
	
	public publicKey(long n, long e)
	{
		this.publicExponent = e;
		this.keyProduct = n;
	}

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
