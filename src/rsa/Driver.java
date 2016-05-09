package rsa;

public class Driver
{
	public static void main(String[] args) throws Exception
	{
		Keypair key = new Keypair(59, 7);
		System.out.println(key);
		System.out.println("Test encrypt 43:\n  " + key.encrypt(43));
		System.out.println("Test decrypt 267:\n  " + key.decrypt(key.encrypt(43)));
		
		String message = "I like potatoes";
		
		System.out.print("Text encrypt message:\n  ");
		String encrypted = "";
		for(int i = 0; i < message.length(); i++)
		{
			encrypted += (char) key.encrypt((long) message.charAt(i));
		}
		System.out.println(encrypted);
		
		System.out.print("Text decrypt encrypted message:\n  ");
		String decrypted = "";
		for(int i = 0; i < encrypted.length(); i++)
		{
			decrypted += (char) key.decrypt((long) encrypted.charAt(i));
		}
		System.out.println(decrypted);
		
		// Hack the encryption protocol
		// ------------------------------------------------------------------------------
		
		System.out.println("\nHack RSA Public Key: \n");
		
		Cracker cracker = new Cracker(key.getPublicKey());
		Keypair hacked = cracker.Crack();
		System.out.println(hacked);
		
		System.out.print("Text decrypt encrypted message with hacked key:\n  ");
		decrypted = "";
		for(int i = 0; i < encrypted.length(); i++)
		{
			decrypted += (char) hacked.decrypt((long) encrypted.charAt(i));
		}
		System.out.println(decrypted);
	}
}
