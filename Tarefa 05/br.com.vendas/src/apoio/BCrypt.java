/**
 * @author Flavio
 */
package apoio;

public class BCrypt {
    
    private static int workload = 12;
    
    public static String hashPassword(String password_plaintext) {
        String salt = org.mindrot.jbcrypt.BCrypt.gensalt(workload);
        String hashed_password = org.mindrot.jbcrypt.BCrypt.hashpw(password_plaintext, salt);
        return (hashed_password);
    }

    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        boolean password_verified = false;
        if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }
        password_verified = org.mindrot.jbcrypt.BCrypt.checkpw(password_plaintext, stored_hash);
        return (password_verified);
    }
}
