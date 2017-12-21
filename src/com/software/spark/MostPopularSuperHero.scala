package com.software.spark

import org.apache.log4j._
import org.apache.spark._


// ------------->>>                             LookUp and MAX

object MostPopularSuperHero {
  // function to extract hero id and number of occurances for each hero
  def countCoOccurences(lines:String)={
    var elements = lines.split("\\s+")
    (elements(0).toInt, elements.length-1)
  }
  
  // function to extract hero ID -> Hero name Tuples or None if failure
  def parseNames(line:String): Option[(Int,String)]={
    var fields = line.split('\"')
    if(fields.length >1){
      return Some(fields(0).trim().toInt,fields(1))
   }else {
     return None // flatmap will just discard None results and extract data from some results
   }
  }
  
  def main(args:Array[String]){
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]","MostPopularSuperHero")
  
  // Build Up a hero ID-> name RDD
  val names = sc.textFile("C:/sparklearn/Marvel-names.txt")
  val namesRDD = names.flatMap(parseNames)
  //namesRDD.foreach(println)
  //Load Up the superhero co-apperance data
  val lines = sc.textFile("C:/sparklearn/Marvel-graph.txt")
  val pairing = lines.map(countCoOccurences)
  //Combine entres that has more than one line
  val totalFriendsByCharachet = pairing.reduceByKey((x,y)=>x+y)
  
  // flip connectinons and hero ID
  val flip = totalFriendsByCharachet.map(x=>(x._2,x._1))
  // finding the Max of connections  based on Key
  val mostPopular = flip.max()
  
  // Based on max connections ID find name by using Lookup ---> takes key and gives array of results 
  val mostPopularName = namesRDD.lookup(mostPopular._2)
  println(mostPopularName(0))
  
  
  
  
  
  
  
  
  
  
  }
}