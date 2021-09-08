import React from "react";
import { classArray, monthArray } from "../../models/DataModels";
import {
  formatGender,
  formatName,
  formatOneDigitDate,
} from "./FormProcessing/DataFormatter";
import "./Form.css";
import {
  nameValidator,
  classValidator,
  genderValidator,
  dateValidator,
} from "./FormProcessing/DataValidator";

const CURRENT_DATE = new Date().getFullYear(); // current year

const Form = ({ onCreateStudent }) => {
  const formHandle = (event) => {
    event.preventDefault();

    //Format Date - Replaces Unwanted White Spaces
    let name = document.getElementById("name");
    name = formatName(name);

    //Validate Name
    if (nameValidator(name)) {
      document.getElementById("error-container").innerHTML =
        nameValidator(name);
      return 0;
    }

    const grade = document.getElementById("class").value;
    const division = document.getElementById("division").value;

    //Validate Class
    if (classValidator(grade, division)) {
      document.getElementById("error-container").innerHTML = classValidator(
        grade,
        division
      );
      return 0;
    }

    const male = document.getElementById("male").checked;
    const female = document.getElementById("female").checked;
    const other = document.getElementById("other").checked;

    //Format Gender
    const gender = formatGender(male, female, other);

    //Validate Gender
    if (genderValidator(gender)) {
      document.getElementById("error-container").innerHTML =
        genderValidator(gender);
      return 0;
    }

    let dobDay = document.getElementById("dob-day").value;
    let dobMonth = document.getElementById("dob-month").value;
    let dobYear = document.getElementById("dob-year").value;

    //Validate Date
    if (
      dateValidator(parseInt(dobDay), parseInt(dobMonth), parseInt(dobYear))
    ) {
      document.getElementById("error-container").innerHTML = dateValidator(
        parseInt(dobDay),
        parseInt(dobMonth),
        parseInt(dobYear)
      );
      return 0;
    }
    dobDay = formatOneDigitDate(parseInt(dobDay));
    dobMonth = formatOneDigitDate(parseInt(dobMonth));

    // Creating Request Body Object
    const body = {
      name: name,
      grade: grade,
      division: division,
      gender: gender,
      dobDay: dobDay,
      dobMonth: dobMonth,
      dobYear: dobYear,
    };
    console.log(body);

    document.getElementById("myForm").reset();

    //create new student
    onCreateStudent(body);
  };

  return (
    <div className="form-wrapper">
      <header>
        <h1>Student Registration</h1>
      </header>
      <form action="" id="myForm">
        <div className="form-item">
          <input type="text" name="name" id="name" placeholder="Full Name" />
        </div>

        <div className="form-item class">
          <select className="class-group-item" name="class" id="class">
            <option className="class-item" value="0" defaultValue>
              Class
            </option>
            {classArray.map((data, index) => (
              <option className="class-item" key={index} value={data}>
                {data}
              </option>
            ))}
          </select>

          <select className="class-group-item" name="division" id="division">
            <option className="division-name" value="0">
              Division
            </option>
            <option className="division-name" value="A">
              A
            </option>
            <option className="division-name" value="B">
              B
            </option>
            <option className="division-name" value="C">
              C
            </option>
          </select>
        </div>
        <div className="field-group-desc">Gender</div>
        <div className="form-item">
          <div className="gender-item">
            <input type="radio" name="gender" id="male" />
            <label htmlFor="male"> Male</label>
          </div>
          <div className="gender-item">
            <input type="radio" name="gender" id="female" />
            <label htmlFor="female"> Female</label>
          </div>
          <div className="gender-item">
            <input type="radio" name="gender" id="other" />
            <label htmlFor="other"> Other</label>
          </div>
        </div>

        {/*         
         === DATE OF BIRTH ===
         */}
        <div className="field-group-desc">Date of Birth</div>
        <div className="form-item">
          <select className="dateofbirth-item" name="day" id="dob-day">
            <option className="dob-day" value="0" defaultValue>
              Day
            </option>
            {Array.apply(null, { length: 31 }).map((e, i) => (
              <option className="dob-day" key={i} value={i + 1}>
                {i + 1}
              </option>
            ))}
          </select>

          <select className="dateofbirth-item" name="month" id="dob-month">
            <option className="dob-month" value="0" defaultValue>
              Month
            </option>
            {monthArray.map((data, index) => (
              <option className="dob-month" key={index} value={index + 1}>
                {data}
              </option>
            ))}
          </select>

          <select className="dateofbirth-item" name="year" id="dob-year">
            <option className="dob-year" value="0" defaultValue>
              Year
            </option>
            {Array.apply(null, { length: 100 }).map((e, i) => (
              <option
                className="dob-year"
                key={i}
                value={CURRENT_DATE - (i + 4)}
              >
                {CURRENT_DATE - (i + 4)}
              </option>
            ))}
          </select>
        </div>
        <div className="message-container error" id="error-container"></div>

        <button className="sumbit-button" type="submit" onClick={formHandle}>
          Register
        </button>
      </form>
    </div>
  );
};

export default Form;
