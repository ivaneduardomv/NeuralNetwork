class NeuralNetwork{
	NeuralNetwork(int numOfLayers){
		numberOfLayers = numOfLayers;
		layers = new Layer[numberOfLayers];
	}

	public void SetupLayer(int layerIndex, int numOfPerceptrons, int numOfInputs){
		layers[layerIndex] = new Layer(numOfPerceptrons, numOfInputs);
	}

	public void Display(){
		for(int loopIndex = 0; loopIndex < numberOfLayers; ++loopIndex){
			layers[loopIndex].ToJSON();
		}
	}

	public double[] Feed(double input[]){
		return layers[0].Feed(input);
	}

	public void DisplayOutput(){
		layers[numberOfLayers - 1].DisplayOutput();
	}

	private int numberOfLayers;
	private Layer layers[];
}