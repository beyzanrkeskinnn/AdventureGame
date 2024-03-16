public class SafeHouse extends NormalLoc {

    SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        this.player.setHealthy((player.getOrginalHealth()));
        System.out.println("Güvenli evdesiniz canınız yenilendi.");
        this.getPlayer().setHealthy(this.getPlayer().getOrginalHealth());
        return true;
    }
    public boolean finish(){
        if (this.getPlayer().getInventory().isFood() && this.getPlayer().getInventory().isWater() && this.getPlayer().getInventory().isFirewood()){
            System.out.println("Tebrikler oyunu bitirdiniz.");
            return true;
        }
        return false;
    }
}
