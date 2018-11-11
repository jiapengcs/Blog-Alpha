#!/bin/sh

# app name, must be modified!(use for directory name, so it cannot contains special symbols)
APP_NAME=example
BASE_PATH=~/deploy/target

echo "=== Start Deploying... ==="

# clean and extract files
cd $BASE_PATH
if [ ! -d "/${APP_NAME}" ]
then
    echo "directory ${BASE_PATH}/${APP_NAME} not exists, creating..."
    mkdir $APP_NAME
else
    echo "directory ${BASE_PATH}/${APP_NAME} already exists, removing..."
    rm -r $APP_NAME
fi

echo "Extracting files to ${BASE_PATH}/${APP_NAME}..."

tar -zxvf artifacts.tar.gz -C ./$APP_NAME
if [ $? != 0 ]
then
    echo "extract file failed!"
    echo "=== Deploy Failed! ==="
    exit 1
fi

cd $APP_NAME

# if app is running, get pid then kill the process
pid=`cat pid.txt`
if [ -n "$pid" ]
then
    echo "Instance ${APP_NAME} is still running, pid: ${pid}, killing process..."
    kill -9 $pid
    sleep 1
    echo "Killed success."
fi

# run new instance
echo "Running new instance..."
nohup java -jar *.jar > logs.txt & echo $! > pid.txt
echo "appending logs to logs.txt, and write pid to pid.txt..."
sleep 1

echo "=== Deploy Success! ==="

