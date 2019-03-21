package com.in.team2.dao.post;

import com.in.team2.vo.CommentVO;
import com.in.team2.vo.PostVO;
import java.util.ArrayList;

public abstract interface PostDAO
{
  public abstract int create(PostVO post);
  
  public abstract ArrayList<PostVO> showList(PostVO post);
  
  public abstract ArrayList<PostVO> showMySellList(PostVO post);
  
  public abstract ArrayList<PostVO> searchList(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract PostVO showDetail(PostVO post);
  
  public abstract PostVO showDetailModify(PostVO post);
  
  public abstract int modify(PostVO post);
  
  public abstract int delete(PostVO post);
  
  public abstract int addComment(CommentVO comment);
  
  public abstract int deleteComment(CommentVO comment);
  
  public abstract int modifyComment(CommentVO comment, PostVO post);
}
