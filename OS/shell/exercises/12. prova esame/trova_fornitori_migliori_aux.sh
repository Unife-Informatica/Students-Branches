#!/bin/bash

dir=$1
cod_parte=$2
num=$3

cerca_file() {
  dir=$1
  for item in "$dir"/*; do
    if [[ -d "$item" ]]; then
      cerca_file "$item"
    else
      counter=$(grep "$cod_parte" "$i" | cut -f 4 -d ,)
      forn=$(grep "$cod_parte" "$i" | cut -f 1 -d ,)
      if test "$counter" -ge "$num_pezzi_richiesti"; then
        if test "$counter" -ge $(cat /tmp/max_counter); then
          echo "$counter" >/tmp/max_counter
          echo "$forn" >/tmp/max_fornitore
        fi
      fi
    fi
  done
}
