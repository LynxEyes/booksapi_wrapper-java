package support;

import io.github.azagniotov.stubby4j.client.StubbyClient;
import org.junit.After;
import org.junit.Before;

public abstract class StubbedNetworkTest {
    protected StubbyClient stubby;
    protected int port = 9876;
    public final String localBaseURL = String.format("http://localhost:%d", port);

    public abstract String getStubbyFile();

    @Before
    public void setUpStubby() throws Exception {
        this.stubby = new StubbyClient();
        stubby.startJetty(port, getStubbyFile());
    }

    @After
    public void tearDownStubby() throws Exception {
        stubby.stopJetty();
    }
}
