import java.util.Scanner;

public class Magazine extends Document {
    private int soPhatHanh;
    private int thangPhatHanh;
    private String ngonNgu;

    public Magazine(){
        super();
        this.soPhatHanh = this.thangPhatHanh= 0;
        this.ngonNgu = "";
    }
    public Magazine(String id, String name, String maSoKe, int namxuatban, int soluong, String tacgia, String type,
            String tinhTrangTL, int soPhatHanh, int thangPhatHanh, String ngonNgu) {
        super(id, name, maSoKe, namxuatban, soluong, tacgia, type, tinhTrangTL);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
        this.ngonNgu = ngonNgu;
    }

    @Override
    public void nhap(){
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phat hanh cua tap chi: ");
        this.soPhatHanh = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhap thang phat hanh cua tap chi: ");
        this.thangPhatHanh = sc.nextInt();
        System.out.print("Nhap ngon ngu cua tap chi: ");
        this.ngonNgu = sc.nextLine();
    }
    @Override
    public void xuat(){
        super.xuat();
        System.out.print("So phat hanh: "+ soPhatHanh + "  ");
        System.out.print("Thang phat hanh: "+ thangPhatHanh +"  ");
        System.out.println("Ngon ngu: "+ngonNgu);
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }
    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }
    public int getThangPhatHanh() {
        return thangPhatHanh;
    }
    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }
    public String getNgonNgu() {
        return ngonNgu;
    }
    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }
    @Override
    public String toString() {
        return super.toString() +"So phat hanh: " + getSoPhatHanh() + ", Thang phat hanh: " + getThangPhatHanh()
                + ", Ngon ngu: " + getNgonNgu();
    }
}
