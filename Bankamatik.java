import java.util.Scanner;

public class Bankamatik {
    public static void main(String[] args) {
        String userName, password;
        Scanner input = new Scanner(System.in);
        int maxAttempts = 3;
        int balance = 1500;
        int select;

        // Burada kullanıcının doğru giriş yapması durumunda while döngüsünden çıkılmasını kontrol ediyoruz.
        boolean isLogged = false;

        while (maxAttempts > 0 && !isLogged) {
            System.out.println("Merhaba 101 Bankasına Hoş Geldiniz\n");

            System.out.print("Kullanıcı Adınızı Giriniz: ");
            userName = input.nextLine();

            System.out.print("Parolanızı Giriniz: ");
            password = input.nextLine();

            isLogged = userName.equals("Emre Bas") && password.equals("emre123");

            if (isLogged) {
                while (true) {
                    System.out.println("1- Para Yatırma\n" + "2- Para Çekme\n" + "3- Bakiye Sorgulama \n" + "4- Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");

                    select = input.nextInt();
                    input.nextLine();

                    switch (select) {
                        case 1:
                            System.out.print("Lütfen yatırmak istediğiniz para miktarını giriniz: ");
                            int depositAmount = input.nextInt();
                            balance += depositAmount;
                            System.out.println(depositAmount + " TL bakiyenize eklenmiştir.");
                            break;

                        case 2:
                            System.out.print("Lütfen çekmek istediğiniz para miktarını giriniz: ");
                            int withdrawAmount = input.nextInt();

                            if (withdrawAmount <= balance) {
                                balance -= withdrawAmount;
                                System.out.println(withdrawAmount + " TL tutarında para çekme işleminiz başarıyla gerçekleşmiştir.");
                            } else {
                                System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
                            }
                            break;

                        case 3:
                            System.out.println("Bakiyeniz: " + balance + " TL");
                            break;

                        case 4:
                            System.out.println("Güle güle. Bankamızı tercih ettiğiniz için teşekkür ederiz.");
                            return; // İşlem seçildikten sonra kodun çalışmasını durdurur.

                        default:
                            System.out.println("Geçersiz bir seçenek girdiniz.");
                            break;
                    }
                }
            } else {
                maxAttempts--;
                if (maxAttempts == 0) {
                    System.out.println("Hesabınız bloke olmuştur. Lütfen bankanız ile iletişime geçiniz.");
                    break; // Hesap bloke olduktan sonra döngüden çıkılır
                } else {
                    System.out.println("Hatalı kullanıcı adı veya şifre girdiniz. Kalan hakkınız: " + maxAttempts);
                }
            }
        }
    }
}
