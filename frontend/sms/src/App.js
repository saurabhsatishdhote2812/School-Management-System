
import './App.css';
import LoginPage from './LoginPage/LoginPage';
import Dashboard from './Dashboard';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {
  return (
   <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </Router>
  );
}

export default App;
