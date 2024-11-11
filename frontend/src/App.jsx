import {BrowserRouter, Route, Routes} from 'react-router-dom'

import ListAllEmployee from "./components/ListAllEmployee";
import AddEmployee from './pages/AddEmployee';


export default function App() {
  return (
    <BrowserRouter>
        <Routes>
            <Route path='/' element={<ListAllEmployee/>} ></Route>
            <Route path='/add-employee' element={<AddEmployee/>} ></Route>
        </Routes>
    </BrowserRouter>
  )
}