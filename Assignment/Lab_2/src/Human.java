public class Human implements Animals {
    String specieName;
    int hands;
    int feet;
    public Human() {
        this.specieName = "Human";
        this.hands = 2;
        this.feet = 2;
    }
    // vis duj
    @Override
    public String getInfor() {
        return String.format(
                "Species: %s, have %d hands and %d feet",
                specieName,
                hands,
                feet
        );
    }

    @Override
    public void action() {
        System.err.printf("Action of %s: run, walk, hold, jump,...\n", specieName);
    }
}
