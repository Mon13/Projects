1.	Launch amazon EC2 instance.
2.	Install spark on the instance (Steps are described in the following sections)
3.	Login into the spark cluster
4.	Copy source code to master instance
5.	create input file using gensort using ./gensort -a <lineNumbers> <filePath>
6.	move the file to HDFS using ./hadoop dfs -copyFromLocal <input file path> /input
7.	Run the program,./bin/spark-submit --master spark://MASTER IP:7077 /terasort/sparkterasort.py
8.	Copy file to local from HDFS using ./hadoop dfs -copyToLocal /output <local file path>
9.	Validate output using valsort ./valsort <file name>
