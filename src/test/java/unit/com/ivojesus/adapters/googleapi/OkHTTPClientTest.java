package unit.com.ivojesus.adapters.googleapi;

import com.ivojesus.adapters.googleapi.OkHTTPClient;
import org.junit.Test;
import support.StubbedNetworkTest;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OkHTTPClientTest extends StubbedNetworkTest {
    private final String url = String.format("%s/books", localBaseURL);
    private final OkHTTPClient subject = new OkHTTPClient();

    @Test
    public void getsURLContentAsAString() throws IOException {
        String expectedResponse = "{\"fruit\": \"banana\"}";

        String response = subject.get(url);

        assertThat(response, is(equalTo(expectedResponse)));
    }

    @Override
    public String getStubbyFile() {
        return "src/test/resources/stubby.yml";
    }
}
