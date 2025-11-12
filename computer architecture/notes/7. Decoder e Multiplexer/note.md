# Decoder e Multiplexer

## Decoder

È un circuito con n ingressi e $2^n$ uscite.
Solo una delle uscite vale $1$, quella corrispondente al numero binario rappresentato dagli ingressi. Tutte le altre valgono $0$.

Esempio semplice:
Se ho 2 ingressi $(x1, x0)$, avrò 4 uscite $(y0, y1, y2, y3)$:
- ingresso $00 \rightarrow y0 = 1$
- ingresso $01 \rightarrow y1 = 1$
- ingresso $10 \rightarrow y2 = 1$
- ingresso $11 \rightarrow y3 = 1$

### Segnale di abilitazione

Un segnale di _enable_ può essere messo in prodotto logico con ciascuna uscita. Questo consente di mettere tutte le uscite a $0$.

Esempio($n=2$):
$$y_0=x'_1x'_0en \quad y_1=x'_1x_0en \quad y_2=x_1x'_0en \quad y_3=x_1x_0en$$

## Multiplexer

è un componente che ha $2^n+n$ ingressi parzionati tra:

- ingressi dati
- ingressi di selezione

Il multiplexer può essere visto come un componente che riporta in uscita il valore dell'ingresso dati selezionato dagli ingressi di selezione.
