package acceptance;

import com.greghaskins.spectrum.Spectrum;
import com.greghaskins.spectrum.Variable;
import com.ivojesus.cli.BookCLI;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.feature;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.given;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.scenario;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.then;
import static com.greghaskins.spectrum.dsl.gherkin.Gherkin.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.startsWith;

@RunWith(Spectrum.class)
public class BooksCLISpec {{
//    feature("Command usage", () -> {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(baos));
//        BookCLI cli = new BookCLI();
//
//        scenario("running without any arguments", () -> {
//            Variable<String[]> arguments = new Variable<>();
//
//            given("No arguments", () -> arguments.set(new String[]{}));
//            when("I run the command", () -> cli.run(arguments.get()));
//            then("It prints out the usage message", () ->
//                assertThat(baos.toString(), startsWith("Usage: "))
//            );
//        });
//
//        scenario("running with a single string argument", () -> {
//            String term = "tolkien";
//            Variable<String[]> arguments = new Variable<>();
//
//            given("tolkien as search term", () -> arguments.set(new String[]{term}));
//            when("I run the command", () -> cli.run(arguments.get()));
//            then("It prints out books that mention that term", () ->
//                assertThat(baos.toString(), matchesPattern("tolkien"))
//            );
//        });
//    });
}}
