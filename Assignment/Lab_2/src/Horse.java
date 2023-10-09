public class Horse implements Animals {
    String specieName;
    int feet;
    int tail;
    public Horse() {
        this.specieName = "Horse";
        this.feet = 4;
        this.tail = 1;
    }

    @Override
    public String getInfor() {
        return String.format(
                "Species: %s, have %d feet and %d tail",
                specieName,
                feet,
                tail
        );
    }

    @Override
    public void action() {
        System.err.printf("Action of %s: run,...\n", specieName);
    }
}
