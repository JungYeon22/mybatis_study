package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory = null;
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance(){
		return userDAO;
	}
	
	public UserDAO(){
		try {
			//Reader reader = Resources.getResourceAsReader("mybatis-config.xml");  //문자 단위로 읽을 것이다. 
			//sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			String resource = "mybatis-config.xml"; 
			InputStream inputStream = Resources.getResourceAsStream(resource); 
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();	// 생성
		sqlSession.insert("userSQL.write", userDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.commit();
		sqlSession.close();
		return list;
	}

	public UserDTO getUserById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getUserById", id);
		sqlSession.commit();
		sqlSession.close();
		return userDTO;
	}

	public int updateUser(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.updateUser", userDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

	public int deleteUserById(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.delete("userSQL.deleteUserById", id);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

}
