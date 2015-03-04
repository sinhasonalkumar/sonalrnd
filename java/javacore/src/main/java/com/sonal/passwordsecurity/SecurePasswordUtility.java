package com.sonal.passwordsecurity;

import org.mindrot.jbcrypt.BCrypt;

public class SecurePasswordUtility {

   

   
    // This method is used to generate a string representing user password which is save for storing in a database
    public static String hashPassword(String passwordClearText) {
	// gensalt's log_rounds parameter determines the complexity
	// the work factor is 2**log_rounds, and the default is 10
	int  workload = 12;
	String salt = BCrypt.gensalt(workload);
	String hashed_password = BCrypt.hashpw(passwordClearText, salt);

	return (hashed_password);
    }
    
    
    //This method is used to verify a computed hash from a plaintext
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
	boolean password_verified = false;

	if (null == stored_hash || !stored_hash.startsWith("$2a$"))
	    throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

	password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

	return (password_verified);
    }

    
    public static void main(String[] args) {
	
	String passwordClearText = "Passw0rd$$";
	

	System.out.println("Hashing The Password...");
	
	String saltedHashPassword = hashPassword(passwordClearText);
	System.out.println("Storing saltedHashPassword in DB : " + saltedHashPassword);
	
	System.out.println("Retrieving saltedHashPassword From DB : " + saltedHashPassword);
	
	
	
	System.out.println("Verifying user clear text Password and stored hash both match ");
	
	boolean passwordMatched = checkPassword(passwordClearText, saltedHashPassword);
	
	//String hackedHasedPasword = "$2a$12$dMocxEMxHAlLqAADY94zdu5GjgLdzde1ysB5C2P1nQWwXotmqoHFOoHFO" ;
	//boolean passwordMatched = checkPassword(passwordClearText, hackedHasedPasword);
	
	if(passwordMatched){
	    System.out.println("Password Matched Success !!");
	}else{
	    System.err.println("Password Matched Failed !!");
	}

    }
}
