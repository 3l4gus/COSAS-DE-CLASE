public class Bombilla {
    private boolean interruptorHab;
    public static boolean interruptorGeneral;

    public Bombilla(boolean interruptorHab){
        this.interruptorHab = interruptorHab;
    }

    public boolean isInterruptorHab() {
        return interruptorHab;
    }
}
