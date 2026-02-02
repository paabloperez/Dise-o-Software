package e3;

public enum EuroCountryType {
    Andorra ("AD"), Austria ("AT"), Belgium ("BE"), Cyprus ("CY"), Croatia ("HR"), Estonia ("EE"),
    Finland ("FI"), France ("FR"), Germany ("DE"), Greece ("GR"), Ireland ("IE"), Italy ("IT"),
    Latvia ("LV"), Lithuania ("LT"), Luxembourg ("LU"), Malta ("MT"), Monaco ("MC"), Netherlands ("NL"),
    Portugal ("PT"), SanMarino ("SM"), Slovakia ("SK"), Slovenia ("SI"), Spain ("ES"),  VaticanCity ("VA");
    private String ISO;
    EuroCountryType(String ISO) {
        this.ISO = ISO;
    }

    public String getISO() {
        return ISO;
    }

}
