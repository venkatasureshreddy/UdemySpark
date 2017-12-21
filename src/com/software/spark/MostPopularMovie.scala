package com.software.spark.MostPopularMovie

import org.apache.log4j._
import org.apache.spark._

object MostPopularMovie {
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","MostPopularMovie")
    
    val data = sc.textFile("C:/sparklearn/ml-100k/u.data")
    
    // taking movies and converting in to movie,1 tuples
    val moviesRDD = data.map(x=>(x.split("\t")(1),1))
    
    //counts up all ones for each movie
    val countmovesRDD = moviesRDD.reduceByKey((x,y)=>x+y)
    // interchaging tuples for popular movie
    val sortedRDD = countmovesRDD.map(x=>(x._2,x._1)).sortByKey()
    val results = sortedRDD.collect()
    results.foreach(println)
    
  }
}