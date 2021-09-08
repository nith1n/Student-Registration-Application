import {
  classArray,
  divisionArray,
  genderArray,
} from "../../../models/DataModels";

const CURRENT_YEAR = new Date().getFullYear();

const isLeapYear = (year) => {
  return year % 4 === 0
    ? year % 100
      ? year % 400
        ? true
        : false
      : true
    : false;
};

export const dateValidator = (day, month, year) => {
  if (year > CURRENT_YEAR - 4 || year < CURRENT_YEAR - 100)
    return "Invalid Year";
  if (day < 1 || day > 31) return "Invalid Day";
  if (month < 1 || month > 12) return "Invalid Month";
  if ([2, 4, 6, 9, 11].includes(month) && day > 30)
    return "Invalid Day for the Month";
  if (month === 2 && day > 29) return "Invalid Day for the Month";
  if (month === 2 && !isLeapYear(year) && day > 28)
    return "Invalid Day for the Month - Not a Leap Year";

  return null;
};

export const nameValidator = (name) => {
  if (name === "") return "Name Cannot be Blank";
  if (name.length < 6) return "Name Should Be Atleast 6 Characters Long ";
  if (!/^[A-Z][A-z\s]*$/.test(name)) return "invalid name";
  return null;
};

export const classValidator = (grade, division) => {
  if (!classArray.includes(grade)) return "Invalid Class";
  if (!divisionArray.includes(division)) return "Invalid Division";
  return null;
};

export const genderValidator = (gender) => {
  if (!genderArray.includes(gender)) return "Invalid Gender";
  return null;
};
