dir_sorgente=$1
dir_destinazione=$2

muovi_file() {
  file_name=$1
  dest=$2

  for item in "$dest"/*; do
    if [ $(basename "$item") = $(basename "$file_name") ]; then
      if [ ! -d "$dest"/duplicati ]; then
        mkdir -p "$dest"/duplicati
      fi
      mv "$file_name" "$dest"/duplicati/$(basename "$file_name")
      return
    fi
    done
    mv "$file_name" "$dest"/$(basename "$file_name")
}

cerca_file() {
  local dir=$1
  local dest=$2

  for item in "$dir"/*; do
    if [ -d "$item" ]; then
      cerca_file "$item"  "$dest"
    elif [ -f "$item" ]; then
      case "$item" in
        *.jpg)
            muovi_file "$item" "$dest"
          ;;
      esac
    fi
  done
}

cerca_file "$dir_sorgente" "$dir_destinazione"