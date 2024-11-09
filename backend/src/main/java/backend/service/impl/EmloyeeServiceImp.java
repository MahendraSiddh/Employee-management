package backend.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import backend.dto.EmployeeDto;
import backend.entity.Employee;
import backend.exception.ResourceNotFoundException;
import backend.mapper.EmployeeMapper;
import backend.repository.EmployeeRepository;
import backend.service.EmployeeService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmloyeeServiceImp implements EmployeeService{
    
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            ()-> new ResourceNotFoundException("Employee doest not exist")
        );
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployee()
    {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee)).toList();
    }
    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto)
    {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
           ()-> new ResourceNotFoundException("Employee does not exist")
        );
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    public void deleteEmployee(Long employeeId)
    {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
            ()-> new ResourceNotFoundException("Employee does not exist")
        );
        employeeRepository.delete(employee);
        return ;
    }
}
