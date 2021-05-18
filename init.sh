#!bin/bash

until=$1

declare -a musics=(
"fear of the dark"
"atirei o pau no gato"
"parabens pra vc"
"musica aleatoria"
"outro tipo de musica bem aletoria"
"musica de abertura do pokemon"
)

declare -a duration_in_seconds=(
    324
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

    java -jar ./producer/build/libs/producer-0.1-all.jar song --title="${musics[$index]}" --id="$index" --duration="${duration_in_seconds[$index]}"
done