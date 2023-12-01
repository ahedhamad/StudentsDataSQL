# Students Data Analysis with Apache Spark

This Scala application processes student data stored in a CSV file and performs various analytical tasks using Apache Spark's DataFrame API.

## Setup

Make sure you have the necessary dependencies and Spark environment configured before running the application.

## Usage

1. The application reads student data from the CSV file located at `src/main/resources/students.csv`.

2. Upon running the program, it performs the following analytical tasks:

### Tasks Performed:

#### 1. Group Students by Studying Status
   - Splits students into classes based on their studying status and counts the number of students in each class.
   - Displays the count of students in each class.

#### 2. View Details of Graduated Students
   - Displays the first name, last name, and GPA of students who have graduated.

#### 3. Calculate Mean GPA of Students Studying
   - Calculates the mean of GPAs for students who are currently studying.

#### 4. Sort Students by GPA
   - Sorts the students by GPA in descending order.

#### 5. Calculate Student Age from Birth Date
   - Adds a new column 'age' to the DataFrame, calculated from the birth date.

#### 6. Filter Students by GPA Threshold
   - Displays details of students with a GPA greater than 3.7.

### How to Run
   - Execute the `Students` object's `main` method to perform the analytical tasks.
   - The program will read the student data from the CSV file and output the results of the analyses.

### Important Notes:
   - Ensure the `students.csv` file is located at `src/main/resources/students.csv`.
   - The application utilizes Apache Spark's DataFrame API for data processing.
   - Results for each task will be displayed in the console output.

## Libraries Used:
- Apache Spark SQL
- Apache log4j

## Disclaimer:
This application assumes the presence of the specified CSV file and may require adjustments based on the data structure or specific requirements.

