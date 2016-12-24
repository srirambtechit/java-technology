package com.msrm.jdk7feature.autocloseable;

/**
 * Below code output is
 * 
 * <pre>
 * 	Open door
	Swing door
	Close door
	Close door
 * </pre>
 * 
 * Close door prints twice since try-with-resource block automatically invoke
 * close method
 * 
 * @author srirammuthaiah Reference:
 *         http://www.theserverside.com/tutorial/OCPJP-OCAJP-Java-7-Suppressed-Exceptions-Try-With-Resources
 */
public class TryWithResourceApp {

	public static void main(String[] args) throws Exception {
		// below block is try-with-resource
		// which allows object creation whose parent is AutoCloseable
		try (OpenDoor od = new OpenDoor()) {
			od.open();
			od.swing();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// suppressed exception will be catch
			Throwable[] suppressed = e.getSuppressed();
			if (suppressed != null) {
				System.out.println("Suppressed exception count: " + suppressed.length);
				for (Throwable throwable : suppressed) {
					System.out.println(throwable.getMessage());
				}
			}
		} finally {
			System.out.println("I'm done");
		}
	}

}
