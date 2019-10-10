#!/bin/sh
source /etc/profile
echo "source: $1"
echo "target: $2"
echo "logger_id: $3"
spark-submit --master yarn --deploy-mode cluster --executor-memory 2g --class com.clinbrain.datac.spark.DataCompareTask /opt/datac/compare_spark-1.0-SNAPSHOT.jar "$1" "$2" "$3"
if [ $? -ne 0 ]
then
 echo "command failed"
 echo $?
 exit 1
fi