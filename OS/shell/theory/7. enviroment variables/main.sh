#!/bin/bash

SCRIPT_DIR=$(pwd) # salva in SCRIPT_DIR l'ouput del comando pwd

PATH=$PATH:$SCRIPT_DIR # concatena il valore di SCRIPT_DIR al valore di PATH e lo salva in PATH

export $PATH # esporta la variabile PATH in modo da renderlo visibile anche ai processi figli
