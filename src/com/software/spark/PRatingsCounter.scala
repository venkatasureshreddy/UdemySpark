package com.software.spark

import org.apache.log4j._
import org.apache.spark.SparkContext


object PRatingsCounter {
  
//  def main(args:Array[String]){
//    
//    Logger.getLogger("org").setLevel(Level.ERROR)
//    val sc = new SparkContext("local[*]","PRatingsCounter")
//    val lines = sc.textFile("C:/sparklearn/ml-100k/u.data")
//    val ratings = lines.map(x=>x.toString().split("\t")(2))
//    
//    val results = ratings.countByValue()
//    results.foreach(println)
    
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","PRatingsCounter")
    
    val rdd = sc.textFile("C:/sparklearn/ml-100k/u.data")
    val ratting = rdd.map(x=>x.toString().split("\t")(2))
    
    
    println(ratting.count())
    val results = ratting.countByValue()
    println(results)
    
    for(a<-results){
      println(a._2)
    }
    
    
  }
  
  
  
}