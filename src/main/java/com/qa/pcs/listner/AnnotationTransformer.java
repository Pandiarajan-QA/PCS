package com.qa.pcs.listner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.qa.pcs.utils.Log;

public class AnnotationTransformer implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation,Class testClass,Constructor testConstructor,Method testMethod) {
		Log.info("Retry method is invoked");
		annotation.setRetryAnalyzer(Retry.class);
		Log.info("Retry method is completed");

	}

}
