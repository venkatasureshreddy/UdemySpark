package com.scala.practises
import scala.collection.mutable.Map
import scala.collection.mutable.ListBuffer



object Ifstatements {
  
  def main(arrgs:Array[String]){
    
    var list = List(1,2,3,4,5,6)
    var listbuffer = ListBuffer(1,2,3,4,5,6)
     var l = 7 :: list
    
    listbuffer += 10
    listbuffer.remove(5)
    
   // listbuffer.foreach(println)
    
    var seq = Seq(1,2,34)
    println(seq)
    
    
   
    
//    var l = for(i<- list if i>2) yield i
//    var map:Map[Int,String] = Map(1->"suresh",2->"Reddy")
//    
//  // map.foreach(x=>println(x._1 + " " + x._2))
//    map.foreach{case(k,y)=>println(k +""+y)}
    
   // l.foreach(println)
    
    
 
  }
  

  
  
}