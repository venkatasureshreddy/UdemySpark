package com.software.spark
import org.apache.log4j._
import org.apache.spark.SparkContext
import scala.math._

object MinimumTemperatureByLocation {
  
  def parseLine(recordRDD:String)={
    val lines = recordRDD.split(",")
    val stationID = lines(0)
    val entryType = lines(2)
    val temperature = lines(3).toFloat * 0.1f *(9.0f / 5.0f) + 32.0f
    
    (stationID,entryType,temperature)
    
  }
  
  def main(args:Array[String]) = {
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","MinimumTemperatureByLocation")
    
    val recordRDD = sc.textFile("C:/sparklearn/1800.csv")
    
    
    val parsedLine = recordRDD.map(parseLine)
    //Only considering TMIN values with filter function
    val minTemps = parsedLine.filter(x => x._2 == "TMIN")
    parsedLine.foreach(println)
    
    // Converting stationID,temperature in to tuples key,value RDD
    val stationTemp = minTemps.map(x => (x._1,x._3.toFloat))
    //stationTemp.foreach(println)
    
    // reduceBy station Id and take minimum temperature found
    val reducebyStationID = stationTemp.reduceByKey((x,y) => max(x,y))
   // reducebyStationID.foreach(println)
    
    // Collect is a action method. format and print the result
    val collRDD = reducebyStationID.collect()
    
    for(result <-collRDD.sorted){
      val station = result._1
      val temp = result._2
      val formatedTemp = f"$temp%.2f F"
     // println(s"$station minimumTemp: $formatedTemp")
    }
    
    
        
  }
  
}