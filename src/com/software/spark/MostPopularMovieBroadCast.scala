package com.software.spark

import org.apache.log4j._
import org.apache.spark._
import scala.io.Codec
import java.nio.charset.CodingErrorAction
import scala.io.Source

object MostPopularMovieBroadCast {
  
  // Load up a Map of movies ID's to Movie names---> just using scala functions not spark.(not using Spark Context)
  def loadMovieNames() : Map[Int,String]={
    
    //Handling Character encoding Issuses
    implicit val codec = Codec("UTF-8")
    codec.onMalformedInput(CodingErrorAction.REPLACE)
    codec.onUnmappableCharacter(CodingErrorAction.REPLACE)
    
    //Create a Map of Ints to String, and populate it from u.item
    var movieNames : Map[Int,String] = Map()
    
    var lines = Source.fromFile("C:/sparklearn/ml-100k/u.item").getLines()
    for(line <- lines){
      var fields = line.split('|')
      if(fields.length > 1){
        movieNames += (fields(0).toInt -> fields(1))
      }
      
    }
    return movieNames
    
 }
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","MostPopularMovieBroadCast")
    // Create Broadcast variable of our ID -> Movie Name Map
    val nameDist = sc.broadcast(loadMovieNames)
    
     val data = sc.textFile("C:/sparklearn/ml-100k/u.data")
    
    // taking movies and converting in to movie,1 tuples
    val moviesRDD = data.map(x=>(x.split("\t")(1)toInt,1))
    
    //counts up all ones for each movie
    val countmovesRDD = moviesRDD.reduceByKey((x,y)=>x+y)
    // interchaging tuples for popular movie
    val sortedRDD = countmovesRDD.map(x=>(x._2,x._1)).sortByKey()
    
    // using value from broadcast to get movie names from id's
    val sortedMoviesWithNames = sortedRDD.map(x=> (nameDist.value(x._2),x._1))
    
    val result = sortedMoviesWithNames.collect()
    
    result.foreach(println)
    
    
    
    
    
    
  }
  
  
  
  
}