import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void nameConstructor() {
        String[] testCases = { "", " ", "Peter","   Vincent ", "A B C D E"};
        for(String testCase : testCases){
            Assertions.assertThrows(IllegalArgumentException.class, ()-> new Name(testCase) );
        }
    }

    @Test
    void getGivenName() {
        String[] testCases = { "Bill Gates", "Leonardo da Vinci", " Thomas  Edison  "," MR   Vincent   Van Gogh" };
        String[] testResult = {"Bill", "Leonardo da", "Thomas","MR Vincent Van"};
        for(int i=0; i<testCases.length; i++) {
            Name name = new Name(testCases[i]);
            Assertions.assertEquals(testResult[i], name.getGivenName());
        }
    }

    @Test
    void getFamilyName() {
        String[] testCases = { "Bill Gates", "Leonardo da Vinci", " Thomas  Edison  "," MR   Vincent   Van Gogh" };
        String[] testResult = {"Gates", "Vinci", "Edison","Gogh" };
        for(int i=0; i<testCases.length; i++) {
            Name name = new Name(testCases[i]);
            Assertions.assertEquals(testResult[i], name.getFamilyName());
        }
    }

    @Test
    void testToString() {
        String[] testCases = { "Bill Gates", "Leonardo da Vinci", " Thomas  Edison  "," MR   Vincent   Van Gogh" };
        String[] testResult = { "Bill Gates", "Leonardo da Vinci", "Thomas Edison","MR Vincent Van Gogh" };
        for(int i=0; i<testCases.length; i++) {
            Name name = new Name(testCases[i]);
            Assertions.assertEquals(testResult[i], name.toString());
        }
    }

    @Test
    void compareTo() {
        Assertions.assertTrue((new Name("Bill Gates").compareTo(new Name("Leonardo da Vinci"))) < 0);
        Assertions.assertTrue((new Name("Bill Gates").compareTo(new Name("  Bill   Gates   "))) == 0);
        Assertions.assertTrue((new Name("A BC K").compareTo(new Name("  AB C K   "))) < 0);
        Assertions.assertTrue((new Name("AB C K").compareTo(new Name("ABC     K   "))) < 0);
    }
}