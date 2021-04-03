
import java.lang.Math;
// You may uncomment the following line if you wish.
// import java.util.*; 


class Example {
		public static void main(String[] args){
				//Do *not* delete/alter the next line
				//Changing the next line will lead to loss of marks
		    long startT=System.currentTimeMillis();

				//Edit this according to your name and login
			String name="Rojan Giri" ;
			String login = "rg427";

			 System.out.println("These are the instructions of how to use the problem library.");
		    System.out.println("Please make sure you follow the instructions carefully.");


			System.out.println("For the first problem, you need to use Assess.getTest1(double, double).");
			//get the fitness for problem 1 like so
			//An example solution consists of the a pair of doubles betweem -500 and +500.
			//Lower fitness is best. The optimal fitness is 0 (i.e. no negative fitness values).
			double mind1= -500;
			double mind2= -500;
			
			double[] sol1= {mind1,mind2};
			double fit= Assess.getTest1(sol1[0], sol1[1]);
			double cross= 20;
			double[] optimaldouble= new double[2];
			double temp_fitness= 0; 
			optimaldouble[0]= mind1;
			optimaldouble[1]=mind2;
			temp_fitness= fit;
			double maxd1= 500;
			double maxd2 =500;

			while(fit !=0){	
				while(mind1<= maxd1){
					while(mind2<=maxd2){
						temp_fitness= Assess.getTest1(mind1, mind2);
						if(temp_fitness < fit && temp_fitness >= 0){
							optimaldouble[0]=mind1;
							optimaldouble[1]=mind2;
							fit=temp_fitness;
						}
						if(fit==0)
						break;
						mind2+= cross;
					}
					if(fit==0)
					break;
					mind2=optimaldouble[1];
					mind1 += cross;
				}
				maxd1 =optimaldouble[0]+cross;
				maxd2 = optimaldouble[1]+cross;
				mind1 = optimaldouble[0] - cross;
				mind2= optimaldouble[1] - cross;
				if(cross> 50){
					cross = 50;
				} else if (cross > 10) {
					cross = 10;
				} else if (cross > 1) {
					cross = 1;
				} else if (cross > 0.1) {
					cross = 0.1;
				} else if (cross > 0.01) {
					cross = 0.01;
				} else {
					break;
				}
				long Time = System.currentTimeMillis();
				if ((Time - startT) > 14000) {
					break;
				}
			}

			sol1[0]= mind1;
			sol1[1]=mind2;
			
			System.out.println("The fitness is: " + fit);
			System.out.println("");
			System.out.println("");
			//
			//Second Questions
			//
			System.out.println("Now let us turn to the second problem:");
			System.out.println("A sample solution in this case is a boolean array of size 100.");
			System.out.println("I now create a random sample solution and get the weight and utility:");
			//Creating a sample solution for the second problem
			//The higher the fitness, the better, but be careful of  the weight constraint!

			boolean[] sol2 = new boolean[100];
			double[]temp={0,0};
			double weight=0;

			double[][] weightUtility= new double[100][2]; 
			// It finds out the weight and utility of each of 100 items
			for(int i=0;i< sol2.length; i++){
				for(int j=0; j<100;j++){
					sol2[j]=false;
				}
				sol2[i]= true;
				weightUtility[i]=(Assess.getTest2(sol2));
			}
			sol2[99] = false;//it makes sure that all the values are false
			int weightlimit = 50;// it sets the weiths limit to 50.
			int minutility = 4; //it selects the minimum utility to the start adding items to knapsack.

			while (weight <= 500) {
				for (int n = 0; n< weightlimit; n++) {
					if (sol2[n]) {
						continue;
					}
					if (weightUtility[n][1] > minutility) {
						if ((weight + weightUtility[n][0]) < 500) {
							weight += weightUtility[n][0];
							sol2[n] = true;
						}
	
					}
				}
				if (weight < 100) {
					weightlimit = 80;
				} else if (weight < 200) {
					weightlimit = 80;
				} else if (weight < 300) {
					weightlimit = 70;
				} else if (weight < 400) {
					weightlimit = 60;
				} else if (weight < 500) {
					minutility = minutility - 1;
				}
				if (minutility <= 0) {
					break;
				}
				long Time = System.currentTimeMillis();
				if ((Time - startT) > 27000) {
					break;
				}
			}
			
			temp = (Assess.getTest2(sol2));
			//Now checking the fitness of the candidate solution
			
			
			//The index 0 of temp gives the weight. Index 1 gives the utility
			System.out.println("The weight is: " + temp[0]);
			System.out.println("The utility is: " + temp[1]);
			System.out.println("");
			System.out.println("");


			//Once completed, your code must submit the results you generated, including your name and login: 
			//If you don't check in your results, you will incur a substantil loss of marks
			//Use and adapt  the function below:
			Assess.checkIn(name,login,sol1,sol2);
      
		  //Do not delete or alter the next 2 lines
			 //Changing them will lead to loss of marks
		  long endT= System.currentTimeMillis();
			System.out.println("Total execution time was: " +  ((endT - startT)/1000.0) + " seconds");

	  }



}
