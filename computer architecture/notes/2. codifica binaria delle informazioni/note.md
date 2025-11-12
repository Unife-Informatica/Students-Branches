# Codifica binaria delle informazioni

Come codice binario si intende una funzione $f:\{0,1\}^n \rightarrow J$, dove $J$ rappresenta un insieme di $M$ informazioni.

## Selezione del valore di $n$
Il numero di configurazioni binarie deve essere maggiore o uguale al numero di informazioni $M$ da codificare
$$2^n \ge M$$
risolvendo tale disequazione rispetto $n$ si ottiene
$$n\ge [\log_2M]$$