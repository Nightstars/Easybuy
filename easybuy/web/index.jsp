<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%--Created by IntelliJ IDEA.
User: Chris
Date: 2019/9/3
Time: 12:59
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.ArrayList" language="java" %>
<%@ page import="java.util.List" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/my.js"></script>
</head>
<body onload="show();showGoodsIndex()">
<h1 hidden><%=session.getAttribute("name") %></h1>
<h1 hidden>${id}</h1>
<div id="welcomeImage">
    <img width="100%" height="150" src="images/banner.jpg" alt="welcome">
</div>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">${name}<a href="shopping.jsp" class="shopping">购物车X件</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a><a href="manage/index.jsp">后台管理</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="#">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl id="tpyeLisit">
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view" style="height: 100px;">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<dt><img src="images/product/10_small.jpg" /></dt>
				<dd><a href="product-view.html"  target="_self">利仁2018M福满堂电饼铛 好用实惠</a><a href="product-view.html"></a></dd>
				<dt>&nbsp;</dt>
				<dd>&nbsp;</dd>
		  </dl>
	  </div>
	</div>
	<div class="main">
		<div class="price-off">
            <div class="slideBox">
                <ul id="slideBox">
                    <li><img src="images/product/banner_1.jpg"/></li>
                    <li><img src="images/product/banner_2.jpg"/></li>
                    <li><img src="images/product/banner_3.jpg"/></li>
                    <li><img src="images/product/banner_4.jpg"/></li>
                </ul>
            </div>
			<h2>商品列表</h2>
			<ul class="product clearfix" id="showGoodsIndex">
				<li><dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/1.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html" target="_self">法国德菲丝松露精品巧克力500g/盒</a></dd>
						<dd class="price">￥108.0</dd>
				</dl></li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/2.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">乐扣普通型保鲜盒圣诞7件套</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/3.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">欧珀莱均衡保湿四件套</a></dd>
						<dd class="price">￥279.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/4.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">联想笔记本电脑 高速独立显存</a></dd>
						<dd class="price">￥4199</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/5.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">法姿韩版显瘦彩边时尚牛仔铅笔裤</a></dd>
						<dd class="price">￥49.00</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/6.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">Genius925纯银施华洛世奇水晶吊坠</a></dd>
						<dd class="price">￥69.90</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/10.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">利仁2018M福满堂电饼铛 好用实惠</a></dd>
						<dd class="price">￥268.0</dd>
					</dl>
				</li>
				<li>
					<dl>
						<dt><a href="product-view.html"  target="_self"><img src="images/product/8.jpg" /></a></dt>
						<dd class="title"><a href="product-view.html"  target="_self">达派高档拉杆箱20寸 经典款式</a></dd>
						<dd class="price">￥198.0</dd>
					</dl>
				</li>
			</ul>
		</div>
		<div class="side">			
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
                    <li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
					<li><a href="news-view.html"  target="_self">抢钱啦</a></li>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
    </div>
</div>
<div id="footer">
	Copyright &copy; 2016 ZR All Rights Reserved. 沪ICP证1000001号
</div>
</body>
</html>
