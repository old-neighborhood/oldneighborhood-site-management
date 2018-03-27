/**
 * 
 */

$().ready(function() {
	var courseID=$("#courseID").text();
	console.log(courseID);
	var coursename = "";
	var courseintro = "";
	var formData = new FormData();


	$.ajax({
		url: "/getCourse",
		type: 'post',
		success: function (data) {
			//json数据解析
			var obj = eval ("(" + data + ")");
			for (i in obj){
				var id = obj[i].id;
				if (id == courseID) {
					coursename = obj[i].name;
					courseintro = obj[i].brief;
					console.log(coursename+courseintro);
					break;
				}
			}
			//传输到下一个位置="/release?courseId="+courseID;
			$("#newexam").html('<a href="/release?courseId='
					+ courseID + '&courseName='+ coursename +
					'" class="btn btn-default" type="button">发布新的考试</a>');
			console.log(coursename);
			$("#coursename").html(coursename);
			$("#courseintro").html(courseintro);
			$("#course").html(coursename);
		},
		error: function(e){    //失败后回调
			toastr.error("出错了");
		},
		datatype: "json"
	})


	//获取课程的考试信息
	$.ajax({
		url: "/getTest",
		type: 'post',
		success: function (data) {
			var obj = eval ("(" + data + ")");
			console.log(obj);
			var examcontent = "";
			for (i in obj){
				var course = obj[i].courseId;
				if (courseID==course) {
					var examname = obj[i].id;
					var on = new Date(obj[i].start);
					var off = new Date(obj[i].end);
					var examtime = on.toLocaleString() +"——"+ off.toLocaleString();
					examcontent += ' <div><label class="btn btn-default" type="label">考试ID： '
						+ examname +'</label><br/><span class="card-text small">'
						+ examtime +'</span></div><br/>' ;
					$("#examinfo").html(examcontent);
				}

			}
		},
		error: function(e){    //失败后回调
			toastr.error("出错了");
		},
		datatype: "json"
	})


//	导入题库的上传button
	$("#uploadfile").click(function(){

		console.log("upload...");
		
		$("#uploadfile").attr("disabled", true);
		var FileName = $("#inputlib").val();
		console.log(FileName);
		if (FileName == null | FileName == undefined | FileName == '') {
			toastr.error("文件不能为空");  
			$("#uploadfile").attr("disabled", false);  
			return;  
		}
		var seat=FileName.lastIndexOf(".");
		//返回位于String对象中指定位置的子字符串并转换为小写.
		var extension=FileName.substring(seat).toLowerCase();
		//判断允许上传的文件格式
		if(extension!=".xlsx"&&extension!=".xls"){
			toastr.error("不支持"+extension+"文件的上传!");
			$("#uploadfile").attr("disabled", false);  
			return;
		}
		
		
		formData.append("file",$("#inputlib")[0].files[0]);
		formData.append("courseId",courseID);
		
		$.ajax({
			url: 'http://47.100.35.185:8085/Upload', //用于文件上传的服务器端请求地址
            type: 'post',
            data: formData,
            processData: false,  // 告诉jQuery不要去处理发送的数据
            contentType: false,   // 告诉jQuery不要去设置Content-Type请求头
            success: function (data) {   //成功后回调
                console.log(data);
                toastr.success("上传成功！");
				$("#uploadfile").html("上传成功！");
				$("#uploadfile").attr("disabled", false);
            },
            error: function(e){    //失败后回调
				$("#uploadfile").html("失败！重试");
				$("#uploadfile").attr("disabled", false);
            },
            datatype: "json"
            	
		})	


	})
})
