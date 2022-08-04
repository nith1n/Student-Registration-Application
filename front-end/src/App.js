import { useEffect, useState } from "react";
import "./App.css";
import Form from "./Components/Form/Form";
import Table from "./Components/Table/Table";

function App() {
  const [studentData, setStudentData] = useState([]);

  const fetchStudentData = async () => {
    const data = await fetch("/list").then((response) =>
      response.json()
    );
    setStudentData(data);
    console.log(data);
  };

  const createStudent = async (body) => {
    const data = await fetch("/create", {
      headers: {
        "Content-Type": "application/json",
      },
      method: "POST",
      body: JSON.stringify(body),
    }).then((response) => response.text());
    console.log(data);
    fetchStudentData();
  };

  useEffect(() => {
    fetchStudentData();
  }, []);

  return (
    <div className="app">
      <Form onCreateStudent={createStudent} />
      <Table studentData={studentData} />
    </div>
  );
}

export default App;
