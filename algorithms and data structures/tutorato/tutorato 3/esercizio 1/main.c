#include <stdio.h>
#include <stdlib.h>

// Dovrebbe bastare "50", come specificato nel testo, ma stiamo larghi
#define MAX_SIZE 128

// Definizione di stack

struct stack {
  int numbers[MAX_SIZE];
  int top_index;
};

void initialize(struct stack *stack) { stack->top_index = -1; }

int is_empty(struct stack *stack) { return stack->top_index == -1; }

int is_full(struct stack *stack) { return stack->top_index == MAX_SIZE - 1; }

void push(struct stack *stack, int number) {
  if (is_full(stack)) {
    fprintf(stderr, "Overflow!");
    exit(-1);
  }

  stack->numbers[++(stack->top_index)] = number;
}

int pop(struct stack *stack) {
  if (is_empty(stack)) {
    fprintf(stderr, "Underflow!");
    exit(-2);
  }

  return stack->numbers[(stack->top_index)--];
}

// Operatori

void dot(struct stack *stack) {
  int b = pop(stack);
  int a = pop(stack);

  push(stack, a + b);
}

void at(struct stack *stack) {
  int c = pop(stack);
  int b = pop(stack);
  int a = pop(stack);

  push(stack, a * (b - c));
}

// implementazione naive della potenza, vedi octothorp
int _naive_pow(int base, int exp) {
  int result = 1;

  for (int i = 0; i < exp; i++) {
    result *= base;
  }

  return result;
}

// logica associata al simbolo #
int octothorp(struct stack *stack) {
  int b = pop(stack);
  int a = pop(stack);

  push(stack, _naive_pow(b, a));
}

void dollar(struct stack *stack) {
  int b = pop(stack);
  int a = pop(stack);

  push(stack, (a - 1) * (b - 1));
}

void big_m(struct stack *stack) {
  int current_max = -1;

  while (!is_empty(stack)) {
    int candidate = pop(stack);
    if (candidate > current_max)
      current_max = candidate;
  }

  push(stack, current_max);
}

void small_m(struct stack *stack) {
  int current_min = 2147483647;

  while (!is_empty(stack)) {
    int candidate = pop(stack);
    if (candidate < current_min)
      current_min = candidate;
  }

  push(stack, current_min);
}

// punto di entrata per invocare la logica dietro un certo operatore
int evaluate_operator(struct stack *stack, char operator) {
  switch (operator) {
  case '.':
    dot(stack);
    break;
  case '@':
    at(stack);
    break;
  case '#':
    octothorp(stack);
    break;
  case '$':
    dollar(stack);
    break;
  case 'M':
    big_m(stack);
    break;
  case 'm':
    small_m(stack);
    break;
  default:
    fprintf(stderr, "Undefined operator!");
    exit(-3);
  }
}

int main(void) {
  // inizializziamo la stack in cui metteremo i vari numeri letti,
  // e da cui attingeremo per prendere gli argomenti giusti dei vari operatori
  struct stack stack;
  initialize(&stack);

  // si dovrebbe controllare la corretta apertura
  FILE *input_file, *output_file;
  input_file = fopen("input.txt", "r");
  output_file = fopen("output.txt", "w");

  char buffer[MAX_SIZE];
  int number;

  // itera sull'unica riga in input; in particolare, su tutti i blocchetti
  // separati da spazi.
  // esempio: "13 21 . 34 41 . ." mette nel buffer "13", poi "21", poi "."...
  // https://www.experts-exchange.com/questions/21322713/Use-of-fscanf-and-parsing-line-by-line-of-a-FILE.html
  while (fscanf(input_file, "%s", buffer) != EOF) {
    if (sscanf(buffer, "%d", &number) == 1) {
      // prova ad interpretare il buffer come se fosse un intero;
      // se tutto fila liscio, aggiungi l'intero allo stack.
      push(&stack, number);
    } else {
      // se qualcosa, allo stiamo sicuramente leggendo un operatore;
      // applichiamolo ai numeri nella stack con questa funzione
      evaluate_operator(&stack, buffer[0]);
    }
  }

  fprintf(output_file, "%d", stack.numbers[0]);

  // per una questione di disciplina, andrebbero chiusi in modo più delicato
  fclose(input_file);
  fclose(output_file);

  return 0;
}
