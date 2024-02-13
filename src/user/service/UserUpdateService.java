package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 id 입력 : ");
		String id = scan.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getUserById(id);
		if(userDTO != null) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());	
			
			System.out.print("이름 수정 : ");
			String name = scan.next();
			System.out.print("비밀번호 수정 : ");
			String pwd = scan.next();
			userDTO = new UserDTO();
			userDTO.setName(name);
			userDTO.setId(id);
			userDTO.setPwd(pwd);
			int su = userDAO.updateUser(userDTO);
			if(su == 1) System.out.println("업데이트 성공!");
			else System.out.println("업데이트 실패");
		}else {
			System.out.println("찾고자하는 Id가 없습니다.");
		}
		
		
	}

}
