dir_articoli=$1

if [ ! "$dir_articoli" ]; then
  echo "./cancella_versioni_preliminari.sh <dir>"
  exit 1
fi

if [ ! -d "$dir_articoli" ]; then
  echo "Errore: $dir_articoli directory non valida"
  exit 1
fi

echo 0 >/tmp/max_counter.tmp
echo "" >/tmp/max_dirname.tmp

./cancella_versioni_preliminari_aux.sh "$dir_articoli"

rm /tmp/max_counter.tmp /tmp/max_dirname.tmp
