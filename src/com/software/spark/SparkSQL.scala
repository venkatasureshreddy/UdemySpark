package com.software.spark

import org.apache.log4j._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object SparkSQL {
  
  case class Person(ID:Int,name:String,age:Int,numFriends:Int)
  
  def mapper(line:String): Person = {
    val fields = line.split(',')
    
    val person:Person = Person(fields(0).toInt,fields(1),fields(2).toInt,fields(3).toInt)
    return person
    
  }
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Creating SparkSession
    val spark = SparkSession
                .builder()
                .appName("SparkSQL")
                .master("local[*]")
                .getOrCreate()
                
    val lines = spark.sparkContext.textFile("C:/sparklearn/fakefriends.csv")
    //lines.foreach(println)
//    val people = lines.map(mapper)
//    //people.foreach(println)
//    
//    //infer the schema and register the dataset as table
//    import spark.implicits._
//    val schemaPeople = people.toDS()
//    schemaPeople.printSchema()
//    
//    // convert the contents of dataset to sql table with name people
//    schemaPeople.createOrReplaceTempView("People")
//    
//    val tennegers = spark.sql("select * from people where age > 10 and age < 20 ")
//    
//    val results = tennegers.collect()
//    results.foreach(println)
//    spark.stop()
    
    /*---------------------------Using Data Frames----------------------------------------------*/
    /*------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------*/
    import spark.implicits._
    val people = lines.map(mapper).toDS().cache()
    // Other ways to create datafarmes
    //example spark.read.json("json file path")
    //or sqlContext.table(Hive table name)
    
    println("Printing the schema")
    people.printSchema()
    
    println("printing the name column")
    people.select("age","name").show()
    
    println("Filtering the age")
    people.filter(people("age") < 20).show()
    
    println("Group by age")
    people.groupBy("age").count().show()
    
    println("Make every one 15 years Older")
    people.select(people("name"),people("age")+15).show()
    
    spark.stop()
    
    
    
  
                
                
                
                
                
                
                
                
                
                
                
                
                
  }
}