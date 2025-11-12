#!/bin/bash

LIST=(one two three four five)

for item in ${LIST[@]}; do
  echo $item
done
