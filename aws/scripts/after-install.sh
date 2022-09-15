#!/bin/bash
set -xe


# Copy war file from S3 bucket to tomcat webapp folder
aws s3 cp s3://dnd-battle-be-webappdeploymentbucket-zgef6kg0vss9/DndBattleeAppBE.war /usr/local/tomcat9/webapps/DndBattleeAppBE.war


# Ensure the ownership permissions are correct.
chown -R tomcat:tomcat /usr/local/tomcat9/webapps