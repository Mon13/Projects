
"""sparkTeraSort.py"""
from pyspark import SparkContext

dataFile = "hdfs://ec2-54-174-86-20.compute-1.amazonaws.com:9000/sparkproject/input"  


sc = SparkContext("local", "128sort")
logData = sc.textFile(dataFile).cache()

pairs = logData.map(lambda x: (x.split("  ")[0], x))
sorted = pairs.sortByKey(ascending=True, numPartitions=None, keyfunc = lambda x: str(x))
result = sorted.values()

result.saveAsTextFile("hdfs://ec2-54-174-86-20.compute-1.amazonaws.com:9000/sparkproject/output")


