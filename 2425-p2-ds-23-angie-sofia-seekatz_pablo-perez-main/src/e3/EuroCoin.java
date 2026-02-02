package e3;


import java.util.Objects;

public record EuroCoin(EuroValue euroValue, ColorType colorType, EuroCountryType euroCountryType, String design, int year) {

    public EuroCoin {
    }

    public boolean isEuroNull() {
        return this.euroValue == null;
    }

    @Override
    public EuroValue euroValue() {
        return this.euroValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EuroCoin euroCoin)) return false;
        return Objects.equals(design, euroCoin.design) && euroValue == euroCoin.euroValue && euroCountryType == euroCoin.euroCountryType;
    }


    @Override
    public int hashCode() {
        return Objects.hash(euroValue, euroCountryType, design);
    }

    @Override
    public String toString() {
        return "Coin:\n" +
                euroValue + "-" + euroCountryType.getISO() + "\n" +
                colorType + "\n" +
                design + "\n" +
                year + "\n";
    }

 }
