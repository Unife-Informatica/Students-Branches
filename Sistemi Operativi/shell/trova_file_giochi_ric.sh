currentDir="$1"

for elemento in "$currentDir";
do
    case $elemento in 
        *.txt)
            if [ -r "$elemento" ];
            then
                riga=$(head -n 1 "$elemento")
                if [ "$riga" = "giochi"];
                then
                    echo $(basename "$elemento") .txt >> "$output"