package lab2_TH_B2;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
public class Account {
  public double sotien;
  public int sotk;
  public String tentk;
  public String trangthai;
  static Scanner sc = new Scanner (System.in);
  Locale local = new 	Locale("vi","vn");
	public Account() {
		
	}
	public Account(double sotien, int sotk, String tentk, String trangthai) {
		super();
		this.sotien = sotien;
		this.sotk = sotk;
		this.tentk = tentk;
		this.trangthai = trangthai;
	}
	public double getSotien() {
		return sotien;
	}
	public void setSotien(double sotien) {
		if( sotien >= 50)
		this.sotien = sotien;
	}
	public int getSotk() {
		return sotk;
	}
	public void setSotk(int sotk) {
		if(sotk>0)
		this.sotk = sotk;
	}
	public String getTentk() {
		return tentk;
	}
	public void setTentk(String tentk) {
		if(tentk != null)
		this.tentk = tentk;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	@Override
	public String toString() {
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
        String trangthai = formatter.format(sotien);
		return "Account [sotien=" + sotien + ", sotk=" + sotk + ", tentk=" + tentk + ", trangthai=" + trangthai + "]";
	}
	//khởi tạo phương thức nạp tiền
    public double napTien() {
        double nap;
        System.out.print("Nhập số tiền bạn cần nạp: ");
        nap = sc.nextDouble();
        //nếu số tiền nạp vào lớn hơn 0 thì hợp lệ
        if (nap >= 0) {
            sotien = nap + sotien;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String trangthai = currencyEN.format(nap);
            System.out.println("bạn vừa nạp " + trangthai + " vào tài khoản.");
        } else {//ngược lại nếu số tiền nộp vào bé hơn 0 thì không hợp lệ
            System.out.println("Số tiền nạp vào không hợp lệ!");
        }
        return nap;
    }
 
    //khởi tạo phương thức rút tiền
    public double rutTien() {
        double phi = 5;
        double rut;
        System.out.print("Nhập số tiền bạn cần rút: ");
        rut = sc.nextDouble();
        //nếu số tiền rút bé hơn hoặc bằng số tiền còn trong tài khoản + phí thì hợp lệ
        if (rut <= (sotien - phi)) {
            sotien = sotien - (rut + phi);
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance(local);
            String trangthai = currencyEN.format(rut);
            System.out.println("Bạn vừa rút " + trangthai + "Đ từ tài khoản. Phí là $5.");
        } else {//ngược lại nếu số tiền rút lớn hơn số tiền có trong tài khoản thì không hợp lệ
            System.out.println("Số tiền muốn rút không hợp lệ!");
            return rutTien();
        }
        return rut;
    }
    
    //khởi tạo phương thức đáo hạn
    public double daoHan() {
        double laiSuat = 0.035;
        sotien = sotien + sotien * laiSuat;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance(local);
        String trangthai = currencyEN.format(sotien);
        System.out.println("Bạn vừa được " + trangthai + " từ đáo hạn 1 tháng");
        return sotien;
    }
    // tạo hàm tạo tài khoản và in tài khoản
   
void intk() {
	   NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
       String trangthai = currencyEN.format(sotien);
       System.out.printf("%-10d %-20s %-20s \n", sotk, tentk, trangthai);  
   }
    }
	
