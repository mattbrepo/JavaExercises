import java.util.*;

public class Test1
{
	public static void main(String[] args)
	{
		long date = 15 * 10000 + 1 * 100 + 15; //yymmdd
		long key = 123456;
		long hd = 0x3F7812E1;
		long hd_part = 0x3F78;
		
		System.out.println("\n---------date test");
		long nYear = date / 10000;
		long nMonth = (date - (nYear * 10000)) / 100;
		long nDay = (date - (nYear * 10000) - (nMonth * 100));
		System.out.println("nYear: " + nYear);
		System.out.println("nMonth: " + nMonth);
		System.out.println("nDay: " + nDay);
		
		System.out.println("\n---------test1");
		cryptoTest(date, key);
		
		System.out.println("\n---------test2");
		cryptoTest(date, hd);

		System.out.println("\n---------test3");
		cryptoTest(date, hd_part);
	}
	
	private static void cryptoTest(long msg, long key)
	{
		long c = msg ^ key;
		long d = c ^ key;
		System.out.println("msg: " + msg);
		System.out.println("key: " + key);
		System.out.println("crypted: " + c);
		System.out.println("decrypted: " + d);
	}
}