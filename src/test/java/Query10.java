public class Query10 extends DatabaseUtilty {

    public static void main(String[] args) {

        createConnection();

        String query ="select * from ogrenciler";
        getColumnNames(query);

        System.out.println("Sutun isimleri: " + getColumnNames(query));

        System.out.println("Okul No " + getColumnData(query, "okul_no"));
        System.out.println("Ogrenci ismi " + getColumnData(query, "ogrenci_ismi"));
        System.out.println("sinif " + getColumnData(query, "sinif"));
        System.out.println("Cinsiyet " + getColumnData(query, "cinsiyet"));
    }
}
