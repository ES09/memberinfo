package memberinfo.com.osf.dao.impl;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import memberinfo.com.osf.dao.MemberInfoDAO;
import memberinfo.com.osf.vo.MemberInfoVO;

public class MemberInfoDAOImpl implements MemberInfoDAO {

	private static SqlSessionFactory ssFactory;
	static {
		InputStream is = MemberInfoDAOImpl.class.getClassLoader().getResourceAsStream("config/mapper/mybatis-config.xml");
		SqlSessionFactoryBuilder ssfBuilder = new SqlSessionFactoryBuilder();
		ssFactory = ssfBuilder.build(is);
	}
	
	private MemberInfoVO mivo = new MemberInfoVO();
	
	@Override
	public List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi) {
		try(SqlSession ss = ssFactory.openSession()) {
			return ss.selectList("memberinfo.com.osf.Member.selectMemberInfoList", mi);
		}
	}
	
	@Override
	public MemberInfoVO selectMemberInfoByPK(MemberInfoVO mi) {
		return null;
	}

	@Override
	public MemberInfoVO selectMemberInfoListByIdAndPwd(MemberInfoVO mi) {
		try(SqlSession ss = ssFactory.openSession()){
			return ss.selectOne("memberinfo.com.osf.Member.selectMemberInfoListByIdAndPwd", mi);
		}		
	}

	@Override
	public int insertMemberInfo(Map<String,String> mi) {
		try(SqlSession ss = ssFactory.openSession()) {
			if(ss.insert("memberinfo.com.osf.Member.insertMemberInfo", mi)==1) {
				ss.commit();
				return 1;
				}
		}
		return 0;
	}

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MemberInfoVO mivo = new MemberInfoVO();
		System.out.println(mivo.getMiNum());
		Method[] methods = mivo.getClass().getDeclaredMethods();
		String mName = "miNum";
		mName = "set" + mName.substring(0,1).toUpperCase() + mName.substring(1);
		
		for(Method method:methods) {
			Parameter[] params = method.getParameters();
			if(mName.equals(method.getName())) {
				if(params[0].getType().getName().equals("java.lang.Integer")) {
					method.invoke(mivo, 1);
				} else {
					method.invoke(mivo, "나나");
				}				
			}			
		}
		System.out.println(mivo.getMiNum());
	}

	

}
