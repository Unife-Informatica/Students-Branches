current_dir="$1"

for elemento in "$current_dir"/*;
do
	case "$elemento" in
		*.txt)
			count=0
			if [ -r "$elemento" ];
			then
				prima_riga=$(head -n 1 "$elemento")
				if [ "$prima_riga"= "giochi" ];
				then
					echo "$(basename "$elemento")" >> "$output"
					count=$(wc -l < "$elemento")
					if [ "$count" -gt "$max_righe" ];
					then
						max_righe="$count"
						file_max="$elemento"
						export max_righe file_max
					fi
				fi
			fi
		;;
		*)
			if [ -d "$elemento" ];
			then
				./trova_file_giochi_ric.sh "$elemento"
			fi
		;;
	esac
done
