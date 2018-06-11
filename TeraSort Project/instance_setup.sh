hostnamectl set-hostname datanode*

apt-get install openjdk-8-jdk

wget http://apache.claz.org/hadoop/common/hadoop-2.7.4/hadoop-2.7.4.tar.gz

tar -xvzf hadoop-2.7.4.tar.gz

export JAVA_HOME=/usr
export PATH=$PATH:~/hadoop/sbin:~/hadoop/bin
export HADOOP_CLASSPATH=/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar


ssh-keygen
cat /root/.ssh/id_rsa.pub >> /root/.ssh/authorized_keys

scp mapred-site.xml yarn-site.xml core-site.xml hdfs-site.xml root@datanode1:`pwd`

mkdir -p /root/hadoop/file/datanode

chmod -R 755 /root/hadoop/file/