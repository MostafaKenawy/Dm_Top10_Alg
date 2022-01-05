package ca.pfv.spmf.algorithms.classifiers.knn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.pfv.spmf.algorithms.classifiers.data.Dataset;
import ca.pfv.spmf.algorithms.classifiers.data.Instance;
import ca.pfv.spmf.algorithms.classifiers.general.ClassificationAlgorithm;
import ca.pfv.spmf.algorithms.classifiers.general.Classifier;


public class AlgoKNN extends ClassificationAlgorithm {

	/** start time of the latest execution */
	private long startTime;

	/** end time of the latest execution */
	private long endTime;

	/** the parameter k */
	int k;

	/**
	 * Constructor
	 */
	public AlgoKNN(int k) {
		this.k = k;
	}

	/**
	 * Print statistics about the execution of this algorithm
	 */
	public void printStatistics() {
		System.out.println("Time to prepare the model = " + (endTime - startTime) + " ms");
		System.out.println();
	}

	@Override
	protected Classifier train(Dataset dataset) {
		// record the start time
		startTime = System.currentTimeMillis();
		// Create the classifier
		ClassifierKNN knn = new ClassifierKNN(dataset, k);
		// record end time
		endTime = System.currentTimeMillis();

		return knn; // return the classifier
	}

	@Override
	public String getName() {
		return "KNN";
	}
}
