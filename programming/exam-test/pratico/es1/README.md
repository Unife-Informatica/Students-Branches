# Delivery
Un progettista deve sviluppare una scheda hardware e deve decidere che tipo di memoria RAM utilizzare. Le memorie disponibili sul mercato sono riportate in un file di testo  memory.txt e sono al massimo 100. Per ciascuna memoria nel file sono riportati:
- stringa contenente al più 20 caratteri, senza spazi: costruttore
- intero: tempo di accesso in ns
- intero: costo in dollari

Nel progetto precedente, era prevista una memoria con tempo di accesso 47 ns e costo 46 $. Il progettista vuole avere l'elenco di tutte le memorie che sono migliori di quella attualmente in uso, cioè:
- il cui tempo di accesso è al più 47 ns
- il cui costo è al più 46 $

Inoltre vuole escludere le memorie che abbiano esattamente le stesse caratteristiche della memoria attuale: se trova una memoria che ha tempo di accesso uguale a 47 ns e costo 46 $ preferisce mantenere la memoria attualmente in uso.