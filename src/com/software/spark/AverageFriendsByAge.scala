package com.software.spark

import org.apache.log4j._
import org.apache.spark.SparkContext

object AverageFriendsByAge {
  
  // Function to create required tuples
  def par(dataRDD:String) = {
    // Split by commas
    val fields = dataRDD.split(",")
    val age = fields(2).toInt
    val numFriends = fields(3).toInt
    // Returning the required Tuples
    (age,numFriends)
    
  }
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","AverageFriendsByAge")
    
    // Load each line of xls in to RDD
    val dataRDD = sc.textFile("C:/sparklearn/fakefriends.csv")
    val valuesRDD = dataRDD.map(par)
    
    // we use mapValues to convert each numFriends values to tuples of (numFriends,1)
    val tupleRDD = valuesRDD.mapValues(x=>(x,1))
    //tupleRDD.foreach(println)
    
    //We use reduceByKey to sum up the total numfriends and Total instance for each age. we get Tuples of (age,(totalFriends,totalInstances))
    val reduceRDD = tupleRDD.reduceByKey((x,y)=>(x._1 + y._1, x._2 + y._2))
    
    // For average we divide totalFriends/total Instances
    val avgByAgeRDD = reduceRDD.mapValues(x=>x._1/x._2)
    
    val results = avgByAgeRDD.collect()
    results.sorted.foreach(println)
    
    
    
 }
}