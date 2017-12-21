package com.scala.practises

object StringObject {
  
  def main(args:Array[String]){
    // Multi line String use """ 3 qoutes
    val str = """suresh
               sueeeee"""
    
    println(str)
    
    // to avoid white space before the string use {stripmargin} with |(pipe) or your type
    
    var speech = """Hello My self venkata
    |I am from chiacgo
    |this is just sampe case of the 
    |stripmargin""".stripMargin
    
    println(speech)
    
    // Custom strip margin with contionus line
    var sp = """Hello My self venkata
    $I am from chiacgo
    $this is just sampe case of the 
    $stripmargin""".stripMargin('$').replace("\n"," ")
    
    println(sp)
    
    var st = "hello this is\t"
    println(st.stripLineEnd)
  }
  
  
}