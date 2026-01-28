while true
do
    echo "Inserisci nome file(fine per terminare)"
    read input

    if test "$input" = fine
    then
        break
    fi

    if test -f "$input"
    then 
        echo "$input: file "
    else
        if test -d "$input"
        then
            echo "$input: dir"
        else
            echo "$input: non esistente"
        fi
    fi

done