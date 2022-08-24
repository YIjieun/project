package com.board.util;

//게시판의 글내용을 출력할때 줄바꿈을 자동으로 인식해서 출력시켜주기위해 필요
//<pre></pre>사이에 출력하면 바꿀필요가 없기때문에 
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		//문자열을 변경->replace(변경전단어,변경전단어)
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}
