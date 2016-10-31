/**
	 * This class solves an ODE system with a supplied system size then returns the values
	 * @author Temi_Ogunsanya
	 *Solver class
	 */
		
public class RungeKuttaSolver {
		
		/**
		 * 
		 * @param time the time at a given moment
		 * @param system the ODE system that needs to be solved
		 * @return the updated  values
		 * 
		 * This method makes use of the Runge_kutta ODE solver for any given size of the system
		 */
		public static double[] Solver(double time, ODESystem system, double interval){
			int size = system.getSystemSize();
			
			double [] q1 = new double[size];
			double [] q2 = new double[size];
			double [] q3 = new double[size];
			double [] q4 = new double[size];
			double[] temp = new double [size]; //Stores intermediate values
			double [] newVals = new double[size]; //Value to be returned
					
					
			double [] initialVal = new double [size];
			initialVal = system.getVelocity();		 
			double halfTime = time + interval / 2;
			double fullTime = time + interval;
			
			// Uses a loop to calculate all the values for each system variable depending on the size of the system.
			q1 = system.getFunction(time, initialVal);
			for (int i=0;i<size;i++){
				temp[i] = initialVal[i] + interval*q1[i]/2;
			}
			q2 = system.getFunction(halfTime, temp);
			for (int i=0;i<size;i++){
				temp[i] = initialVal[i] + interval*q2[i]/2;
			}
			q3 = system.getFunction(halfTime, temp);
			for (int i=0;i<size;i++){
				temp[i] = initialVal[i] + interval*q3[i];
			}
			q4 = system.getFunction(fullTime, temp);
			//calculate final values
			for (int i=0;i<size;i++){
				newVals[i] = initialVal[i] + interval * (q1[i] + 2*q2[i] + 2*q3[i] + q4[i])/6;
			}
			return newVals;
		}

			
		}
