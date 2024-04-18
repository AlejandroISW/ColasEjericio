package colalista;

/**
 *
 * @author maryse
 * 
 * Cola - Listas
 */

public class ColaLista {

    public Nodo frente;
    protected Nodo fin;
    
    // constructor: crea cola vacía
    public ColaLista() {
        frente = fin = null;
    }
    
    public String visualizar() {
    StringBuilder sb = new StringBuilder();
    Nodo actual = frente;
    while (actual != null) {
        sb.append(actual.elemento.toString()).append(" ");
        actual = actual.siguiente;
    }
    return sb.toString().trim();
}

    
    // insertar: pone elemento por el final
    public void insertar(Object elemento) {
        Nodo a;
        a = new Nodo(elemento);
        if (colaVacia()) {
            frente = a;
        } else {
            fin.siguiente = a;
        }
        fin = a;
    }
    
    // quitar: sale el elemento frente
    public Object quitar() throws Exception {
        Object aux;
        if (!colaVacia()) {
            aux = frente.elemento;
            frente = frente.siguiente;
        } else {
            throw new Exception("Eliminar de una cola vacía");
        }
        return aux;
    }
    
    // libera todos los nodos de la cola
    public void borrarCola() {
        for (; frente != null;) {
            frente = frente.siguiente;
        }
        System.gc();
    }
    
    // acceso al primero de la cola
    public Object frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (frente.elemento);
    }
    
    // verificación del estado de la cola
    public boolean colaVacia() {
        return (frente == null);
    }
}
