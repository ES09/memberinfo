package memberinfo.com.osf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class EncodingFilter implements Filter {
	
	private String encoding = null;
	private String setContentType = null;
	
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + setContentType);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
		setContentType = fConfig.getInitParameter("setContentType");
		if(encoding == null) {
			encoding = "UTF-8";
		}
		if(setContentType == null) {
			setContentType = "UTF-8";
		}
	
	}

}
