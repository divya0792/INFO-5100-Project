package m1.team3.login;

import java.util.List;

/**
 * Data Access Object
 * @author Neha Sadhasivareddy
 *
 */
public interface LoginDAO {

	public List<User> getAllUsers( );

	public User signUpUser(User user );

}
