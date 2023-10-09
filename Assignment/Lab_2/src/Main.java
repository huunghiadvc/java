public class Main {
    public static void main(String[] args) {

        Animals human = new Human();
        System.err.println(human.getInfor());
        human.action();

        Animals mermaid = new Mermaid();
        System.err.println(mermaid.getInfor());
        mermaid.action();

        Animals horse = new Horse();
        System.err.println(human.getInfor());
        horse.action();

        Animals sagittarius = new Sagittarius();
        System.err.println(sagittarius.getInfor());
        sagittarius.action();

    }
}