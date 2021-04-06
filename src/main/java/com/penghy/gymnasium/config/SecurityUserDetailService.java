package com.penghy.gymnasium.config;

import com.penghy.gymnasium.core.entity.User;
import com.penghy.gymnasium.core.service.impl.UserServiceImp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class SecurityUserDetailService implements UserDetailsService {
    @Resource
    private UserServiceImp userServiceImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImp.getUserByUsername(username);
        if(user == null) {
            return null;
        }
        return new SecurityUserInfo(user, true, true, true);
//        List<SimpleGrantedAuthority> simpleGrantedAuthorities = createAuthorities(user.getAuthority());
//        return new org.springframework.security.core.userdetails.User(user.getUserAccount(),
//                user.getUserPassword(), simpleGrantedAuthorities);
    }

//    private List<SimpleGrantedAuthority> createAuthorities(String roleStr){
//        String[] roles = roleStr.split(",");
//        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
//        for (String role : roles) {
//            System.out.println(role);
//            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role));
//        }
//        return simpleGrantedAuthorities;
//    }
}
