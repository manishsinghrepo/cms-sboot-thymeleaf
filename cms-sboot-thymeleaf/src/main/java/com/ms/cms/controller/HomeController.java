package com.ms.cms.controller;

import com.ms.cms.dao.CustomerDao;
import com.ms.cms.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/cms")
public class HomeController {

    @Autowired
    CustomerDao customerDao;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @RequestMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("customerMap", customerDao.getCustomerList());
        model.addAttribute("theDate", new java.util.Date());
        return "homepage";
    }

    /*@RequestMapping("/loginForm")
    public String showHome() {

        return "loginForm";
    }
*/
    @RequestMapping("/showcustomerForm")
    public String showStudentFormPage(Model model) {


        model.addAttribute("customer", new Customer());
        model.addAttribute("stateList", customerDao.getStateList());
        model.addAttribute("languageList", customerDao.geLanguageList());
        model.addAttribute("genderList", customerDao.getGenderList());
        System.out.println(customerDao.geLanguageList().toString());
        System.out.println(customerDao.geLanguageList().size());
        return "/customerForm";
    }


    @RequestMapping("/addCustomer")
    public String processStudentFormPage(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult, Model model) {

        if (theBindingResult.hasErrors()) {
            System.out.println("<----Customer---->");
            return "customerForm";
        } else {

            customerDao.addCustomer(customer);
            return "redirect:/cms/home";
        }
    }

    @RequestMapping("/modifyCustomer")
    public String modifyCustomer(@RequestParam("id") Integer id, Model model) {

        Customer customer = customerDao.getCustomer(id);

        model.addAttribute("customer", customer);
        model.addAttribute("id", id);
        model.addAttribute("stateList", customerDao.getStateList());
        model.addAttribute("languageList", customerDao.geLanguageList());
        model.addAttribute("genderList", customerDao.getGenderList());

        return "/modifyCustomerForm";
    }

    @RequestMapping("/updateCustomer")
    public String deleteCustomer(@RequestParam("id") Integer id, @ModelAttribute("customer") Customer customer, Model model) {

        customerDao.modifyCustomer(id, customer);

        return "redirect:/cms/home";

    }


    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") Integer id, Model model) {

        customerDao.deleteCustomer(id);

        return "redirect:/cms/home";

    }


    @RequestMapping("/processForm")
    public String processLoginForm(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName").toUpperCase();
        model.addAttribute("studentName", name);
        return "afterLogin";
    }

}
