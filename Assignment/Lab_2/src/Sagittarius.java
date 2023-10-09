public class Sagittarius implements Animals {
    String specieName;
    int hands;
    int feet;
    int tail;
    public Sagittarius() {
        this.specieName = "Sagittarius";
        this.hands = 2;
        this.feet = 4;
        this.tail = 1;
    }

    @Override
    public String getInfor() {
        return String.format(
                "Species: %s, have %d hands, %d feet and %d tail",
                specieName,
                hands,
                feet,
                tail
        );
    }

    @Override
    public void action() {
        System.err.printf("Action of %s: run, hold, fly,...\n", specieName);
    }
}
