package com.msrm.jdk8.feature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

// 1. Annotations in Java 8 are repeatable. 
// 2. The usage of annotations in Java 8 is expanded to two new targets

@interface Hints {
	Hint[] value();
}

@Repeatable(Hints.class)
@interface Hint {
	String value();
}

// older Java style
@Hints({ @Hint("value1"), @Hint("value2") })
class OldJava {
}

// from Java 8 onwards
@Hint("value1")
@Hint("value2")
class NewJava8 {
}

public class RepeatableAnnotationApp {

	public static void main(String[] args) {
		// reading annotation back
		Hint hint = NewJava8.class.getAnnotation(Hint.class);
		System.out.println(hint); // null

		Hints hints = NewJava8.class.getAnnotation(Hints.class);
		System.out.println(hints); // null

		Hint[] byTypeHint = NewJava8.class.getAnnotationsByType(Hint.class);
		System.out.println(byTypeHint.length);
	}

}

// 2. the usage of annotations in Java 8 is expanded to two new targets
@Target({ ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
@interface MyAnnotation {
}
