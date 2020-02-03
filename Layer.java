public class Layer{
	Layer(int numOfPerceptrons, int numOfInputs){
		numberOfPerceptrons = numOfPerceptrons;
		numberOfInputs = numOfInputs;
		perceptronsArray = new Perceptron[numberOfPerceptrons];
		output = new double[numberOfPerceptrons];

		for(int loopIndex = 0; loopIndex < numberOfPerceptrons; ++loopIndex){
            perceptronsArray[loopIndex] = new Perceptron(numberOfInputs);            
        }
	}

	public double[] Feed(double input[]){
		for(int loopIndex = 0; loopIndex < numberOfPerceptrons; ++loopIndex){
			output[loopIndex] = perceptronsArray[loopIndex].Feed(input);
		}
		return output;
	}

	public void ToJSON(){
		System.out.println("{");
		for(int loopIndex = 0; loopIndex < numberOfPerceptrons; ++loopIndex){
			perceptronsArray[loopIndex].ToJSON();
		}
		System.out.println("}");
	}

	public void DisplayOutput(){
		System.out.print("output[");
		for(int loopIndex = 0; loopIndex < numberOfPerceptrons; ++loopIndex){
			System.out.print(output[loopIndex]);
			if(loopIndex < numberOfPerceptrons - 1){
                System.out.print(",");
            }
		}
		System.out.println("]");
	}

	private int numberOfPerceptrons;
	private int numberOfInputs;
	private Perceptron perceptronsArray[];
	private double output[];
}