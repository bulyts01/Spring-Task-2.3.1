package com.bulytovs.spring.controllers;

import com.bulytovs.spring.dao.UserDAO;
import com.bulytovs.spring.models.User;
import com.bulytovs.spring.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("users")
public class UsersController {

    private UserDAO userDAO;
    private final UserValidator userValidator;

    @Autowired
    public UsersController(UserDAO userDAO, UserValidator userValidator) {
        this.userDAO = userDAO;
        this.userValidator = userValidator;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userDAO.index());
        return "users/index";
    }

    @RequestMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.show(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDAO.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAO.show(id));
        return "users/edit";
    }
@PatchMapping("/{id}")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @PathVariable("id") int id) {
    userValidator.validate(user, bindingResult);
    if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userDAO.update(id, user);
    return "redirect:/users";
    }
@DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAO.delete(id);
        return "redirect:/users";
    }

}
