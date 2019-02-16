#!/bin/bash

#echo "install apirunner package"
#mvn install:install-file -Dfile=./lib/dtp/apirunner/apirunner-1.0.0-SNAPSHOT.jar -DgroupId=com.duanlei.dtp -DartifactId=apirunner -Dversion=1.0.0-SNAPSHOT -Dpackaging=jar  -DdownloadSources=true -DgeneratePom=true -DcreateChecksum=true -DpomFile=./lib/dtp/apirunner/pom.xml
#source ./lib/dtp/apirunner/install_api.sh

#echo "install testng-DT package"
#mvn install:install-file -Dfile=./lib/dtp/testng/testng-6.9.5-SNAPSHOT.jar -DgroupId=org.testng -DartifactId=testng -Dversion=6.9.5 -Dpackaging=jar  -DdownloadSources=true -DgeneratePom=true -DcreateChecksum=true -DpomFile=./lib/dtp/testng/pom.xml
#source ./lib/dtp/apirunner/install_testng.sh

echo "make stand alone test package"
mvn clean package -Dmaven.test.skip=true

echo "well done"
