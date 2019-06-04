package memberinfo.com.osf.dao;

import java.util.List;
import java.util.Map;

import memberinfo.com.osf.vo.MemberInfoVO;

public interface MemberInfoDAO {
	
	List<MemberInfoVO> selectMemberInfoList(MemberInfoVO mi);
	MemberInfoVO selectMemberInfoByPK(MemberInfoVO mi);
	MemberInfoVO selectMemberInfoListByIdAndPwd(MemberInfoVO mi);
	int insertMemberInfo(Map<String,String> mi);	

}
