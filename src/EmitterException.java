/**
 * Thrown by the Emitter object if an illegal angle is supplied.
 * @author Alan McLeod
 * @version 1.0
 */
public class EmitterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5778086627790210282L;

	/**
	 * Accepts a specific message about the problem.
	 * @param message A string error message.
	 */
	public EmitterException(String message) {
		super(message);
	}
	
} // end EmitterException class
