package lot.entity;

public class Lot {
    // 期数
    private int term;
    // 前区01
    private int f01;
    private int f02;
    private int f03;
    private int f04;
    private int f05;
    // 后区01
    private int e01;
    private int e02;
    
    private String total;

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getF01() {
        return f01;
    }

    public void setF01(int f01) {
        this.f01 = f01;
    }

    public int getF02() {
        return f02;
    }

    public void setF02(int f02) {
        this.f02 = f02;
    }

    public int getF03() {
        return f03;
    }

    public void setF03(int f03) {
        this.f03 = f03;
    }

    public int getF04() {
        return f04;
    }

    public void setF04(int f04) {
        this.f04 = f04;
    }

    public int getF05() {
        return f05;
    }

    public void setF05(int f05) {
        this.f05 = f05;
    }
    
    public int getE(int index) {
        return index == 1 ? e01 : e02;
    }
    
    public int getF(int index) {
        if (index == 1) {
            return f01;
        }
        if (index == 2) {
            return f02;
        }
        if (index == 3) {
            return f03;
        }
        if (index == 4) {
            return f04;
        }
        return f05;
    }


    public int getE01() {
        return e01;
    }

    public void setE01(int e01) {
        this.e01 = e01;
    }

    public int getE02() {
        return e02;
    }

    public void setE02(int e02) {
        this.e02 = e02;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    public boolean e01InF() {
        return getE01() == getF01() || getE01() == getF02() || getE01() == getF03() || getE01() == getF04()
                || getE01() == getF05();
    }

    public boolean e02InF() {
        return getE02() == getF01() || getE02() == getF02() || getE02() == getF03() || getE02() == getF04()
                || getE02() == getF05();
    }

    public boolean eInF() {
        return e01InF() || e02InF();
    }

    @Override
    public String toString() {
        return this.term +" " + this.total;
    }
}
