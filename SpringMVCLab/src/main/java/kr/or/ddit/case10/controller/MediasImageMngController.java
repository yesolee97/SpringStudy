package kr.or.ddit.case10.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 특정 폴더 아래의 파일을 관리하기 위한 컨트롤러
 * > 파일은 수정이 불가능해서 수정은 안만듬
 *   /case10/files (GET)
 *   /case10/files/파일명 (GET)
 *   /case10/files (POST)
 *   /case10/files/파일명 (DELETE)
 */
@Slf4j
@Controller
@RequestMapping("/case10/files")
public class MediasImageMngController {
	@Value("${imagesFolder}")
	private Resource imageRes;	//  폴더의 정보, R
	private File saveFolder;
	
	// 파일 다운로드에 사용하는 mime을 톰캣이 가지고 있는 mime DB에서 꺼내기 위해서 주입받음
	@Autowired
	private ServletContext application;
	
	// ReadOnly인 리소스객체를 파일로 변환해서 가지고 노는 작업을 여기서 함
	// 이거로딩 동작 방식에 의해서 먼저 생성해 놓을때 주입이 다 완료되고 난 후 실행되는 콜백 
	@PostConstruct
	public void init() throws IOException {
		saveFolder = imageRes.getFile();	
	}
	
	@GetMapping
	public void fileList(Model model) {
		 model.addAttribute("fileNames", saveFolder.list());
	}

	/**
	 * 파일 다운로드 처리에서 제일 중요한것은? 
	 * Content-Disposition 헤더의 사용 - 응답 데이터 소비방식을 정하는 속성임
	 * 1) inline		(기본 처리 형태) : 브라우저의 창 내에서 응답 컨텐츠를 소비함
	 * 2) attatchment	(페이지 이동x, 파일 저장): attatchment;filename="파일명" (;를 기준으로 토큰을 쪼갬)
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	// a태그로 다운로드 요청 - 응답에 맞는 c.t세팅하기!
	@GetMapping(value="{fileName}")
	public ResponseEntity<Resource> fileDownload(@PathVariable String fileName) throws IOException {
		Resource targetRes=  imageRes.createRelative(fileName);	// 파일까지의 경로를 새로운 리소스로 반환, 다운로드 시켜야 하는 리소스
		// 다운로드할 파일이 없는경우
		if(!targetRes.exists()) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentLength(targetRes.contentLength());
		
		// 마임이 있으면!
		MediaType mediaType = Optional.ofNullable(application.getMimeType(targetRes.getFilename()))
			.map(MediaType::parseMediaType)	// mime이 있으면 미디어 타입을 줌!
			.orElse(MediaType.APPLICATION_OCTET_STREAM);	// 어떤 파일의 마임을 모를 떄, 이걸 사용해줌!!기본값 세팅! > 8비트(=1바이트)로 데이터를 표현
		headers.setContentType(mediaType);
		
		headers.setContentDisposition(
			ContentDisposition.attachment()
			.filename(targetRes.getFilename(), Charset.defaultCharset())
			.build()	// build 패턴 사용
		);
		
		// 다운로드 처리 시작
		return ResponseEntity.ok()
				.headers(headers)
				.body(targetRes);	// body를 넣으면 build를 따로 안해줘도 됨
		
	}
	
	@PostMapping
	public String upload(
		MultipartFile uploadFile
		, RedirectAttributes redirectAttributes
	) throws IllegalStateException, IOException {
		if(!uploadFile.isEmpty()) {
			String saveName = UUID.randomUUID() .toString();
			File saveFile = new File(saveFolder, saveName);
			uploadFile.transferTo(saveFile);
			redirectAttributes. addFlashAttribute("uploaded", saveName);
		}
		return "redirect:/case10/files";
	}
	
	@DeleteMapping("{fileName}")
	@ResponseBody	// 응답을 json으로 보내려면 응답바디가 무조건 있어야 함
	public Map<String, Object> deleteOne(@PathVariable String fileName) throws IOException {
		Resource targetRes=  imageRes.createRelative(fileName);	// 파일까지의 경로를 새로운 리소스로 반환, 다운로드 시켜야 하는 리소스
		// 다운로드할 파일이 없는경우
		if(!targetRes.exists()) {
			throw new ResponseStatusException(HttpStatusCode.valueOf(404));
		}
		// 지우려면 파일이 있어야함, 리소스는 읽기전용이라 삭제 불가능
		targetRes.getFile().delete();
		return Map.of("success", true, "target", fileName);
		
	}
	
}
