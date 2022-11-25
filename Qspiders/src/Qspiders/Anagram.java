//if a user entered two string are anagram or not ?
package Qspiders;

public class Anagram {
	static boolean returnAnagram(String s1,String s2)
	{
		String s3=s1.toUpperCase();
		String s4=s2.toUpperCase();
		int c1[] = new int[26];
		int c2[] = new int[26];
		for(int i=0;i<s3.length();i++)
		{
			char c = s3.charAt(i);
			
			if(c>='A'&&c<='Z')
			c1[c-65]++;
		}
		for(int i=0;i<s4.length();i++)
		{
			char c = s4.charAt(i);
			
			if(c>='A'&&c<='Z')
			c2[c-65]++;
		}
		
		
		for(int i=0;i<26;i++)
		{
			if(c1[i]!=c2[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args)
	{
		String s1 = "Mother in Law";
		String s2 = "Hitler Woman";
		if(returnAnagram(s1,s2)==true)
		System.out.println("The mentioned two strings are Anagram");
		
		else
			System.out.println("The mentioned two strings are Not Anagram");
	}

}
