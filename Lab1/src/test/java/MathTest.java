import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MathTest {
    private MyMath myMath = new MyMath();

    @ParameterizedTest
    @CsvFileSource(resources = "/correctData.csv", numLinesToSkip = 1)
    public void testSecCorrectData(String input, double expected){
        double inputNum = parseInput(input);
        Assertions.assertEquals(expected, Math.round(myMath.sec(inputNum)*1000.0)/1000.0);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/incorrectData.csv", numLinesToSkip = 1)
    public void testSecIncorrectData(String input, double expected){
        double inputNum = parseInput(input);
        Assertions.assertEquals(expected, myMath.sec(inputNum));
    }
    public double parseInput(String input) {
        double inputNum;
        switch (input.trim()) {
            case ("PI/2"):
                inputNum = Math.PI / 2;
                break;
            case ("-PI/2"):
                inputNum = -Math.PI / 2;
                break;
            case ("PI"):
                inputNum = Math.PI;
                break;
            case ("-PI"):
                inputNum = -Math.PI;
                break;
            default:
                inputNum = Double.parseDouble(input);
        }
        return inputNum;
    }
}

