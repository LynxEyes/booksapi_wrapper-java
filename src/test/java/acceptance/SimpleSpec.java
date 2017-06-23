package acceptance;

import com.greghaskins.spectrum.Spectrum;
import org.junit.runner.RunWith;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.Spectrum.it;
import static org.junit.Assert.assertEquals;

@RunWith(Spectrum.class)
public class SimpleSpec {{
    describe("Simple spec", () -> {
        it("Is simple", () -> {
            assertEquals(2, 2);
        });
    });
}}
