import React from 'react';
import './Dashboard.css';

const subjects = ["Mathematics", "Science", "History", "Geography", "English", "Computer Science"];

const Dashboard = () => {
  return (
    <div className="dashboard-container">
      <h1 className="dashboard-title">SUBJECTS</h1>
      <div className="card-container">
        {subjects.map((subject, index) => (
          <div key={index} className="subject-card">
            <h2>{subject}</h2>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Dashboard;