#!/bin/bash

case ${1,,} in
pietro | administrator)
  echo "Oh, you're the boss here. Welcome!"
  ;;
help)
  echo "Just enter your username, duh!"
  ;;
*)
  echo "I don't know who you are"
  ;;
esac
