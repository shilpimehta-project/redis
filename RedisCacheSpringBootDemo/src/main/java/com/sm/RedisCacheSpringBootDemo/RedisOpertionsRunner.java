package com.sm.RedisCacheSpringBootDemo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sm.RedisCacheSpringBootDemo.entity.User;
import com.sm.RedisCacheSpringBootDemo.service.UserService;

@Component
public class RedisOpertionsRunner  implements CommandLineRunner{

	@Autowired
    private UserService empDao;

    @Override
    public void run(String... args) throws Exception {

           //saving one employee
       empDao.saveUser(new User(500, "user0", "Emp0@gmail.com"));

          //saving multiple employees
       empDao.saveAllEmployees(
            Map.of( 501, new User(501, "user1", "user1@gmail.com"),
                    502, new User(502, "user2", "user2@gmail.com"),
                    503, new User(503, "user3", "user3@gmail.com")
                  )
       );

         //modifying employee with empId 503
       empDao.updateUser(new User(503, "user3", "user3@gmail.com"));

         //deleting employee with empID 500
       empDao.deleteUser(500);

        //retrieving all employees
       empDao.getAllUser().forEach((k,v)-> System.out.println(k +" : "+v));

        //retrieving employee with empID 501
       System.out.println("Emp details for 501 : "+empDao.getOneUser(501));
    }
}
