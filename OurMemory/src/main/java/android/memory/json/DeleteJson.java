package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;

@Controller
public class DeleteJson {
	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/DeleteJson")
	public void memberDelete(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		int result = 0;
		String rt = null;
		
		int memory_num = Integer.parseInt(request.getParameter("memory_num"));
		result = ourMemoryService.memoryDelete(memory_num);
		
		if(result > 0) {
			rt = "성공!";
			JSONObject json = new JSONObject();
			json.put("rt", rt);
			
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
