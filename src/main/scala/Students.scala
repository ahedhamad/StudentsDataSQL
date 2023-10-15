import org.apache.log4j.BasicConfigurator
import org.apache.log4j.varia.NullAppender
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions.{DslSymbol, StringToAttributeConversionHelper}
import org.apache.spark.sql.functions.{avg, col, current_date, datediff}

object Students {
  def main(args: Array[String]): Unit = {

    val nullAppender = new NullAppender
    BasicConfigurator.configure(nullAppender)

    val spark = SparkSession.builder()
      .appName("Students data")
      .master("local")
      .getOrCreate

    val studentDataFrame = spark.read
      .option("header","true")
      .csv("src/main/resources/students.csv")
 println("...(1)............................................................................................................")
    //Task 1: split students into classes by studying status and count the number of students in each class
    val groupedByStudentStudyingStatus = studentDataFrame.groupBy("studying_status").count().show()
println("...(2)............................................................................................................")
    //Task 2: view student first name, last name, and GPA for students who have graduated
   val viewStudentGraduated = studentDataFrame.filter(studentDataFrame("studying_status")==="graduated")
     .select("first_name","last_name","gpa").show()
println("...(3)...........................................................................................................")
    //Task 3: Calculate the mean of GPAs for students who are studying
   val meanGAPStudentStudying = studentDataFrame.filter(studentDataFrame("studying_status")==="studying")
      .agg(avg("gpa")).show()
println("...(4)...........................................................................................................")
    //Task 4: Sort students by GPA in descending order
   val sortStudentByGPA = studentDataFrame.sort(studentDataFrame("gpa").desc).show()
println("...(5)...........................................................................................................")
    //Task 5: Add a new column 'age' calculated from birth date
   val studentAge = studentDataFrame.withColumn("age",datediff(current_date,studentDataFrame("birth_date"))/365).show(10)
println("...(6)...........................................................................................................")
    //Task 6: show only the students who have a GPA greater than 3.7
    val studentsGPA = studentDataFrame.filter(studentDataFrame("gpa")>3.7).show()
  }
}