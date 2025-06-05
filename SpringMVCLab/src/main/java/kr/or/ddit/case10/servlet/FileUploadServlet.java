package kr.or.ddit.case10.servlet;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import jakarta.jws.WebService;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Slf4j
//@WebServlet("/case10/servlet/upload")
@MultipartConfig()
public class FileUploadServlet extends HttpServlet {
	private File saveFolder = new File("D:/uploadFiles");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/case10/uploadForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uploader = req.getParameter("uploader");
		log.info("uploader: {}", uploader);
		
		Part uploadFile = req.getPart("uploaderFile");
		String mime = uploadFile.getContentType();
		// mimeㅇ으로 확인한 파일의 확장자가 이미지가 아닐 경우에는 400으로 에러 넘기고, 제어를 여기서 멈춘다.
		if(!mime.startsWith("image/")) {
			resp.sendError(400);
			return;
		}
		
		log.info("uploadFile: {}", uploadFile);
		String originalFileName = uploadFile.getSubmittedFileName();	// 원본파일명
		String saveName = UUID.randomUUID().toString();
		File saveFile = new File(saveFolder, saveName);	// 업로드한 파일이름
		uploadFile.write(saveFile.getAbsolutePath());	// 경로
	}
}
