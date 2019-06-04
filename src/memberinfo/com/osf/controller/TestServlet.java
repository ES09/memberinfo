package memberinfo.com.osf.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import memberinfo.com.osf.dao.impl.MemberInfoDAOImpl;
@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static SqlSessionFactory ssFactory;
	static {
		InputStream is = MemberInfoDAOImpl.class.getClassLoader().getResourceAsStream("config/mapper/mybatis-config.xml");
		SqlSessionFactoryBuilder ssfBuilder = new SqlSessionFactoryBuilder();
		ssFactory = ssfBuilder.build(is);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		try(SqlSession ss = ssFactory.openSession()) {
			List<Object> tlsit= ss.selectList("memberinfo.com.osf.Test.selectMemberInfoList");
			pw.print(tlsit);
			}	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
