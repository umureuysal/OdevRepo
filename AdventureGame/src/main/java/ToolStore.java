public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz!");
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış Yap");
        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Lütfen geçerli bir değer giriniz! ");
            selectCase = input.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            case 3:
                System.out.println("Tekrar bekleriz!");
                return true;
        }
        return true;
    }

    public void printWeapons() {
        System.out.println("Silahlar");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " fiyat: " + weapon.getCost() + " hasar: " + weapon.getDamage());
        }
        System.out.print("Bir silah seçiniz: ");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.print("Geçersiz değer, tekrar giriniz: ");
            selectWeapon = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponbyId(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getCost() > this.getPlayer().getMoney()) {
                System.out.println("Yeterli bakiyeniz bulunmamaktadır!");
            } else {
                int removed = this.getPlayer().getMoney() - selectedWeapon.getCost();
                this.getPlayer().setMoney(removed);
                System.out.println(selectedWeapon.getName() + " satın alındı! Kalan paranız: " + this.getPlayer().getMoney());
            }
        }
    }


    public void printArmors() {
        System.out.println("Zırhlar");
    }
}
