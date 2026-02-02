package e3;

import java.util.Objects;

public record Property(PropertyType tipoPropiedad, String catastro, String direccion, String codigoPostal, int metros, int habitaciones, int banhos) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property property)) return false;
        return Objects.equals(catastro, property.catastro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(catastro);
    }

    @Override
    public String toString() {
        return   tipoPropiedad + "\n" +
                 catastro + "\n" +
                 direccion + "\n" +
                 codigoPostal + "\n" +
                 metros + " meters, " + habitaciones + " rooms, " + banhos + " bathrooms\n";
    }




}
