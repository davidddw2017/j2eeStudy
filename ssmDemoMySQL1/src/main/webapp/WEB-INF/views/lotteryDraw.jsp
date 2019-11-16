<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>抽奖</title>
  <link rel="stylesheet" type="text/css" href="<%=basePath%>static/lottery/style.css">
</head>
<body>
  <div class="bg">
    <img src="<%=basePath%>static/lottery/bg.jpg">
  </div>
  <div class="box">
    <div class="jz">
      <span class="name">姓名</span><br />
      <span class="phone">电话</span><br />
      <div class="start" id="btntxt" onclick="start()">大奖</div>
      <div class="start xn2" id="btnluck" onclick="luck()">幸运奖</div>
    </div>
    <div class="zjmd">
      <p class="p1">中奖者名单</p>
      <div class="list" id="content">
        <!-- <div class="xyjmd"><h1>幸运奖</h1></div> -->
        <div class="zjmd_bt_xy"></div>
        <div class="dajmd"><h1></h1></div>
        <div class="zjmd_bt_dj"></div>
      </div>
      <div class="clear"></div>
      
    </div>
    <!-- 文件保存格式 value="" -->
    <input type="text" name="filename" id="filename" value="中奖名单.txt" style="display:none;" />
    <!-- .csv后缀 -->
    <button class="start svbtn" id="saveBtn">保存名单</button>
  </div>
  <div class="confirmbox">
    <div class="zj_top">
      <img src="<%=basePath%>static/lottery/zj_top.png" alt="">
    </div>
    <div class="lucknum">
        
    </div>
    <div class="conbox">
      
    </div>
    <div class="clear"></div>
    <div class="btnbox">
      <div class="start new_s daj" id="btnqr" onclick="">确认</div>
      <div class="start new_s 22stop" id="btnqx" onclick="" style="background:#FC6666;">取消</div>
    </div>
    <div class="zj_bottom">
      <img src="<%=basePath%>static/lottery/zj_bottom.png" alt="">
    </div>
  </div>
  
  <script type="text/javascript" src="<%=basePath%>static/lottery/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>static/lottery/cj.js"></script>
  <script type="text/javascript" src="<%=basePath%>static/lottery/blob.js"></script>
  <script type="text/javascript" src="<%=basePath%>static/lottery/filesaver.js"></script>
  <script>
      (function(){
        document.getElementById("saveBtn").onclick = function(event){
          event.preventDefault();
          var BB = self.Blob;
          saveAs(
              new BB(
                ["\ufeff" + document.getElementById("content").innerHTML] //\ufeff防止utf8 bom防止中文乱码
              , {type: "text/plain;charset=utf8"}
            )
            , document.getElementById("filename").value
          );
        };
      })();

        var i = 1;
      $('.xn').live('click', function() {
      
      $('.lucknum').text('第'+i+'1 -- '+(i+1)+'0名');
      i++;
    });
    $('.xn2').one('click',function(){
      $('.lucknum').text('第1 -- 10名');
    })
  </script>
</body>
</html>