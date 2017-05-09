/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorlaberinto;

public class Paredes {

    //Primer celda.
    private int celdaA;
    //Segunda celda, adyacente a la primera, pero del otro lado de la supuesta pared.
    private int celdaB;
    //Condicion que indica si la pared ha sido eliminada o no.
    private boolean eliminada;

    public Paredes() {
    }

    public Paredes(int celdaA, int celdaB, boolean eliminada) {
        this.celdaA = celdaA;
        this.celdaB = celdaB;
        this.eliminada = eliminada;
    }

    /**
     * Get the value of eliminada
     *
     * @return the value of eliminada
     */
    public boolean isEliminada() {
        return eliminada;
    }

    /**
     * Set the value of eliminada
     *
     * @param eliminada new value of eliminada
     */
    public void setEliminada(boolean eliminada) {
        this.eliminada = eliminada;
    }

    /**
     * Get the value of celdaB
     *
     * @return the value of celdaB
     */
    public int getCeldaB() {
        return celdaB;
    }

    /**
     * Set the value of celdaB
     *
     * @param celdaB new value of celdaB
     */
    public void setCeldaB(int celdaB) {
        this.celdaB = celdaB;
    }

    /**
     * Get the value of celdaA
     *
     * @return the value of celdaA
     */
    public int getCeldaA() {
        return celdaA;
    }

    /**
     * Set the value of celdaA
     *
     * @param celdaA new value of celdaA
     */
    public void setCeldaA(int celdaA) {
        this.celdaA = celdaA;
    }

}
