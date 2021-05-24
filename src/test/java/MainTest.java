import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;

public class MainTest {

    @Test
    void testNameSorter() throws Exception {
        String testResourcesPath = "src/test/resources";
        String[] testInputs = {"names-test-list-1.txt", "names-test-list-2.txt", "names-test-list-3.txt"};
        String[] expectedOutputs = {"names-result-list-1.txt", "names-result-list-2.txt", "names-result-list-3.txt"};

        for (int i = 0; i < testInputs.length; i++) {
            File expected = new File(testResourcesPath, expectedOutputs[i]);
            NameSorter.main(new String[]{testResourcesPath +"/"+ testInputs[i]});
            File output = new File("sorted-names-list.txt");
            Assertions.assertEquals(FileUtils.readLines(expected, Charset.defaultCharset()), FileUtils.readLines(output, Charset.defaultCharset()));
        }
    }
}

