#!/bin/bash 
java -Djdk.tls.namedGroups="secp256k1" -cp 'apps/*:conf/:lib/*:abi/' cn.webank.demo.DeployClient

