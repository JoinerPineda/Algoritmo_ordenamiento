class Nodo {
    int valor;
    Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    
    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    
    public void ordenarBurbuja() {
        if (cabeza == null || cabeza.siguiente == null) {
            return; 
        }

        boolean huboIntercambio;
        do {
            Nodo actual = cabeza;
            Nodo anterior = null;
            Nodo siguiente = cabeza.siguiente;
            huboIntercambio = false;

            while (siguiente != null) {
                if (actual.valor > siguiente.valor) {
                    
                    huboIntercambio = true;
                    if (anterior == null) {
                        
                        cabeza = siguiente;
                    } else {
                        anterior.siguiente = siguiente;
                    }
                    actual.siguiente = siguiente.siguiente;
                    siguiente.siguiente = actual;

                  
                    anterior = siguiente;
                    siguiente = actual.siguiente;
                } else {
                    anterior = actual;
                    actual = siguiente;
                    siguiente = siguiente.siguiente;
                }
            }
        } while (huboIntercambio);
    }

    
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.valor + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        lista.agregar(4);
        lista.agregar(2);
        lista.agregar(8);
        lista.agregar(1);
        lista.agregar(5);

        System.out.println("Lista antes de ordenar:");
        lista.imprimir();

        lista.ordenarBurbuja();

        System.out.println("Lista después de ordenar:");
        lista.imprimir();
    }
}
