package generadorlaberinto;

import static generadorlaberinto.Main.columna;
import static generadorlaberinto.Main.fila;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Generador {

    //Arreglo de objetos tipo Celdas, donde se almacenaran todas las celdas.
    private Celdas[] celda;
    //Arreglo de objetos tipo Paredes, donde se almacenaran todas las paredes.
    private Paredes[] pared;
    //Cantidad de filas.
    //private int fila=150;
    //Cantidad de columnas.
    //private int columna=150;
    private int x;
    private int y;
    private int i;
    //ArrayList de lineas a dibujar
    //private ArrayList<Linea> lineas;
    //private Main m = new Main();

    //public Generador(int fila, int columna) {
    //  this.fila = fila;
    //this.columna = columna;
    //}
    public Generador() {
        //fila = m.getColumna();
        //columna = fila;
        //Creo el arreglo de tipo Celdas.
        celda = new Celdas[fila * columna];
        //Creo el arreglo de tipo Columnas.
        pared = new Paredes[((fila - 1) * columna) + (fila * (columna - 1))];
        //Ejecuto metodo listaCeldas().
        listaCeldas();
        //Ejecuto metodo listaParedes().
        listaParedes();
        //Ejecuto metodo eliminaParedes().
        eliminaParedes();
        //Ejecuto metodo agregaLineas
        //agregaLineas();

    }

    public Celdas[] getCelda() {
        return celda;
    }

    public void setCelda(Celdas[] celda) {
        this.celda = celda;
    }

    public Paredes[] getPared() {
        return pared;
    }

    public void setPared(Paredes[] pared) {
        this.pared = pared;
    }

    /**
     * El metodo "listaCeldas"sera el encargado de crear cada objeto Celda y
     * almacenarlo en el arreglo "celda".
     */
    private void listaCeldas() {
        //Posicion en el eje X.
        this.x = x;
        //Posicion en el eje Y.
        this.y = y;
        //Indice que se utilizara en el arreglo "celda".
        this.i = i;
        i = 0;

        for (y = 0; y < fila; y++) {
            for (x = 0; x < columna; x++) {
                /**
                 * Creo un objeto tipo Celdas en el array "celda", indice ´i´ y
                 * le asigno valores correspondientes a los parametro. X, Y
                 * seran sus cordenadas en el tablero, visitado y enPila, seran
                 * falsos, ya que aun no han sido visitados y no estan en pila.
                 */
                celda[i] = new Celdas(x, y, false, false);
                /**
                 * Incremento ´i´ en uno al final del bucle, para que en la
                 * siguiente pasada, tome el siguiente indice.
                 */
                i++;

            }

        }
    }

    private void listaParedes() {
        this.x = x;
        this.y = y;
        this.i = i;
        i = 0;

        for (y = 0; y < fila; y++) {
            for (x = 0; x < columna; x++) {
                //Si la celda de la derecha existe...
                if (x < columna - 1) {
                    //...creo una pared vertical entre celdas horizontales.
                    pared[i] = new Paredes(y * columna + x, y * columna + x + 1, false);

                    i++;
                }
                //si la celda de abajo existe...
                if (y < fila - 1) {
                    //...creo una pared horizontal entre celdas verticales.
                    pared[i] = new Paredes(y * columna + x, y * columna + x + columna, false);

                    i++;
                }

            }

        }
    }

    public void eliminaParedes() {
        //Contador de celdas que se encuentran en stack.
        int celdasEnPila = 0;
        //Stack de celdas
        Stack<Integer> pila = new Stack<Integer>();
        //Contador de celdas no visitadas aún.
        int celdasNoVisitadas = celda.length;
        //Hago que la celda inicial sea la actual...
        int celdaActual = 0;
        int celdaSiguiente;
        int indicePared;
        //...y la marco como visitada.
        celda[celdaActual].setVisitada(true);
        //Decremento celdasNoVisitadas en uno, ya que ya he visitado una celda.
        --celdasNoVisitadas;

        //Mientras haya celdas sin visitar.
        while (celdasNoVisitadas > 0) {
            //Elijo un vecino de la celda actual al azar.
            celdaSiguiente = eligeVecino(celdaActual);
            //Si la celda actual tiene vecinos sin visitar.
            if (celdaSiguiente != -1) {
                //Agrego la celda actual a la pila.
                celda[celdaActual].setEnPila(true);
                pila.push(celdaActual);
                //celdasEnPila++;
                //Busco la pared entre la celda actual y la siguiente...
                indicePared = buscaParedEntre(celdaActual, celdaSiguiente);
                if (indicePared != -1) {
                    //...y la elimino.
                    pared[indicePared].setEliminada(true);
                }
                //Hago de la celda siguiente, la actual,...
                celdaActual = celdaSiguiente;
                //...la marco como visitada...
                celda[celdaActual].setVisitada(true);
                //...y decremento la cantidad de celdas sin visitar.
                --celdasNoVisitadas;
                //Si la pila de celdas no esta vacía...
            } else if (!pila.empty()) {
                //...saco una celda de la pila...
                for (int i = 0; i < pila.size(); i++) {

                    if (celda[pila.peek()].isEnPila()) {
                        //...y la marco como celda actual.
                        celdaActual = pila.pop();
                        celda[celdaActual].setEnPila(false);
                        //--celdasEnPila;
                        break;
                    }

                }
            }

        }
    }

    private int eligeVecino(int celdaActual) {
        int x = celda[celdaActual].getX();
        int y = celda[celdaActual].getY();
        Integer[] vecino = new Integer[4];
        int vecinoNoVisitado = 0;

        //Izquierda.
        if (x > 0 && !celda[celdaActual - 1].isVisitada()) {
            vecino[vecinoNoVisitado++] = celdaActual - 1;
        }
        //Derecha.
        if (x < columna - 1 && !celda[celdaActual + 1].isVisitada()) {
            vecino[vecinoNoVisitado++] = celdaActual + 1;
        }
        //Arriba.
        if (y > 0 && !celda[celdaActual - columna].isVisitada()) {
            vecino[vecinoNoVisitado++] = celdaActual - columna;
        }
        //Abajo.
        if (y < fila - 1 && !celda[celdaActual + columna].isVisitada()) {
            vecino[vecinoNoVisitado++] = celdaActual + columna;
        }
        //Si no hay ningun vecino sin visitar...
        if (vecinoNoVisitado == 0) {
            //...devuelve -1.
            return -1;

        } else {
            do {
                Collections.shuffle(Arrays.asList(vecino));

            } while (vecino[0] == null);
            return vecino[0];
        }

    }

    private int buscaParedEntre(int celdaActual, int celdaSiguiente) {
        for (int i = 0; i < pared.length; i++) {
            if (pared[i].getCeldaA() == celdaActual || pared[i].getCeldaA() == celdaSiguiente) {
                if (pared[i].getCeldaB() == celdaActual || pared[i].getCeldaB() == celdaSiguiente) {
                    return i;
                }

            }

        }
        return -1;
    }

    //  public void agregaLineas() {
    //    int anc = 800 / columna;
    //  int alt = 800 / fila;
    //for (int i = 0; i < pared.length; i++) {
    //  if (pared[i].isEliminada() == false) {
    //    Linea l = new Linea(x, x, y, y);
    //  lineas.add(new Linea((celda[pared[i].getCeldaA()].getX() * anc), (celda[pared[i].getCeldaA()].getY() * alt), ((celda[pared[i].getCeldaB()].getX()) * anc), (celda[pared[i].getCeldaB()].getY() * alt)));
    //}
    //}
    //}
}

//class Linea {
//  int x1;
//int x2;
//int y1;
//int y2;
//public Linea(int x1, int x2, int y1, int y2) {
//  this.x1 = x1;
//this.x2 = x2;
// this.y1 = y1;
//this.y2 = y2;
//}

//}
