import React, { useState } from "react";
import "./SubjectCards.css";

const subjects = [
  "Maths",
  "Science",
  "English",
  "Geography",
  "History",
];

const SubjectCard = ({ name, onSelect }) => {
  return (
    <div className="subject-card" onClick={() => onSelect(name)}>
      <h2>{name}</h2>
    </div>
  );
};

const SubjectCards = () => {
  const [selectedSubject, setSelectedSubject] = useState(null);
  const [syllabus, setSyllabus] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  const fetchSyllabus = async (subjectName) => {
    setSelectedSubject(subjectName);
    setSyllabus(null);
    setError(null);
    setLoading(true);

    try {
      const response = await fetch(`http://localhost:8083/sms/getSyllabus/${subjectName}`);
      const data = await response.json(); // Convert response to JSON

    // Extract units & corresponding topics
    const syllabusArray = data.flatMap(subject => 
      subject.units.map(unit => ({
        unit: unit.title,
        topics: unit.topics.join(", ") // Convert array of topics into a comma-separated string
      }))
    );

    setSyllabus(syllabusArray.length ? syllabusArray : [{ unit: "No syllabus available", topics: "" }]);
  } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="subject-cards-container">
      {subjects.map((subject, index) => (
        <SubjectCard key={index} name={subject} onSelect={fetchSyllabus} />
      ))}
      {selectedSubject && (
  <div className="syllabus-section">
    <h3>{selectedSubject} Syllabus</h3>
    {loading ? (
      <p>Loading...</p>
    ) : syllabus ? (
      <table border="1">
        <thead>
          <tr>
            <th>Units</th>
            <th>Topics</th>
          </tr>
        </thead>
        <tbody>
          {syllabus.map((item, index) => (
            <tr key={index}>
              <td>{item.unit}</td>
              <td>{item.topics}</td>
            </tr>
          ))}
        </tbody>
      </table>
    ) : error ? (
      <p className="error">{error}</p>
    ) : null}
  </div>
)}
    </div>
  );
};

export default SubjectCards;