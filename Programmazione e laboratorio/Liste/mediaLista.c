int somma(Lista l){
    int s;
    while (l!=NULL)
    {
        s=s+l->dato;
        l=l->next;
    }
    return s;
}
somma(l)/lunghezza(l);