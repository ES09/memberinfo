package memberinfo.com.osf.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import memberinfo.com.osf.auth.SHAEncoder;
import memberinfo.com.osf.service.MemberInfoService;
import memberinfo.com.osf.service.impl.MemberInfoServiceImpl;
import memberinfo.com.osf.vo.MemberInfoVO;

@WebServlet("/mem/*")
public class MemberInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PATH = "D:\\study\\workspace3\\memberinfo\\WebContent\\onload";
	
	private MemberInfoService mis = new MemberInfoServiceImpl();
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("list", mis.selectMemberInfoList(null));
		RequestDispatcher rd = 
				request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		url = url.replace("/mem/", "");
		Map<String,String> param = new HashMap<String,String>();
		
		if("signup".equals(url)) {
			ServletFileUpload sfu = 
					new ServletFileUpload(new DiskFileItemFactory());
			try {
				List<FileItem> fiList = sfu.parseRequest(request);
				
				for(FileItem fi:fiList) {
					if(fi.isFormField()) {
						String key = fi.getFieldName();
						String value = fi.getString("utf-8");
						param.put(key,value);
					}else {
						String key = fi.getFieldName();
						String fileName = Long.toString(System.nanoTime());
						String ext = FilenameUtils.getExtension(fi.getName());
						fileName += "." + ext;
						param.put(key,"/onload/" + fileName);
						File f = new File(PATH +"/"+ fileName);
						try {
							fi.write(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				param.put("miPwd",SHAEncoder.encode(param.get("miPwd")));
				param.put("miBirth",param.get("miBirth").replace("-", ""));
				request.setAttribute("cnt", mis.insertMemberInfo(param));
				RequestDispatcher rd = request.getRequestDispatcher("/member/signok.jsp");
				rd.forward(request, response);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
		}else if("login".equals(url)) {
			MemberInfoVO mvo = new MemberInfoVO();
			mvo.setMiId(request.getParameter("miId"));
			mvo.setMiPwd(SHAEncoder.encode(request.getParameter("miPwd")));
			mvo = mis.selectMemberInfoListByIdAndPwd(mvo);
			if(mvo!=null) {
				HttpSession hs = request.getSession();
				hs.setAttribute("list", mvo);
				
				RequestDispatcher rd = 
						request.getRequestDispatcher("/member/list.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("/member/login.jsp");
				rd.forward(request, response);
			}
		}
		
	}
}
