/**
 * 
 */
$(document).ready(function(){
	$("#product_cold_brew").change(function(){
		  		var check=$(this).is(":checked");
    	  		var checkVal=$(this).val();
    	if(check){
    	  			$.ajaxCall(check, checkVal);
    	}else{
        	$(".coldbrew").remove();
        }	
   });
   
   $("#product_brood").change(function(){
 		var check=$(this).is(":checked");
 		var checkVal=$(this).val();
 		if(check){
 			$.ajaxCall(check, checkVal);
 		}else{
	$(".brood").remove();
 	}	
   });
   
   $("#product_esspresso").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".esspresso").remove();
	}	
  });
   $("#product_frappucino").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".frappucino").remove();
	}	
  });
   $("#product_blendid").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".blendid").remove();
	}	
  });
   $("#product_fizzo").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".fizzo").remove();
	}	
  });
   $("#product_tea").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".tea").remove();
	}	
  });
   
   $("#product_etc").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".etc").remove();
	}	
 });
   
   $("#product_juice").change(function(){
		var check=$(this).is(":checked");
		var checkVal=$(this).val();
		if(check){
			$.ajaxCall(check, checkVal);
		}else{
	$(".juice").remove();
	}	
 });  		
})

$.ajaxCall=function(check, checkVal){
	$.ajax({
    	url : "http://localhost:8080/coffee/selectedCoffee",
    	type : "post",
    	data : { "param": checkVal},
    	success : function(data){
    		var count=data.length;
    		$("#fixNextTag").append($("<div id='"+checkVal+"'>"));
    		for(var i=0; i<count; i++){
    			$("#"+checkVal).append($("<div class='object'><h3>"+data[i].category+"</h3><div id='coffee_img_container'>"+
    					"<img id='coffee_img' src='"+ data[i].img_address+"'></div>"+
    					"<div id='coffee_info'>"+
    					"<div class='coffee_title btn-group'>"+
    					"<label for='"+data[i].id+"'><input class='kcal_data' type='checkbox' name='kcal' id='"+data[i].id+"' value='"+data[i].kcal+"'>"+data[i].coffee_name+"</label></div>"+
    					"<div class='coffee_ingredient'>"+
    					"<div class='left'>"+
    					"<p>1회 제공량 (kcal): "+data[i].kcal+"</p>"+
    					"<p>포화지방 (g): "+data[i].sat_fat+"</p>"+
    					"<p>단백질 (g): "+data[i].protein+"</p></div>"+
    					"<div class='right'>"+
    					"<p>나트륨 (mg): "+data[i].sodium+"</p>"+
    					"<p>당류 (g): "+data[i].sugars+"</p>"+
    					"<p>카페인 (mg): "+data[i].caffeine+"</p></div>"+
    					+"</div></div></div></div>"));

    		}
    		
    	}
    });
}
$(document).ready(function(){
	 
    var topBar = $("#topBar").offset();
 
    $(window).scroll(function(){
        
        var docScrollY = $(document).scrollTop()
        var barThis = $("#topBar")
        var fixNext = $("#fixNextTag")
 
        if( docScrollY > topBar.top ) {
            barThis.addClass("top_bar_fix");
            fixNext.addClass("pd_top_80");
        }else{
            barThis.removeClass("top_bar_fix");
            fixNext.removeClass("pd_top_80");
        }
 
    });
    
  
})

$(document).ready(function(){
	var arr = [];
	var result=null;
	$('#kcalCul').on('click',function(){
	        $('input[name="kcal"]').each(function(){
	        	 if ($(this).prop('checked')) {      
	        	      arr.push($(this).val());
	        	     
	        	    }
	        	
	        });
	        result=$.kcal_calculate(arr);
	        if(window.confirm("칼로리는 '"+result+"' 입니다")){
	        	$(".kcal_data").prop("checked", false);
	        	$("#kcalCul").prop("checked", false);
	        	$("#kcalCul").button('toggle');
	        	arr=[];
	        	}else{
	        	$("#kcalCul").button('toggle');
	        	}
	       
	   
	    });
	
})

$.kcal_calculate=function(arr){
	var temp=0;
	for(var i=0; i<arr.length; i++){
		arr[i]=parseInt(arr[i]);
		temp+=arr[i];
	}
	return temp;
}
