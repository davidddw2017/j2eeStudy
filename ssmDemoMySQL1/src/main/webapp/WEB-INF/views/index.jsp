<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<meta name="renderer" content="webkit" />
<link rel="icon" type="image/x-icon" href="static/favicon.ico">
<link rel="stylesheet" href="<%=basePath%>webjars/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>webjars/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath%>static/css/zadmin.css">
<link rel="stylesheet" href="<%=basePath%>static/css/dtree.css">
<link rel="stylesheet" href="<%=basePath%>static/css/common.css">
<link rel="stylesheet" href="<%=basePath%>static/css/font.css">
</head>
<body class="layui-layout-body">
  <div class="layui-layout layui-layout-admin">
    <!-- Main Header -->
    <div class="layui-header">
      <!-- logo 区域 -->
      <div class="layui-logo">
        <cite>&nbsp;PESTLE&emsp;</cite>
      </div>

      <!-- 头部区域 -->
      <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item" lay-unselect><a lay-event="flexible" title="侧边伸缩"> <i
            class="layui-icon layui-icon-shrink-right"></i>
        </a></li>
        <!-- 面包屑 -->
        <span class="layui-breadcrumb layui-anim layui-anim-up"> <a><cite>首页</cite></a></span>
      </ul>

      <!-- 头像区域 -->
      <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
          <a><img src="static/images/avatar.png" class="layui-nav-img" alt="头像">
            <span class="layui-nav-more"></span>
          </a>
          <dl class="layui-nav-child layui-anim layui-anim-upbit">
            <dd lay-unselect> <a onclick="logout()">退出</a> </dd>
          </dl>
        </li>
      </ul>
    </div>

    <!-- 左侧导航区域 -->
    <div class="layui-side">
      <div class="layui-side-scroll">
        <div class="layui-side-user">
          <img class="layui-side-user-avatar open-popup" data-size="680,464"
            src="static/images/security.png" alt="logo" />
          <div>
            <p class="layui-side-user-name">超级管理员</p>
            <p class="layui-side-user-designation">在线</p>
          </div>
        </div>
        <ul class="layui-nav layui-nav-tree" lay-filter="lay-nav" lay-accordion="true">
          <li class="layui-nav-item layui-this">
            <a lay-url="home" lay-id="home">
              <i class="layui-icon layui-icon-home"></i>&emsp; <cite>首页</cite>
            </a>
          </li>
          <li class="layui-nav-item">
	        <a lay-id="#" lay-url="#">
              <i class="iconfont layui-icon-picker-securityscan"></i>&emsp; <cite>人事管理</cite>
            </a>
            <dl class="layui-nav-child">
              <dd data-name="stack">
                <a lay-url="employeeList" lay-id="employeeList"><cite>雇员管理</cite></a>
              </dd>
            </dl>
            <dl class="layui-nav-child">
              <dd data-name="stack">
                <a lay-url="departmentList" lay-id="departmentList"><cite>部门管理</cite></a>
              </dd>
            </dl>
          </li>
        </ul>
      </div>
    </div>

    <div class="layui-body">
      <div class="layui-pagetabs">
        <div class="layui-icon admin-tabs-control layui-icon-refresh-3" lay-event="refresh"></div>
        <div class="layui-tab" lay-unauto lay-allowclose="true" lay-filter="lay-tab">
          <ul class="layui-tab-title">
            <li lay-id="home" lay-url="home" class="layui-this"><i
              class="layui-icon layui-icon-home"></i></li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
              <iframe src="home" class="layui-iframe"></iframe>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- 底部固定区域 -->
    <div class="layui-footer">copyright © 2019 Z-Admin all rights reserved.</div>

    <!-- 移动端遮罩 -->
    <div class="site-mobile-shade"></div>
  </div>
  <script src="<%=basePath%>webjars/jquery/jquery.min.js"></script>
  <script src="<%=basePath%>webjars/layui/layui.all.js"></script>
  <script src="<%=basePath%>static/js/zadmin.js"></script>
  <script src="<%=basePath%>static/js/custom.js"></script>
  <script src="<%=basePath%>static/js/dtree.js"></script>
</body>
</html>