public class Cho implements DongVat, VatNuoiTrongNha {
    private String name;
    private double height;
    private double weight;

    public Cho(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String getInfor() {
        return String.format(
                "Dog name: %s, height: %f, weight: %f",
                name, height, weight
                );
    }

    @Override
    public void move() {
        System.err.println("Run");
    }

    @Override
    public void makeNoise() {
        System.err.println("Sủa");
    }

}
