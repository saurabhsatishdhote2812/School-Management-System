
import './App.css';
import LoginPage from './LoginPage/LoginPage';
import SubjectCards from './SubjectCards';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';


function App() {
  return (
   <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/subjects" element={<SubjectCards />} />
      </Routes>
    </Router>
  );
}

export default App;
