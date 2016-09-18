#! /bin/bash

mongo replset-init-1.js &
mongo replset-init-2.js &
mongo replset-init-3.js &

wait
echo "initied on three mongo instance"
