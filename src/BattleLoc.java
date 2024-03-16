import java.sql.SQLOutput;
import java.util.Random;

public class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award; //ödül
    private int maxObstacle; //maxCanavar

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şu an buradasınız " + this.getName());
        System.out.println("Dikkatli Ol!  burada " + obsNumber + " tane " + this.getObstacle().getName() + "yaşıyor. ");
        System.out.println("<S>avaş veya <K>aç");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + "Tüm düşmanları yendiniz ! ");
            return true;
        }
        if (this.getPlayer().getHealthy() <= 0) {
            System.out.println("Öldünüz ! ");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealthy(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while (this.player.getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
                System.out.println("<V>ur veya <K>aç: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")) {
                    System.out.println("Siz Vurdunuz !");
                    this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealthy() > 0) {
                        System.out.println();
                        System.out.println("Canavar sizi vurdu ! ");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                    }
                } else {
                    return false;
                }
            }
            if (this.getObstacle().getHealthy() < this.getPlayer().getHealthy()) {
                System.out.println("Düşmanı yendiniz !");
                System.out.println(this.getObstacle().getAward() + " para kazandınız ! ");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paranaız : " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + "Canı : " + this.getObstacle().getHealthy());
        System.out.println("--------------------- ");
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("=====================");
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Sağlık: " + this.getPlayer().getHealthy());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para: " + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
        System.out.println("=========================");
        System.out.println("Sağlık : " + this.getObstacle().getHealthy());
        System.out.println("Hasar: " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(3) + 1;

    }
}
