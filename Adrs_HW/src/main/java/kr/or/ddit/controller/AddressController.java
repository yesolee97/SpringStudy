package kr.or.ddit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.service.AddressService;
import kr.or.ddit.vo.AddressBookVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/rest/addr")
@RequiredArgsConstructor
public class AddressController {
	private final AddressService service;
	
	@GetMapping
	public String getForm() {
		List<AddressBookVO> addrList = service.readAddrList();
		return "addr/addrList";
	}
	
	@GetMapping("/list")
	@ResponseBody
	public List<AddressBookVO> readList() {
		List<AddressBookVO> addrList = service.readAddrList();
		return addrList;
	}

	@GetMapping("/list/{key}")
	@ResponseBody
	public AddressBookVO readAddr(
		@PathVariable Integer key
	) {
		AddressBookVO addr = service.readAddr(key).get();
		return addr;
	}
}
