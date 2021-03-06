package com.sonerpyci.ciceksepeti.hackathon.controllers;


import com.sonerpyci.ciceksepeti.hackathon.services.GiftService;
import com.sonerpyci.ciceksepeti.hackathon.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MainController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private GiftService giftService;

    /*@GetMapping(value = "/order")
    public String init(HttpServletRequest req){
        req.setAttribute("orders", orderService.findAllOrders());
        req.setAttribute("mode", "ORDER_VIEW");
        return "customer"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/updateCustomer")
    public String init(@RequestParam long id, HttpServletRequest req){
        req.setAttribute("customer", orderService.findCustomerById(id));
        req.setAttribute("mode", "CUSTOMER_EDIT");
        return "customer"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @PostMapping(value = "/saveCustomer")
    public void saveCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp){
        orderService.saveCustomer(customer);
        req.setAttribute("customers", orderService.findAllCustomers());
        req.setAttribute("mode", "CUSTOMER_VIEW");
        try {
            resp.sendRedirect("/customer"); //redirect to homepage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/createCustomer")
    public String createCustomer(HttpServletRequest req){
        req.setAttribute("mode", "CUSTOMER_CREATE");
        return "customer";
    }

    @GetMapping(value = "/deleteCustomer")
    public void deleteCustomer(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp){
        orderService.deleteCustomer(id);
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }


    @GetMapping(value = "/pet")
    public String initPet(@RequestParam(required = false) Long customerId, HttpServletRequest req){
        if (req.getParameter("customerId") != null){
            req.setAttribute("pets", giftService.findPetsByOwnerId(customerId));
            req.setAttribute("mode", "CUSTOMER_PET_VIEW");
        }else{
            req.setAttribute("pets", giftService.findAllPets());
            req.setAttribute("mode", "PET_VIEW");
        }
        return "pet"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/createPet")
    public String createPet(@RequestParam(required = false) Long id, HttpServletRequest req){
        if (req.getParameter("id") != null){
            req.setAttribute("mode", "CUSTOMER_PET_CREATE");
            req.setAttribute("customerId", id);
            System.out.println("CUSTOMER_PET_CREATE");
        } else {
            req.setAttribute("mode", "PET_CREATE");
        }
        return "pet";
    }

    @PostMapping(value = "/savePet")
    public void updatePet(@ModelAttribute Pet pet, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp){
        giftService.savePet(pet);
        req.setAttribute("pets", giftService.findAllPets());
        req.setAttribute("mode", "PET_VIEW");
        try {
            resp.sendRedirect("/pet"); //redirect to pet page
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/updatePet")
    public String initPet(@RequestParam long id, HttpServletRequest req){
        req.setAttribute("pet", giftService.findPetById(id));
        req.setAttribute("mode", "PET_EDIT");
        return "pet"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/deletePet")
    public void deletePet(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp){
        giftService.deletePet(id);
        try {
            resp.sendRedirect("/pet");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }*/
}
