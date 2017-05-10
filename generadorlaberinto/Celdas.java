
package generadorlaberinto;

public class Celdas {

    //Indicara la posicion en el eje x de la celda.
    private int x;
    //Indicara la posicion en el eje y de la celda.
    private int y;
    //Indicara la condicion de la celda, si ya ha sido visitada o no.
    private boolean visitada;
    //Indicara la condiciond de la celda, si se encuentra en pila o no.
    private boolean enPila;

    public Celdas() {
    }

    public Celdas(int x, int y, boolean visitada, boolean enPila) {
        this.x = x;
        this.y = y;
        this.visitada = visitada;
        this.enPila = enPila;
    }

    /**
     * Get the value of enPila
     *
     * @return the value of enPila
     */
    public boolean isEnPila() {
        return enPila;
    }

    /**
     * Set the value of enPila
     *
     * @param enPila new value of enPila
     */
    public void setEnPila(boolean enPila) {
        this.enPila = enPila;
    }

    /**
     * Get the value of visitada
     *
     * @return the value of visitada
     */
    public boolean isVisitada() {
        return visitada;
    }

    /**
     * Set the value of visitada
     *
     * @param visitada new value of visitada
     */
    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    /**
     * Get the value of y
     *
     * @return the value of y
     */
    public int getY() {
        return y;
    }

    /**
     * Set the value of y
     *
     * @param y new value of y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public int getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(int x) {
        this.x = x;
    }

}
