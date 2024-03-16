import java.util.Scanner;

public class Player {
    private String name; //ismi
    private int damage; //hasar
    private int healthy; //sağlık
    private int orginalHealth;
    private int money;   //para
    private Inventory inventory;
    Scanner input = new Scanner(System.in);

    public Player(String name) { //oyuncudan aldığımız name e eşitledik
        this.name = name;
        this.inventory = new Inventory(); //içi boş inventory
    }

    Characters[] characterList = {new Samurai(), new Archer(), new Knight()};

    public void selectChar() {

        System.out.println("=========================================");
        System.out.println("Karakterler ");
        System.out.println("=========================================");

        for (Characters character : characterList) {
            System.out.println("Karakter Id : " + character.getId() +
                    " Karakter ismi : " + character.getName() +
                    " Hasar: " + character.getDamage() +
                    " Sağlık: " + character.getHealthy() +
                    " Para : " + character.getMoney());
        }
        System.out.println("ilk önce Karakter seçmelisin ");
        int selectChars = input.nextInt();
        switch (selectChars) {
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter :" + this.getName() +
                " Hasar: " + this.getDamage() +
                "Sağlık: " + this.getHealthy() +
                "Para: " + this.getMoney());

    }

    public void printInfo() {
        System.out.println(
                "Silahınız " + this.getInventory().getWeapon().getName() +
                        " Zırhınız " + this.getInventory().getArmor().getName() +
                        " Bloklama  " + this.getInventory().getArmor().getBlock() +
                        " Karakter :" + this.getName() +
                        " Hasar: " + this.getTotalDamage() +
                        " Sağlık: " + this.getHealthy() +
                        " Para: " + this.getMoney());
    }


    public void initPlayer(Characters characters) {
        this.setDamage(characters.getDamage());
        this.setHealthy(characters.getHealthy());
        this.setOrginalHealth(characters.getHealthy());
        this.setMoney(characters.getMoney());
        this.setName(characters.getName());
    }

    public int getTotalDamage() {
        return damage + getInventory().getWeapon().getDamage();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}
