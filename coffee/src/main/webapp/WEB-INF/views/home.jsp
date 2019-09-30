<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="resources/css/coffee.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/coffee.js" charset="utf-8"></script>

</head>
<body>
<div class="wrap">
<div class="btn-group-toggle top_bar_fix" data-toggle="buttons" id="topBar">
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_cold_brew" value="coldbrew">콜드 브루 커피</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_brood" value="brood">브루드 커피</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_esspresso" value="esspresso">에스프레소</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_frappucino" value="frappucino">프라푸치노</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_blendid" value="blendid">블렌디드</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_fizzo" value="fizzo">스타벅스 피지오</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_tea" value="tea">티(티바나)</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_etc" value="etc">기타 제조 음료</label>
<label class="btn btn-primary"><input style="vertical-align:middle;" type="checkbox" name="product" id="product_juice" value="juice">스타벅스 주스(병음료)</label>
<input id="kcalCul" type="button" value="칼로리 계산하기" class="btn btn-success" />
</div>

<div class="top_con_zone" id="fixNextTag">

</div>
</div>


</body>
</html>