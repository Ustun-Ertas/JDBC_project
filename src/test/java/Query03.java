import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3305/batch59?serverTimezone=UTC", "root", "1234");

        Statement st = con.createStatement();

        ResultSet veri = st.executeQuery("select * from bolumler ");

       // while(veri.next()){

         //   System.out.printf("%-6d %-15.15s %-8s\n", veri.getInt(1),
       //             veri.getString(2), veri.getString(3));
       // }


        // SORU2:SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını,
        // maaş ters sıralı listeleyiniz.

        System.out.println("==========================================================================");

        ResultSet veri2 = st.executeQuery("select personel_isim, maas from personel " +
                "where bolum_id in(10,30) " +
                "order by maas desc;");

        while (veri2.next()){
            System.out.printf("%-15.15s %-6d\n",
                    veri2.getString(1),
                    veri2.getInt(2));
        }

        // Soru3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,
        // bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.

        System.out.println("==========================================================================");

        ResultSet veri3 = st.executeQuery("select bolum_isim, personel_isim, maas\n" +
                "from bolumler as B left join personel as p\n" +
                "on B.bolum_id = P.bolum_id\n" +
                "order by bolum_isim desc, P.maas;");

        System.out.printf("%-10s %-10s %6d\n",veri2.getString(1),
                veri2.getString(2),veri2.getInt(3));


        System.out.println("==========================================================================");

        // SORU4: Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz.


        ResultSet veri4 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas from bolumler " +
                "b left join personel p on b.bolum_id=p.bolum_id order by maas desc limit 10");

        while (veri.next()){
            System.out.printf("%-15.15s %-15.15s %-8s", veri.getString(1),
                    veri.getString(2), veri.getInt(3));
        }



    }
}


