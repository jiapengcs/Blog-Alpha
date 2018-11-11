#!/bin/sh

# app name, must be modified!(used for directory name, so it cannot contains special symbols)
APP_NAME=blog-alpha
ARTIFACTS_NAME=artifacts.tar.gz
BASE_PATH=~/deploy/$APP_NAME
TARGET_PATH=$BASE_PATH/target

echo "=== Start Deploying... ==="


# if app is running, get pid then kill the process
cd $BASE_PATH
pid=`cat ${TARGET_PATH}/pid.txt`
if [ -n "$pid" ]
then
    echo "Instance ${APP_NAME} is still running, pid: ${pid}, killing process..."
    kill -9 $pid
    sleep 1
    echo "Killed success."
fi


# clean and extract files
if [ -d "${TARGET_PATH}" ]
then
    echo "directory ${TARGET_PATH} already exists, cleaning..."
    rm -r $TARGET_PATH
fi

echo "Extracting files..."
tar -zxvf $ARTIFACTS_NAME
if [ $? != 0 ]
then
    echo "extract file failed!"
    echo "=== Deploy Failed! ==="
    exit 1
fi


# run new instance
cd $TARGET_PATH
echo "Running new instance..."
nohup java -jar *.jar > logs.txt & echo $! > pid.txt
echo "appending logs to logs.txt, and write pid to pid.txt..."
sleep 1

echo "=== Deploy Success! ==="

