public class Circulo {
    private double x;
    private double y;
    private double raio;
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.raio = 0;
    }

    public Circulo(double x, double y, double raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public Circulo(Circulo other){
        this.x = other.x;
        this.y = other.y;
        this.raio = other.raio;
    }

    public double getX() {
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getRaio() {
        return this.raio;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public Circulo cloneC(){
       return new Circulo(this);
    }

    public boolean equalsC(Object o){
        if(o == this) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Circulo other = (Circulo) o;
        return (this.x == other.x && this.y == other.y);
    }


    public String toString() {
       return "(" + this.x + "," + this.y + ")" + "\n" + " Com raio: " + this.raio;
    }

    public void alteraCentro(double newX, double newY){
        this.x = newX;
        this.y = newY;
   }

   public double areaCirculo(double radius){
        this.raio = radius;
        return Math.PI * this.raio;
   }

   public double calculaPerimetro(double radius){
        this.raio = radius;
        return 2 * Math.PI * this.raio;
   }






}
