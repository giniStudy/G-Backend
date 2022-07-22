#!/bin/bash

echo docker stop joylog-----------

docker stop joylog

echo docker rm jolog------
docker rm joylog

echo cd /home/ec2-user/github_action -----------------

cd /home/ec2-user/joylog

echo docker build -t test:auto .

docker build -t test:auto .

echo docker run build -p 8080:80 -d --name joylog test:auto


docker run -p 8080:80 -d --name joylog test:auto
