#!/bin/bash

echo "Inserire il nome del file: "
read fileName

if [ ${fileName,,} = fine ]; then
  exit 0
fi

if [ -d $fileName ]; then
  echo $fileName "è una directory"
elif [ -f $fileName ]; then
  echo $fileName "è un file"
else
  echo "idk"
fi
