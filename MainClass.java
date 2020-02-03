public class MainClass{
    public static void main(String[] args){
    	double inputs[][] = { {0.0, 0.0},
                              {0.0, 1.0},
                              {1.0, 0.0},
                              {1.0, 1.0} };

        double outputs[] = { 0.0,
                             0.0,
                             0.0,
                             1.0 };

        Perceptron p = new Perceptron(2);

        for(int loopIndex = 1; loopIndex <= 100 ; ++loopIndex){
            System.out.println("iteration = " + loopIndex);
            TrainPerceptron(p, inputs, outputs);
        }

        for(int loopIndex = 0; loopIndex < 4; ++loopIndex){
            System.out.println("p.Feed(inputDataSet[" + loopIndex + "]) = " + p.Feed(inputs[loopIndex]));
        }

        System.exit(0);
    }

    public static void TrainPerceptron(Perceptron p, double inputDataSet[][], double outputDataset[]){
        double costFunctionSum = 0.0;
        double delta = 1e-6;
        double lerningRate = 0.1;
        double deltaCostFunction[] = new double[2];
        double gradient[] = new double[2];

        for(int loopIndex = 0; loopIndex < 4; ++loopIndex){
            costFunctionSum += CostFunction(p.Feed(inputDataSet[loopIndex]), outputDataset[loopIndex]);
        }
        System.out.println("costFunctionSum = " + costFunctionSum);

        for(int outLoopIndex = 0; outLoopIndex < 2; ++outLoopIndex){
            deltaCostFunction[outLoopIndex] = 0.0;
            for(int loopIndex = 0; loopIndex < 4; ++loopIndex){
                deltaCostFunction[outLoopIndex] += CostFunction(p.GetDelta(outLoopIndex, delta, inputDataSet[loopIndex]), outputDataset[loopIndex]);
            }
            gradient[outLoopIndex] = -Derivative(costFunctionSum, deltaCostFunction[outLoopIndex], delta);
            System.out.println("gradient[" + outLoopIndex + "] = " + gradient[outLoopIndex]);
        }

        for(int loopIndex = 0; loopIndex < 2; ++loopIndex){
            p.SetWeight(loopIndex, lerningRate * gradient[loopIndex]);
        }

        p.ToJSON();
    }

    public static double CostFunction(double netOutput, double expectedOutput){
        return ((netOutput - expectedOutput)*(netOutput - expectedOutput));
    }

    public static double Derivative(double fx, double fdeltax, double delta){
        return (fx - fdeltax) / delta;
    }
}