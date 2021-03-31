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
        if (input.matches("^[0-9]*PI/2"))
            inputNum = Math.PI / 2;
        else if (input.matches("^-[0-9]*PI/2"))
            inputNum = -Math.PI / 2;
        else if (input.matches("^[0-9]*PI"))
            inputNum = Math.PI;
        else if (input.matches("^-[0-9]*PI"))
            inputNum = -Math.PI;
        else
            inputNum = Double.parseDouble(input);
        return inputNum;
    }
}

