package org.example
import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


object WordCount {

  def main(args: Array[String]): Unit = {

    if (args.length < 1) {
      System.err.println("Usage: WordCount <file>")
      System.exit(1)
    }

    val sparkConf = new SparkConf().setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val lines = sc.textFile(args(0))
    val words = lines.flatMap(line => line.split(" "))
    val wordCounts = words.map(word => (word, 1)).reduceByKey(_ + _)
    println("-----------------------------------------------------")
    println("From file: " + args(0))
    println("To file: " + args(1))
    println("Result: ")
    println(wordCounts.collect().mkString(","))
    println("-----------------------------------------------------")
    wordCounts.saveAsTextFile(args(1))
    sc.stop()
  }

}
