import java.util.Scanner;

class Dia extends Document {
    private String diaId;
    private double dungLuong;
    private String loaiDia;

    public Dia(){
        super();
        this.dungLuong = 0;
        this.diaId = this.loaiDia = "";
    }

    public Dia(String id, String name, String maSoKe, int namxuatban, int soluong, String tacgia, String type,
            String tinhTrangTL, String diaId, double dungLuong, String loaiDia) {
        super(id, name, maSoKe, namxuatban, soluong, tacgia, type, tinhTrangTL);
        this.diaId = diaId;
        this.dungLuong = dungLuong;
        this.loaiDia = loaiDia;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so dia: ");
        this.diaId = sc.nextLine();
        System.out.print("Nhap dung luong cua dia: ");
        this.dungLuong = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap loai dia (DVD, CD,...): ");
        this.loaiDia = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.print("Ma so Dia: " + diaId + "  ");
        System.out.print("Dung luong: " + dungLuong + " GB"+ "  ");
        System.out.println("Loai dia: "+ loaiDia);
    }

    public String getDiaId() {
        return diaId;
    }

    public void setDiaId(String diaId) {
        this.diaId = diaId;
    }

    public double getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(double dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getLoaiDia() {
        return loaiDia;
    }

    public void setLoaiDia(String loaiDia) {
        this.loaiDia = loaiDia;
    }

    @Override
    public String toString() {
        return super.toString() + "Ma so Dia: " + getDiaId() + "Dung luong: " + getDungLuong() + ", loai dia: " + getLoaiDia();
    }
}