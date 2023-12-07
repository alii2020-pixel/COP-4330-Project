// IWrapper.java
// Ethan Curtis

package frontend;

import javax.swing.JComponent;

/**
 * Interface representing a wrapper for changing the Model-View-Controller (MVC) components.
 */
public interface IWrapper {
	/**
     * Changes the Model-View-Controller (MVC) components.
     *
     * @param model     The object representing the model component.
     * @param view      The JComponent representing the view component.
     * @param controller The object representing the controller component.
     */
	public void changeMVC(Object model, JComponent view, Object controller);
}
