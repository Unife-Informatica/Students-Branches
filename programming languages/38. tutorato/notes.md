### **1️⃣ Da cosa parto? (tipo iniziale)**

Chiediti subito:

> **Qual è il tipo dello Stream all’inizio?**

Esempi:

* `List<Book>` → `Stream<Book>`
* `List<List<String>>` → `Stream<List<String>>`

✍️ Scrivilo mentalmente o su carta.

---

### **2️⃣ Dove voglio arrivare? (tipo finale)**

Chiediti:

> **Che risultato vuole l’esercizio?**

Esempi:

* `List<String>`
* `Set<Integer>`
* `long`
* `boolean`

👉 Questo ti dice **che operazione terminale usare**:

* `List` → `collect()` / `toList()`
* `Set` → `Collectors.toSet()`
* numero → `count()`
* vero/falso → `anyMatch`, `allMatch`, `noneMatch`

---

### **3️⃣ Devo filtrare?**

Se il testo dice:

* “solo”
* “che soddisfano”
* “con valore maggiore di”
* “non null”

👉 **`filter`**

```java
.filter(b -> b.getPages() > 100)
```

---

### **4️⃣ Devo trasformare i dati?**

Se il testo dice:

* “estrarre”
* “ottenere”
* “prendere il campo”

👉 **`map`**

```java
.map(Book::getTitle)
```

⚠️ Se ottieni **collezioni annidate**:

> `Stream<List<T>>`

👉 serve **`flatMap`**

```java
.flatMap(List::stream)
```

🧠 **Regola d’oro da esame**

> Se vedi `List<List<...>>` → pensa subito a `flatMap`

---

### **5️⃣ Devo eliminare duplicati / ordinare / limitare?**

* “unici” → `distinct()`
* “ordinati” → `sorted()`
* “primi N” → `limit(n)`

---

### 🔹 Esempio 1

**“Titoli dei libri con più di 300 pagine”**

```java
List<String> titles = books.stream()
        .filter(b -> b.getPages() > 300)
        .map(Book::getTitle)
        .toList();
```

---

### 🔹 Esempio 2

**“Tutti i tag unici dei libri”**

```java
Set<String> tags = books.stream()
        .map(Book::getTags)
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .collect(Collectors.toSet());
```

---

### 🔹 Esempio 3

**“Esiste almeno un libro con tag 'java'?”**

```java
boolean exists = books.stream()
        .map(Book::getTags)
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .anyMatch(tag -> tag.equals("java"));
```

---

### 🔹 Esempio 4

**“Numero totale di tag (con duplicati)”**

```java
long count = books.stream()
        .map(Book::getTags)
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .count();
```
