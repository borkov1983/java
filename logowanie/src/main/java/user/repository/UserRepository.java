package user.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import user.model.User;

public class UserRepository {
	
	private List<User> users;
	private HttpSession session;
	
	private void updateUsersFromSession() {
		this.users = (List<User>) this.session.getAttribute("users");
		if(this.users == null) {
			this.users = new ArrayList<>();
		}
	}
	
	public UserRepository(HttpSession session) {
		super();
		this.session = session;
		updateUsersFromSession();
		
		if(this.users.size() < 1) {
			User user = new User("user", "user", "user");
			
			User admin = new User("admin", "admin", "admin");
			admin.setIsAdmin(true);
			admin.setIsPremium(true);
			
			User premiumUser = new User("premium", "premium", "premium");
			premiumUser.setIsPremium(true);
			
			this.addUser(user);
			this.addUser(admin);
			this.addUser(premiumUser);
			updateUsersFromSession();
		}
	}

	public void addUser(User user) {
		updateUsersFromSession();
		this.users.add(user);
		this.session.setAttribute("users", this.users);
	}
	
	public List<User> getAllUsers() {
		updateUsersFromSession();
		return this.users;
	}
	
	public User findUser(String username, String password) {
		updateUsersFromSession();
		if(this.users != null) {
			List<User> users = this.users.stream()
	                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
	                .collect(Collectors.toList());  
			if(users.size() == 1) {
				return users.get(0);
			}
		}
		return null;
	}
	
	public User getUserByUsername(String username) {
		updateUsersFromSession();
		if(this.users != null) {
			List<User> users = this.users.stream()
	                .filter(user -> user.getUsername().equals(username))
	                .collect(Collectors.toList());  
			if(users.size() == 1) {
				return users.get(0);
			}
		}
		return null;
	}
	
	public boolean validateIfUserExists(String username) {
		updateUsersFromSession();
		List<User> users = this.users.stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList());  
		if(users.size() > 0) {
			return true;
		}
		return false;
	}
	
	public void updateUser(User olderUser, User newerUser) {
		updateUsersFromSession();
		this.users.remove(olderUser);
		this.users.add(newerUser);
		this.session.setAttribute("users", this.users);
	}
}
