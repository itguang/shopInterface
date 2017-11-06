$(function(){
		   
	$("#test").click(function(){
			
		$(".guanzhu-box").removeClass("guanzhu-box").addClass("guanzhu-active");
		
	});
	
	$("#test2").click(function(){
			
			$(".plusNum").removeClass("plusNum").addClass("plusNum-active");
			$(".toupiao").removeClass("toupiao").addClass("toupiao-visited");
			
			document.getElementById("test").innerHTML="您已经投过票啦";
			
			setTimeout(function(){
				$(".plusNum-active").removeClass("plusNum-active").addClass("plusNum");
				
			},3100);
			
			/*setTimeout(function(){
				$(".guanzhu-box").removeClass("guanzhu-box").addClass("guanzhu-active");
				
			},1800);*/
			
			
		});
	
	
	
	
	
	
	

});