package com.in.team2.bot;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ReturnItemName{	
	@RequestMapping(value="/returnItemName")
	public void returnItemName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		String itemCategory=(String)request.getParameter("itemCategory");			
		RequestDispatcher rd = request.getRequestDispatcher("/ajax/itemCategory/"+itemCategory+".xml");
		rd.forward(request, response);		
	}
}
