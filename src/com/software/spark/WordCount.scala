package com.software.spark
import org.apache.log4j._
import org.apache.spark._



object WordCount {
  
  def main(args:Array[String]){
    Logger.getLogger("org").setLevel(Level.ERROR)
    val sc = new SparkContext("local[*]","WordCount")
    
    val DataRdd = sc.textFile("c:/sparklearn/book.txt")
    
    // spliting each word in to new RDD by using regural expression only taking words.
    val wordsRDD = DataRdd.flatMap(x=>x.split("\\W+"))
    
    val lowerCaseRDD = wordsRDD.map(x=>x.toLowerCase())
    
    val countByValue = wordsRDD.countByValue() //----> basically gives scala Map.
    // You can use key,value rdd. by using reduce by key
   
    //making values to key,value tuple and add the reduce them by Key
    val wordsByRDD = lowerCaseRDD.map(x=>(x,1)).reduceByKey((x,y)=>x+y)
    
    // Sort by Key by exchanging the positions
    val result = wordsByRDD.map(x=>(x._2,x._1)).sortByKey()
   result.foreach(println)

    
    
  }
}