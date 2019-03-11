package com.kiss.mlwebui.prediction;

import java.util.ArrayList;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class Prediction {

	public static String predict(ArrayList<String> param) {

		try {

			int validParams = checkVals(param);
			String week = String.format("%02d", validParams);

			/*
			 * Properties prop = new Properties(); prop.setProperty("log4j.rootLogger",
			 * "DEBUG"); PropertyConfigurator.configure(prop);
			 */

			// String simpleMlp = System.getProperty("user.dir") +
			// "\\workspace\\mlwebui\\models\\week"+week+".h5";
			String simpleMlp = "C:\\OneDriveFHTW\\Java\\eclipse\\workspace\\mlwebui\\models\\week" + week + ".h5";

			System.out.println(simpleMlp);
			MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);

			int inputs = validParams;
			INDArray features = Nd4j.zeros(inputs);

			for (int i = 0; i < validParams; i++) {
				features.putScalar(new int[] { i }, Integer.parseInt(param.get(i)));
			}

			double prediction = model.output(features).getDouble(0);

			System.out.println(prediction);

			return Double.toString(prediction);

		} catch (Exception e) {
			e.printStackTrace();
			return "Prediction error";
		}
	}

	public static int checkVals(ArrayList<String> param) {
		int retVal = 0;

		for (String item : param) {
			if (!item.isBlank()) {
				retVal++;
			}
		}

		return retVal;
	}
}
