public class ToolStore extends NormalLoc {
    public ToolStore(Player player, String name) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Mağazaya hoşgeldiniz. ");
            System.out.println("Yapmak istediğiniz işlemler. ");
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış yapınız");
            System.out.print("Seçiminiz ");
            int selectTool = Location.input.nextInt();
            while (selectTool < 1 || selectTool > 3) {
                System.out.println("yanlış seçim yaptınız. ");
                selectTool = input.nextInt();
            }
            switch (selectTool) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmon();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz. ");
                    showMenu = false;
                    break;
            }

        }
        return true;

    }

    public void printWeapon() {
        System.out.println("Silahlar geldi");
        for (Weapon weapons : Weapon.weapons()) {
            System.out.println(weapons.getId() + " - " +
                    weapons.getName() +
                    " < Para: " + weapons.getPrice() +
                    " Hasar: " + weapons.getDamage() + " >");
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyWeapon() {
        System.out.println("Bir silah seçiniz. ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("yanlış seçim yaptınız. ");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    //satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız. ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki silahınız :" + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni silahınız :" + this.getPlayer().getInventory().getWeapon().getName());
                }

            }

        }
    }


    public void printArmon() {
        System.out.println("Zırhlar geldi");
        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - "
                    + armor.getName() +
                    " Para: " + armor.getPrice() +
                    " Zırh: " + armor.getBlock());
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("yanlış seçim yaptınız. ");
            selectArmorId = input.nextInt();
        }
        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                } else {
                    //satın almanın gerçekleştiği alan
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız. ");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki zırhınız : " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni zırhınız :" + this.getPlayer().getInventory().getWeapon().getName());
                }
            }

        }

    }


}
