import java.util.Scanner;

public class Game {
    public static Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.println("Lütfen isminizi giriniz : ");
        String name = scan.nextLine();
        Player player = new Player(name);
        System.out.println("Harikasın " + player.getName() + "Bu eğlenceli macera oyununa  Hogeldin");
        player.selectChar();
        Location location = null;
        while (true) {

            System.out.println("=================== Bolgeler ====================== ");
            System.out.println(" ");
            System.out.println("1- Güvenli Bölge --> Burası sizin için güvenli bir ev ,  düşman yok.");
            System.out.println("2- Eşya Dükyanı ---> Silah veya Zırh satın alabilirsin ");
            System.out.println("3 - Mağara --> Ödül<yemek>  Dikkatli ol ZOMBİ çıkabilir! ");
            System.out.println("4 - Orman --> Ödül<Odun>, Dikkatli ol Vampir çıkabilir. ");
            System.out.println("5 - Nehir --> Ödül<Su> Dikkatli ol karşına ayı çıkabilir");
            System.out.println("0 - Çıkış Yap - Oyunu sonlandır");
            System.out.println("Lütfen girmek istediğiniz bölgeyi seçiniz. ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player, name);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz.");

            }
            System.out.println("=============================================");
            if (location == null) {
                System.out.println("Oyun bitti yine bekleriz. ");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER");
                break;
            }
        }


    }
}
