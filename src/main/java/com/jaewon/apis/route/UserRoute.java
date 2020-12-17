package com.jaewon.apis.route;

import com.jaewon.apis.model.User;
import com.jaewon.apis.service.UserService;
import com.jaewon.apis.vo.UserRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRoute {
    private final UserService userService;

    @Autowired
    public UserRoute(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseBody
    public List<User> getUsers() {
        return this.userService.findAll();
    }

    @GetMapping("/{user_id}")
    @ResponseBody
    public User getUser(@PathVariable(value="user_id") String userId) throws Exception{
        return this.userService.find(Integer.parseInt(userId));
    }

    @PostMapping
    public int createUser(UserRegisterVO user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/initialize")
    public void initializeUsers() {
        this.userService.initializeUsers();
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable(value="user_id") String userId) {
        this.userService.deleteUser(Integer.parseInt(userId));
    }
}
