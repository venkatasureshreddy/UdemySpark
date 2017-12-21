package com.scala.practises

case class Person(firstName:String,lastName:String,age:Int)
object ListObject {
  
  def main(args:Array[String]){
    
    var sur = new Person(lastName="Reddy",firstName="Suresh",age=16)
    var ram = new Person(age=13,firstName="Ramesh",lastName="Pasupuleti")
    var nag = new Person(firstName="Nagendra",lastName="pasuplla",age=17)
    var aka = new Person(age=15,firstName="akash",lastName="ralla")
    
    var seq:Seq[Person] = Seq(aka,nag,ram,sur)
    
    for(i<-seq.filter(_.age >=15).sortBy(_.age)map(_.firstName)){
      
      println(i)
      
    }
    
  }
  
  
}