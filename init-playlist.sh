#!bin/bash

until=$1

declare -a musics=(
1
2
3
4
5
6
)

declare -a playerStatus=(
"started"
"skiped"
"paused"
"closed"
)

declare -a song_id=(
    1
    120
    3600
    60
    120
    330
)

for ((i = 0; i < $until; i++))
do
    index=$((0 + $RANDOM % ${#musics[@]-1}))
    echo ""
    
    java -jar ./producer/build/libs/producer-0.1-all.jar player --accountId=1 --songId="${musics[$index]}" --startedAt="$(date '+%d/%m/%Y - %H:%M:%S')" --status='${musics[${#playerStatus[@]-1}]}'
    
done