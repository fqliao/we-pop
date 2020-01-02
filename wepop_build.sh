#!/bin/bash

set -e

dirpath="$(cd "$(dirname "$0")" && pwd)"
cd $dirpath

# default value 
type=

function help(){
	echo -e "\033[31m"$1"\033[0m"
    cat << EOF
Usage:
    -g <guomi>                [Optional]
    -h Help
EOF

exit 0 
}

function check_java(){
   version=$(java -version 2>&1 |grep version |awk '{print $3}')
   len=${#version}-2
   version=${version:1:len}

   IFS='.' arr=($version)
   IFS=' '
   if [ -z ${arr[0]} ];then
      LOG_ERROR "At least Java8 is required."
      exit 1
   fi
   if [ ${arr[0]} -eq 1 ];then
      if [ ${arr[1]} -lt 8 ];then
           LOG_ERROR "At least Java8 is required."
           exit 1
      fi
   elif [ ${arr[0]} -gt 8 ];then
          :
   else
       LOG_ERROR "At least Java8 is required."
       exit 1
   fi
}

function parse_params() {
  while getopts ":gh" option;do
      case $option in
      g) type=gm;;
      h) help;;
      esac
  done
}

function run(){
  if [[ ${type} == "gm" ]];then
      cp src/test/resources/applicationContext-1.xml  src/main/resources/applicationContext.xml
		  cp gm/* src/main/java/cn/webank/blockchain/contracts/web3j/
  else 
      cp src/test/resources/applicationContext-0.xml  src/main/resources/applicationContext.xml
		  cp ngm/* src/main/java/cn/webank/blockchain/contracts/web3j/
  fi
	bash gradlew build
}

function main() {
  run
}

check_java
parse_params $@
main
