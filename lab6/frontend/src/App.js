import './App.css';

import {BrowserRouter, Routes, Route} from 'react-router-dom'

import UsersList from './pages/UsersList/UsersList';
import EditUser from './pages/EditUser/EditUser';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" index element={<UsersList/>}/>
        <Route path="/edit/:id" element={<EditUser/>}/>
        <Route path="/add" element={<EditUser/>}/>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
