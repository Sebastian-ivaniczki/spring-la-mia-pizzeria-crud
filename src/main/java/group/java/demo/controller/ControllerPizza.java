package group.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import group.java.demo.entity.Pizza;
import group.java.demo.service.PizzaService;

@Controller
public class ControllerPizza {
		
	
	
	
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getHome(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		
		model.addAttribute("pizzas", pizzas);
		
		return "index";
		
	}
	
	@GetMapping("/pizzas/{id}")
    public String getSinglePizza(@PathVariable("id") Integer id, Model model) {
        Optional<Pizza> optpizza = pizzaService.findById(id);
        Pizza pizza = optpizza.get();
        if (pizza == null) {
            
            return "error";
        }
        
        model.addAttribute("pizza", pizza);
        
        return "singlepizza";
    }
	

}
