package util;

// srp: so cuida da pausa usada para mostrar as etapas uma de cada vez
public class Pausa {
    public static void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            // se a pausa for interrompida, o programa apenas continua
        }
    }
}
