<%@page language="java" contentType="text/xml; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.in.team2.vo.AuctionVO"%>
<%@page import="java.util.List"%>
<%List<AuctionVO> list = (List)request.getAttribute("auctionList");
Iterator<AuctionVO> iter = list.iterator();
%>
<result>

	<%while(iter.hasNext()){
		AuctionVO auction = iter.next();%>
		
		<buyerId><%=auction.getBuyerId()%></buyerId>
		<itemCurPrice><%=auction.getItemCurPrice()%></itemCurPrice>
	
	<%}%>
</result>
