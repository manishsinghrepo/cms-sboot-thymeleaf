package com.ms.cms.dao;

import com.ms.cms.models.Customer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedHashMap;

@Component
public class CustomerDao {

    private static HashMap<Integer, Customer> customerHashMap = null;

    static {
        if (customerHashMap == null) {
            customerHashMap = new HashMap<Integer, Customer>();
            String[] lang = {"J", "C"};
            customerHashMap.put(1, new Customer("Manish", "Singh", "SC", lang, "M"));
            customerHashMap.put(2, new Customer("Sam", "Patrick", "NC", lang, "M"));
            customerHashMap.put(3, new Customer("Sandy", "Peter", "SC", lang, "F"));
            customerHashMap.put(4, new Customer("Tom", "Hang", "GE", lang, "M"));
        }
    }

    public HashMap getCustomerList() {
        return customerHashMap;
    }

    public static void setCustomerList(Integer key, Customer customer) {
        customerHashMap.put(key, customer);
    }


    public HashMap<String, String> getStateList() {
        HashMap<String, String> stateList = new LinkedHashMap();
        stateList.put("SC", "South Carolina");
        stateList.put("NC", "North Carolina");
        stateList.put("GE", "Georgia");
        stateList.put("NY", "New York");
        stateList.put("NJ", "New Jersey");
        return stateList;
    }


    public HashMap<String, String> geLanguageList() {
        HashMap<String, String> languageList = new LinkedHashMap();
        languageList.put("C", "C");
        languageList.put("J", "Java");
        languageList.put("P", "Perl");
        languageList.put("N", ".Net");
        return languageList;
    }

    public HashMap<String, String> getGenderList() {
        HashMap<String, String> genderList = new LinkedHashMap();
        genderList.put("M", "Male");
        genderList.put("F", "Female");
        return genderList;
    }

    public void addCustomer(Customer customer) {
        if (!customerHashMap.isEmpty()) {
            int size = customerHashMap.size() + 1;
            do {
                size += 1;
            } while (customerHashMap.containsKey(size));

            customerHashMap.put(size, customer);
        }
    }

    public void modifyCustomer(int id, Customer customer) {
        if (!customerHashMap.isEmpty()) {
            customerHashMap.put(id, customer);
        }
    }


    public Customer getCustomer(Integer id) {
        if (!customerHashMap.isEmpty()) {

            return customerHashMap.get(id);
        } else
            return new Customer();
    }

    public void deleteCustomer(Integer id) {
        if (!customerHashMap.isEmpty()) {
            customerHashMap.remove(id);
        }
    }


}
