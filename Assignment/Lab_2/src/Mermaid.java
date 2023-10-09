public class Mermaid implements Animals{
    String specieName;
    int hands;
    int tail;
    public Mermaid() {
        this.specieName = "Mermaid";
        this.hands = 2;
        this.tail = 1;
    }

    @Override
    public String getInfor() {
        return String.format(
                "Species: %s, have %d hands and %d tail",
                specieName,
                hands,
                tail
        );
    }

    @Override
    public void action() {
        System.err.printf("Action of %s: swim.\n", specieName);
    }
}
