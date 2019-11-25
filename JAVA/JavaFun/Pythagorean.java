public class Pythagorean{
    public double calculateHypotenuse(int legA, int legB){
        int sumLeg = legA * legA + legB * legB;
        double legC = (double)Math.sqrt(sumLeg);
        return legC;
    }
}