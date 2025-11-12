#!/bin/bash

LIST=(one two three four five)
echo $LIST      # OUT: one
echo ${LIST[@]} # OUT: one two three four five
echo ${LIST[1]} # OUT: two
