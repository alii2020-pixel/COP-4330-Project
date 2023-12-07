// LogoutWrapperController.java
// Ethan Curtis

package frontend.LogoutWrapper;

import javax.swing.JComponent;
import frontend.*;
import frontend.Login.*;

public class LogoutWrapperController implements IWrapper {
	public static LogoutWrapperController Instance;
	
	private LogoutWrapperView view;
	private LogoutWrapperModel model;
	
	private Object customModel, customController;
	
	public LogoutWrapperController(LogoutWrapperView view, LogoutWrapperModel model) {
		Instance = this;
		
		this.view = view;
		this.model = model;
		
		this.view.addLogoutButtonListener(e -> onLogoutButtonClick());
	}
	
	private void onLogoutButtonClick() {
		model.logout();
		
		LoginModel model = new LoginModel();
		LoginView view = new LoginView();
		
		MainWindow.Instance.changeMVC(model, view, new LoginController(model, view));
	}
	
	public void changeMVC(Object model, JComponent view, Object controller) {
		this.customModel = model;
		this.customController = controller;
		
		this.view.updateView(view);
	}
}
