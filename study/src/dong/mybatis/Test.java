package dong.mybatis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dong.mybatis.domain.Dept;
import dong.mybatis.mapping.DeptMapping;

public class Test {
	public static void main(String[] args) {
		
		//testMybatis();
		//testMybatis2();
		testMybatis3();
	}

	private static void testMybatis3() {
		String resource = "conf.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			String statement = "dong.mybatis.mapping.DeptMapping.getDepts";
			DeptMapping deptMapping = sqlSession.getMapper(DeptMapping.class);
			Dept dept = deptMapping.getDepts(24);
			System.out.println(dept.toString()+"sssss");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void testMybatis2() {
		String resource = "conf.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			String statement = "dong.mybatis.mapping.DeptMapping.getDepts";
			Dept dept =  sqlSession.selectOne(statement,24);
			System.out.println(dept.toString()+"sssss");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testMybatis() {
		//mybatis的配置文件
        String resource = "conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource); 
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "dong.mybatis.mapping.DeptMapping.getDepts";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        Dept dept = session.selectOne(statement, 24);
        System.out.println(dept+"---SSS");		
	}
	
}
