package br.com.fiap.epictask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository u;
	
	@GetMapping("/user")
	public ModelAndView index() {
		List<User> users = u.findAll();
		ModelAndView modelAndView = new ModelAndView("users");
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	@PostMapping("/user")
	public String save(@Valid User profile, BindingResult result) {
		if (result.hasErrors()) {
			return "registerUser";
		}
		u.save(profile);
		return "users";
	}
	
	@RequestMapping("/user/register")
	public String registerUser(User profile) {
		return "registerUser";
	}
}
