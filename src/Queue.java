public class Queue implements QueueInterface {

     QueueNode cabeza;
     QueueNode cola;
     int cantidad;

     class QueueNode {
        Object object;
        int prioridad;
        QueueNode siguiente;

        QueueNode(Object object, int prioridad) {
            this.object = object;
            this.prioridad = prioridad;
            this.siguiente = null;
        }
    }

    @Override
    public void clear() {
        this.cabeza = null;
        this.cola = null;
        this.cantidad = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public Object extract() {
        if (this.isEmpty()) {
            return null;
        }

        Object object = this.cabeza.object;
        this.cabeza = this.cabeza.siguiente;
        this.cantidad--;

        if (this.cabeza == null) {
            this.cola = null;
        }

        return object;
    }

    @Override
    public boolean insert(Object object) {
        QueueNode nuevo = new QueueNode(object, 0);

        if (this.isEmpty()) {
            this.cabeza = nuevo;
            this.cola = nuevo;
        } else {
            this.cola.siguiente = nuevo;
            this.cola = nuevo;
        }

        this.cantidad++;
        return true;
    }

    @Override
    public boolean insert(Object object, int prioridad) {
        QueueNode nuevo = new QueueNode(object, prioridad);

        if (this.isEmpty()) {
            this.cabeza = nuevo;
            this.cola = nuevo;

        } else if (prioridad < this.cabeza.prioridad) {
            nuevo.siguiente = this.cabeza;
            this.cabeza = nuevo;

        } else {
            QueueNode iterator = this.cabeza;

            while (iterator.siguiente != null
                    && iterator.siguiente.prioridad <= prioridad) {
                iterator = iterator.siguiente;
            }

            nuevo.siguiente = iterator.siguiente;
            iterator.siguiente = nuevo;

            if (nuevo.siguiente == null) {
                this.cola = nuevo;
            }
        }

        this.cantidad++;
        return true;
    }

    @Override
    public int size() {
        return this.cantidad;
    }

    @Override
    public boolean search(Object object) {
        QueueNode iterator = this.cabeza;

        while (iterator != null) {
            if (iterator.object == null && object == null) {
                return true;
            }

            if (iterator.object != null && iterator.object.equals(object)) {
                return true;
            }

            iterator = iterator.siguiente;
        }

        return false;
    }

    @Override
    public String toString() {
        String result = "";
        QueueNode iterator = this.cabeza;

        while (iterator != null) {
            result = result + iterator.object;

            if (iterator.siguiente != null) {
                result = result + " -> ";
            }

            iterator = iterator.siguiente;
        }

        return result;
    }
}