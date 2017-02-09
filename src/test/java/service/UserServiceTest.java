package service;

import com.springHello.bean.User;
import com.springHello.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by root on 1/26/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext*.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;



    @Test
    public void testFindAllBooks(){
        List<User> users = userService.findAllUser();
        assertEquals(users.size(),3);
        users.stream().forEach(System.out::println);
    }

    @Test
    public void testFindUserWithRoleById(){
        User user = userService.findUserWithRoleById(1L);
        assertNotNull(user);
        assertNotNull(user.getRole());
        assertEquals(user.getRole().getName(),"ADMIN");

    }

    @Test
    public void testFindUserByUsername(){
        UserDetails user = userService.loadUserByUsername("mar1");
        assertNotNull(user);
        assertEquals("mar1",user.getUsername());
    }

    @Test
    public void testUsernameNotFoundException(){
        try{
            UserDetails user = userService.loadUserByUsername("mar155");
            fail("Expected an UsernameNotFoundException to be thrown");
        }catch (UsernameNotFoundException ex){
            assertEquals(ex.getMessage(),"User not found");
        }
    }
}
