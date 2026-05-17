public class LampadaLed extends Lampada{

    private double intensidade;
    private int lumen;

    @Override
    public double calculaConsumo() {
        if (getEstados().equals(Estado.ECO)){
            return getConsumo() / 1.25;
        } else if (getEstados().equals(Estado.ON)){
            return getConsumo(); // ta mal
        } else
            return 0;
    }

    public LampadaLed clone() {
        return new LampadaLed();
    }
}
