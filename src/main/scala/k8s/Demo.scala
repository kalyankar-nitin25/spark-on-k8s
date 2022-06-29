package k8s

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Demo {
  def main(args: Array[String]): Unit = {
    val conf= new SparkConf()
      .setAppName("spark-scala-k8-app")
      .setIfMissing("spark.master", "local[*]")
    val spark = SparkSession.builder()
      .config(conf)
      .getOrCreate()

    val values = List(List("1", "One") ,List("2", "Two") ,List("3", "Three"),List("4","4")).map(x =>(x(0), x(1)))
    import spark.implicits._
    val df = values.toDF("id","value")
    df.show()

  }
}
