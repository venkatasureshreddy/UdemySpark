package com.scala.practises

object TupleObject {
  // Tuple is a class that contains miscellaneous collection
  
  def main(args:Array[String]){
  var tuple = (1,1.23,-23.4,"suresh",false,'c',1,1,1,1,1,1,1,1,1," ",1," ",1,1,1,2)
  
  println(tuple._22)
  val tup = 1->"a"   //--> you can create tuple like this
  
  // You cannot iterate tuple directly because is not a collection class.you can use (product iterator) method
  
  tuple.productIterator.foreach(println)
  
  
  
  }
}