package zoos.zoos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zoos.zoos.model.User;
import zoos.zoos.model.UserRoles;
import zoos.zoos.repo.RoleRepository;
import zoos.zoos.repo.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{
	@Autowired
	private UserRepository userRepos;
	@Autowired
	private RoleRepository roleRepos;


	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepos.findByUsername(username);
		if (user == null)
		{
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
	}

	@Override
	public List<User> findAll()
	{
		ArrayList<User> users = new ArrayList<>();
		userRepos.findAll().iterator().forEachRemaining(users::add);
		return users;
	}

	@Override
	public User findUserById(long id)
	{
		return null;
	}

	@Transactional
	@Override
	public void delete(long userid)
	{
		if (userRepos.findById(userid).isPresent())
		{
			userRepos.deleteUserRole(userid);
			userRepos.deleteById(userid);
		} else {
			throw new EntityNotFoundException(Long.toString(userid));
		}
	}

	@Override
	public User save(User user)
	{
		User newUser = new User();

		newUser.setUsername(user.getUsername());
		newUser.setPassword(user.getPassword());

		for(UserRoles ur : user.getUserRoles())
		{
			newUser.getUserRoles().add(new UserRoles(ur.getUser(), ur.getRole()));
		}

		return userRepos.save(newUser);
	}

	@Override
	public User update(User user, long id)
	{
		return null;
	}
}
