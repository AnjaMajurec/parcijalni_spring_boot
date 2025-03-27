package algebra.example.Spring_parcijalniIspist.security;

import algebra.example.Spring_parcijalniIspist.User.User;
import algebra.example.Spring_parcijalniIspist.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Wrong credentials");
        }
        return new CustomUserDetails(user.get());
    }
}
