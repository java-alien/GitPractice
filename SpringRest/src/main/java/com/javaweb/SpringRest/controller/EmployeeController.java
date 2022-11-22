package com.javaweb.SpringRest.controller;

import com.javaweb.SpringRest.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController
{
    @RequestMapping(value ="/employees",method = RequestMethod.GET)
    private List<Employee> getEmployees()
    {
        List<Employee> employee=new ArrayList<>();
        employee.add(new Employee(1080357,"Shilpa","shilpa.07@gmail.com","Senior Project Manager"));
        employee.add(new Employee(1070347,"Gokul","gokul.varma@gmail.com","Project Manager"));
        employee.add(new Employee(1070367,"Logitha","logitha.sidd@gmail.com","Lead Consultant"));
        employee.add(new Employee(1078023,"Radesh","rad.nk@gmail.com","Senior Project Manager"));
        employee.add(new Employee(1090378,"Amar","amar.psd@gmail.com","Delivery Manager"));
        employee.add(new Employee(1087268,"Uma","uma.ms@gmail.com","Senior Project Manager"));
        employee.add(new Employee(1078356,"Logesh","log.p@gmail.com","Senior Consultant"));
        return employee;
    }

    @GetMapping("/managers")
    private List<Employee> getManagers()
    {
        return getEmployees().stream().filter(x->x.getDesignation().contains("Manager")).collect(Collectors.toList());
    }

    @GetMapping("/projectmanagers")
    private List<Employee> getProjectManagers()
    {
        return getEmployees().stream().filter(x->x.getDesignation().equals("Project Manager")).collect(Collectors.toList());
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id)
    {
        Employee employee = null;
        for(Employee e:getEmployees())
            if(e.getId()==id)
            {
                employee=e;
                break;
            }
        return employee;
    }
}
