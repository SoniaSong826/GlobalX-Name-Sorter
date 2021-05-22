import java.util.ArrayList;
import java.util.Arrays;

public class Name implements Comparable<Name> {

    private final String familyName;
    private final ArrayList<String> givenNames;

    public Name(String fullName) {
        String[] nameFields = fullName.trim().split("\\s+");
        if (nameFields.length < 2 || nameFields.length > 4) {
            throw new IllegalArgumentException(fullName + " should have 1 family name, at least 1 given name and may have up to 3 given names");
        }
        ArrayList<String> nameFieldsArray = new ArrayList<String>(Arrays.asList(nameFields));
        int fieldsCount = nameFieldsArray.size();
        this.familyName = nameFieldsArray.remove(fieldsCount - 1);
        this.givenNames = nameFieldsArray;
    }

    public String getGivenName() {
        String concatGivenNames = "";
        for (String field : this.givenNames) {
            concatGivenNames = concatGivenNames.concat(field + " ");
        }
        return concatGivenNames.trim();
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String toString() {

        return this.getGivenName() + " " + this.getFamilyName();
    }

    public int compareTo(Name otherName) {

        int familyNameCompare = this.getFamilyName().compareToIgnoreCase(otherName.getFamilyName());
        int givenNameCompare = this.getGivenName().compareToIgnoreCase(otherName.getGivenName());

        return (familyNameCompare == 0) ? givenNameCompare : familyNameCompare;
    }

}
