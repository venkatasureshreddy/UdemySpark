package com.software.spark

import org.apache.log4j._
import org.apache.spark._

object TotalAmountSpentByCustomer {
  
  def parse(Data:String) = {
    val line = Data.split(",")
    val customerId = line(0).toInt
    val moneySpent = line(2).toFloat
    (customerId,moneySpent)
  }
  
  def main(args:Array[String]) {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","TotalAmountSpentByCustomer")
    
    val Data = sc.textFile("C:/sparklearn/customer-orders.csv")
    
    val parsedRDD = Data.map(parse)
    //parsedRDD.foreach(println)
    val resultRDD = parsedRDD.reduceByKey((x,y)=>x+y)
    
    val result = resultRDD.collect()
    result.sorted.foreach(println)
    
    
  }
  
  
}