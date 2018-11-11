#!/bin/sh

# app name, must be modified!(used for directory name, so it cannot contains special symbols)
APP_NAME=blog-alpha
TAR_NAME=artifacts.tar.gz
BASE_PATH=~/deploy/$APP_NAME
BIN_PATH=$BASE_PATH/bin

echo "=== Start Deploying... ==="


# if app is running, get pid then kill the process
cd $BASE_PATH
pid=`cat pid.txt`
if [ -n "$pid" ]
then
    echo "Instance ${APP_NAME} is still running, pid: ${pid}, killing process..."
    kill -9 $pid
    sleep 1
    echo "Killed success."
fi


# clean and extract files
if [ -d "/${BIN_NAME}" ]
then
    echo "directory ${BIN_PATH} already exists, cleaning..."
    rm -r $BIN_PATH
fi

echo "Extracting files to ${BIN_PATH}..."
tar -zxvf $TAR_NAME -C $BIN_PATH
if [ $? != 0 ]
then
    echo "extract file failed!"
    echo "=== Deploy Failed! ==="
    exit 1
fi


# run new instance
echo "Running new instance..."
nohup java -jar $BIN_PATH/*.jar > logs.txt & echo $! > pid.txt
echo "appending logs to logs.txt, and write pid to pid.txt..."
sleep 1

echo "=== Deploy Success! ==="

