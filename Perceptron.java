import java.lang.Math;

public class Perceptron{
    Perceptron(int numOfInputs){
        numberOfInputs = numOfInputs;
        weights = new double[numberOfInputs];
        bias = 0.0; //Math.random();
        for(int loopIndex = 0; loopIndex < numOfInputs; ++loopIndex){
            weights[loopIndex] = Math.random();
        }
    }

    public double Feed(double inputs[]){
        double weightedSum = bias;
        for(int loopIndex = 0; loopIndex < numberOfInputs; ++loopIndex){
            weightedSum += weights[loopIndex] * inputs[loopIndex];
        }

        return ActivationFunction(weightedSum);
    }

    public double GetDelta(int weightIndex, double delta, double inputs[]){
        weights[weightIndex] += delta;
        double tempVal = this.Feed(inputs);
        weights[weightIndex] -= delta;
        return tempVal;
    }

    public void ToJSON(){
        System.out.print("{");
        System.out.print("\"bias\":" + bias + ",");
        System.out.print("\"weights\":[");
        for(int loopIndex = 0; loopIndex < numberOfInputs; ++loopIndex){
            System.out.print(weights[loopIndex]);
            if(loopIndex < numberOfInputs - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println("}");
    }

    public void SetBias(double newBias){
        bias = newBias;
    }

    public double GetBias(){
        return bias;
    }

    public void SetWeight(int weightIndex, double newWeigth){
        weights[weightIndex] += newWeigth;
    }

    public double GetWeight(int weightIndex){
        return weights[weightIndex];
    }

    private double ActivationFunction(double x){
        return 1.0 / (1.0 + Math.exp(-x));
    }

    private double bias;
    private double weights[];
    private int numberOfInputs;
}