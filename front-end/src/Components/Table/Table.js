import React from "react";
import "./Table.css";

const Table = ({ studentData }) => {
  return (
    <div className="table-wrapper">
      <table className="table-main">
        <thead>
          <tr>
            <th>Name</th>
            <th>Class</th>
            <th>Division</th>
            <th>Roll No</th>
            <th>Gender</th>
            <th>Date of Birth</th>
          </tr>
        </thead>
        <tbody>
          {/* mapping student's data ito the table  */}
          {studentData.map((data, index) => (
            <tr key={index}>
              <td>{data.name}</td>
              <td>{data.grade}</td>
              <td>{data.division}</td>
              <td>{data.rollNumber}</td>
              <td>{data.gender}</td>
              <td>{data.dateOfBirth}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Table;
