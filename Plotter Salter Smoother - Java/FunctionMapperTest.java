import java.math.BigDecimal;
import java.util.ArrayList;

public class FunctionMapperTest {

	
	public static void main(String[] args) {
		
		ArrayList<BigDecimal> testValues = new ArrayList<BigDecimal>();
		
		testValues.add(new BigDecimal(1));
		testValues.add(new BigDecimal(2));
		
		FunctionMapper test = new FunctionMapper();
		
		test.run(testValues);
		
		
	}
	
}
