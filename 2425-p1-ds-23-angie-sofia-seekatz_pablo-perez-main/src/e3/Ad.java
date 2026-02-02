package e3;

import java.util.Objects;

public class Ad {
    public String empresa;
    protected Property property;
    public AdType adType;
    public int price;

    public Ad (String empresa, Property property, AdType adType, int price) {
        this.empresa = empresa;
        this.property = property;
        this.adType = adType;
        this.price = price;
    }

    public Ad(Ad a1) {
        this.empresa = a1.empresa;
        this.property = a1.property;
        this.adType = a1.adType;
        this.price = a1.price;
    }

    public int getPriceInEuros() {
        return this.price;
    }

    public boolean isPropertyEqual(Ad ad2) {
        return this.property.equals(ad2.property);
    }

    public boolean isPriceNormal() {
        if (this.adType == AdType.PURCHASE && this.price >= 10000) {
            return true;
        } else return this.adType == AdType.RENTAL && this.price < 10000;
    }

    public float priceMetersEuros () throws ArithmeticException {
        if (this.adType == AdType.PURCHASE && this.price >= 10000) {
            return (float) this.price / this.property.metros();
        } else throw new ArithmeticException();
    }

    public void dropPrice (int percentage) {
        if (percentage>=100||percentage<=0) throw new IllegalArgumentException();
        this.price = this.price - ((this.price*percentage)/100) ;
    }

    @Override
    public String toString() {
        return  empresa + " ofrece:\n"+
                property + "\t\n"+
                adType + "\n"+
                price+" euros";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ad ad)) return false;
        return price == ad.price && Objects.equals(empresa, ad.empresa) && Objects.equals(property, ad.property) && adType == ad.adType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empresa, property, adType, price);
    }
}
