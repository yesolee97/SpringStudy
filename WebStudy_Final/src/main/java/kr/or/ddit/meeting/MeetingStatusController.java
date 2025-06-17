package kr.or.ddit.meeting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MeetingStatusController {
	@Value("${contentFile}")
	private Path contentFile;	// 해당 디렉토리나 경로에 대한 정보만 가직 있는 객체 = Path
	
	@GetMapping("/meeting")
	public String meetingView(Model model) throws IOException {
		// 파일이 있으면, Path는경로만 가지고 있어서 혼자서는 있나없나 확인 불가능함, Files API 같이 씀
		if(Files.exists(contentFile)){
			String tableContent = Files.readString(contentFile);
			model.addAttribute("tableContent", tableContent);
		}
		return "meeting/status";
	}
}
