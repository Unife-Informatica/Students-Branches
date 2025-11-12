#!/bin/bash

dir_articoli="$1"

isPreliminare() {
  local file="$1"
  if grep -qi "preliminare" "$file"; then
    return 0 # True
  else
    return 1 # False
  fi
}

cercaFile() {
  local dir="$1"
  local count=0

  for item in "$dir"/*; do
    if [ -d "$item" ]; then
      local subcount
      subcount=$(cercaFile "$item")
      count=$((count + subcount))
    elif [[ "$item" == *.txt ]]; then
      if isPreliminare "$item"; then
        rm "$item"
        echo "[eliminato]: $item"
        count=$((count + 1))
      fi
    fi
  done

  if [ -f /tmp/max_counter.tmp ]; then
    max_count=$(cat /tmp/max_counter.tmp)
  else
    max_count=0
  fi

  if [ "$count" -gt "$max_count" ]; then
    echo "$count" >/tmp/max_counter.tmp
  fi

  echo "$count"
}

cercaFile "$dir_articoli"
