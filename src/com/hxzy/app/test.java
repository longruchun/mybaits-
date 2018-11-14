package com.hxzy.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

import com.hxzy.Dao.IAdminDao;
import com.hxzy.Dao.IPetOwner;
import com.hxzy.Dao.IPetStore;
import com.hxzy.Dao.IRole;
import com.hxzy.Dao.Idept;
import com.hxzy.entity.Admin;
import com.hxzy.entity.PetOwner;
import com.hxzy.entity.PetStore;
import com.hxzy.entity.Role;
import com.hxzy.entity.dept;

public class test {

	/*
	 * @Test public void test1() throws IOException { // TODO Auto-generated method
	 * stub InputStream is=Resources.getResourceAsStream("MyBatis-config.xml");
	 * SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession();
	 * 
	 * List<Admin> list=session.selectList("com.hxzy.entity.Admin.getAll");
	 * System.out.println(list.size()); }
	 * 
	 * @Test public void test2() throws IOException { InputStream
	 * is=Resources.getResourceAsStream("MyBatis-config.xml"); SqlSessionFactory
	 * factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession();
	 * 
	 * Role role=session.selectOne("com.hxzy.entity.Role.getEntityById",1);
	 * System.out.println(role.getRolename()+"------"+role.getResource_ids()); }
	 * 
	 * 
	 * 
	 * @Test public void test3() throws IOException { InputStream
	 * is=Resources.getResourceAsStream("MyBatis-config.xml"); SqlSessionFactory
	 * factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession();
	 * 
	 * IRole dao=session.getMapper(IRole.class); Role role=(Role)
	 * dao.getEntityById(1);
	 * System.out.println(role.getRolename()+"-----------------"+role.
	 * getResource_ids());
	 * 
	 * Role role1=session.selectOne("com.hxzy.entity.Role.getEntityById",1);
	 * System.out.println(role1.getRolename()+"------"+role1.getResource_ids()); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void test4() throws IOException { InputStream
	 * is=Resources.getResourceAsStream("MyBatis-config.xml"); SqlSessionFactory
	 * factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession(); IPetStore
	 * dao=session.getMapper(IPetStore.class); List<PetStore> petstore=dao.getAll();
	 * 
	 * System.out.println(petstore);
	 * 
	 * }
	 * 
	 * @Test public void test5() throws IOException { InputStream
	 * is=Resources.getResourceAsStream("MyBatis-config.xml"); SqlSessionFactory
	 * factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession(); Idept
	 * dao=session.getMapper(Idept.class); List<dept> dept=dao.getAll();
	 * 
	 * System.out.println(dept);
	 * 
	 * }
	 * 
	 * @Test public void test6() throws IOException { InputStream
	 * is=Resources.getResourceAsStream("MyBatis-config.xml"); SqlSessionFactory
	 * factory=new SqlSessionFactoryBuilder().build(is);
	 * 
	 * SqlSession session=factory.openSession(); IPetOwner
	 * dao=session.getMapper(IPetOwner.class); List<PetOwner> petowner=dao.getAll();
	 * 
	 * System.out.println(petowner);
	 * 
	 * }
	 */

	@Test
	public void test7() throws IOException {
		InputStream is = Resources.getResourceAsStream("MyBatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		SqlSession session = factory.openSession();
		IAdminDao dao = session.getMapper(IAdminDao.class);

		String name = "test";
		String password = "123456";
		String roleid = "1,2,3,4,5";
		password = new Md5Hash(password, name, 2).toString();
		Admin admin = new Admin(name, password, roleid);

		try {
			dao.insert(admin);
			System.out.println("添加成功");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void test8() throws IOException {
		InputStream is = Resources.getResourceAsStream("MyBatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		SqlSession session = factory.openSession();
		IAdminDao dao = session.getMapper(IAdminDao.class);

		Scanner input = new Scanner(System.in);

		System.out.println("请输入用户名:");
		String name = input.next();

		System.out.println("请输入密码");
		String password = input.next();

		List<Admin> list = dao.getEntityByName();
		Iterator<Admin> it = list.iterator();

		if (it.hasNext()) {
			Admin admin = it.next();
			password = new Md5Hash(password, name, 2).toString();

			if (password.equals(admin.getPassword())) {
				System.out.println("登录成功");

			} else {

				System.out.println("用户名或密码错误");

			}

		} else {
			System.out.println("用户名或密码错误");
		}

	}

	public void test9() throws IOException {

		String password = new Md5Hash("123456", "admin", 2).toString();
		System.out.println(password);

	}

}
