## Spark Job Word Count

Requirements:

> * [Apache Spark 3.2.1](https://spark.apache.org/downloads.html)
> * [Scala 2.12.15](https://www.scala-lang.org/download/)
> * [Java 11](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)

Submit a Spark job to count the number of words in a text file.

- `mvn clean package`
- `spark-submit --class org.example.WordCount --master local target/spark-word-count-1.0-SNAPSHOT.jar ~/data.txt ~/spark-output`