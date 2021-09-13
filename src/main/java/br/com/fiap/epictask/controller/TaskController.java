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

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;

@Controller
public class TaskController {
	
	@Autowired
	private TaskRepository r;
	
	@GetMapping("/task")
	public ModelAndView index() {
		List<Task> tasks = r.findAll();
		ModelAndView modelAndView = new ModelAndView("tasks");
		modelAndView.addObject("tasks", tasks);
		return modelAndView;
	}
	
	@PostMapping("/task")
	public String save(@Valid Task task, BindingResult result) {
		if (result.hasErrors()) {
			return "registerTask";
		}
		r.save(task);
		return "tasks";
	}
	
	@RequestMapping("/task/register")
	public String taskRegister(Task task) {
		return "registerTask";
	}
}
