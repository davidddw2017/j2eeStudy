<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="renderer" content="webkit" />
<title>抽奖</title>
<base href=" <%=basePath%>">
<link rel="stylesheet" href="<%=basePath%>static/lucky/css/style.css" media="screen" type="text/css">
</head>
<div class="container none"></div>
<div class="mask"></div>
<div id="stop" class="btn_circle none">停止</div>
<div class="loader_file">
  用户数据导入中 <span class="current_number"></span><span class="all_number"></span>
</div>
<div class="lucky_container">
  <div class="lucky_list">
    <div class="left lucky_prize">
      <div class="lucky_prize_box">
        <button class="lucky_prize_left lucky_prize_direction"><</button>
        <div data-default="1" class="lucky_prize_picture">
          <img class="lucky_prize_show none" src="<%=basePath%>static/lucky/images/bXshiKc7Z2mQusImhSzC33czcBci3K.png" alt="一等奖笔记本" />
          <img class="none lucky_prize_show" src="<%=basePath%>static/lucky/images/szSy9dU21WZnSdGwP9tE533ntEd1WE.png" alt="二等奖平衡车" />
          <img class="none lucky_prize_show" src="<%=basePath%>static/lucky/images/gLz4H2xZ8XxkXlDDGdd8Fd2xF35kjX.png" alt="三等奖现金红包" />
        </div>
        <button class="lucky_prize_right active lucky_prize_direction">></button>
      </div>
      <div class="lucky_prize_title">一等奖笔记本</div>
      <div class="lucky_setting">
        <span> <b class="lucky_number">${count}</b> 人参与 </span>

        <div class="select_box"> 一次抽 <select name="select_lucky_number" class='select_lucky_number'>
            <option selected="selected" value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="10">10</option>
            <option value="20">20</option>
            <option value="30">30</option>
          </select> 人
        </div>
      </div>
      <div id="open" class="btn_circle btn_start">开始</div>
    </div>
    <div class="right lucky_people_list">
      <div class="lucky_people_title">中奖名单</div>
      <div class="lpl_list clearfix none">
      <!--<div class="lpl_userInfo">
          <img class="lpl_userImage" src="http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK9YW8jiaJuo8xHZohXgpMpzVCWleDx4ko9zLn5B8iavAR2yQpeLMR5BQjf2jicwcGURXq5xf4yguwIQ/132" alt=""/>
          <p class="lpl_userName">小木姐姐</p>
        </div>-->
      </div>
      <div class="lpl_list clearfix none"></div>
      <div class="lpl_list clearfix none"></div>
    </div>
  </div>
</div>

<script type="text/javascript" src="<%=basePath%>static/lucky/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src='<%=basePath%>static/lucky/js/transform.js'></script>
<script type="text/javascript" src='<%=basePath%>static/lucky/js/tick.js'></script>
<!--data为静态数据 如用ajax获取请取消输入引入-->
<!--抽奖动画-->
<script type="text/javascript" src='<%=basePath%>static/lucky/js/3d.js'></script>
<!--实际抽奖逻辑代码-->
<script type="text/javascript" src='<%=basePath%>static/lucky/js/lucky.js'></script>
<!-- ajax抽奖逻辑 -->
<!-- <script type="text/javascript" src='js/ajaxLucky.js'></script> -->
<script type="text/javascript" src="<%=basePath%>static/lucky/js/data.js"></script>

</body>
</html>