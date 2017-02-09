package service;

import com.springHello.bean.Role;
import com.springHello.bean.User;
import com.springHello.mapper.UserMapper;
import com.springHello.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        User user = userService.findUserByUsername("mar1");
        assertNotNull(user);
        assertEquals("mar1",user.getUsername());
    }
}
