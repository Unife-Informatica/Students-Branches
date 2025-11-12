if [ ! -d "$1" ]; then
  echo "uso: $0 <dir_sorgente> <dir_destinazione>"
  exit 1;
fi

if [ ! -d "$2" ]; then
  echo "uso: $0 <dir_sorgente> <dir_destinazione>"
  exit 1;
fi

./riordina_foto_aux.sh "$1" "$2"