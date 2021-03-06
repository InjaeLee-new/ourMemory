package android.memory.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import OurMemory.service.OurMemoryService;
import appmember.dto.AppMemberDTO;
import member.dto.MemberDTO;

@Controller
public class appLoginJson {
	@Autowired
	   OurMemoryService ourMemoryService;

	   // Android에서  Login Controller
	   @RequestMapping(value = "/appLogin")
	   public void recommendation(HttpServletRequest request, HttpServletResponse response) {
	      MemberDTO memberDTO = new MemberDTO();
	      memberDTO.setUser_id(request.getParameter("id"));
	      memberDTO.setPwd(request.getParameter("pw"));

	      int result = ourMemoryService.memberLogin(memberDTO.getUser_id(), memberDTO.getPwd());
	      String user_name = ""; String user_id = "";

	      String rt = "FAIL";
	      if (result > 0) {
	         rt = "OK";
	         MemberDTO memberDTOInfo = ourMemoryService.memberInformation(request.getParameter("id"));
	         user_name = memberDTOInfo.getUser_name();
	         user_id = memberDTOInfo.getUser_id();
	      }
	      JSONObject json = new JSONObject();
	      json.put("rt", rt);
	      json.put("result", result);
	      AppMemberDTO appMemberDTO = ourMemoryService.appMemberSelect(user_id);
	      JSONArray cateList = new JSONArray();

		   if(appMemberDTO != null) {
			    JSONObject select = new JSONObject();
			    select.put("user_name", user_name);
			    select.put("user_id", user_id);
		        select.put("cate1", appMemberDTO.getCate1());
		        select.put("cate2", appMemberDTO.getCate2());
		        select.put("cate3", appMemberDTO.getCate3());
		        select.put("google_Id", appMemberDTO.getGoogle_Id());
		        select.put("kakao_Id", appMemberDTO.getKakao_Id());

		        cateList.add(select);
		   }
		   json.put("cateList", cateList);


	      try {
	         response.setCharacterEncoding("UTF-8");
	         response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println(json);
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	   }
}
