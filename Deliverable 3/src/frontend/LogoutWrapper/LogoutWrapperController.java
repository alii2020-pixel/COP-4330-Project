package frontend.LogoutWrapper;

import frontend.MainWindow;
import frontend.Login.*;

public class LogoutWrapperController {
	private LogoutWrapperView view;
	private LogoutWrapperModel model;
	
	public LogoutWrapperController(LogoutWrapperView view, LogoutWrapperModel model) {
		this.view = view;
		this.model = model;
		
		this.view.addLogoutButtonListener(e -> onLogoutButtonClick());
	}
	
	private void onLogoutButtonClick() {
		LoginModel model = new LoginModel();
		LoginView view = new LoginView();
		
		MainWindow.Instance.changeMVC(model, view, new LoginController(model, view));
	}
}
