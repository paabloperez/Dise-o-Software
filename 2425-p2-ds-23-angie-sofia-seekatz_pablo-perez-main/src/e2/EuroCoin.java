package e2;

import java.util.Objects;

public record EuroCoin(EuroValue euroValue, ColorType colorType, EuroCountryType euroCountryType, String design, int year) implements Comparable<EuroCoin> {

    public boolean isEuroNull () {
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
                "Value :" + euroValue.getValue() + "\n" +
                colorType + "\n" +
                euroCountryType + "\n" +
                design + "\n" +
                year + "\n" ;
    }

    @Override
    public int compareTo(EuroCoin o) {
            int valorComparison = this.euroValue.compareTo(o.euroValue);  //dudo que este bien
            int countryComparison = this.euroCountryType.compareTo(o.euroCountryType);
            int designComparison = this.design.compareTo(o.design);

            if (valorComparison != 0) {                   //replantear con menos branch
                return valorComparison;
                } else if (countryComparison != 0) {
                                return countryComparison;
                            } else if (designComparison != 0) {
                                            return designComparison;
                                    } else return 0;
                        }

        }

