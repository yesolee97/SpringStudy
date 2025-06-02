package kr.or.ddit.case03.view;

import java.io.PrintWriter;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.view.AbstractView;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class GsonView extends AbstractView{
	
	
	public GsonView() {
		// C.T을 JSON으로 설정
		setContentType(MediaType.APPLICATION_JSON_VALUE);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		try(
			PrintWriter out = response.getWriter();
		){
			new Gson().toJson(model, out);			
		}

		
	}

}
