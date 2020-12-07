import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Crypt {

	public static void main(String[] args) throws Exception{
		String x = "Gundamxr78-2";
		byte[] passc = cifra(x);
		String pass = descifra(passc);
		System.out.println(pass);
		
	}
	
	static private Cipher getCipher(boolean paraCifrar) throws Exception {
		String cipherBase = "Elperrodesanroquenotieneraboporqueramónrodriguezselohacortado";
		MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(cipherBase.getBytes("UTF-8"));
		SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}
	
	static public byte[] cifra(String in) throws Exception{
		byte[] bytes = in.getBytes("UTF-8");
		Cipher aes = getCipher(true);
		byte[] out = aes.doFinal(bytes);
		return out;
	}
	
	static public String descifra(byte[] in) throws Exception {
		Cipher aes = getCipher(false);
		byte[] bytes = aes.doFinal(in);
		String out = new String(bytes, "UTF-8");
		return out;
	}

}
