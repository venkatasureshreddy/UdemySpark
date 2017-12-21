package com.software.spark
import org.apache.log4j._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object DataSetPopularMovies {
  
  case class Movie(movieId:Int)
  
  def main(args:Array[String]){
    
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    val spark = SparkSession
                .builder
                .appName("DataSetPopularMovies")
                .master("local[*]")
                .getOrCreate()
                
     val line = spark.sparkContext.textFile("C:/sparklearn/ml-100k/u.data")
     val rdd = line.map(x=>Movie(x.split('\t')(1).toInt))
     rdd.foreach(println)
     //Converting to Data Set
     import spark.implicits._
     //val moviesDS = rdd.toDS()
     
     //SQL style to sort all popular movies in one Line
   //  val bestMoviesID = moviesDS.groupBy("movieId").count().orderBy(desc("count")).cache()
   //  bestMoviesID.show()
   //  val results = bestMoviesID.collect()
     //results.foreach(println)
                
    spark.close()            
    
    
  }
}