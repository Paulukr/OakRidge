package library.controller.command.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.controller.UrlConstants;
import library.controller.command.Command;

public class AddVolumeCommand  implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub


		return UrlConstants.HOME;
	}

}
