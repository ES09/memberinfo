package memberinfo.com.osf.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import memberinfo.com.osf.dao.MemberInfoDAO;
import memberinfo.com.osf.dao.impl.MemberInfoDAOImpl;
import memberinfo.com.osf.service.MemberInfoService;
import memberinfo.com.osf.vo.MemberInfoVO;

public class MemberInfoServiceImpl implements MemberInfoService {

	
	private MemberInfoDAO midao = new MemberInfoDAOImpl();
		
	@Override
	public List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi) {
		return midao.selectMemberInfoList(mi);
	}

	@Override
	public MemberInfoVO selectMemberInfoByPK(MemberInfoVO mi) {
		return midao.selectMemberInfoByPK(mi);
	}

	@Override
	public MemberInfoVO selectMemberInfoListByIdAndPwd(MemberInfoVO mi) {
		MemberInfoVO mo =midao.selectMemberInfoListByIdAndPwd(mi);
		return mo;
	}

	@Override
	public int insertMemberInfo(Map<String,String> mi) {
		return midao.insertMemberInfo(mi);
	}

	

}
