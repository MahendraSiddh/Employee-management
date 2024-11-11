import React, { useEffect, useState } from 'react';
import { listAllEmployee } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListAllEmployee = () => {

  const navigate = useNavigate();

  const [employees,setEmployees] = useState([]);
  useEffect(()=>{
    listAllEmployee().then((Response)=>{
        setEmployees(Response.data);
    }).catch(error =>
        console.log(error)
    )
  },[]);

  function handleAddNewEmployee(){
    navigate('/add-employee');
  }

  return (
    <div className="container mx-auto px-4 sm:px-8">
      <div className="py-8">
        <div className="mb-4 flex flex-row gap-8">
          <h2 className="text-2xl font-semibold leading-tight">Employees Data</h2>
          <button type="button" onClick={handleAddNewEmployee} class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800">Add new Employee</button>
        </div>
        <div className="overflow-x-auto bg-white shadow-md rounded-lg">
          <table className="min-w-full leading-normal">
            <thead>
              <tr className="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                <th className="py-3 px-6 text-left">ID</th>
                <th className="py-3 px-6 text-left">First Name</th>
                <th className="py-3 px-6 text-left">Last Name</th>
                <th className="py-3 px-6 text-left">Email</th>
              </tr>
            </thead>
            <tbody className="text-gray-600 text-sm font-light">
              {employees.map((user) => (
                <tr key={user.id} className="border-b border-gray-200 hover:bg-gray-100">
                  <td className="py-3 px-6 text-left whitespace-nowrap">
                    <div className="flex items-center">
                      <span className="font-medium">{user.id}</span>
                    </div>
                  </td>
                  <td className="py-3 px-6 text-left">
                    <div className="flex items-center">
                      <span>{user.firstName}</span>
                    </div>
                  </td>
                  <td className="py-3 px-6 text-left">
                    <div className="flex items-center">
                      <span>{user.lastName}</span>
                    </div>
                  </td>
                  <td className="py-3 px-6 text-left">
                    <div className="flex items-center">
                      <span>{user.email}</span>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default ListAllEmployee;