import java.util.Scanner;

public class Solution {
    private int numerator;
    private int denominator;

    // ĐỀ BÀI YÊU CẦU MẪU SỐ MẶC ĐỊNH KHI KHỞI TẠO LÀ 1
    // HÀM KHỞI TẠO CHƯA THỰC SỰ CHẠY ĐÚNG VỚI YÊU CẦU ĐỀ BÀI

    public Solution() { // NẾU KHỞI TẠO KHÔNG THAM SỐ, MẪU SỐ MỚI ĐƯỢC GÁN BẰNG 1
        this.denominator = 1;
    }

    public Solution(int numerator, int denominator) { // NẾU KHỞI TẠO CÓ THAM SỐ, MẪU KHÔNG ĐƯỢC GÁN BẰNG 1 TRONG TRƯỜNG HỢP KHÔNG HỢP LỆ
        this.numerator = numerator;
        setDenominator(denominator);
    }

    /* Idea:

    public Solution(int numerator, int denominator) {
        this.numberator = numerator;
        this.denominator = 1;
        setDenominator(denominator);
    }

    */

    

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public Solution reduce() {
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
        return this;
    }

    public Solution add(Solution fraction) {
        int num = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    public Solution subtract(Solution fraction) {
        int num = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    public Solution multiply(Solution fraction) {
        int num = this.numerator * fraction.numerator;
        int den = this.denominator * fraction.denominator;
        return new Solution(num, den).reduce();
    }

    public Solution divide(Solution fraction) { // CHƯA KIỂM TRA TÍNH HỢP LỆ CỦA PHÉP CHIA
        int num = this.numerator * fraction.denominator;
        int den = this.denominator * fraction.numerator;
        return new Solution(num, den).reduce();
    }

   public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            return this.numerator * other.denominator == this.denominator * other.numerator;
        }
        return false;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) { // NẾU MẪU SỐ BẰNG 0 THÌ KHÔNG LÀM GÌ CẢ, CHỨ KHÔNG PHẢI GÁN BẰNG 1
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }
}
