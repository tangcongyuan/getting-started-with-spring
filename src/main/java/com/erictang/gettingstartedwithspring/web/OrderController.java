// tag::baseClass[]
package com.erictang.gettingstartedwithspring.web;

import javax.validation.Valid;

import com.erictang.gettingstartedwithspring.Order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
//end::baseClass[]

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {

//tag::orderForm[]
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }
//end::orderForm[]

/*
//tag::handlePost[]
  @PostMapping
  public String processOrder(Order order) {
    log.info("Order submitted: " + order);
    return "redirect:/";
  }
//end::handlePost[]
*/

    //tag::handlePostWithValidation[]
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        log.info("Order submitted: " + order);
        return "redirect:/";
    }
//end::handlePostWithValidation[]

}
//end::baseClass[]