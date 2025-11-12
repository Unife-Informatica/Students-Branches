#!/bin/bash

# Example:
# $ ./if.sh pietro

# Se if.sh PiEtRo
# ${1}   = "PiEtRo"
# ${1,,} = "pietro"
if [ ${1,,} = pietro ]; then
  echo "Oh, you're the boss here. Welcome!"
elif [ ${1,,} = help ]; then
  echo "Just enter your username, duh!"
else
  echo "I don't know who you are"
fi # chiusura del blocco condizionale if
