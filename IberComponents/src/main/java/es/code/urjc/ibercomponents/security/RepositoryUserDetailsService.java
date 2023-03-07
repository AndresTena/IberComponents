package es.code.urjc.ibercomponents.security;

import es.code.urjc.ibercomponents.entities.User;
import es.code.urjc.ibercomponents.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RepositoryUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));
        List<GrantedAuthority> roles = new ArrayList<>();

        for(String role:user.getRoles())
        {
            roles.add(new SimpleGrantedAuthority("ROLE_"+role));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getUserPassword(),roles);
    }
}
