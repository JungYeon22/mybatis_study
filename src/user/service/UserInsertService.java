package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		// 데이터
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(id);
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		
		UserDAO  userDAO = UserDAO.getInstance();
		userDAO.write(userDTO);
		System.out.println("회원 등록 완료");
	}

}
