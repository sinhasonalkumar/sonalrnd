package com.sonal.passwordsecurity;

import org.mindrot.jbcrypt.BCrypt;

public class SecurePasswordToStoreInDBMemo {

    // This method is used to generate a string representing user password which
    // is save for storing in a database
    public static String hashPassword(String passwordClearText) {
	// gensalt's log_rounds parameter determines the complexity
	// the work factor is 2**log_rounds, and the default is 10
	int workload = 12;
	String salt = BCrypt.gensalt(workload);
	String hashed_password = BCrypt.hashpw(passwordClearText, salt);

	return (hashed_password);
    }

    // This method is used to verify a computed hash from a plaintext
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
	boolean passwordVerified = false;
	passwordVerified = BCrypt.checkpw(password_plaintext, stored_hash);
	return (passwordVerified);
    }

    public static void main(String[] args) {
	
	String passwordClearText = "Passw0rd$$";	
	//storePasswordToDB(passwordClearText);
	
	String storedPassword = pullStoredPassword();
	
	doPasswordMatch(passwordClearText, storedPassword);
	

    }

    public static void storePasswordToDB(String passwordClearText) {
	
	System.out.println("Hashing The Password...");
	String saltedHashPassword = hashPassword(passwordClearText);
	System.out.println("Storing saltedHashPassword in DB : " + saltedHashPassword);
    }

    public static String pullStoredPassword() {
	String storedSaltedHashePassword = "$2a$12$VZJak69EpNn9KMQGq4j02.3Qa0p5jjA.HfE.mjHNF62CmfE5/8Tle";
	System.out.println("Retrieving saltedHashPassword From DB : " + storedSaltedHashePassword);
	return storedSaltedHashePassword;
    }

    public static void doPasswordMatch(String passwordClearText, String storedSaltedHashePassword) {
	boolean passwordMatched = checkPassword(passwordClearText, storedSaltedHashePassword);
	if (passwordMatched) {
	    System.out.println("Password Matched Success !!");
	} else {
	    System.err.println("Password Matched Failed !!");
	}
    }
}
