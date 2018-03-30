$().ready(function() {
	var courseID=$("#courseID").text();
	var coursename=$("#courseName").text();
	var email = $("#email").text();
	//设置课程名
	$("#course").html("<label style='color:grey; font-size:20px'>课程：" + coursename +"</label>");

	var formData = new FormData();
	
	//处理上传的名单Excel文件
	$("#uploadlist").click(function(){
		
		console.log("upload list...");
		$("#uploadlist").attr("disabled", true);
		var FileName = $("#studentlist").val();
		console.log(FileName);
		if (FileName == null | FileName == undefined | FileName == '') {
			toastr.error("文件不能为空");  
			$("#uploadlist").attr("disabled", false);  
			return false;  
		}
		var seat=FileName.lastIndexOf(".");
		//返回位于String对象中指定位置的子字符串并转换为小写.
		var extension=FileName.substring(seat).toLowerCase();
		//判断允许上传的文件格式
		if(extension!=".xlsx"&&extension!=".xls"){
			toastr.error("不支持"+extension+"文件的上传!");
			$("#uploadlist").attr("disabled", false);  
			return false;
		}
		
		formData.append("file",$("#studentlist")[0].files[0]);
		$("#uploadlist").html("已处理");
	})
	

	/*$("#getScore").click(function(){
		var singlenum = $("#singlenum").val();
		var singlepoint = $("#singlepoint").val();
		var doublenum = $("#doublenum").val();
		var doublepoint = $("#doublepoint").val();
		var score = singlenum * singlepoint + doublenum * doublepoint;
		$("#score").html(score);

		formData.append("single",singlenum);
		formData.append("plural",doublenum);
		formData.append("sscore",singlepoint);
		formData.append("pscore",doublepoint);
	})*/

			
	
	
	$("#release").click(function(){
		var examName = $("#examname").val();
		var examTimeOn = $("#timestart").val();
		var examTimeOff = $("#timeend").val();
		console.log(examTimeOn+examName+"hehe");
		formData.append("courseId",courseID);
		formData.append("tmail",email);
		formData.append("starttime",examTimeOn);
		formData.append("endtime",examTimeOff);
	  	$.ajax({
            url: 'http://localhost:8082/oldneighborhood/site/add',
            type: 'post',
            data: formData,
            processData: false,  // 告诉jQuery不要去处理发送的数据
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
            success: function (data) {   //成功后回调
            	toastr.success("发布成功！");
                console.log(data);
            },
            error: function(e){    //失败后回调
                toastr.error("出错了");
            },
            datatype: "json"
    	})
		
	})

});