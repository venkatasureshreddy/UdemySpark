package com.scala.practises
import scala.collection.mutable.Map

object MapObject {
  
  def main(args:Array[String]){
    
    val tuple = (1,4.90,"dthef")
    val map = Map(1->List("suresh","ramesh"),2->tuple,3->"suresh")
    
    map.foreach(print)
    println()
    
    // adding elements to map
    map += (4->"reddy")
    
    // removing elements to map
    map -= 3
    map.foreach(print)
    
    // update values in tuple
    map.update(4,"updated")
    println()
    map.foreach(print)
    
    println("Iterating Map")
    map.foreach(print)
    for((k,v)<-map){print(k+" "+v+" ")}
    
    map.map{case(k,v)=>println(k+" "+v)} //----------> this is one way of iteration
    map.foreach(x =>x._1)
    
    
    
    
    
    
  }
  
}