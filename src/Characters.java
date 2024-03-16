public abstract class Characters {
    private int Id;
    public int damage; //hasar
    private int healthy; //sağlık
    private int money;   //para
    private String name;

    public Characters(int Id, String name, int damage, int healthy, int money) {
        this.Id = Id;
        this.damage = damage;
        this.healthy = healthy;
        this.money = money;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
