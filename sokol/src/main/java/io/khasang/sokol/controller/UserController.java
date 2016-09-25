package io.khasang.sokol.controller;

import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(value ="/{login}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("login") String login){
        userDao.delete(userDao.getByLogin(login));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody User createUser(@RequestBody User user, BindingResult result, HttpServletResponse response) throws BindException {
        if(result.hasErrors()){
            throw new BindException(result);
        }
        userDao.save(user);
        return user;
    }
}
