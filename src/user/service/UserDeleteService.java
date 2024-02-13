package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 id 입력 : ");
		String id = scan.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUserById(id);
		if(userDTO != null) {
			System.out.println(userDTO.getId() + "님 정보가 삭제되었습니다.");	
			
			int su = userDAO.deleteUserById(id);
			if(su == 1) System.out.println("삭제되었습니다.");
			else System.out.println("삭제가 실패하였습니다.");
		}else {
			System.out.println("찾고자 하는 Id가 없습니다.");
		}
	

	}

}
