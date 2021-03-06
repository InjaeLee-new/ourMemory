package memory.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import OurMemory.service.OurMemoryService;
import memory.dto.MemoryDTO;

@Controller
public class MemoryWriteController {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@RequestMapping(value = "/memoryWrite")
	public ModelAndView memoryWrite(MultipartRequest request, HttpServletResponse response, MultipartFile img) throws Exception {
		MultipartFile mf = request.getFile("img");
		String filePath = "C:\\Users\\USER\\git\\ourMemoryWeb\\OurMemory\\src\\main\\webapp\\img";
		String fileName = img.getOriginalFilename();
		File file = new File(filePath, fileName);
		try {
			mf.transferTo(file);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// 파일 복사
		// getInputStream() : 업로드한 파일 데이터를 읽어오는 InputStream을 구한다.gg
//		try {
//			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		ModelAndView modelAndView = new ModelAndView();
		
		MemoryDTO memoryDto = new MemoryDTO();
		memoryDto.setMemory_name(((ServletRequest) request).getParameter("memory_name"));
		memoryDto.setMemory_pass(((ServletRequest) request).getParameter("memory_pass"));
		memoryDto.setMemory_id("imsiId");
		memoryDto.setMemory_subject(((ServletRequest) request).getParameter("memory_subject"));
		memoryDto.setMemory_content(((ServletRequest) request).getParameter("memory_content"));
		memoryDto.setMemory_file(fileName);
		
		int result = ourMemoryService.memoryBoardWrite(memoryDto);
		
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("index.jsp?req=writeMemoryPro");
		
		return modelAndView;
	}

}
