package backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.dto.EmployeeDto;
import backend.service.EmployeeService;
import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEnEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEnEmployeeDto,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable("id")Long id)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto> > getAllEmployee()
    {
        List<EmployeeDto> allEmployeeDtos = employeeService.getAllEmployee();
        return new ResponseEntity<>(allEmployeeDtos,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto saveEmployeeDto = employeeService.updateEmployee(employeeId, employeeDto);
        return new ResponseEntity<>(saveEmployeeDto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
