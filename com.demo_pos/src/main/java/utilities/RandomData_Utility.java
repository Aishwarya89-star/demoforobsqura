package utilities;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomData_Utility {
	 static Faker faker;
	 
	 public static String getname() {
		 faker=new Faker();
		 return faker.company().profession();
	 }
	 
	 public static String getName() {
		 faker = new Faker(new Locale("en-IND"));
			return faker.name().name();
	 }
	 public static String getEmail() {

			String alphabet = "abcdefghijklmnopqrstuvwxyz";//string created from a to z
			StringBuilder sb = new StringBuilder();//used string builder class
			Random random = new Random();//used to generate random nos usng random class
			int length = 5;//length of characters for email
			for (int i = 0; i < length; i++) {
				int index = random.nextInt(alphabet.length());//randomly choosen eachletters from string a to z
				char randomChar = alphabet.charAt(index);//adding the string to b4 @
				sb.append(randomChar);//appending the characters
			}
			String randomStringEmail = sb.toString() + "@gmail.com";
			return randomStringEmail;

		}
	
	 public static String getFirstname() {
		 faker = new Faker(new Locale("en-IND"));
			return faker.name().firstName();
	 }
	 public static String getLastname() {
		 faker = new Faker(new Locale("en-IND"));
			return faker.name().lastName();
	 }
	 
	 public static String getPrefix() {
		 faker = new Faker();// no need for locale
			return faker.name().prefix();
	 }

	 public static String getPassword() {
		 faker = new Faker();// no need for locale
			return faker.internet().password(5, 8);
	 }
}
