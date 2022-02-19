package smart.vas.service;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import  smart.vas.model.Role;
import  smart.vas.repository.RoleRepository;

import smart.vas.model.User;
import smart.vas.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	


   @Autowired
   private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
  
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<User> getUserbyRole(String Role) {
		return userRepository.findByRole(Role);
	}
	
   
   public void saveUser(User user) {
	   
	   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
       this.userRepository.save(user);
   }
	
	public User get(int id) {
		return userRepository.findById(id).get();
	}
	
	public List<Role> getRoles(){
		return roleRepository.findAll();
	}

	
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}