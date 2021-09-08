export const formatName = (name) => {
  return name.value.replace(/\s+/g, " ").trim();
};

export const formatGender = (male, female, other) => {
  return male === true
    ? "Male"
    : female === true
    ? "Female"
    : other === true
    ? "Other"
    : 0;
};

// export const formatDate = (day, month, year) => {
//   return day >= 10
//     ? day + "/" + month + "/" + year
//     : "0" + day + "/" + month + "/" + year;
// };

export const formatOneDigitDate = (date) => {
  return date < 10 ? "0" + date : date;
};

