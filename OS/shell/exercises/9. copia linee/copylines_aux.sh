dir=$1
stringa=$2

shift 2

for item in "$dir"/*; do
  if [[ -d "$item" ]]; then
    ./copylines_aux.sh "$item" "$stringa" "$@"
  else
    for file in "$@"; do
      if [[ "$(basename "$item")" == "$(basename "$file")" ]]; then
        if grep -q "$stringa" "$item"; then
          echo "Moving: $item"
        fi
      fi
    done
  fi
done
