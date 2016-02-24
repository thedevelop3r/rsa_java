package rsa;

public class NotInEncryptionRangeException extends Exception
{
	private static final long serialVersionUID = -4611028788225411193L;

	public NotInEncryptionRangeException()
	{
		System.out.println("Error, value was not in valid range; must be less than the key product");
	}
}
