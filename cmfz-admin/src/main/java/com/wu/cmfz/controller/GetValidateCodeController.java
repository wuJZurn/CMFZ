package com.wu.cmfz.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wu.cmfz.utils.NewValidateCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GetValidateCodeController {

	@RequestMapping("/getVcode")
	public void create(HttpSession session,HttpServletResponse response) throws IOException{
		NewValidateCodeUtils codes=new NewValidateCodeUtils(130, 50, 4);
		
		session.setAttribute("code", codes.getCode());
		
		codes.write(response.getOutputStream());
		
	}
	
}
