package unit.com.ivojesus.adapters.googleapi;

import com.ivojesus.adapters.googleapi.OkHTTPClient;
import org.junit.Test;
import support.StubbedNetworkTest;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OkHTTPClientTest extends StubbedNetworkTest {
    private final String url = String.format("%s/fruits", localBaseURL);
    private final OkHTTPClient subject = new OkHTTPClient();

    @Override
    public String getStubbyFile() {
        return "src/test/resources/stubby.yml";
    }

    @Test
    public void getsURLContentAsAString() throws IOException {
        String expectedResponse = "{\"fruit\": \"banana\"}";

        String response = subject.get(url);

        assertThat(response, is(equalTo(expectedResponse)));
    }
}
