public abstract class NormalLoc extends Location {
    NormalLoc(Player player, String name) {
        super(player, name);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz.");
        return true;
    }
}
