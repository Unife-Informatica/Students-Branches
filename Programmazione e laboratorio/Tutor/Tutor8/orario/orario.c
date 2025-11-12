#include <stdio.h>
#include <string.h>
#include "orario.h"
void inizOrario(char m[RIGHE][COLONNE][SIZE]){
    const char *giorni[]={"Lunedi'","Martedi'","Mercoledi'","Giovedi'","Venerdi'"};
    const char *ore[]={"Agenda","9-11","11-13","14-16","16-18"};
    for (int i = 0; i < COLONNE; i++){
        snprintf(m[0][i],SIZE,"%s",ore[i]);
    }
    
    for (int i = 1; i < RIGHE; i++){
        snprintf(m[i][0],SIZE,"%s",giorni[i-1]);
    }
    
    for (int i = 1; i < RIGHE; i++){
        for (int j = 1; j < COLONNE; j++){
            snprintf(m[i][j],SIZE,"Vuoto");
        }
        
    }
    
}
void stampaOrarioG(char m[RIGHE][COLONNE][SIZE], char g[20]){
    for (int i = 0; i < COLONNE; i++){
        printf("%s  ",m[0][i]);
    }
    printf("\n");  
    for (int i = 0; i < RIGHE; i++){
        for (int j = 0; j < COLONNE; j++){
            if(strcmp(g,m[i][0])==0){
                printf("%s ",m[i][j]);
            }
        }
    }
    
    printf("\n");
}
void modifica(char m[RIGHE][COLONNE][SIZE],char g[20],char o[10],char lezione[50]){
    for (int i = 1; i < RIGHE; i++)
    {
        if(strcmp(g,m[i][0])==0){
            for (int j = 1; j < COLONNE; j++)
            {
                if(strcmp(o,m[0][j])==0){
                    snprintf(m[i][j],SIZE,"%s",lezione);
                }
            }
            
        }
        
    }
    
}
void stampaOrario(char m[RIGHE][COLONNE][SIZE]){
    for (int i = 0; i < RIGHE; i++){
        for (int j = 0; j < COLONNE; j++){
            printf("%s  ",m[i][j]);
        }
        printf("\n");
    }
    
}