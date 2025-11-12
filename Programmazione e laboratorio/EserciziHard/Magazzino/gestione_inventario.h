typedef struct{
    int ID;
    char nome[20];
    int quantita;
    float prezzo;
}Prodotto;
void cercaID(Prodotto *prodotti,int *contProd);
void cercaNome(Prodotto *prodotti,int *contProd);
void cercaQuant(Prodotto *prodotti,int *contProd);
void cercaPrezzo(Prodotto *prodotti,int *contProd);
void modificaProd(Prodotto *prodotti,int *contProd);
void visualizzaProd(Prodotto *prodotti,int *contProd);
