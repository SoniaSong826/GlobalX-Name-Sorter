import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a Name with family name(last name) and given names.
 * Implement Comparable interface to support NameSorter.
 * @author Sonia Song
 *
 */
public class Name implements Comparable<Name> {

    private final String familyName;
    private final ArrayList<String> givenNames;

    /**
     * Constructor for Name class
     * Separate String into fields by whitespaces. The last field will be family name. Other fields are given names.
     *
     * @throws IllegalArgumentException A name must have at least 1 given name and may have up to 3 given names. An
     *                                  Exception will be thrown if not meet this requirement.
     * @param fullName The name with fields separated by whitespaces.
     */
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

    /**
     * Compare one name with another name provided.
     * Comparing Rules:
     * 1. Compare family name.
     * 2. Compare given names character by character with whitespaces if existing.
     * Note that: When given name has more than one fields (e.g. Adonis Julius Archer)
     *            First name and other middle names are treated as given names.
     *            No precedences for them when comparing.
     *
     * @see "https://immi.homeaffairs.gov.au/help-text/eplus/Pages/elp-h0010.aspx"
     * @param otherName The name compared to.
     * @return          0 if two names are the same. A value less than 0 is if the name is less than the other name
     *                  (less characters) and a value greater than 0 if the name is greater than the other name
     *                  (more characters).
     */
    public int compareTo(Name otherName) {
        int familyNameCompare = this.getFamilyName().compareToIgnoreCase(otherName.getFamilyName());
        int givenNameCompare = this.getGivenName().compareToIgnoreCase(otherName.getGivenName());

        return (familyNameCompare == 0) ? givenNameCompare : familyNameCompare;
    }

}
