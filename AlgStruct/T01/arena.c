#include <stdio.h>
#include <stdlib.h>
#define M 1000000007
long calculator(int n,int e){
    long result=1;
    for(int i=0;i<e;i++){
        result = (result*n)%M;
    }
    return result;

}
void solve(FILE *input_file,FILE *output_file){
    unsigned int N;
    fscanf(input_file,"%d",&N);
    for(int i = 0; i<N;i++){
        int n;
        int e;
        fscanf(input_file,"%d %d",&n,&e);
        fprintf(output_file,"%ld\n",calculator(n,e));
    }
}
int main(){
    FILE *input_file, *output_file;

    input_file=fopen("input.txt","r");
    if(input_file==NULL){
        perror("Errore apertura file di lettura");
        exit(1);
    }
    output_file=fopen("output.txt","w");
    if(output_file==NULL){
        perror("Errore apertura file di scrittura");
        exit(2);
    }

    solve(input_file,output_file);

    if(fclose(input_file)!=0){
        perror("Errore nella chiusura del file di lettura");
        exit(3);
    }
    if(fclose(output_file)!=0){
        perror("Errore nella chiusura del file di scrittura");
        exit(4);
    }

    return EXIT_SUCCESS;
}
