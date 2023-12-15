package com.springboot.spring_crud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.spring_crud.entity.Laptop;
import com.springboot.spring_crud.service.LaptopService;

@Controller

public class Homecontroller {
	
		
	@Autowired
	private LaptopService laptopService;
		
    @GetMapping("/")
    public ModelAndView getAllLaptops(Model model) {
    	ModelAndView modelAndView=new ModelAndView();
        List<Laptop> laptops = laptopService.getAllLaptops();
        modelAndView.addObject("laptops", laptops);
        modelAndView.setViewName("home");
        return modelAndView;
    }
    
    @PostMapping("/save")
    public ModelAndView saveLaptop(@ModelAttribute Laptop laptop, Model model) {
    	ModelAndView modelAndView=new  ModelAndView();
        laptopService.saveLaptop(laptop);
        List<Laptop> list = laptopService.getAllLaptops();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("submitform");
        return modelAndView;
    }

    
    @GetMapping("/submitform")
    public ModelAndView showSubmitForm(Model model) {
    	ModelAndView modelAndView=new ModelAndView();
    	List<Laptop> list = laptopService.getAllLaptops();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("submitform");
        return modelAndView;
    }


    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id, Model model) {
    	ModelAndView modelAndView=new ModelAndView();
        Laptop laptop = laptopService.getLaptopById(id);
        modelAndView.addObject("laptop", laptop);
        modelAndView.setViewName("edit");
        return modelAndView;
        
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateLaptop(@PathVariable int id, @ModelAttribute Laptop updatedLaptop, Model model) {
        ModelAndView modelAndView=new ModelAndView();
    	laptopService.updateLaptop(id, updatedLaptop);
        List<Laptop> list = laptopService.getAllLaptops();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("submitform");
        return modelAndView;
        
    }
    


    @GetMapping("/delete/{id}")
    public ModelAndView deleteLaptop(@PathVariable int id,Model model) {
    	ModelAndView modelAndView=new ModelAndView();
        laptopService.deleteLaptop(id);
        List<Laptop> list = laptopService.getAllLaptops();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("submitform");
        return modelAndView;
    }
    
    
    
    
    
    
    
    
//    @GetMapping("/alllaptops")
//    @ResponseBody
//    public List<Laptop> getAllStudentsJson() {
//        try {
//            // Return the list of all students as JSON
//            return (List<Laptop>) laptopService.getAllLaptops();
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Log the exception using a logger
//            // Handle the exception appropriately, e.g., return an empty list or an error message
//            return Collections.emptyList();
//        }
//    }
    
}
