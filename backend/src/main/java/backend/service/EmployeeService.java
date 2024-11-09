package backend.service;

import java.util.List;

import backend.dto.EmployeeDto;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto enEmployeeDto);
    public EmployeeDto getEmployeeById(Long employeeId);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto employeeDto);
    public void deleteEmployee(Long employeeId);
}
