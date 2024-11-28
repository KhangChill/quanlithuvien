import java.util.Scanner;

public class Document implements NhapXuat {
    private String id;
    private static int dem = 0;
    private String name;
    private String maSoKe;
    private int namxuatban;
    private int soluong;
    private String tacgia;
    private String type;
    private String tinhTrangTL;

    public Document() {
        this.id = "";
        this.name = "";
        this.maSoKe = "";
        this.namxuatban = 0;
        this.soluong = 0;
        this.tacgia = "";
        this.type = "";
        this.tinhTrangTL = "";
    }


    public Document(String id, String name, String maSoKe, int namxuatban, int soluong, String tacgia, String type,
            String tinhTrangTL) {
        this.id = id;
        this.name = name;
        this.maSoKe = maSoKe;
        this.namxuatban = namxuatban;
        this.soluong = soluong;
        this.tacgia = tacgia;
        this.type = type;
        this.tinhTrangTL = tinhTrangTL;
    }

    @Override
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        if (this.id == null || this.id.isEmpty()) {
            dem++;
            this.id = "TL" + String.format("%03d", dem);
        }
        System.out.print("Nhap ten tai lieu: ");
        this.name = sc.nextLine();
        System.out.print("Nhap the loai cua tai lieu: ");
        this.type = sc.nextLine();
        System.out.print("Nhap ma so ke dat tai lieu: ");
        this.maSoKe = sc.nextLine();
        System.out.print("Nhap so luong: ");
        this.soluong = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nhap tinh trang cua sach: ");
        this.tinhTrangTL = sc.nextLine();
        System.out.print("Nhap nam xuat ban cua tai lieu: ");
        this.namxuatban = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Nhap tac gia cua tai lieu: ");
        this.tacgia = sc.nextLine();
    }

    @Override
    public void xuat() {
        System.out.print("ID: " + this.id+"  ");
        System.out.print("Ten tai lieu: " + this.name+"  ");
        System.out.print("The loai tai lieu: " + this.type+"  ");
        System.out.print("Ma so ke: " + this.maSoKe+"  ");
        System.out.print("So luong: " + this.soluong+"  ");
        System.out.print("Tinh trang: " + this.tinhTrangTL+"  ");
        System.out.print("Nam xuat ban: " + this.namxuatban+"  ");
        System.out.print("Tac gia: " + this.tacgia+"  ");
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public static int getDem() {
        return dem;
    }

    public static void setDem(int dem) {
        Document.dem = dem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaSoKe() {
        return maSoKe;
    }

    public void setMaSoKe(String maSoKe) {
        this.maSoKe = maSoKe;
    }

    public int getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(int namxuatban) {
        this.namxuatban = namxuatban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTinhTrangTL() {
        return tinhTrangTL;
    }

    public void setTinhTrangTL(String tinhTrangTL) {
        this.tinhTrangTL = tinhTrangTL;
    }


    @Override
    public String toString() {
        return "ID: " + getId() + ", Ten: " + getName() + ", Ma so ke: " + getMaSoKe()
                + ", Nam xuat ban: " + getNamxuatban() + ", So luong: " + getSoluong() + ", Tac gia: "
                + getTacgia() + ", The loai: " + getType() + ", Tinh trang: " + getTinhTrangTL() + ", ";
    }

    
}